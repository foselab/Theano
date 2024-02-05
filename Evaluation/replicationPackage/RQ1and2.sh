#!/bin/bash

# This file execute one run of the experiments necessary to replicate the experiments for RQ1 and 2.
#
# Usage:
#  $ ./RQ1and2 param1
# * param1: <The identifier of the run>

TIMEFORMAT=%U

# load the experiments and the expected results from the benchmark files
tables=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f1) );
analysis=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f2) );
expectedResults=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f3) )
threshold=( $(tail -n +2 benchmarkTables/input.csv | cut -d ',' -f4) )
timeoutvalue=7200

# used to select the bounded our unbounded encodings
bounded=1;

# creates the folder that will contain the evaluation scripts
mkdir .evalscripts

if (($bounded==1))
# Case bounded encoding
then
  boundedOutputFile="results/boundedResults_$1.csv"
  echo "inputfile,table,encoding,bound,check,result,expectedResult,time" > $boundedOutputFile
  #defines an array containing all the bounded encodings
  boundedencodings=("BeArFs" "BeArVs" "BeUfFs" "BeUfVs")
  len=${#boundedencodings[@]}

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

        #bound=$((${threshold[$tableindex]}+100));
        bound=$((${threshold[$tableindex]}));
    #    echo $bound;
        pythonfile=".evalscripts/${boundedencodings[$i]}$tablename${analysis[$tableindex]}-$bound.py"

        (time ./execBounded.sh $inputfile $pythonfile ${boundedencodings[$i]}  ${expectedResults[$tableindex]} $bound ${analysis[$tableindex]} $boundedOutputFile $timeoutvalue $tabname) 2>> $boundedOutputFile

      done
  done
else
  # Case unbounded encoding
  unboundedOutputFile="results/unboundedResults_$1.csv"
  echo "inputfile,table,encoding,check,result,expectedResult,time" > $unboundedOutputFile
  #defines an array containing all the unbounded encodings
  unboundedencodings=("UeArFs" "UeArVs" "UeUfFs" "UeUfVs")
  len=${#unboundedencodings[@]}
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
