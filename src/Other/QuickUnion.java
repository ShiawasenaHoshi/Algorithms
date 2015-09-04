package Other;

public class QuickUnion implements QuickFindUnion {
    int[] elements;

    public QuickUnion(int[] elements) {
        this.elements = elements;
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
        elements[i] = j;
    }
}
