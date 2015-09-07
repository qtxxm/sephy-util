package net.sephy.util;

import java.util.Collection;

/**
 * @author Sephy
 * @since: 2015-09-07
 */
public abstract class CollectionUtils {

    public static final boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }
}
