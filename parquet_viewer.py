import pandas as pd
import argparse
import os

def main(parquet_path):
    if not os.path.exists(parquet_path):
        print(f"[ERROR] File not found: {parquet_path}")
        return

    try:
        df = pd.read_parquet(parquet_path)
    except Exception as e:
        print(f"[ERROR] Failed to read parquet: {e}")
        return

    print(f"[INFO] Loaded {len(df)} triples from: {parquet_path}")
    print("=" * 60)

    for idx, row in df.iterrows():
        print(f"[{idx}] {row['subject']} — {row['relation']} — {row['object']}")
        if idx >= 9:  # Выводим только первые 10
            print("... (truncated)")
            break

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--p", help="Path to the .parquet file to read")
    args = parser.parse_args()
    main(args.p)
