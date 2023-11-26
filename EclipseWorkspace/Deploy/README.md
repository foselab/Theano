*** Running Theano
Running Theano requires to perform three steps:

(a) Convert the Requirements table into a file ".rt"  processable by Theano run

(b) Generate the python scripts
	java -jar Theano.jar -i ./Table2.rt -o ./UeArFsTable2.py -e UeArFs -t consistency

(c) Check for consistency
	python3 ./UeArFsTable2.py


*** Evaluation
To generate the Requirements Tables of our benchmark, open the folder benchmarkGenerator run the script generateTables.sh

''sh generateTables.sh''

This script will generate the benchmarkTales into the folder benchmarkTables.

The names of the tables generated from the Baseline Tables 1,2,3, and 4 will be respectively start with Table1, Table2, Table3, and Table 4.

** RQ1 
