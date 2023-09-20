package requirements2Z3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;

public class Requirements2Z3 {

	public static void main(String[] args) throws Exception {
		
		
		Scanner sc=new Scanner(new FileReader("./Table1.txt"));
		
		Writer wt=new FileWriter("./Table1.py");
		
		wt.write("from z3 import *;\n");
				
		if(!(sc.nextLine().equals("------- Input Data -----"))) {
			sc.close();
			wt.close();
			throw new Exception("The file does not start with the string \"------- Input Data -----\" ");
		}
		
		String nextLine=null;
		if(sc.hasNext()) {
			nextLine=sc.nextLine();
		}
		
		
		System.out.println("Creating the variables");
		
		while(nextLine!=null && !nextLine.equals("------- Requirements -----")) {
			
			String[] splitted=nextLine.split(",");
			
			if(splitted[1].equals("Real")) {
				wt.write(splitted[0]+"="+"Real('"+splitted[0]+"')\n");
			}
			nextLine=sc.nextLine();	
		}
		
		
		
		
		StringBuilder requirements = new StringBuilder();
		while (sc.hasNextLine())
		{
			requirements.append(sc.nextLine()).append("\n");
		}
		
		String[] requirementLines = requirements.toString().split("\n");
		
		for (String requirement : requirementLines)
		{
			String[] parts = requirement.split(" ");
			
			if (parts.length == 3)
			{
				String variable = parts[0];
				String operation = parts[1];
				String value = parts[2];
				
				String symbol = operation.equals("==") ? "=" : operation;
				
				String result = variable + symbol + "('" + value + "')";
				wt.write(result + "\n");
			}
		}
		
		
		
		sc.close();
		wt.close();	
	}	

	private static String conversion(String input) {
		matlabLexer lexer = new matlabLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		matlabParser parser = new matlabParser(tokens);
		parser.setBuildParseTree(true);
		
		ParseTree tree = parser.statement_list();
		
		
		String result=tree.accept(new UeUfFs());
		return result;
	}
}
