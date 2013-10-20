package nl.newnexus.skills.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * User: xanderarling
 * Date: 9/15/13
 * Time: 20:15
 */
@Entity
@Table(name="rol")
public class Rol extends VersionedEntity {

    @NotEmpty
    private String rol;

    @ManyToMany(mappedBy="rollen")
    private Set<Persoon> personen;

    public Set<Persoon> getPersonen() {
        return personen;
    }

    public void setPersonen(Set<Persoon> personen) {
        this.personen = personen;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
