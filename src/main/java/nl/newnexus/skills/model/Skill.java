package nl.newnexus.skills.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * User: xanderarling
 * Date: 9/19/13
 * Time: 16:45
 */
@Entity
@Table(name="skill")
public class Skill extends VersionedEntity {

    private String naam;

    @ManyToMany(mappedBy="skills")
    private Set<Persoon> personen;


    public Set<Persoon> getPersonen() {
        return personen;
    }

    public void setPersonen(Set<Persoon> personen) {
        this.personen = personen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
