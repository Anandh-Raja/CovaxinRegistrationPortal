package com.wipro.covaxin.exceptionHandling;

public class DuplicateResourceException extends Exception{
    public DuplicateResourceException() {
        super();
    }
    public DuplicateResourceException(final String message) {
        super(message);
    }
}
