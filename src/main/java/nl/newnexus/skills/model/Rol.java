package nl.newnexus.skills.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
