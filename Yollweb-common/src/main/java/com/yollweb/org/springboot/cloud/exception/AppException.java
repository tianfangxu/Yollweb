package com.yollweb.org.springboot.cloud.exception;

/**
 * 一般由于输入导致的；
 */
public class AppException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1628907543957269428L;

	public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
