package nl.newnexus.skills.util.jackson;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.stereotype.Component;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * The JacksonContext Resolver which enables configuring the ObjectMapper of Jackson in Jersey.
 * 
 * @author Xander Arling
 *
 */
@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {
    private ObjectMapper objectMapper;

    /**
     * 
     */
    public JacksonContextResolver() {
        this.objectMapper = new ObjectMapper();
        // als het object properties heeft die het andere object niet heeft krijgen we geen foutmelding
        this.objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // als het object geen properties heeft krijgen we geen foutmelding
        this.objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        
        SimpleModule customSerializers = new SimpleModule("CustomSerializers", new Version(1, 0, 0, null));
        objectMapper.registerModule(customSerializers);
        
    }
    
    /* (non-Javadoc)
     * @see javax.ws.rs.ext.ContextResolver#getContext(java.lang.Class)
     */
    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}