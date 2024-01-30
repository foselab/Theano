
inputfile=$1
pythonfile=$2
encoding=$3 #${unboundedencodings[$i]}
expectedResult=$4 #${expectedResults[$tableindex]}
analysis=$5
outputFile=$6
timeoutvalue=$7
table=$8

#echo "java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e $encoding -t $analysis"
java -jar Theano.jar -i $inputfile -o "${pythonfile}" -e $encoding -t $analysis

source ~/my_z3venv/bin/activate
timeout $timeoutvalue python3 "${pythonfile}"
deactivate

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
    printf "$inputfile,$table,$encoding,$analysis,$positive,$expectedResult." >> $outputFile
  else
    if [ "$retval" == 255 ]
      then
        printf "$inputfile,$table,$encoding,$analysis,$negative,$expectedResult," >> $outputFile
      else
        printf "$inputfile,$table,$encoding,$analysis,Unknown,$expectedResult," >> $outputFile
    fi
fi
