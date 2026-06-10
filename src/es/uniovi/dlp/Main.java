package es.uniovi.dlp;

import es.uniovi.dlp.codegenerator.CodeGenerator;
import es.uniovi.dlp.codegenerator.ExecuteCGVisitor;
import es.uniovi.dlp.codegenerator.OffSetVisitor;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import org.antlr.v4.runtime.*;

import es.uniovi.dlp.ast.ASTNode;
import es.uniovi.dlp.errorhandler.ErrorHandler;
import es.uniovi.dlp.parser.*;
import es.uniovi.dlp.semantic.IdentificationVisitor;
import es.uniovi.dlp.semantic.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		if (args.length<2) {
			System.err.println("Please, pass me the input and output files.");
			return;
		}

		// create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		PmmParser parser = new PmmParser(tokens);	
		ASTNode ast = parser.program().ast;

		/*if (parser.getNumberOfSyntaxErrors() > 0) {
			return;
		}*/

		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new TypeCheckingVisitor(),null);

		// * Check errors
		if(ErrorHandler.getInstance().anyError()){
			// * Show errors
			ErrorHandler.getInstance().showErrors(System.err);
		}
		else{
			// * The AST is shown
			ast.accept(new OffSetVisitor(),null);
			ast.accept(new ExecuteCGVisitor(new CodeGenerator(args[1], args[0])), null);
			//IntrospectorModel model=new IntrospectorModel("Program", ast);
			//new IntrospectorView("Introspector", model);
		}
	}
}
