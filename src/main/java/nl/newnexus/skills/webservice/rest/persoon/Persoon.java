package nl.newnexus.skills.webservice.rest.persoon;

import java.util.List;

/**
 * User: xanderarling
 * Date: 9/14/13
 * Time: 20:00
 */
public class Persoon {
    private Long id;
    private String achternaam;
    private String voornaam;

    private List<Skill> skills;

    private List<Rol> rollen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public List<Rol> getRollen() {
        return rollen;
    }

    public void setRollen(List<Rol> rollen) {
        this.rollen = rollen;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
