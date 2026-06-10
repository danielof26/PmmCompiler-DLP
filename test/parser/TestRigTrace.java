package parser;

public class TestRigTrace {
	
	public static void main(String... args) throws Exception {
		org.antlr.v4.gui.TestRig.main(new String[]{"es.uniovi.dlp.parser.Pmm", "program", "-trace", "input.txt"});
	}
}
