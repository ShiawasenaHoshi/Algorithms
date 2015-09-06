package Other.QuickUnionAndFind;

/**
 * This is implementation of simple quick-find algorithm
 */
public class QuickFind implements QuickFindUnion {
    public int[] elements;

    public QuickFind(int[] elements) {
        this.elements = elements;
    }

    /**
     * @param p - first element index
     * @param q - second element index
     * @return if p and q has equal parent (which index stores they stores in themselves)
     */
    public boolean connected(int p, int q) {
        return elements[p] == elements[q];
    }

    /**
     * Union operation connects two elements
     *
     * @param p - first element index
     * @param q - second element index
     */
    public void union(int p, int q) {
        int pElement = elements[p];
        int qElement = elements[q];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == pElement) elements[i] = qElement;
        }
    }
}
