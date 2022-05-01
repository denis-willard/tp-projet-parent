package fr.natsystem.tp.data.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import fr.natsystem.tp.core.utilities.ConstantesOuiNon;

public class OuiOuNonValidator implements ConstraintValidator<OuiOuNon, String> {


	public void initialize(String valeur) {
        // initialisation si nécessaire
    }

    public boolean isValid(String valeur, ConstraintValidatorContext context) {

        if (StringUtils.isBlank(valeur)) return true;
        
        if ( ConstantesOuiNon.OUI.equals(valeur)) return true;
        if ( ConstantesOuiNon.NON.equals(valeur)) return true;
        
        return false;

    }


}
