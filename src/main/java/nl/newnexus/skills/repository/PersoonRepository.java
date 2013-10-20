package nl.newnexus.skills.repository;

import nl.newnexus.skills.model.Persoon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: xanderarling
 * Date: 9/14/13
 * Time: 16:48
 */
public interface PersoonRepository extends CrudRepository<Persoon, Long> {

    @Query("select p from Persoon as p left join fetch p.skills")
    public List<Persoon> findPersonenWithSkills();

    @Query("select p from Persoon as p left join fetch p.skills where p.id=:id")
    public Persoon findOneWithSkills(@Param("id") Long id);
}
