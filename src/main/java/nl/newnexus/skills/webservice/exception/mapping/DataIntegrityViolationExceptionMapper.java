package nl.newnexus.skills.webservice.exception.mapping;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@Provider
public class DataIntegrityViolationExceptionMapper implements ExceptionMapper<DataIntegrityViolationException>{
	private Logger logger = LoggerFactory.getLogger(DataIntegrityViolationExceptionMapper.class);
	
	@Override
	public Response toResponse(final DataIntegrityViolationException exception) {
		logger.debug("The request could not be completed due to a conflict with the current state of the resource.", exception);
		
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("De actie kan niet worden uitgevoerd omdat dit object gekoppeld is aan andere objecten. " 
						+ exception.getMessage())
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
