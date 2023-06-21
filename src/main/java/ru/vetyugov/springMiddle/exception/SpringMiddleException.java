package ru.vetyugov.springMiddle.exception;

public class SpringMiddleException extends RuntimeException{
    public SpringMiddleException(String message) {
        super(message);
    }

    public SpringMiddleException(Throwable cause) {
        super(cause);
    }
}
