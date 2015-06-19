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

    private void checkCollection(Collection<Integer> collection){
        Iterator<Integer> it = collection.iterator();
        for (int i = 0; i < expectedResult.length; i++) {
            int integer = it.next();
            Assert.assertEquals(expectedResult[i], integer);
        }
    }
}