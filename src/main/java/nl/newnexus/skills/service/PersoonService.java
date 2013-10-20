package nl.newnexus.skills.service;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import nl.newnexus.skills.exception.DataNotFoundException;
import nl.newnexus.skills.model.Persoon;
import nl.newnexus.skills.model.Skill;
import nl.newnexus.skills.repository.PersoonRepository;
import nl.newnexus.skills.repository.RolRepository;
import nl.newnexus.skills.repository.SkillRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * User: xanderarling
 * Date: 9/14/13
 * Time: 16:44
 */
@Transactional
@Service
public class PersoonService {

    @Inject
    private PersoonRepository persoonRepository;

    @Inject
    private SkillRepository skillRepository;



    //@Cacheable("personen")
    @Transactional(readOnly = true)
    public List<Persoon> getPersonen() {
        Iterable<Persoon> personen = persoonRepository.findAll();
        return Lists.newArrayList(personen);
    }

    @Transactional(readOnly = true)
    public Persoon getPersoon(Long id) {
        return persoonRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Persoon getPersoonWithSkills(Long id) {
        return persoonRepository.findOneWithSkills(id);
    }

    public void delete(Long id) {
        persoonRepository.delete(id);
    }

    public Persoon addSkill(Long persoonId, Long skillId) {
        final Skill skillToAdd = skillRepository.findOne(skillId);

        if (null == skillToAdd) {
            throw new DataNotFoundException("skill not found");
        }

        final Persoon persoon = persoonRepository.findOne(persoonId);

        if (null == persoon) {
            throw new DataNotFoundException("persoon not found");
        }

        persoon.addSkill(skillToAdd);
        return persoon;
    }

    public Persoon update(Persoon persoon) {
        if ( null == persoon.getId() ) {
            throw new IllegalArgumentException("id cannot be null or empty");
        }

        final Persoon persoonToUpdate = persoonRepository.findOne(persoon.getId());

        persoonToUpdate.setAchternaam(persoon.getAchternaam());
        persoonToUpdate.setVoornaam(persoon.getVoornaam());
        persoonToUpdate.setTussenvoegsel(persoon.getTussenvoegsel());

        return persoon;
    }

    public Persoon save(final Persoon persoon) {
        return persoonRepository.save(persoon);
    }

    public Persoon addSkill(final Long persoonId, final Skill skill) {
        final Persoon persoon = persoonRepository.findOne(persoonId);
        final Skill skillToAdd = skillRepository.findOne(skill.getId());
        persoon.addSkill(skillToAdd);
        return persoonRepository.save(persoon);
    }

}
