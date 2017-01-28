package me.common.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 2646071524977955111L;

	public ServiceException(final String message) {
		super(message);
	}

}
