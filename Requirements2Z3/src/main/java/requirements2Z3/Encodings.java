package requirements2Z3;

import java.io.FileReader;
import java.io.FileWriter;

import requirements2Z3.analysis.Translator;
import requirements2Z3.consistency.Functionality;
import requirements2Z3.factory.BeArFsFactory;
import requirements2Z3.factory.BeArVsFactory;
import requirements2Z3.factory.BeUfFsFactory;
import requirements2Z3.factory.BeUfVsFactory;
import requirements2Z3.factory.UeArFsFactory;
import requirements2Z3.factory.UeArVsFactory;
import requirements2Z3.factory.UeUfFsFactory;
import requirements2Z3.factory.UeUfVsFactory;
import requirements2Z3.visitors.translators.Table2Z3Visitor;

public enum Encodings {
	UeArFs, 
	UeUfFs,
	UeArVs,
	UeUfVs,
	BeArFs,
	BeUfFs,
	BeArVs,
	BeUfVs;
	
	public static <T extends Table2Z3Visitor> Translator<? extends Table2Z3Visitor> translate(String inputFilePath, String outputFilePath,
			String selectedEncoding, int bound, Functionality<T> functionality) throws Exception {
		float ts = 2;

		
		Translator<? extends Table2Z3Visitor> translator;
		Table2Z3Visitor z3visitor = null;
		
		switch (Encodings.valueOf(selectedEncoding)) {
		// unbounded
		case UeArFs:
			z3visitor = new UeArFsFactory(ts).getVisitor();
			break;
		case UeUfFs:
			z3visitor = new UeUfFsFactory(ts).getVisitor();
			break;
		case UeArVs:
			z3visitor = new UeArVsFactory().getVisitor();
			break;
		case UeUfVs:
			z3visitor = new UeUfVsFactory().getVisitor();
			break;
		// bounded
		case BeArFs:
			z3visitor = new BeArFsFactory(bound, ts).getVisitor();
			break;
		case BeUfFs:
			z3visitor = new BeUfFsFactory(bound, ts).getVisitor();
			break;
		case BeArVs:
			z3visitor = new BeArVsFactory(bound).getVisitor();
			break;
		case BeUfVs:
			z3visitor = new BeUfVsFactory(bound).getVisitor();
			break;
		default:
			throw new IllegalArgumentException("Encoding: " + selectedEncoding + " is not supported. ");
		}
		return new Translator(z3visitor, functionality, new FileReader(inputFilePath), new FileWriter(outputFilePath));
	}
}
