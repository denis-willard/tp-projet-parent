package fr.natsystem.tp.core.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NeCommencePasParXValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeCommencePasParX {
	String message() default "Le champ ne doit pas commencer par un X";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
