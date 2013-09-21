package nl.newnexus.skills.webservice.exception.mapping;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Bad request exception, will send a http 400 response
 * @author xandera
 *
 */
public class BadRequestException extends WebApplicationException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BadRequestException() {
		super(Response.Status.BAD_REQUEST);
	}
	

}
