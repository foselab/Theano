#!/bin/sh

#unset JAVA_TOOL_OPTIONS
export JAVA_TOOL_OPTIONS="-Xms256m -Xmx2g"
source $LMOD_PKG/init/zsh
source $LMOD_PKG/init/ksh

module load java/17.0.2
module load python

source ~/my_z3venv/bin/activate

n_runs=10

for ((i=0;i<$n_runs;i++))

do
	sleep 60
	echo $i
	sbatch -t 10-00:00 -J "Theano $i" --mem 8000 RQ1and2.sh $i
done
deactivate
