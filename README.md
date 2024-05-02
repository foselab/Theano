# Theano

_Theano_ is a tool that checks the completeness and consistency of Requirements Tables.

## Repository Folders

- Requirements2Z3: contains the Eclipse project that enables converting Requirements Tables (.rt files) in z3

  - antlr4: grammar
  - java
  - resources: four examples of Requirements Tables

- Evaluation: contains the script related to the evaluation and the replication package

## Developer Section

### Install and setup

1. Install [Eclipse](https://www.eclipse.org/downloads/)
2. From Eclipse Marketplace, install:
   - Eclipse Xtend 2.34.0
   - ANTLR 4 IDE 0.3.6
3. Install [Maven](https://maven.apache.org/install.html)
4. Install [Python](https://www.python.org/downloads/)
5. Install Python libraries, creating a virtual environment

   ```terminal
   python -m venv .venv
   .venv\Scripts\activate
   pip install -r requirements.txt
   ```

6. In Requirements2Z3 folder, run the setup file from terminal

   ```terminal
   .\setup.sh
   ```

### Run

1. Open Requirements2Z3 project from Eclipse
2. Right click on Main.java in src/main/java/requirements2Z3
3. Click on Run As > Run Configurations...
4. In Arguments Tabs insert the parameters, for example:

   ```terminal
   -i src/main/resources/Table1_5.rt -o src/main/resources/Table1_5.py -e BeUfVs -t completeness -b 6
   ```

   All the options are explained [here](#options).

5. Run. At this point Python file is generated. You can run it from terminal:

   ```terminal
   python Table1_5.py
   ```

## User Section

### Requirements

- Java
- Python3
- MATLAB Simulink

### Install Python libraries

Follow instructions from point 5 of this [section](#install-and-setup).

### Running Theano

To run Theano, copy the file [Theano.jar](https://github.com/foselab/Theano/releases) in this folder. Then run:

```terminal
java -jar Theano.jar -i Table1_5.rt -o Table1_5.py -e BeUfVs -t completeness -b 6
```

Then, run

```terminal
python Table1_5.py
```

#### Options

The options for the java -jar Theano.jar are as follows:

- i: inputFile (input file path)

- o: outputFile (output file path)

- t: type (consistency | completeness)

- b: bound (the bound)

- e: encoding (one among BeArFs | BeArVs | BeUfFs | BeUfVs | UeArFs | UeArVs | UeUfFs | UeUfVs). More details in this [section](#encodings).

## Generate .rt files

You can also generate an .rt file from a Simulink model.

(a) In MATLAB Simulink, generate the .rt files running the following command

```matlab
RT2Text("SimulinkExamples/Example1.slx")
```

(b) In a terminal, generate the .py from the .rt file. Run

```terminal
java -jar Theano.jar -i Table1.rt -o Table1.py -e UeUfVs -t completeness
```

(c) Run the .py file. Running

```terminal
python3 Table1.py
```

## Encodings

| Encoding | Bound     | Trace    | Semantics     |
| -------- | --------- | -------- | ------------- |
| UeUfFs   | Unbounded | Function | Fixed Step    |
| UeUfVs   | Unbounded | Function | Variable Step |
| UeArFs   | Unbounded | Array    | Fixed Step    |
| UeArVs   | Unbounded | Array    | Variable Step |
| BeUfFs   | Bounded   | Function | Fixed Step    |
| BeUfVs   | Bounded   | Function | Variable Step |
| BeArFs   | Bounded   | Array    | Fixed Step    |
| BeArVs   | Bounded   | Array    | Variable Step |
