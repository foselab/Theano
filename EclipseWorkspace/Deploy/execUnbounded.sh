
inputfile=$1
pythonfile=$2
encoding=$3 #${unboundedencodings[$i]}
expectedResult=$4 #${expectedResults[$tableindex]}
analysis=$5

java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e $encoding -t $analysis
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
    printf "$inputfile,$encoding,$positive,$expectedResult." >>unboundedResults.cls
  else
    if [ "$retval" == 255 ]
      then
        printf "$inputfile,$encoding,$negative,$expectedResult," >>unboundedResults.cls
      else
        printf "$inputfile,$encoding,Unknown,$expectedResult," >>unboundedResults.cls
    fi
fi
