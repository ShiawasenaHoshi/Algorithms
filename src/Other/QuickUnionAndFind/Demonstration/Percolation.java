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
    //    WeightedQuickUnionUF quickUnion;
    private QuickFindUF quickUnion; //You can choose another algorithm: WeightedQuickUnionUF, QuickUnionUF, QuickUnionWCP

    public Percolation(int size) {
        this.size = size;
        cellsAmount = size * size;
        openCells = new boolean[cellsAmount];
        for (int i = 0; i < cellsAmount; i++) {
            openCells[i] = false;
        }
//        quickUnion = new WeightedQuickUnionUF(cellsAmount + 2);
        quickUnion = new QuickFindUF(cellsAmount + 2);
        virtualTop = cellsAmount;
        virtualBottom = cellsAmount + 1;
    }

    public boolean isFull(int col, int row) {
        int cellIndex = calcCellIndex(col, row);
        if (col == size) {
            if (quickUnion.connected(cellIndex, virtualTop)) {
                quickUnion.union(cellIndex, virtualBottom);
            }
        }
        return quickUnion.connected(cellIndex, virtualTop);
    }

    public boolean isOpen(int col, int row) {
        return openCells[calcCellIndex(col, row)];
    }

    public void open(int col, int row) {
        int cellIndex = calcCellIndex(col, row);
        openCells[cellIndex] = true;

        int up = cellIndex - size;
        if (up < 0) quickUnion.union(cellIndex, virtualTop);
        else if (openCells[up]) quickUnion.union(cellIndex, up);

        int right = cellIndex + 1;
        if (right % size != 0 && openCells[right]) quickUnion.union(cellIndex, right);

        int down = cellIndex + size;
        if (down >= cellsAmount) {
            if (quickUnion.connected(cellIndex, virtualTop)) quickUnion.union(cellIndex, virtualBottom);
        } else if (openCells[down]) quickUnion.union(cellIndex, down);

        int left = cellIndex - 1;
        if (left % size != size - 1 && left >= 0 && openCells[left]) quickUnion.union(cellIndex, left);
    }

    private int calcCellIndex(int col, int row) {
        return (row - 1) + ((col - 1) * size);
    }

    public boolean percolates() {
        return quickUnion.connected(virtualTop, virtualBottom);
    }

}
