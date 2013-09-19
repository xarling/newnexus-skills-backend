package nl.newnexus.skills.util.dozer;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.Hibernate;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;

/**
 * @author Xander Arling ($Author$)
 * @version $Revision$ $Date$
 */
public class HibernateFieldMapper implements CustomFieldMapper {

    /* (non-Javadoc)
     * @see org.dozer.CustomFieldMapper#mapField(java.lang.Object, java.lang.Object, java.lang.Object, org.dozer.classmap.ClassMap,
         * org.dozer.fieldmap.FieldMap)
     */
    @Override
    public boolean mapField(final Object source, final Object destination, final Object sourceFieldValue, final ClassMap classMap,
                            final FieldMap fieldMapping) {
        if (!(sourceFieldValue instanceof PersistentCollection) && !(sourceFieldValue instanceof HibernateProxy)) {
            return false;
        } else {
            return !Hibernate.isInitialized(sourceFieldValue);
        }
    }
}