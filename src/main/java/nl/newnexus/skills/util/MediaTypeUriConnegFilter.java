package nl.newnexus.skills.util;


import com.sun.jersey.api.container.filter.UriConnegFilter;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of UriConnegFilter for supporting .xml and .json uri extensions.
 *
 * @author Xander Arling
 * @version $Revision: 42106 $ $Date: 2012-09-25 15:40:52 +0200 (Tue, 25 Sep 2012) $
 */
public class MediaTypeUriConnegFilter extends UriConnegFilter {
    private static final Map<String, MediaType> MAPPED_MEDIA_TYPES = new HashMap<String, MediaType>(2);

    static {
        MAPPED_MEDIA_TYPES.put("json", MediaType.APPLICATION_JSON_TYPE);
        MAPPED_MEDIA_TYPES.put("xml", MediaType.APPLICATION_XML_TYPE);
    }

    /**
     * Public constructor
     */
    public MediaTypeUriConnegFilter() {
        super(MAPPED_MEDIA_TYPES);
    }
}