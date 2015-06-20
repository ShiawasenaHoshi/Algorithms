package Find;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Find.BinarySearch.binarySearch;

/**
 * Created by vasily on 20.06.15.
 */
public class BinarySearchTest {
    List<Integer> list;
    Random random = new Random();
    StringBuilder sb;
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testBinarySearch() throws Exception {
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            list.add(i);
        }
        for (int i = 0; i < 1000; i++) {
            int toFind = random.nextInt(list.size() -1);
            Assert.assertEquals(toFind, binarySearch(list, toFind));
        }
    }

    @Test
    public void testBinarySearch2() throws Exception {
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            int toFind = random.nextInt(list.size() -1);
            list.remove(new Integer(toFind));
            Assert.assertEquals(-1, binarySearch(list, toFind));
        }
    }

    @Test
    public void testBinarySearch3() throws Exception {
        list = new ArrayList<>();
        sb = new StringBuilder();
        sb.append("Массив: ");
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            for (int j = 0; j < random.nextInt(5); j++) {
                list.add(i);
                sb.append(i);
                sb.append(", ");
            }
        }
        sb.append("\n");
        sb.append("Размер: ");
        sb.append(list.size());
        sb.append("\n");

        for (int i = 0; i < 1000; i++) {
            int toFind = random.nextInt(list.size() -1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Искомое: ");
            sb2.append(toFind);
            if(list.indexOf(new Integer(toFind)) != binarySearch(list, toFind)){
                sb.append(sb2);
                int index = list.indexOf(new Integer(toFind));
                sb.append("\nИндекс в массиве: ");
                sb.append(index);
                System.out.println(sb.toString());
                Assert.assertEquals(list.indexOf(new Integer(toFind)), binarySearch(list, toFind));
            }
        }
    }

    //Тест, чтобы выявить даже самые маловероятные ошибки.
    @Test
    public void testBinarySearch4() throws Exception {
        for (int i = 0; i < 10000; i++) {
            testBinarySearch3();
        }
    }
}