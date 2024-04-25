read in
read out
find $in -type f -name "*.*" | while read file;
   do
  name=$(basename "$file")
  source="$out/$name"
  
  if [ -f "$source" ]; then
    count=1
    while [ -f "$source" ]; do
      n_name="${name%.*}_$count.${name##*.}"
      source="$out/$n_name"
      count+=1
    done
  fi
  
  cp "$file" "$source"
done
