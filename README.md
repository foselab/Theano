This folder is organized as follows:

- Requirements2Z3: contains the eclipse project that enables converting Requirements Tables (.rt files) in z3

- Evaluation: contains the script related to the evaluation and the replication package

- Table1_5, Table2_5, Table3_5, Table4_5 are four examples of Requirements Tables.




<h1> Running Theano </h1>

- To run Theano, copy the file Theano.jar from [https://github.com/foselab/Theano/releases](https://github.com/foselab/Theano/releases)  in this folder.

- Then run

<code>java -jar Theano.jar -i Table1_5.rt -o Table1_5.py -e BeUfVs -t completeness -b 6</code>

Then, run

<code>python3 Table1_5.py</code>


The options for the java -jar Theano.jar are as follows:

- i: inputFile (input file path)

- o: outputFile (output file path)

- t: type (consistency | completeness)

- b: bound (the bound)

- e: encoding (one among BeArFs | BeArVs | BeUfFs | BeUfVs | UeArFs | UeArVs | UeUfFs | UeUfVs)


<h1> Executing the Complete Workflow </h1>


(a) Generate the .rt files from Simulink. Run the following command

<code>RT2Text("SimulinkExamples/Example1.slx")</code>

(b) Generate the .py from the .rt file. Run

<code>java -jar Theano.jar -i Table1.rt -o Table1.py -e UeUfVs -t completeness</code>

(c) Run the .py file. Running

<code>python3 Table1.py</code>
