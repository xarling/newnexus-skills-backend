package nl.newnexus.skills.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: xanderarling
 * Date: 9/15/13
 * Time: 20:09
 */
@MappedSuperclass
public class TimestampedEntity extends VersionedEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimestamp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTimestamp;

    @PrePersist
    protected void onCreate() {
        createdTimestamp = new Date();
        updatedTimestamp = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTimestamp = new Date();
    }
}
