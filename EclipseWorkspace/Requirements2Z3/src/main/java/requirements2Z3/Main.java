package requirements2Z3;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import requirements2Z3.checkers.BeArFsChecker;
import requirements2Z3.checkers.BeArVsChecker;
import requirements2Z3.checkers.BeUfFsChecker;
import requirements2Z3.checkers.BeUfVsChecker;
import requirements2Z3.checkers.UeArFsChecker;
import requirements2Z3.checkers.UeArVsChecker;
import requirements2Z3.checkers.UeUfFsChecker;
import requirements2Z3.checkers.UeUfVsChecker;
import requirements2Z3.consistency.BoundedCompletenessChecker;
import requirements2Z3.consistency.BoundedConsistencyChecker;
import requirements2Z3.consistency.CompletenessChecker;
import requirements2Z3.consistency.ConsistencyChecker;

public class Main {

	public static void main(String[] args) throws Exception {
		Options options = new Options();
		String currentPath = new java.io.File(".").getCanonicalPath();
		
		Option input = new Option("i", "inputFile", true, "input file path");
		input.setRequired(true);
		options.addOption(input);

		Option output = new Option("o", "inputFile", true, "output file path");
		output.setRequired(true);
		options.addOption(output);

		Option type = new Option("t", "type", true, "consistency | completeness");
		type.setRequired(true);
		options.addOption(type);

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

		System.out.println("-----------------------------------------");
		System.out.println("Processing the file: "+inputFilePath);
		System.out.println("-----------------------------------------");
		String typeInput = cmd.getOptionValue("t") != null ? cmd.getOptionValue("t") : cmd.getOptionValue("type");

		switch (typeInput) {
		case "consistency":
			manageConsistency(inputFilePath, outputFilePath, selectedEncoding);
			break;

		case "completeness":
			manageCompleteness(inputFilePath, outputFilePath, selectedEncoding);
			break;

		default:
			throw new IllegalArgumentException("Type: " + typeInput + " is not supported. ");

		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("File: "+outputFilePath+" correctly generated");
		System.out.println("Run \"python3 "+outputFilePath+"\" to check for "+typeInput);
		
		System.out.println("--------------------------------------------------------------");

	}

	private static void manageConsistency(String inputFilePath, String outputFilePath, String selectedEncoding)
			throws Exception {
		int ts = 2;
		int bound = 4;
		int index = 0;
		switch (selectedEncoding) {
		// unbounded
		case "UeArFs":
			new UeArFsChecker(inputFilePath, outputFilePath, new ConsistencyChecker(), ts).check();
			break;
		case "UeUfFs":
			new UeUfFsChecker(inputFilePath, outputFilePath, new ConsistencyChecker(), ts).check();
			break;
		case "UeArVs":
			new UeArVsChecker(inputFilePath, outputFilePath, new ConsistencyChecker()).check();
			break;
		case "UeUfVs":
			new UeUfVsChecker(inputFilePath, outputFilePath, new ConsistencyChecker()).check();
			break;
			// bounded
		case "BeArFs":
			new BeArFsChecker(inputFilePath, outputFilePath, new BoundedConsistencyChecker(ts, bound, index), ts,
					bound).check();
			break;
		case "BeUfFs":
			new BeUfFsChecker(inputFilePath, outputFilePath, new BoundedConsistencyChecker(ts, bound, index), ts,
					bound).check();
			break;
		case "BeArVs":
			new BeArVsChecker(inputFilePath, outputFilePath, new BoundedConsistencyChecker(ts, bound, index), bound).check();
			break;
		case "BeUfVs":
			new BeUfVsChecker(inputFilePath, outputFilePath, new BoundedConsistencyChecker(ts, bound, index), bound).check();
			break;
		default:
			throw new IllegalArgumentException("Encoding: " + selectedEncoding + " is not supported. ");
		}
	}

	private static void manageCompleteness(String inputFilePath, String outputFilePath, String selectedEncoding)
			throws Exception {
		int ts = 2;
		int bound = 4;
		switch (selectedEncoding) {
		// unbounded
		case "UeArFs":
			new UeArFsChecker(inputFilePath, outputFilePath, new CompletenessChecker(), ts).check();
			break;
		case "UeUfFs":
			new UeUfFsChecker(inputFilePath, outputFilePath, new CompletenessChecker(), ts).check();
			break;
		case "UeArVs":
			new UeArVsChecker(inputFilePath, outputFilePath, new CompletenessChecker()).check();
			break;
		case "UeUfVs":
			new UeUfVsChecker(inputFilePath, outputFilePath, new CompletenessChecker()).check();
			break;
			// bounded
		case "BeArFs":
			new BeArFsChecker(inputFilePath, outputFilePath, new BoundedCompletenessChecker(ts, bound), ts, bound).check();
			break;
		case "BeUfFs":
			new BeUfFsChecker(inputFilePath, outputFilePath, new BoundedCompletenessChecker(ts, bound), ts, bound).check();
			break;
		case "BeArVs":
			new BeArVsChecker(inputFilePath, outputFilePath, new BoundedCompletenessChecker(ts, bound), bound).check();
			break;
		case "BeUfVs":
			new BeUfVsChecker(inputFilePath, outputFilePath, new BoundedCompletenessChecker(ts, bound), bound).check();
			break;
		default:
			throw new IllegalArgumentException("Encoding: " + selectedEncoding + " is not supported. ");
		}
	}

}
