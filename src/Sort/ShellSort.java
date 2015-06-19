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
    final private static int[] EMPIRIC_DELTAS = {701, 301, 132, 57, 23, 10, 4};

    @Override
    public Collection<T> sort(Collection<T> collection) {
        if (collection.size() <= 1) {
            return collection;
        }
        copyToArray(collection);
        int currentDelta;
        for (int currentDeltaIndex = 0; currentDeltaIndex < EMPIRIC_DELTAS.length; currentDeltaIndex++) {
            currentDelta = EMPIRIC_DELTAS[currentDeltaIndex];
            if (currentDelta >= size) {
                continue;
            }
            for (int startIndex = 0; startIndex < currentDelta; startIndex++) {
                int elementsAmount = ((size - startIndex) / currentDelta) + 1;
                if (elementsAmount == 1) {
                    break;
                }
                int[] indexesForPart = new int[elementsAmount];
                for (int i = 0, indexForPart = startIndex; indexForPart < size; i++, indexForPart += currentDelta) {
                    indexesForPart[i] = indexForPart;
                }
                List<T> part = new ArrayList<>();
                for (int i : indexesForPart) {
                    part.add(list.get(i));
                }
                insertSort(part);
                for (int i = 0; i < part.size(); i++) {
                    list.set(indexesForPart[i], part.get(i));
                }
            }
        }
        insertSort(list);
        return list;
    }

    private void copyToArray(Collection<T> collection) {
        list = new ArrayList<>();
        list.addAll(collection);
        size = list.size();
    }

    //Поскольку сортировка Шелла содержит сортировку вставками, сортировка вставками выделена в метод SortPart
    private void insertSort(List<T> part) {
        T buffer;
        int partSize = part.size();
        for (int i = 1; i < partSize; i++) {
            T current = part.get(i);
            int currentIndex = i;
            int prevIndex = i - 1;
            while (current.compareTo(part.get(prevIndex)) < 1) {
                buffer = part.get(prevIndex);
                part.set(prevIndex, current);
                part.set(currentIndex, buffer);
                if (prevIndex > 0) {
                    prevIndex--;
                    currentIndex--;
                } else {
                    break;
                }
            }
        }
    }
}
