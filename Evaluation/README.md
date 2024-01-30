The evaluation folder is organized as follows:

- results: contains the results of the experiments and the scripts to visualize them.

*** Generate the benchmark

To run the experiments for RQ1 and RQ2 it is first necessary to generate the benchmark of Requirements Tables used to answer the questions. To generate the benchmark run the command

''sh RQBenchmarkGenerator''

This command creates the benchmark of Requirements Tables within the folder benchmarkTables

The names of the tables generated from the Baseline Tables 1,2,3, and 4 will be respectively start with Table1, Table2, Table3, and Table 4.




*** Running Theano
Running Theano requires to perform three steps:

(a) Convert the Requirements table into a file ".rt"  processable by Theano run

(b) Generate the python scripts
	java -jar Theano.jar -i ./Table2.rt -o ./UeArFsTable2.py -e UeArFs -t consistency

(c) Check for consistency
	python3 ./UeArFsTable2.py


*** Evaluation

** RQ1 and RQ2

Run the command

``sh RQ1and2.sh"
