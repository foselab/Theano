These scripts are designed to work on the HPC platform provided by Compute Canada.

Minor changes have to be applied if the scripts need to be executed on another HPC platform or on a standalone PC.


To replicate our experiments copy the file Theano.jar in this folder.

This folder is organized as follows:

- RQBenchmarkGenerator.sh Generates the benchmark tables into a folder called benchmarkTables. The file input.csv contained in this folder will list all the benchmark tables and the expected boundedResults_

- RQ1and2.sh: this script replicates the experiments for RQ1 and RQ2. This script uses the scripts execBounded.sh and execUnbounded.sh to run the experiments.

- execBounded.sh: Executes a single bounded experiment

- execUnbounded.sh: Executes a single unbounded experiment
