package nl.newnexus.skills.validator;

import nl.newnexus.skills.model.Geslacht;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author mikew
 */
public class CheckGeslachtValidator implements
        ConstraintValidator<CheckGeslacht, Geslacht> {

    /**
     * Check on geslacht.
     */
    public boolean isValid(Geslacht geslacht,
                           ConstraintValidatorContext constraintContext) {

        //wordt momenteel niet meegegeven
        if (geslacht == null) {
            return true;
        }

        if (geslacht.isMan() || geslacht.isVrouw()) {
            return true;
        }
        return false;
    }

    @Override
    public void initialize(CheckGeslacht constraintAnnotation) {

    }

}