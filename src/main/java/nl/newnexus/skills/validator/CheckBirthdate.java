package nl.newnexus.skills.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author mikew
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckBirthdateValidator.class)
@Documented
public @interface CheckBirthdate {

	String message() default "{nl.famed.constraints.valid.birthdate}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
