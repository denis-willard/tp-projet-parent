package fr.natsystem.tp.core.exception;

import java.util.List;

public class ValidationEntityException extends GenericException {
    private static final long serialVersionUID = -7276583262551664082L;
    public static final String ERROR_BASE="Le controle de validation a détecté {0} anomalies de saisie. Merci de les corriger avant d'enregistrer.";

    /** une explication a destination d'un utilisateur de l'erreur */
    private final List<String> listeViolations;

	public ValidationEntityException(String messageCode, String origin, String message, List<String> listeViolations,
			Object[] paramMessage) {
		super(messageCode, origin, message, null, paramMessage);
		this.listeViolations = listeViolations;
	}

	public ValidationEntityException(String messageCode, String origin, String message) {
		super(messageCode, origin, message, null, null);
		this.listeViolations = null;
	}

	public List<String> getListeViolations() {
		return listeViolations;
	}

}

