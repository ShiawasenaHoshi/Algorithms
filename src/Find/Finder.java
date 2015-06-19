package Find;

import java.util.Collection;

/**
 * Created by vasily on 19.06.15.
 */
public interface Finder<T> {
    T find(Collection<T> collection);
}
