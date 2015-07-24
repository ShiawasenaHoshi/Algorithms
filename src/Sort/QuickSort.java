package Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {
    List<T> list;

    @Override
    public Collection<T> sort(Collection<T> collection) {
        if(collection.size() <= 1){
            return collection;
        }
        list = new ArrayList<>();
        list.addAll(collection);
        qSort(list);
        return list;
    }

    private void qSort(List<T> list){
        int size = list.size();
        int first = 0;
        int last = size-1;
        T refElement = list.get(size/2);
        while (first <= last) {
            while (list.get(first).compareTo(refElement) < 0) {
                first++;
            }
            while (list.get(last).compareTo(refElement) > 0) {
                last--;
            }
            if (first <= last) {
                Collections.swap(list, first, last);
                first++;
                last--;
            }
        }
        if (last>0){
            qSort(list.subList(0, last + 1));
        }
        if (first<size){
            qSort(list.subList(first, size));
        }
    }
}
