package Other.QuickUnionAndFind.Demonstration;

import edu.princeton.cs.algs4.QuickFindUF;

/**
 * Percolation simulation.
 */
public class Percolation {
    private final int size;
    private final int cellsAmount;
    private final int virtualTop;
    private final int virtualBottom;
    private boolean[] openCells;
    private QuickFindUF quickFindUF; //You can choose another algorithm: WeightedQuickUnionUF, QuickUnionUF, QuickUnionWCP

    public Percolation(int size) {
        this.size = size;
        cellsAmount = size * size;
        openCells = new boolean[cellsAmount];
        for (int i = 0; i < cellsAmount; i++) {
            openCells[i] = false;
        }
        quickFindUF = new QuickFindUF(cellsAmount + 2);
        virtualTop = cellsAmount;
        virtualBottom = cellsAmount + 1;
    }

    public boolean isFull(int col, int row) {
        int cellIndex = calcCellIndex(col, row);
        return quickFindUF.connected(cellIndex, virtualTop);
    }

    public boolean isOpen(int col, int row) {
        return openCells[calcCellIndex(col, row)];
    }

    public void open(int col, int row) {
        int cellIndex = calcCellIndex(col, row);
        openCells[cellIndex] = true;

        int up = cellIndex - size;
        if (up < 0) quickFindUF.union(cellIndex, virtualTop);
        else if (openCells[up]) {
            quickFindUF.union(cellIndex, up);
            if (row == size && quickFindUF.connected(up, virtualTop)) {
                quickFindUF.union(cellIndex, virtualBottom);
            }
        }

        int right = cellIndex + 1;
        if (right % size != 0 && openCells[right]) {
            quickFindUF.union(cellIndex, right);
            if (row == size && quickFindUF.connected(right, virtualTop)) {
                quickFindUF.union(cellIndex, virtualBottom);
            }
        }

        int down = cellIndex + size;
        if (down >= cellsAmount) {
            if (quickFindUF.connected(cellIndex, virtualTop)) quickFindUF.union(cellIndex, virtualBottom);
        } else if (openCells[down]) quickFindUF.union(cellIndex, down);

        int left = cellIndex - 1;
        if (left % size != size - 1 && left >= 0 && openCells[left]) {
            quickFindUF.union(cellIndex, left);
            if (row == size && quickFindUF.connected(left, virtualTop)) {
                quickFindUF.union(cellIndex, virtualBottom);
            }
        }
    }

    private int calcCellIndex(int col, int row) {
        if (col > size || col <= 0 || row > size || row <= 0) {
            throw new IndexOutOfBoundsException();
        }
        return (row - 1) + ((col - 1) * size);
    }

    public boolean percolates() {
        return quickFindUF.connected(virtualTop, virtualBottom);
    }

}
