package nl.newnexus.skills.webservice.rest.persoon;

import nl.newnexus.skills.model.VersionedEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: xanderarling
 * Date: 9/15/13
 * Time: 20:15
 */
public class Rol {
    private Long id;

    private String rol;


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
