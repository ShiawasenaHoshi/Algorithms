package Find;

import java.util.List;

/**
 * Created by vasily on 19.06.15.
 */
public class BinarySearch {

    //    int function BinarySearch (Array A, int Lb, int Ub, int Key);
//    begin
//    do forever
//            M = (Lb + Ub)/2;
//    if (Key < A[M]) then
//            Ub = M - 1;
//    else if (Key > A[M]) then
//            Lb = M + 1;
//    else
//            return M;
//    if (Lb > Ub) then
//    return -1;
//    end;
    public static int binarySearch(List<Integer> list, int key) {
        return binarySearch(list, 0, list.size() - 1, key);
    }

    public static int binarySearch(List<Integer> list, int leftBound, int rightBound, int key) {
        while (true) {
            int size = rightBound - leftBound;
            int centerIndex = (leftBound + rightBound) / 2;
            int center = list.get(centerIndex);
            if (center == key) {
                if (centerIndex > 0) {
                    while (center == list.get(centerIndex - 1)) {
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
                if (rightBound < list.size() && list.get(rightBound) == key) {
                    return rightBound;
                } else {
                    return -1;
                }
            }
            if (center < key) {
                leftBound = centerIndex;
            }
            if (center > key) {
                rightBound = centerIndex;
            }
        }
    }
}
