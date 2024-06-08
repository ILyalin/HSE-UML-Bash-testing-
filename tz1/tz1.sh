#!/bin/bash

src_dir="$1"
dest_dir="$2"

all_files=$(find "$src_dir" -type f)

index=-1

for file in $all_files; do
    file_name=$(basename "$file")
    new_file_path="${dest_dir}/${index}-${file_name}"
    
    ((index++))
    cp "$file" "$new_file_path"
done

echo "Файлы в $1:"
find "$src_dir" -maxdepth 1 -type f -exec basename {} \;

echo "Директории в $1:"
find "$src_dir" -maxdepth 1 -mindepth 1 -type d -exec basename {} \;

echo "Все файлы (влож):"
find "$src_dir" -type f -exec basename {} \;

