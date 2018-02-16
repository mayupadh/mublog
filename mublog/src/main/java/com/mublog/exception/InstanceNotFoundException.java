package com.mublog.exception;

public class InstanceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public InstanceNotFoundException(String message) {
        super(message);
    }
	
	public InstanceNotFoundException(Throwable e) {
        super(e);
    }
}
