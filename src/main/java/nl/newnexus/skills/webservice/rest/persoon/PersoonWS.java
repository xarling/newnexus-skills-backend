package nl.newnexus.skills.webservice.rest.persoon;

import nl.newnexus.skills.service.PersoonService;
import nl.newnexus.skills.util.dozer.DozerCollectionMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User: xanderarling
 * Date: 9/14/13
 * Time: 16:41
 */
@Path("/persoon/")
@Component
@Scope("request")
@Produces(MediaType.APPLICATION_JSON)
public class PersoonWS {

    @Inject
    private PersoonService persoonService;

    @Inject
    private Mapper mapper;

    @GET
    public List<Persoon> getPersonen() {
        return DozerCollectionMapper.map(mapper, persoonService.getPersonen(), Persoon.class);
    }

}
