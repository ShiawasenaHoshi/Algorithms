package Sort;

import java.util.Collection;

public interface Sorter<T extends Comparable<T>> {
    Collection<T> sort(Collection<T> collection);
}
