package Sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static Sort.Strategy.sort;
/**
 * Created by vasily on 19.06.15.
 */
public class InsertSortTest {

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

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSort() throws Exception {
        Collection<Integer> sortedInts = sort(Arrays.asList(integers), new InsertSort<Integer>());
        for (Integer sortedInt : sortedInts) {
            System.out.println(sortedInt);
        }
    }

    @Test
    public void testSort1() throws Exception {

    }
}