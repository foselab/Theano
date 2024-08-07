package requirements2Z3;

import java.io.FileReader;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import generated.matlabLexer;
import generated.matlabParser;
import requirements2Z3.consistency.BoundedCompletenessTranslator;
import requirements2Z3.consistency.BoundedConsistencyTranslator;
import requirements2Z3.consistency.Functionality;
import requirements2Z3.consistency.UnboundedCompletenessTranslator;
import requirements2Z3.consistency.UnboundedConsistencyTranslator;
import requirements2Z3.rqt.RQTable;
import requirements2Z3.visitors.RQTableToStringVisitor;
import requirements2Z3.visitors.translators.Table2Z3Visitor;

public class Main {

	public static void main(String[] args) throws Exception {
		Options options = new Options();

		Option input = new Option("i", "inputFile", true, "input file path");
		input.setRequired(true);
		options.addOption(input);

		Option output = new Option("o", "inputFile", true, "output file path");
		output.setRequired(true);
		options.addOption(output);

		Option type = new Option("t", "type", true, "consistency | completeness");
		type.setRequired(true);
		options.addOption(type);

		Option bound = new Option("b", "bound", true, "the bound");
		bound.setRequired(false);
		options.addOption(bound);

		Option encoding = new Option("e", "encoding", true,
				"encoding one among BeArFs | BeArVs | BeUfFs | BeUfVs | UeArFs | UeArVs | UeUfFs | UeUfVs");
		encoding.setRequired(true);
		options.addOption(encoding);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine cmd = null;// not a good practice, it serves it purpose

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp("utility-name", options);

			System.exit(1);
		}

		String inputFilePath = cmd.getOptionValue("i") != null ? cmd.getOptionValue("i") : cmd.getOptionValue("input");
		String outputFilePath = cmd.getOptionValue("o") != null ? cmd.getOptionValue("o")
				: cmd.getOptionValue("output");
		String selectedEncoding = cmd.getOptionValue("e") != null ? cmd.getOptionValue("e")
				: cmd.getOptionValue("encoding");

		String boundVal = cmd.getOptionValue("b") != null ? cmd.getOptionValue("b") : cmd.getOptionValue("bound");

		int boundparam = boundVal != null ? Integer.parseInt(boundVal)+2 : -1;

		// System.out.println("Processing the file: "+inputFilePath);
		String typeInput = cmd.getOptionValue("t") != null ? cmd.getOptionValue("t") : cmd.getOptionValue("type");

		
		Reader sc=new FileReader(inputFilePath);
		matlabLexer lexer = new matlabLexer(new ANTLRInputStream(sc));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		matlabParser rqParser = new matlabParser(tokens);
		rqParser.setBuildParseTree(true);


		RQTable rqTable = rqParser.primaryExpression().rqt;
		
		
		double ts=(rqTable.getTd()!=null) ? rqTable.getTd().getConstant() :-1;
		
		System.out.println(rqTable.accept(new RQTableToStringVisitor()));
		switch (typeInput) {
		case "consistency":
			if (cmd.getOptionValue("b") != null) {
				translate(inputFilePath, outputFilePath, selectedEncoding, boundparam,
						new BoundedConsistencyTranslator(),ts);
			} else {
				translate(inputFilePath, outputFilePath, selectedEncoding, boundparam,
						new UnboundedConsistencyTranslator(),ts);
			}
			break;

		case "completeness":
			if (cmd.getOptionValue("b") != null) {
				translate(inputFilePath, outputFilePath, selectedEncoding, boundparam,
						new BoundedCompletenessTranslator(),ts);
			} else {
				translate(inputFilePath, outputFilePath, selectedEncoding, boundparam,
						new UnboundedCompletenessTranslator(),ts);
			}
			break;

		default:
			throw new IllegalArgumentException("Type: " + typeInput + " is not supported. ");

		}
		System.out.println("File: " + outputFilePath + " correctly generated");
		System.out.println("Run \"python3 " + outputFilePath + "\" to check for " + typeInput);

	}

	private static <T extends Table2Z3Visitor> void translate(String inputFilePath, String outputFilePath,
			String selectedEncoding, int bound, Functionality<T> functionality, double ts) throws Exception {
		
		Encodings.translate(inputFilePath, outputFilePath, selectedEncoding, bound, functionality,ts).translate();
	}
}
