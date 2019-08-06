package edu.epam.training.task4.exception;

public class ParserException extends Exception {

    private static final long serialVersionUID = -6212184677700761249L;

    public ParserException() {
    }

    public ParserException(String message) {
        super (message);
    }

    public ParserException(String message, Throwable cause) {
        super (message, cause);
    }

    public ParserException(Throwable cause) {
        super (cause);
    }

    public ParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super (message, cause, enableSuppression, writableStackTrace);
    }
}
