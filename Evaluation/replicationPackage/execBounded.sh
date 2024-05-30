
inputfile=$1
pythonfile=$2
encoding=$3 #${unboundedencodings[$i]}
expectedResult=$4 #${expectedResults[$tableindex]}
bound=$5
analysis=$6
outputFile=$7
timeoutvalue=$8
table=$9

export JAVA_TOOL_OPTIONS='-Xmx2G' 2>> /dev/null
java -Xms256m -Xmx4g -jar Theano.jar -i $inputfile -o "${pythonfile}" -e $encoding -t $analysis -b $bound 2>> /dev/null
#source ~/my_z3venv/bin/activate
timeout $timeoutvalue python3 "${pythonfile}"
#deactivate
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
    printf "$inputfile,$table,$encoding,${bound},${analysis},${positive},$expectedResult," >> $outputFile
  else
    if [ "$retval" == 255 ]
      then
        printf "$inputfile,$table,$encoding,${bound},${analysis},${negative},$expectedResult," >> $outputFile
      else
        printf "$inputfile,$table,$encoding,${bound},${analysis},Unknown,$expectedResult," >>$outputFile
    fi
fi
