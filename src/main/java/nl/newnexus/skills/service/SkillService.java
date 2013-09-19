package nl.newnexus.skills.service;

import com.google.common.collect.Lists;
import nl.newnexus.skills.model.Skill;
import nl.newnexus.skills.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * User: xanderarling
 * Date: 9/19/13
 * Time: 19:44
 */
@Transactional(readOnly = true)
@Service
public class SkillService {

    @Inject
    private SkillRepository skillRepository;

    @Transactional(readOnly = true)
    public List<Skill> getSkills() {
        return Lists.newArrayList(skillRepository.findAll());
    }
}
