package fr.natsystem.tp.data.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = OuiOuNonValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OuiOuNon {

	String message() default "Les seules valeurs autorisées sont OUI et NON";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    
}
