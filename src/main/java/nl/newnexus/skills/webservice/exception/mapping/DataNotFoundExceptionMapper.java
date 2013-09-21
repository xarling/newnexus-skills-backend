package nl.newnexus.skills.webservice.exception.mapping;

import nl.newnexus.skills.exception.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps the DataNotFoundException to a 404 not found
 * @author xandera
 *
 */
@Component
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
	private Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(final DataNotFoundException exception) {
		logger.debug("The entity isn't found", exception);
		
		return Response.status(Response.Status.NOT_FOUND).
				  entity(exception.getMessage()).
				  type(MediaType.APPLICATION_JSON).
				  build();
	}

}
