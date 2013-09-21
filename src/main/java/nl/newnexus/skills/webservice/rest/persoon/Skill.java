package nl.newnexus.skills.webservice.rest.persoon;

/**
 * User: xanderarling
 * Date: 9/19/13
 * Time: 16:45
 */
public class Skill {

    private Long id;

    private String naam;


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
