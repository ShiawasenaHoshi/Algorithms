package Other;

/**
 * Quick-union with weighting
 */
public class QuickUnionW implements QuickFindUnion {
    int[] elements;
    int[] sz;

    public QuickUnionW(int[] elements) {
        this.elements = elements;
        //assume that elements doesn't connected
        sz = new int[elements.length];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    private int getRoot(int index) {
        while (index != elements[index]) {
            index = elements[index];
        }
        return index;
    }

    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            elements[i] = j;
            sz[j] += sz[i];
        } else {
            elements[j] = i;
            sz[i] += sz[j];
        }
    }
}
