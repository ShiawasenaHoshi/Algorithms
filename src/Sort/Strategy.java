package Sort;

import java.util.Collection;

/**
 * Created by vasily on 19.06.15.
 */
public class Strategy {
    public static<T extends Comparable<T>> Collection<T> sort(Collection<T> collection, Sorter<T> sorter){
        return sorter.sort(collection);
    }
}
