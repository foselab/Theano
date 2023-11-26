#!/bin/bash
TIMEFORMAT=%U

tables=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f1) )
analysis=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f2) )
expectedResults=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f3) )
threshold=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f4) )
#timeoutvalue=7200
timeoutvalue=120
#prev=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f5) )

echo "tables  : ${tables[@]}";
echo "analysis   : ${analysis[@]}";
echo "expectedResult : ${expectedResult[@]}";
#echo "duration : ${duration[@]}"
#echo "prev : ${prev[@]}"

unboundedOutputFile="results/unboundedResults.cls"
boundedOutputFile="results/boundedResults.cls"


#defines an array containing all the unbounded encodings
unboundedencodings=("UeArFs" "UeArVs" "UeUfFs" "UeUfVs")

boundedencodings=("BeArFs" "BeArVs" "BeUfFs" "BeUfVs")

#bounds=$(seq 100 100 1200)

bounds=$(seq 2 2 6)

len=${#unboundedencodings[@]}

echo "inputfile,encoding,result,expectedResult,time" > $unboundedOutputFile

boundedCheck=1;
unboundedCheck=1;

if [boundedCheck==1]
then
  for ((tableindex=0; tableindex<${#tables[@]}; tableindex++))
  do
    tablename=${tables[$tableindex]};

    ## checking the unbounded encodings
    for (( i=0; i<$len; i++ ));
    do
      echo "**************************************************"
      echo "Running the encoding: ${unboundedencodings[$i]}"
      echo "**************************************************"
      #creates a string containing the name of the python file
      inputfile="./benchmarkTables/$tablename"
      pythonfile="scripts/${unboundedencodings[$i]}$tablename${analysis[$tableindex]}.py"

      (time ./execUnbounded.sh $inputfile $pythonfile ${unboundedencodings[$i]}  ${expectedResults[$tableindex]} ${analysis[$tableindex]} $unboundedOutputFile $timeoutvalue) 2>> $unboundedOutputFile
     done
  done
fi


echo "inputfile,encoding,bound,result,expectedResult,time" > $boundedOutputFile
## checking the bounded encodings
## get length of $distro array
len=${#boundedencodings[@]}

## checking the bounded encodings
if [ unboundedCheck==1 ]
then
  for ((tableindex=0; tableindex<${#tables[@]}; tableindex++))
  do
    tablename=${tables[$tableindex]}
    for (( i=0; i<$len; i++ ));
    do
      echo "**************************************************"
      echo "Running the encoding: ${boundedencodings[$i]}"
      echo "**************************************************"
      #creates a string containing the name of the python file
      inputfile="./benchmarkTables/$tablename"

      bound=$((${threshold[$tableindex]}+100));
      echo $bound;
      pythonfile="scripts/${boundedencodings[$i]}$tablename${analysis[$tableindex]}-$bound.py"

      (time ./execBounded.sh $inputfile $pythonfile ${boundedencodings[$i]}  ${expectedResults[$tableindex]} $bound ${analysis[$tableindex]} $boundedOutputFile $timeoutvalue) 2>> $boundedOutputFile

    done
  done
fi
