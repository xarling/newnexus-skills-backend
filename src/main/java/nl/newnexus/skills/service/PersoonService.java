package nl.newnexus.skills.service;

import com.google.common.collect.Lists;
import nl.newnexus.skills.model.Persoon;
import nl.newnexus.skills.model.Skill;
import nl.newnexus.skills.repository.PersoonRepository;
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


    //@Cacheable("personen")
    @Transactional(readOnly = true)
    public List<Persoon> getPersonen() {
        Iterable<Persoon> personen = persoonRepository.findPersonenWithSkills();
        return Lists.newArrayList(personen);
    }

    @Transactional(readOnly = true)
    public Persoon getPersoon(Long id) {
        return persoonRepository.findOne(id);
    }

    public void delete(Long id) {
        persoonRepository.delete(id);
    }

    public Persoon update(Persoon persoon) {
        return persoonRepository.save(persoon);
    }

    public Persoon save(final Persoon persoon) {
        return persoonRepository.save(persoon);
    }

    public Persoon addSkill(final Long persoonId, final Skill skill) {
        Persoon persoon = persoonRepository.findOne(persoonId);
        persoon.addSkill(skill);
        return persoonRepository.save(persoon);
    }

}
