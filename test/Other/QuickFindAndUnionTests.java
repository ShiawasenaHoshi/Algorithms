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
        qf.union(2, 7);
        qf.union(6, 7);
        qf.union(7, 0);
        qf.union(7, 9);
        qf.union(3, 0);
        qf.union(0, 1);
        StringBuilder sb = new StringBuilder();
        for (int element : elements) {
            sb.append(element).append(" ");
        }
        Assert.assertEquals(sb.toString(), "1 1 1 1 4 5 1 1 8 1 ");
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
        quw.union(2, 5);
        quw.union(3, 5);
        quw.union(4, 0);
        quw.union(9, 6);
        quw.union(6, 4);
        quw.union(5, 7);
        quw.union(8, 3);
        quw.union(0, 5);
        quw.union(2, 1);
        StringBuilder sb = new StringBuilder();
        for (int element : elements) {
            sb.append(element).append(" ");
        }
        Assert.assertEquals(sb.toString(), "4 2 2 2 9 2 9 2 2 2 ");
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