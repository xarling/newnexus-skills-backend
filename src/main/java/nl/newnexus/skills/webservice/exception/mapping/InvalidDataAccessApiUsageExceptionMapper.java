package nl.newnexus.skills.webservice.exception.mapping;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;

public class InvalidDataAccessApiUsageExceptionMapper implements ExceptionMapper<InvalidDataAccessApiUsageException> {
	private Logger logger = LoggerFactory.getLogger(InvalidDataAccessApiUsageExceptionMapper.class);
	
	@Override
	public Response toResponse(InvalidDataAccessApiUsageException exception) {
		logger.debug("The request could not be completed due to invalid data access.", exception);
		
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("De actie kan niet worden uitgevoerd. " + exception.getMessage())
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
