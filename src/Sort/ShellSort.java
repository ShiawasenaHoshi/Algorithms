package Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by vasily on 19.06.15.
 */
//fixMe Не забудь про DRY! Код в сортировщиках повторяется
public class ShellSort<T extends Comparable<T>> implements Sorter<T> {
    List<T> list;
    int size;
    @Override
    public Collection<T> sort(Collection<T> collection) {
        if(collection.size() <= 1){
            return collection;
        }
        copyToArray(collection);
        T buffer;
    }

    private void copyToArray(Collection<T> collection){
        list = new ArrayList<>();
        list.addAll(collection);
        size = list.size();
    }
}
