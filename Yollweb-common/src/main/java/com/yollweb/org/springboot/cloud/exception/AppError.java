package com.yollweb.org.springboot.cloud.exception;

/**
 * 一般是程序错误导致的；
 *
 */
public class AppError extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1232434356L;

	public AppError() {
    }

    public AppError(String message) {
        super(message);
    }

    public AppError(String message, Throwable cause) {
        super(message, cause);
    }

    public AppError(Throwable cause) {
        super(cause);
    }
}
