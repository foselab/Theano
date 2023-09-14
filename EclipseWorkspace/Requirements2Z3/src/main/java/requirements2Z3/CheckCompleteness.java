package requirements2Z3;

import requirements2Z3.completeness.checkers.UeUfFsCompletenessCheckers;

public class CheckCompleteness {

	public static void main(String[] args) throws Exception {

		String folder = "TestsCompleteness";
		String[] requirementsTablesFileNames = new String[] { "Table2" };
		String encoding = "UeUfFs";

		for (String fileName : requirementsTablesFileNames) {

			System.out.println("Processing the file: " + "./" + folder + "/" + fileName + ".txt");
			new UeUfFsCompletenessCheckers("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/" + encoding + "/" + fileName + ".py");
		}
	}

}
