package fr.natsystem.tp.core.exception;

public class NotFoundException extends GenericException {
    private static final long serialVersionUID = -7276583262551664082L;
    public static final String ERROR_GET="L'identifiant {0} ne correspond à aucun enregistrement en base. Veuillez essayer avec une autre valeur.";

	public NotFoundException(String messageCode, String origin, String message,
			String... messageParam) {
		super(messageCode, origin, message, messageParam);
	}

	public NotFoundException(String messageCode, String origin, String message,
			Throwable cause, String... messageParam) {
		super(messageCode, origin, message, cause, messageParam);
	}

}

