package requirements2Z3;

import java.io.Writer;
import java.util.Scanner;

public interface RTFunctionality {

	public void processRequirements(Scanner sc, Writer wt,Checker ck) throws Exception;
	
	public abstract void printPositiveResult(Scanner sc, Writer wt) throws Exception;
	
	public abstract void printNegativeResult(Scanner sc, Writer wt) throws Exception;
}
