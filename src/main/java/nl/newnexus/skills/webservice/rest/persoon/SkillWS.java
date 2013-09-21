package nl.newnexus.skills.webservice.rest.persoon;

import nl.newnexus.skills.service.PersoonService;
import nl.newnexus.skills.service.SkillService;
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
 * Date: 9/19/13
 * Time: 19:43
 */
@Path("/skill/")
@Component
@Scope("request")
@Produces(MediaType.APPLICATION_JSON)
public class SkillWS {

    @Inject
    private SkillService skillService;

    @Inject
    private Mapper mapper;

    @GET
    public List<Skill> getSkills() {
        return DozerCollectionMapper.map(mapper, skillService.getSkills(), Skill.class);
    }
}
