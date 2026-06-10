package es.uniovi.dlp.parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods

	public static char lexemeToChar(String str) {
		if(str.length()==3){
			return str.charAt(1);
		} else if(str.length() > 3 && str.charAt(1)=='\\'){
			if(Character.isDigit(str.charAt(2))){
				try{
					return (char) Integer.parseInt(str.substring(2, str.length()-1));
				} catch(NumberFormatException e) {
					System.out.println(e);
				}
			}
			else{
				switch(str.charAt(2)){
					case 'n':
						return '\n';
					case 't':
						return '\t';
				}
			}
		}
        return '\\';
    }

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
}
