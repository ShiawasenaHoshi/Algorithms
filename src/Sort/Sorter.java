package Sort;

import java.util.Collection;

/**
 * Created by vasily on 19.06.15.
 */
public interface Sorter<T extends Comparable<T>> {
    Collection<T> sort(Collection<T> collection);
}
