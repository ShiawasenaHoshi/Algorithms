package Other.QuickUnionAndFind;

/**
 * Quick-union with weighting and path compression
 */
public class QuickUnionWCP implements QuickFindUnion {
    int[] elements;
    int[] sz;

    public QuickUnionWCP(int[] elements) {
        this.elements = elements;
        //assume that elements doesn't connected
        sz = new int[elements.length];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 0;
        }
    }

    private int getRoot(int index) {
        while (index != elements[index]) {
            elements[index] = elements[elements[index]]; //only this line changed
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
