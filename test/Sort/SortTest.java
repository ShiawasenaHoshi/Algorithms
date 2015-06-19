package Sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static Sort.Strategy.sort;
/**
 * Created by vasily on 19.06.15.
 */
//TODO Неплохо было бы добавить профилирование
public class SortTest {

    Integer[] integers = {
            new Integer(5),
            new Integer(4),
            new Integer(3),
            new Integer(10),
            new Integer(8),
            new Integer(9),
            new Integer(7),
            new Integer(2),
            new Integer(6),
            new Integer(1),
            new Integer(0),
    };
    int[] expectedResult = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testInsertSort() throws Exception {
        Collection<Integer> sortedInts = sort(Arrays.asList(integers), new InsertSort<>());
        checkCollection(sortedInts);
    }

    @Test
    public void testShellSort() throws Exception {
        Collection<Integer> sortedInts = sort(Arrays.asList(integers), new ShellSort<>());
        checkCollection(sortedInts);
    }

    @Test
    public void testQuickSort() throws Exception {
        Collection<Integer> sortedInts = sort(Arrays.asList(integers), new QuickSort<>());
        checkCollection(sortedInts);
    }

    @Test
    public void testCountingSort() throws Exception {
        int[] ints = {6, 3, 1, 1, 3, 6, 5, 7, 1, 4, 1, 7, 1, 7, 7, 9, 4, 2, 6, 2, 8, 1, 2, 3, 5, 1, 3, 5, 1, 9, 7, 8, 5, 7, 7, 7, 7, 0, 8, 5, 7, 7, 9, 7, 3, 8, 9, 3, 1, 7, 7, 5, 9, 4, 2, 8, 0, 2, 8, 5, 4, 8, 5, 2, 3, 2, 1, 1, 4, 0, 8, 7, 3, 6, 0, 2, 3, 5, 9, 3, 6, 3, 9, 2, 6, 2, 3, 0, 7, 8, 7, 9, 6, 9, 1, 6, 2, 6, 5, 4};
        int[] expected = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] digits = this.expectedResult;
        int[] sorted = CountingSort.sort(ints, digits);
        for (int i = 0; i < 100; i++) {
            if(sorted[i] != expected[i]){
                throw new AssertionError();
            }
        }
    }

    private void checkCollection(Collection<Integer> collection){
        Iterator<Integer> it = collection.iterator();
        for (int i = 0; i < expectedResult.length; i++) {
            int integer = it.next();
            Assert.assertEquals(expectedResult[i], integer);
        }
    }
}