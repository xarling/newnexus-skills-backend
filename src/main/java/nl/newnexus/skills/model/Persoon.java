package nl.newnexus.skills.model;

import org.hibernate.annotations.Cascade;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

/**
 * User: xanderarling
 * Date: 9/14/13
 * Time: 16:48
 */
@Entity
@Table(name = "persoon")
public class Persoon extends TimestampedEntity {

    @NotEmpty
    private String voornaam;

    @NotEmpty
    private String achternaam;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name="persoon_rol",
            joinColumns={@JoinColumn(name="persoon_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="rol_id", referencedColumnName="id")})
    private Set<Rol> rollen;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name="persoon_skill",
            joinColumns={@JoinColumn(name="persoon_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="skill_id", referencedColumnName="id")})
    private Set<Skill> skills;



    @Temporal(TemporalType.DATE)
    private Date geboorteDatum;

    private String tussenvoegsel;

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Set<Rol> getRollen() {
        return rollen;
    }

    public void setRollen(Set<Rol> rollen) {
        this.rollen = new HashSet<Rol>(rollen);
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(final Skill skill) {
        if (this.skills == null) {
            this.skills = new HashSet<>();
        }
        this.skills.add(skill);
    }
}
