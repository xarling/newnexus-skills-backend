// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DozerCollectionMapper.java

package nl.newnexus.skills.util.dozer;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Dozer is not able to map root collections. This collection mapper runs through all the objects in the source collection
 * and calls the mapper to create the dest object and adds that to a destination colletion which is returned
 * @param <T> The source object to map
 * @param <E> The destination object
 */
public class DozerCollectionMapper<T, E> {


    /**
     * Maps all objects in the source List to a destination object. The destination objects are added to a new List which
     * is returned.
     * @param mapper the dozer mapper which is able to map the source object to the destination
     * @param source the List with source objects
     * @param destType the destination object type.
     * @param <T> the source type
     * @param <U> the destination type
     * @return a list with destination objects
     */
    public static <T, U> List<U> map(final Mapper mapper, final List<T> source, final Class<U> destType) {

        final List<U> dest = new ArrayList<>();

        for (T element : source) {
            dest.add(mapper.map(element, destType));
        }

        return dest;
    }

}
