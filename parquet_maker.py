import argparse
import os
from avro.datafile import DataFileReader
from avro.io import DatumReader
import pandas as pd
from tqdm import tqdm

# Константы
AVRO_FILE = "OPIEC/data/OPIEC-Raw-example.avro"
CHUNK_SIZE = 10000
SAVE_DIR = "parquet_files"

# Аргументы командной строки
parser = argparse.ArgumentParser()
parser.add_argument('--start_chunk', type=int, default=1, help='Номер чанка, с которого начать сохранение')
args = parser.parse_args()
start_chunk = args.start_chunk

# Готовим директорию для вывода
os.makedirs(SAVE_DIR, exist_ok=True)

# Функция сохранения в Parquet
def save_to_parquet(triplets, chunk_number):
    df = pd.DataFrame(triplets, columns=["subject", "relation", "object"])
    file_path = os.path.join(SAVE_DIR, f"triplets_chunk_{chunk_number}.parquet")
    df.to_parquet(file_path, engine='pyarrow')
    print(f"[INFO] Saved chunk {chunk_number} to {file_path}")

# Основной код
reader = DataFileReader(open(AVRO_FILE, "rb"), DatumReader())

# Пропуск первых (start_chunk - 1) * CHUNK_SIZE триплетов
triplet_buffer = []
current_chunk = start_chunk
records_to_skip = (start_chunk - 1) * CHUNK_SIZE

print(f"[INFO] Skipping {records_to_skip} records...")

# Быстрое пропускание уже сохранённых
for i in range(records_to_skip):
    try:
        next(reader)
    except StopIteration:
        print("[INFO] Reached end of file while skipping.")
        reader.close()
        exit(0)

# Чтение и сохранение оставшихся триплетов
for triple in tqdm(reader, desc=f"Processing from chunk {start_chunk}"):
    try:
        subject = triple['subject']
        relation = triple['relation']
        object_ = triple['object']

        triplet_buffer.append({
            'subject': ' '.join([x['word'] for x in subject]),
            'relation': ' '.join([x['word'] for x in relation]),
            'object': ' '.join([x['word'] for x in object_]),
        })

        if len(triplet_buffer) >= CHUNK_SIZE:
            save_to_parquet(triplet_buffer, current_chunk)
            current_chunk += 1
            triplet_buffer = []

    except Exception as e:
        print(f"[ERROR] Skipped bad triple: {e}")
        continue

# Сохраняем оставшееся
if triplet_buffer:
    save_to_parquet(triplet_buffer, current_chunk)

reader.close()
