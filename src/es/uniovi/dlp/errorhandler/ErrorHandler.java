package es.uniovi.dlp.errorhandler;

import es.uniovi.dlp.ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {
    private List<ErrorType> errors = new ArrayList<>();
    private static ErrorHandler INSTANCE = new ErrorHandler();

    private ErrorHandler() {}

    public static ErrorHandler getInstance() {
        return INSTANCE;
    }

    public void addError(ErrorType error) {
        errors.add(error);
    }

    public void showErrors(PrintStream out) {
        //out.println(errors);
        for (ErrorType error : errors) {
            out.println(error); // Imprime el error y salta a la siguiente línea
        }
    }

    public boolean anyError() {
        return !errors.isEmpty();
    }
}
