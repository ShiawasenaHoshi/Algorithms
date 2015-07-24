package Find;

import java.util.List;

public interface Finder<T extends Comparable<T>> {
    int indexOf(List<T> list, T toFind);
}
