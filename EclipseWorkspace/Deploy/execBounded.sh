
inputfile=$1
pythonfile=$2
encoding=$3 #${unboundedencodings[$i]}
expectedResult=$4 #${expectedResults[$tableindex]}
bound=$5
analysis=$6

java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e $encoding -t $analysis -b $bound
python3 "${pythonfile}"

retval=$?

if [ "$analysis" = "consistency" ];
  then
      positive="Consistent";
      negative="Inconsistent";
    else
      positive="Complete";
      negative="Incomplete";
fi


if [ "$retval" == 1 ]
  then
    printf "$inputfile,$encoding,${bound},${positive},$expectedResult," >>boundedResults.cls
  else
    if [ "$retval" == 255 ]
      then
        printf "$inputfile,$encoding,${bound},${negative},$expectedResult," >>boundedResults.cls
      else
        printf "$inputfile,$encoding,${bound},Unknown,$expectedResult," >>boundedResults.cls
    fi
fi
