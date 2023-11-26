
inputfile=$1
pythonfile=$2
encoding=$3 #${unboundedencodings[$i]}
expectedResult=$4 #${expectedResults[$tableindex]}
bound=$5
analysis=$6
outputFile=$7
timeoutvalue=$8

java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e $encoding -t $analysis -b $bound
timeout $timeoutvalue python3 "${pythonfile}"

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
    printf "$inputfile,$encoding,${bound},${positive},$expectedResult," >> $outputFile
  else
    if [ "$retval" == 255 ]
      then
        printf "$inputfile,$encoding,${bound},${negative},$expectedResult," >> $outputFile
      else
        printf "$inputfile,$encoding,${bound},Unknown,$expectedResult," >>$outputFile
    fi
fi
