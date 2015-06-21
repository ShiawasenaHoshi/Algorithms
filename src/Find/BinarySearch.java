package Find;

import java.util.List;

/**
 * Created by vasily on 20.06.15.
 */
public class BinarySearch<T extends Comparable<T>> implements Finder<T> {
    @Override
    public int indexOf(List<T> list, T toFind) {
        int leftBound = 0;
        int rightBound = list.size() - 1;
        while (true) {
            int size = rightBound - leftBound;
            int centerIndex = (leftBound + rightBound) / 2;
            T center = list.get(centerIndex);
            if (center.compareTo(toFind) == 0) {
                if (centerIndex > 0) {
                    while (center.compareTo(list.get(centerIndex - 1)) == 0) {
                        centerIndex--;
                        center = list.get(centerIndex);
                        if (centerIndex == 0) {
                            break;
                        }
                    }
                }
                return centerIndex;

            }
            if (size == 1) {
                if (rightBound < list.size() && list.get(rightBound).compareTo(toFind) == 0) {
                    return rightBound;
                } else {
                    return -1;
                }
            }
            if (center.compareTo(toFind) < 0) {
                leftBound = centerIndex;
            }
            if (center.compareTo(toFind) > 0) {
                rightBound = centerIndex;
            }
        }
    }
}
