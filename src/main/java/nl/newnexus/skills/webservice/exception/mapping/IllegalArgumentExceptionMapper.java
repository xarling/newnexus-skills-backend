package nl.newnexus.skills.webservice.exception.mapping;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author xandera
 *
 */
@Component
@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
	private Logger logger = LoggerFactory.getLogger(IllegalArgumentExceptionMapper.class);

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(final IllegalArgumentException exception) {
		logger.info("Parse exception mapped to Bad Request", exception);
		
		return Response.status(Response.Status.BAD_REQUEST).
			  entity("Couldn't handle the request. "+exception.getMessage()).
			  type(MediaType.APPLICATION_JSON).
			  build();
	}

}
