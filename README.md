This project provides a framework that enable the verification of the consistency and completeness of Requirements Tables.

The project is made by three parts:

(i) The requirementExtractor: it extracts from a model the requirements associated with a given Requirement Tables. The requirementExtractor is a matlab function. It can be executed as follows:
requirementsTable2requirements("Model", "DestinationFile");

For example, the command

requirementsTable2requirements("ProjectExamples/Example1.slx","ProjectExamples/Example1.txt");

writes the requirements of the Requirements Tables contained in the Simulink model Example1 in the file requirementsExample1.txt

(ii)


The project is structured as follows 

- ProjectExamples: contains a set of projects that are used to test the application