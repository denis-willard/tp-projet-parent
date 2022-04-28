package fr.natsystem.tp.data.annotations;

import javax.validation.Payload;

public @interface OuiOuNon {

	String message() default "Les seules valeurs autorisées sont OUI et NON";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    
}
