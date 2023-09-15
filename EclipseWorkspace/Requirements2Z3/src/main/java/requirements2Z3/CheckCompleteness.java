package requirements2Z3;

import requirements2Z3.completeness.checkers.UeArFsCompletenessCheckers;
import requirements2Z3.completeness.checkers.UeArVsCompletenessCheckers;
import requirements2Z3.completeness.checkers.UeUfFsCompletenessCheckers;
import requirements2Z3.completeness.checkers.UeUfVsCompletenessCheckers;

public class CheckCompleteness {

	public static void main(String[] args) throws Exception {

		String folder = "TestsCompleteness";
		String[] requirementsTablesFileNames = new String[] { "Table3" };
		String encoding = "UeUfFs";

		for (String fileName : requirementsTablesFileNames) {

			System.out.println("Processing the file: " + "./" + folder + "/" + fileName + ".txt");
			new UeArFsCompletenessCheckers("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/UeArFs" + fileName + ".py",2);
			
			new UeUfFsCompletenessCheckers("./" + folder + "/" + fileName + ".txt",
					"./" + folder  + "/UeUfFs" + fileName + ".py",2);
			
			new UeArVsCompletenessCheckers("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/UeArVs" + fileName + ".py");
			
			new UeUfVsCompletenessCheckers("./" + folder + "/" + fileName + ".txt",
					"./" + folder  + "/UeUfVs" + fileName + ".py",2);
			

		}
	}

}
