package nl.newnexus.skills.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: xanderarling
 * Date: 9/19/13
 * Time: 16:45
 */
@Entity
@Table(name="skill")
public class Skill extends VersionedEntity {

    private String naam;


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
