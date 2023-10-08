
tablename=EugeneTable

#defines an array containing all the unbounded encodings
unboundedencodings=("UeArFs" "UeArVs" "UeUfFs" "UeUfVs")

boundedencodings=("BeArFs" "BeArVs" "BeUfFs" "BeUfVs")

#boundedencodings=("BeUfVs")
#boundedencodings=("BeUfFs" "BeUfVs")

#boundedencodings=("BeArFs")

## get length of $distro array
len=${#unboundedencodings[@]}

echo "" >results.cls

## checking the unbounded encodings
for (( i=0; i<$len; i++ ));
do
  echo "**************************************************"
  echo "Running the encoding: ${unboundedencodings[$i]}"
  echo "**************************************************"
  #creates a string containing the name of the python file
  pythonfile="scripts/${unboundedencodings[$i]}$tablename.py"
  inputfile="./$tablename.rt"

  #START=$(date -r)
  #echo $START
  java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e ${unboundedencodings[$i]} -t consistency
  python3 "${pythonfile}"

  #END=$(date -r)
  #DIFF=$(echo "$END - $START" | bc)
  #echo $DIFF

  retval=$?
  if [ "$retval" == 1 ]
    then
      echo "$inputfile,Consistent,${unboundedencodings[$i]}" >>results.cls
    else
      if [ "$retval" == 255 ]
        then
          echo "$inputfile,Inconsistent,${unboundedencodings[$i]}" >>results.cls
        else
          echo "$inputfile,Unknown,${unboundedencodings[$i]}" >>results.cls
      fi
  fi
done

## checking the bounded encodings
## get length of $distro array
len=${#boundedencodings[@]}

## checking the bounded encodings
for (( i=0; i<$len; i++ ));
do
  echo "**************************************************"
  echo "Running the encoding: ${boundedencodings[$i]}"
  echo "**************************************************"
  #creates a string containing the name of the python file
  inputfile="./$tablename.rt"

for (( bound=100; bound<=1200; bound=bound+100 ));
#  for (( bound=5; bound<=10; bound=bound+2 ));
  do
    pythonfile="scripts/${boundedencodings[$i]}$tablename-$bound.py"

    #t1=$(date +%s%3N);
    java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e ${boundedencodings[$i]} -t consistency -b $bound
    python3 "${pythonfile}"
    #t2=$(date +%s%3N);
    #runtime="$((t2-t1)) ms"

    retval=$?
    if [ "$retval" == 1 ]
      then
        echo "$inputfile,Consistent,${boundedencodings[$i]},$bound" >>results.cls
      else
        if [ "$retval" == 255 ]
          then
            echo "$inputfile,Inconsistent,${boundedencodings[$i]},$bound" >>results.cls
          else
            echo "$inputfile,Unknown,${boundedencodings[$i]},$bound" >>results.cls
        fi
    fi
  done
done
