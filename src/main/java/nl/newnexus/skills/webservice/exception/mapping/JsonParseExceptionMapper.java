package nl.newnexus.skills.webservice.exception.mapping;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Handles the jackson JsonParseException. This exception is thrown when 
 * the JSON send from the client cannot be mapped to the Java model. 
 * Sends a BAD_REQUEST response
 * 
 * @author xandera
 *
 */
@Component
@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {
	private Logger logger = LoggerFactory.getLogger(JsonParseExceptionMapper.class);

	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(final JsonParseException exception) {
		logger.debug("Parse exception mapped to Bad Request", exception);
		
		return Response.status(Response.Status.BAD_REQUEST).
			  entity("Couldn't handle the request").
			  type(MediaType.APPLICATION_JSON).
			  build();
	}

}
