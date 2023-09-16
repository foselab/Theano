package requirements2Z3;

import requirements2Z3.checkers.BeArFsChecker;
import requirements2Z3.checkers.BeArVsChecker;
import requirements2Z3.checkers.BeUfFsChecker;
import requirements2Z3.checkers.BeUfVsChecker;
import requirements2Z3.checkers.UeArFsChecker;
import requirements2Z3.checkers.UeArVsChecker;
import requirements2Z3.checkers.UeUfFsChecker;
import requirements2Z3.checkers.UeUfVsChecker;
import requirements2Z3.consistency.ConsistencyChecker;

public class MainChecker {

	public static void main(String[] args) throws Exception {

		String folder = "TestsCompleteness";
		String[] requirementsTablesFileNames = new String[] { "Table3" };
		String encoding = "UeUfFs";

		// check completeness
		for (String fileName : requirementsTablesFileNames) {
			
			
			System.out.println("Processing the file: " + "./" + folder + "/" + fileName + ".txt");
			// ------ consistency
			
			// unbounded
			new UeArFsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/UeArFs" + fileName + ".py",new ConsistencyChecker(),2);
			
			new UeUfFsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder  + "/UeUfFs" + fileName + ".py",new ConsistencyChecker(), 2);
			
			new UeArVsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/UeArVs" + fileName + ".py",new ConsistencyChecker());
			
			new UeUfVsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder  + "/UeUfVs" + fileName + ".py",new ConsistencyChecker(),2);
			
			// bounded
			new BeArFsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/UeArFs" + fileName + ".py",new ConsistencyChecker(),2,4);
			
			new BeUfFsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder  + "/UeUfFs" + fileName + ".py",new ConsistencyChecker(), 2,4);
			
			new BeArVsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder + "/UeArVs" + fileName + ".py",new ConsistencyChecker(),2);
			
			new BeUfVsChecker("./" + folder + "/" + fileName + ".txt",
					"./" + folder  + "/UeUfVs" + fileName + ".py",new ConsistencyChecker(),2);

		}
	}

}
