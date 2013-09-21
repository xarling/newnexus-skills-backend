package nl.newnexus.skills.webservice.exception.mapping;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;

/**
 * @author Suzanne Walrave ($Author$)
 * @version $Revision$ $Date$
 */
public class DuplicateKeyExceptionMapper implements ExceptionMapper<DuplicateKeyException>{
	private Logger logger = LoggerFactory.getLogger(DuplicateKeyExceptionMapper.class);
			
	@Override
	public Response toResponse(DuplicateKeyException exception) {
		logger.debug("The request could not be completed due to a conflict with the current state of the resource.", exception);
		
		return Response.status(Response.Status.BAD_REQUEST)
				.entity("De actie kan niet worden uitgevoerd omdat er reeds een object bestaat voor deze periode. "
						+ exception.getMessage())
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}