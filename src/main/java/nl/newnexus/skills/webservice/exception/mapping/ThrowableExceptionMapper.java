package nl.newnexus.skills.webservice.exception.mapping;

import org.codehaus.jackson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * User: xanderarling
 * Date: 10/8/13
 * Time: 19:39
 */
@Component
@Provider
public class ThrowableExceptionMapper implements ExceptionMapper<Throwable> {
    private Logger logger = LoggerFactory.getLogger(JsonParseExceptionMapper.class);

    /* (non-Javadoc)
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(final Throwable exception) {
        logger.error("Super bad when this happens", exception);

        return Response.status(Response.Status.BAD_REQUEST).
                entity("Something is really wrong").
                type(MediaType.APPLICATION_JSON).
                build();
    }

}
