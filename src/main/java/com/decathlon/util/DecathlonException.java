package com.decathlon.util;

@SuppressWarnings("serial")
public class DecathlonException extends Exception {
	public DecathlonException(String msg) {
        super(msg);
    }

	public DecathlonException(String message, Exception e) {
		super(e);
	}
}


