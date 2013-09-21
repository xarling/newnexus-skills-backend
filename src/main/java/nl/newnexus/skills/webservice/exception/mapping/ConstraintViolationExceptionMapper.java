package nl.newnexus.skills.webservice.exception.mapping;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * 
 * Map the ContraintViolationException to a bad request 
 * 
 * @author xandera
 *
 */
@Component
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	private Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);
	
	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		logger.debug("Validation exception mapped to Bad Request", exception);
		
		return Response.status(Response.Status.BAD_REQUEST).
				  entity(exception.getMessage()).
				  type(MediaType.APPLICATION_JSON).
				  build();
	}

}
