import argparse
import os
from avro.datafile import DataFileReader
from avro.io import DatumReader
import pandas as pd
from tqdm import tqdm


def save_to_parquet(triplets, chunk_number, parquet_dir, avro_name):
    """Сохраняем список триплетов в parquet."""
    df = pd.DataFrame(triplets, columns=["subject", "relation", "object"])
    file_name = f"{avro_name}_chunk_{chunk_number}.parquet"
    file_path = os.path.join(parquet_dir, file_name)
    df.to_parquet(file_path, engine='pyarrow')
    print(f"[INFO] Saved chunk {chunk_number} to {file_path}")


def load_processed_files(tracking_file):
    """Загрузка списка уже обработанных файлов."""
    if os.path.exists(tracking_file):
        with open(tracking_file, 'r') as f:
            processed = set(line.strip() for line in f.readlines())
    else:
        processed = set()
    return processed


def update_processed_files(tracking_file, avro_file):
    """Добавление файла в список обработанных."""
    with open(tracking_file, 'a') as f:
        f.write(avro_file + '\n')


def process_avro_file(avro_path, parquet_dir, start_chunk=1, chunk_size=10000):
    """Обрабатываем один avro файл в parquet чанки."""
    avro_name = os.path.splitext(os.path.basename(avro_path))[0]
    print(f"[INFO] Processing file: {avro_name}")

    reader = DataFileReader(open(avro_path, "rb"), DatumReader())

    triplet_buffer = []
    current_chunk = start_chunk
    record_counter = 0

    for triple in tqdm(reader, desc=f"Processing {avro_name}"):
        try:
            subject = triple.get('subject', [])
            relation = triple.get('relation', [])
            object_ = triple.get('object', [])

            triplet_buffer.append({
                'subject': ' '.join([x['word'] for x in subject]),
                'relation': ' '.join([x['word'] for x in relation]),
                'object': ' '.join([x['word'] for x in object_]),
            })

            record_counter += 1

            if len(triplet_buffer) >= chunk_size:
                save_to_parquet(triplet_buffer, current_chunk, parquet_dir, avro_name)
                current_chunk += 1
                triplet_buffer = []

        except Exception as e:
            print(f"[ERROR] Skipped bad triple due to error: {e}")
            continue

    if triplet_buffer:
        save_to_parquet(triplet_buffer, current_chunk, parquet_dir, avro_name)

    reader.close()
    print(f"[INFO] Finished {avro_name}, total records processed: {record_counter}")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Convert AVRO triples to Parquet chunks with tracking.")
    parser.add_argument('--avro_dir', required=True, help='Path to directory with .avro files')
    parser.add_argument('--output_dir', required=True, help='Directory to save parquet files')
    parser.add_argument('--tracking_file', default='processed_files.txt', help='Path to tracking file')
    parser.add_argument('--start_chunk', type=int, default=1, help='Start chunk number (default: 1)')
    parser.add_argument('--chunk_size', type=int, default=10000, help='Number of triples per parquet file')

    args = parser.parse_args()

    avro_dir = args.avro_dir
    output_dir = args.output_dir
    tracking_file = args.tracking_file
    start_chunk = args.start_chunk
    chunk_size = args.chunk_size

    os.makedirs(output_dir, exist_ok=True)

    processed_files = load_processed_files(tracking_file)

    avro_files = [os.path.join(avro_dir, f) for f in os.listdir(avro_dir) if f.endswith('.avro')]

    if not avro_files:
        print(f"[ERROR] No .avro files found in directory: {avro_dir}")
        exit(1)

    for avro_file in avro_files:
        if avro_file in processed_files:
            print(f"[INFO] Skipping already processed file: {avro_file}")
            continue

        process_avro_file(avro_file, output_dir, start_chunk=start_chunk, chunk_size=chunk_size)
        update_processed_files(tracking_file, avro_file)
