package fr.natsystem.tp.core.exception;

public class ForbiddenException extends GenericException {
    private static final long serialVersionUID = -7276583262551664082L;

	public ForbiddenException(String messageCode, String origin, String message,
			String... messageParam) {
		super(messageCode, origin, message, messageParam);
	}

	public ForbiddenException(String messageCode, String origin, String message,
			Throwable cause, String... messageParam) {
		super(messageCode, origin, message, cause, messageParam);
	}

}
