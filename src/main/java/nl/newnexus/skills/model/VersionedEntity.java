package nl.newnexus.skills.model;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * User: xanderarling
 * Date: 9/15/13
 * Time: 20:10
 */
@MappedSuperclass
public class VersionedEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;



    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
