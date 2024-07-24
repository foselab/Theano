#!/bin/sh
rm -rf benchmarkTables
mkdir benchmarkTables


threshouldvalues=$(seq 50 50 2000)

# uncomment to generate the smaller tables
#threshouldvalues=$(seq 10 5 50)

# used to select the completeness our consistency experiments
completeness=1;


echo "table,analysis,expectedResult,threshold" > ./benchmarkTables/input.csv

for threshold in $threshouldvalues
do
    # Baseline Table 1
    echo "vardef
      u,Int,input;
      y,Int,output;
    endvardef
    reqdef
      isStartup, y == 0;
      !isStartup & u > 0, y == prev(y) + 1;
      !isStartup & prev(y) == $threshold, y < $threshold;
    endreqdef" > ./benchmarkTables/Table1_$threshold.rt

    if (($completeness==1))
    then
      echo "Table1_$threshold.rt,completeness,Incomplete,$threshold" >> ./benchmarkTables/input.csv
    else
      echo "Table1_$threshold.rt,consistency,Inconsistent,$threshold" >> ./benchmarkTables/input.csv
    fi

    # Baseline Table 2
    echo "vardef
      u,Int,input;
      y,Int,output;
    endvardef
    reqdef
      isStartup, y == 0;
      !isStartup, y == prev(y) + 1;
      !isStartup & prev(y) == $threshold, y < $threshold;
    endreqdef" > ./benchmarkTables/Table2_$threshold.rt
    if (($completeness==1))
    then
      echo "Table2_$threshold.rt,completeness,Complete,$threshold" >> ./benchmarkTables/input.csv
    else
      echo "Table2_$threshold.rt,consistency,Inconsistent,$threshold" >> ./benchmarkTables/input.csv
    fi

    # Baseline Table 3
    echo "vardef
      u,Int,input;
      y,Int,output;
    endvardef
    reqdef
      isStartup, y == 0;
      !isStartup & u == prev(u) + 1, y == prev(y) + 1;
      !isStartup & u ~= prev(u) + 1 & y < $threshold, y < $threshold;
    endreqdef" > ./benchmarkTables/Table3_$threshold.rt
    if (($completeness==1))
    then
      echo "Table3_$threshold.rt,completeness,Incomplete,$threshold" >> ./benchmarkTables/input.csv
    else
      echo "Table3_$threshold.rt,consistency,Consistent,$threshold" >> ./benchmarkTables/input.csv
    fi

    # Baseline Table 4
    echo "vardef
      u,Int,input;
      y,Int,output;
    endvardef
    reqdef
      isStartup, y == 0;
      !isStartup & u == prev(u) + 1, y == prev(y) + 1;
      !isStartup & u ~= prev(u) + 1, y < $threshold;
    endreqdef" > ./benchmarkTables/Table4_$threshold.rt

    if (($completeness==1))
    then
      echo "Table4_$threshold.rt,completeness,Complete,$threshold" >> ./benchmarkTables/input.csv
    else
      echo "Table4_$threshold.rt,consistency,Consistent,$threshold" >> ./benchmarkTables/input.csv
    fi
done
