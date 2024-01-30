#!/bin/sh
module load java/17.0.2
module load python

n_formulas=$(seq 1 1 10)

for i in "${n_formulas[@]}"
do
	echo $i
	sbatch -t 10-00:00 -J "Theano $i" --mem 8000 RQ1and2.sh $i
done


