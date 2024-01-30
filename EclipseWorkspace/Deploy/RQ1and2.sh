#!/bin/bash
TIMEFORMAT=%U

mkdir .evalscripts

tables=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f1) );
analysis=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f2) );
expectedResults=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f3) )
threshold=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f4) )
#timeoutvalue=7200
timeoutvalue=120
#prev=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f5) )

#echo "tables  : ${tables[@]}";
#echo "analysis   : ${analysis[@]}";
#echo "expectedResult : ${expectedResult[@]}";
#echo "duration : ${duration[@]}"
#echo "prev : ${prev[@]}"

unboundedOutputFile="results/unboundedResults_$1.csv"
boundedOutputFile="results/boundedResults_$1.csv"


#defines an array containing all the unbounded encodings
unboundedencodings=("UeArFs" "UeArVs" "UeUfFs" "UeUfVs")

boundedencodings=("BeArFs" "BeArVs" "BeUfFs" "BeUfVs")

#bounds=$(seq 100 100 1200)

bounds=$(seq 2 2 6)

len=${#unboundedencodings[@]}

echo "inputfile,table,encoding,check,result,expectedResult,time" > $unboundedOutputFile

boundedCheck=1;
unboundedCheck=1;

if [boundedCheck==1]
then
  for ((tableindex=0; tableindex<${#tables[@]}; tableindex++))
  do
    tablename=${tables[$tableindex]};
    tabname=$(echo $tablename| cut -d'_' -f 1)

    ## checking the unbounded encodings
    for (( i=0; i<$len; i++ ));
    do
      echo "**************************************************"
      echo "Running the encoding: ${unboundedencodings[$i]}"
      echo "**************************************************"
      #creates a string containing the name of the python file
      inputfile="./benchmarkTables/$tablename"
      pythonfile=".evalscripts/${unboundedencodings[$i]}$tablename${analysis[$tableindex]}.py"

      (time ./execUnbounded.sh $inputfile $pythonfile ${unboundedencodings[$i]}  ${expectedResults[$tableindex]} ${analysis[$tableindex]} $unboundedOutputFile $timeoutvalue $tabname) 2>> $unboundedOutputFile
     done
  done
fi


echo "inputfile,table,encoding,bound,check,result,expectedResult,time" > $boundedOutputFile
## checking the bounded encodings
## get length of $distro array
len=${#boundedencodings[@]}

## checking the bounded encodings
if [ unboundedCheck==1 ]
then
  for ((tableindex=0; tableindex<${#tables[@]}; tableindex++))
  do
    tablename=${tables[$tableindex]}
    tabname=$(echo $tablename| cut -d'_' -f 1)
    for (( i=0; i<$len; i++ ));
    do
      echo "**************************************************"
      echo "Running the encoding: ${boundedencodings[$i]}"
      echo "**************************************************"
      #creates a string containing the name of the python file
      inputfile="./benchmarkTables/$tablename"

      bound=$((${threshold[$tableindex]}+100));
      echo $bound;
      pythonfile=".evalscripts/${boundedencodings[$i]}$tablename${analysis[$tableindex]}-$bound.py"

      (time ./execBounded.sh $inputfile $pythonfile ${boundedencodings[$i]}  ${expectedResults[$tableindex]} $bound ${analysis[$tableindex]} $boundedOutputFile $timeoutvalue $tabname) 2>> $boundedOutputFile

    done
  done
fi
