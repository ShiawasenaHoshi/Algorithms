package Find;

import java.util.List;

/**
 * Created by vasily on 19.06.15.
 */
public interface Finder<T extends Comparable<T>> {
    int indexOf(List<T> list, T toFind);
}
