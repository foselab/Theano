mkdir benchmarkTables

threshouldvalues=$(seq 50 50 2000)


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
  !isStartup & prev(y) == $threshold, y < 23;
endreqdef" > ./benchmarkTables/Table1_$threshold.rt
echo "Table1_$threshold.rt,completeness,Incomplete,$threshold" >> ./benchmarkTables/input.csv
echo "Table1_$threshold.rt,consistency,Inconsistent,$threshold" >> ./benchmarkTables/input.csv

# Baseline Table 2
echo "vardef
  u,Int,input;
  y,Int,output;
endvardef
reqdef
  isStartup, y == 0;
  !isStartup, y == prev(y) + 1;
  !isStartup & prev(y) == $threshold, y < 23;
endreqdef" > ./benchmarkTables/Table2_$threshold.rt
echo "Table2_$threshold.rt,completeness,Complete,$threshold" >> ./benchmarkTables/input.csv
echo "Table2_$threshold.rt,consistency,Inconsistent,$threshold" >> ./benchmarkTables/input.csv


# Baseline Table 3
echo "vardef
  u,Int,input;
  y,Int,output;
endvardef
reqdef
  isStartup, y == 0;
  !isStartup & u == prev(u) + 1, y == prev(y) + 1;
  !isStartup & u ~= prev(u) + 1 & y < $threshold, y < 23;
endreqdef" > ./benchmarkTables/Table3_$threshold.rt
echo "Table3_$threshold.rt,completeness,Incomplete,$threshold" >> ./benchmarkTables/input.csv
echo "Table3_$threshold.rt,consistency,Consistent,$threshold" >> ./benchmarkTables/input.csv

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
echo "Table4_$threshold.rt,completeness,Complete,$threshold" >> ./benchmarkTables/input.csv
echo "Table4_$threshold.rt,consistency,Consistent,$threshold" >> ./benchmarkTables/input.csv

done
