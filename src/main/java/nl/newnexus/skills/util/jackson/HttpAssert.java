package nl.newnexus.skills.util.jackson;

import com.sun.jersey.api.NotFoundException;

/**
 * Helper which validates objects and throws JAX-RS interpretable exceptions
 * @author xandera
 *
 */
public final class HttpAssert {

	private HttpAssert() {
	}
	
	/**
	 * Check if the entity is found
	 * @param object object
	 */
	public static void throwNotFoundWhenNull(final Object object) {
		throwWhenTrue(object == null, new NotFoundException());
	}
	
	
	/**
	 * Check if the entity is found
	 * @param object object
	 * @param r the exception to throw
	 * @throws exception
	 */
	public static void throwWhenNull(final Object object, final RuntimeException r) {
		throwWhenTrue(object == null, r);
	}
	
	/**
	 * Check if the entity is found
	 * @param object object
	 * @param r the exception to throw
	 * @throws exception
	 */
	public static void throwWhenNotNull(final Object object, final RuntimeException r) {
		throwWhenTrue(object != null, r);
	}
	
	/**
	 * Throw r when condition is true
	 * @param condition condition
	 * @param r r
	 */
	public static void throwWhenTrue(final boolean condition, final RuntimeException r) {
		if (condition) {
			throw r;
		}
	}

}
