package nl.newnexus.skills.validator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;
import org.joda.time.Years;

public class CheckBirthdateValidator implements ConstraintValidator<CheckBirthdate, Date> {
	private static final int MIN_AGE = 18;

	/**
	 * Regular expression for a birthday.
	 */

	@Override
	public boolean isValid(final Date object, final ConstraintValidatorContext constraintContext) {

		if (object != null && isInFuture(object)) {
			return false;
		}
		if (youngerThanYearsAgo(object, MIN_AGE)) {
			return false;
		}

		return true;
	}

	@Override
	public void initialize(final CheckBirthdate constraintAnnotation) {

	}

	private boolean isInFuture(final Date geboortedatum) {

		return new Date().before(geboortedatum);
	}

	/**
	 * Check if a date is younger than a number of years ago.
	 * 
	 * @param date
	 *            The date.
	 * @param numberOfYears
	 *            The number of years.
	 * @return True if longer than years ago, false otherwise.
	 */
	public static boolean youngerThanYearsAgo(final Date date, final int numberOfYears) {
		return numberOfYears > yearsBetween(date, new Date());
	}

	/**
	 * Return the years between to dates.
	 * 
	 * @param date1
	 *            Date 1
	 * @param date2
	 *            Date 2
	 * @return The number of years.
	 */
	public static int yearsBetween(final Date date1, final Date date2) {
		return Years.yearsBetween(new DateTime(date1), new DateTime(date2)).getYears();
	}

}