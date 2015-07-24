package Sort;

public class CountingSort {
    //TODO можно попробовать перевести на дженерики
    //предполагается, что массив возможных значений digits, уже рассортирован
    public static int[] sort(int[] ints, int... digits) {
        int length = ints.length;
        int current = 0;
        int[] result = new int[length];
        for (int digit : digits) {
            for (int anInt : ints) {
                if (anInt == digit) {
                    result[current] = digit;
                    current++;
                }
            }
        }
        return result;
    }

}
