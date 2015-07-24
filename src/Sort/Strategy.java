package Sort;

import java.util.Collection;

public class Strategy {
    public static<T extends Comparable<T>> Collection<T> sort(Collection<T> collection, Sorter<T> sorter){
        return sorter.sort(collection);
    }
}
