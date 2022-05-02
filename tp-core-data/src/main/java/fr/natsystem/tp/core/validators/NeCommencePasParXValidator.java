package fr.natsystem.tp.core.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NeCommencePasParXValidator implements ConstraintValidator<NeCommencePasParX, String>{

	public void initialize(String nom) {
		
	}
	
	public boolean isValid(String nom, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(nom)) return true;
		if (nom.startsWith("X")) return false;
		
		return true;
	}
}
