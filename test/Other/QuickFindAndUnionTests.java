package Other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickFindAndUnionTests {
    int[] elements = new int[10];

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }
    }

    @Test
    public void testQF() throws Exception {
        QuickFind qf = new QuickFind(elements);
        testConnected(qf);
        testUnion(qf);
    }

    @Test
    public void testQU() throws Exception {
        QuickUnion qu = new QuickUnion(elements);
        testConnected(qu);
        testUnion(qu);
    }

    @Test
    public void testQUW() throws Exception {
        QuickUnionW quw = new QuickUnionW(elements);
        testConnected(quw);
        testUnion(quw);
    }

    @Test
    public void testQUWCP() throws Exception {
        QuickUnionWCP quwcp = new QuickUnionWCP(elements);
        testConnected(quwcp);
        testUnion(quwcp);
    }

    public void testConnected(QuickFindUnion qfu) throws Exception {
        for (int element : elements) {
            Assert.assertTrue(qfu.connected(element, element));
        }
        for (int i = 0; i < elements.length - 1; i++) {
            Assert.assertFalse(qfu.connected(elements[i], elements[i + 1]));
        }
    }

    public void testUnion(QuickFindUnion qfu) throws Exception {
        qfu.union(0, 9);
        Assert.assertTrue(qfu.connected(0, 9));
        qfu.union(1, 8);
        Assert.assertTrue(qfu.connected(1, 8));
        qfu.union(1, 9);
        Assert.assertTrue(qfu.connected(1, 0));
    }
}