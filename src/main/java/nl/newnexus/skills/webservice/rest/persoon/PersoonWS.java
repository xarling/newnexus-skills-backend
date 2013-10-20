package nl.newnexus.skills.webservice.rest.persoon;

import nl.newnexus.skills.service.PersoonService;
import nl.newnexus.skills.util.dozer.DozerCollectionMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @POST
    public Persoon savePersoon(final Persoon persoon) {
        final nl.newnexus.skills.model.Persoon savedPersoon = persoonService.save(mapper.map(persoon, nl.newnexus.skills.model.Persoon.class));
        return mapper.map(savedPersoon, Persoon.class);
    }

    @POST
    @Path(("{persoonId}/skill"))
    public Persoon addSkill(@PathParam("persoonId") Long persoonId, final Skill skill) {
        final nl.newnexus.skills.model.Persoon savedPersoon = persoonService.addSkill(persoonId, mapper.map(skill, nl.newnexus.skills.model.Skill.class));
        return mapper.map(savedPersoon, Persoon.class);

    }

    @PUT
    @Path("{persoonId}")
    public Persoon updatePersoon(final Persoon persoon) {
        final nl.newnexus.skills.model.Persoon updatedPersoon = persoonService.update(mapper.map(persoon, nl.newnexus.skills.model.Persoon.class));
        return mapper.map(updatedPersoon, Persoon.class);
    }

    @GET
    @Path("{persoonId}")
    public Persoon getPersoon(@PathParam("persoonId") Long persoonId) {
        return mapper.map(persoonService.getPersoon(persoonId), Persoon.class);
    }

    @DELETE
    @Path("{persoonId}")
    public void deletePersoon(@PathParam("persoonId") Long persoonId) {
        persoonService.delete(persoonId);
    }
}
