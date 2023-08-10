package requirements2Z3;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;

public class Requirements2Z3 {

	public static void main(String[] args) {
		
		
		matlabLexer lexer = new matlabLexer(new ANTLRInputStream("u1==x+1;"));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		matlabParser parser = new matlabParser(tokens);
		parser.setBuildParseTree(true);
		
		ParseTree tree = parser.statement_list();
		
		
		String result=tree.accept(new Matlab2Z3Visitor());
		
		System.out.println(result);
		
	}

}
