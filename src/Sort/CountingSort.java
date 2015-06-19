package Sort;

/**
 * Created by vasily on 19.06.15.
 */
public class CountingSort {
    //TODO можно попробовать перевести на дженерики
    //предполагается, что массив возможных значений digits, уже рассортирован
    public static int[] sort(int[] ints, int... digits) {
        int length = ints.length;
        int current = 0;
        int[] result = new int[length];
        for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
            for (int i = 0; i < length; i++) {
                if(ints[i] == digits[digitIndex]){
                    result[current] = digits[digitIndex];
                    current++;
                }
            }
        }
        return result;
    }

}
