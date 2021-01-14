package com.globant.aimate.model;


public class AIMateException extends Exception {

	private static final long serialVersionUID = 3765972072046728734L;

	public AIMateException() {
        super();
    }

	public AIMateException(String message, Throwable cause) {
        super(message, cause);
    }
    
	public AIMateException(String message) {
        super(message);
    }
    
	public AIMateException(Exception e) {
        super(e);
    }
	
}
