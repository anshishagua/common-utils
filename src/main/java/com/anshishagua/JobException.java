package com.anshishagua;

public class JobException extends Exception {
    public JobException(String message) {
        super(message);
    }

    public JobException(Exception ex) {
        super(ex);
    }
}
