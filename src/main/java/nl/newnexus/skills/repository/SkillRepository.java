package nl.newnexus.skills.repository;

import nl.newnexus.skills.model.Skill;
import org.springframework.data.repository.CrudRepository;

/**
 * User: xanderarling
 * Date: 9/19/13
 * Time: 19:47
 */
public interface SkillRepository  extends CrudRepository<Skill, Long> {
}
