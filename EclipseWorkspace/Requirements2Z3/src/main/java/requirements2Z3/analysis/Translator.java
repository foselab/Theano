package requirements2Z3.analysis;

import java.io.Reader;
import java.io.Writer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;
import requirements2Z3.consistency.Functionality;
import requirements2Z3.encodings.Encoder;
import requirements2Z3.visitors.DefineVariablesVisitor;
import requirements2Z3.visitors.translators.Table2Z3Visitor;
import requirements2Z3.z3formulae.Z3Formula;

public class Translator<T extends Table2Z3Visitor> {

	private Encoder encoder;
	private T z3visitor;
	private Reader sc;
	private Writer wt;
	private Functionality<T> functionality;

	public Encoder getEncoder() {
		return this.encoder;
	}

	public Translator(T z3visitor, Functionality<T> functionality, Reader scanner, Writer writer) {
		this.z3visitor = z3visitor;
		this.encoder = z3visitor.getEncoder();
		this.functionality = functionality;
		this.sc = scanner;
		this.wt = writer;
	}

	public void translate() throws Exception {

		matlabLexer lexer = new matlabLexer(new ANTLRInputStream(sc));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		matlabParser parser = new matlabParser(tokens);
		parser.setBuildParseTree(true);

		ParseTree tree = parser.primaryExpression();

		// creates the Z3 solver
		wt.write("from z3 import *;\n");

		wt.write("# Defines the Z3 solver\n");
		wt.write("s = Solver()\n");

		// Define the types I and R that are used to define variables
		wt.write("# Define I and R\n");
		wt.write("I = IntSort()\n");
		wt.write("R = RealSort()\n");

		// visits the requirements table and creates a String that defines the variables
		// to be used in the encoding
		wt.write("# Signal variables definition\n");

		wt.write(new DefineVariablesVisitor().visit(tree) + "\n");

		// defines the quantification variables
		wt.write("# Quantification variables\n");

		wt.write("j = Int('j')\n");
		wt.write("i = Int('i')\n");
		wt.write("k = Int('k')\n");

		// define the timestamp array
		wt.write("# Timestamp structure\n");
		wt.write(this.encoder.defineTraceVariable());

		// add the monotonicity constraint to the timestamp structure
		wt.write("# Timestamp structure monotonicity\n");
		wt.write("s.add(" + this.encoder.getMonotonicityConstraint() + ")\n");
		
		// add the encoding of the requirements table
		wt.write("# Requirements Table\n");
		wt.write("s.add(" +this.functionality.getEncodingActivity(z3visitor, tree)+")\n");

		wt.write("# Processing the result\n");
		wt.write(this.processResult());

		sc.close();
		wt.close();
	}

	/**
	 * this function adds a part that checks whether the result is sat or unsat, and
	 * the corresponding result based on the functionality (consistency or
	 * completeness)
	 * 
	 * @param sc
	 * @param wt
	 * @throws Exception
	 */
	private String processResult() throws Exception {

		StringBuilder b = new StringBuilder();

		b.append("res=s.check()\n");
		b.append("if (res.r ==  Z3_L_FALSE):\n");

		b.append(this.functionality.printPositiveResult());

		b.append("\t sys.exit(1)\n");
		b.append("else:\n");
		b.append("\t if (res.r == Z3_L_TRUE):\n");

		b.append(this.functionality.printNegativeResult());
		b.append("\t\t sys.exit(-1)\n");
		b.append("\t else:\n");
		b.append("\t\t print('unknown')\n");
		b.append("\t\t sys.exit(0)\n");

		return b.toString();
	}

	public Z3Formula visitTree(ParseTree tree) {
		return tree.accept(z3visitor);
	}
}