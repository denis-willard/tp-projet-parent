package fr.natsystem.tp.core.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DateDansLePasseValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateDansLePasse {
	
	String message() default "La date doit être antérieure à la date du jour";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
