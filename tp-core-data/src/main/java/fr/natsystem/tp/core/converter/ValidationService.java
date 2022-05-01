package fr.natsystem.tp.core.converter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.core.exception.ValidationEntityException;

@Service
public class ValidationService {
	private static final Logger LOGGER = LogManager.getLogger(ValidationService.class);
    private static final String MESSAGE_ERROR="BeanValidationService.checkConstraints : Orgine:{0} pour entite: {1}, il y a {2} constraintViolation";

	@Inject
	private Validator validator;

	public <T> void checkConstraints(T instance, String messagePrefix, String originMethod)
			throws ValidationEntityException {
		if (messagePrefix == null) {
			messagePrefix = "";
		}
		if (instance != null) {
			final String nameInstance = instance.getClass().getSimpleName();
			LOGGER.debug("checkConstraints pour {} : Verification contraintes sur : {}", originMethod, nameInstance);
			List<String> listeMessage = new ArrayList<>();
			final Set<ConstraintViolation<T>> constraintViolations = validator.validate(instance);

			readConstraints(messagePrefix, originMethod, nameInstance, listeMessage, constraintViolations);
		} else {
			LOGGER.warn("checkConstraints pour {} : une instance null a été passée.", originMethod);
		}
	}

	private <T> void readConstraints(String messagePrefix, String originMethod, String nameInstance,
			List<String> listeMessage, Set<ConstraintViolation<T>> constraintViolations)
			throws ValidationEntityException {
		if (constraintViolations != null && !constraintViolations.isEmpty()) {
			LOGGER.warn(
					"readConstraints pour {} : contraintes non valide sur : {} : Il y a {} violations de contrainte",
					originMethod, nameInstance, constraintViolations.size());
			for (final ConstraintViolation<T> violation : constraintViolations) {
				LOGGER.warn("readConstraints pour {} : contraintes invalide sur : {} : {}. Message={}", originMethod,
						nameInstance, violation.getPropertyPath(), stripFieldsList(violation.getMessage()));
				listeMessage.add(messagePrefix + stripFieldsList(violation.getMessage()));
			}
			String formattedString = MessageFormat.format(MESSAGE_ERROR, originMethod, nameInstance,
					constraintViolations.size());
			throw new ValidationEntityException(ValidationEntityException.ERROR_BASE, originMethod, formattedString,
					listeMessage, new Object[] { constraintViolations.size() });
		} else {
			LOGGER.debug("readConstraints pour {} : Pas d'erreur dans la validation des contraintes de : {}",
					originMethod, nameInstance);
		}
	}

	private String stripFieldsList(String message) {
		String regex = Pattern.quote("[") + ".*" + Pattern.quote("]");
		return message.replaceFirst(regex, "");
	}

}
