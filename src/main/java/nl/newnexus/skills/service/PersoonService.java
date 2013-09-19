package nl.newnexus.skills.service;

import com.google.common.collect.Lists;
import nl.newnexus.skills.model.Persoon;
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
@Transactional(readOnly = true)
@Service
public class PersoonService {

    @Inject
    private PersoonRepository persoonRepository;


    @Transactional(readOnly = true)
    @Cacheable("personen")
    public List<Persoon> getPersonen() {
        Iterable<Persoon> personen = persoonRepository.findPersonenWithSkills();

        return Lists.newArrayList(personen);
    }

}
