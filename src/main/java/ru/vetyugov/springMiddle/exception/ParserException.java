package ru.vetyugov.springMiddle.exception;

public class ParserException extends SpringMiddleException{
    public ParserException(String message) {
        super(message);
    }

    public ParserException(Throwable cause) {
        super(cause);
    }
}
