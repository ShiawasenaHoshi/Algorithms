package Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by vasily on 19.06.15.
 */
public class InsertSort<T extends Comparable<T>> implements Sorter<T> {
    List<T> list;
    int size;
    @Override
    public Collection<T> sort(Collection<T> collection) {
        if(collection.size() <= 1){
            return collection;
        }
        copyToArray(collection);
        T buffer;
        for (int i = 1; i < size ; i++) {
            T current = list.get(i);
            int currentIndex = i;
            int prevIndex = i - 1;
            while (current.compareTo(list.get(prevIndex)) < 1){
                buffer = list.get(prevIndex);
                list.set(prevIndex, current);
                list.set(currentIndex, buffer);
                if(prevIndex > 0){
                    prevIndex--;
                    currentIndex--;
                }
                else {
                    break;
                }
            }
        }
        return list;
    }

    private void copyToArray(Collection<T> collection){
        list = new ArrayList<>();
        list.addAll(collection);
        size = list.size();
    }
}
