package fr.natsystem.tp.core.exception;

public class TechnicalException extends GenericException {
	private static final long serialVersionUID = 5155426429331070227L;

	public TechnicalException(String code, String origin, String message, Throwable cause) {
		super(code, origin, message, cause);
	}

	public TechnicalException(String messageCode, String origin, String message, Throwable cause,
			String... messageParam) {
		super(messageCode, origin, message, cause, messageParam);
	}

}

