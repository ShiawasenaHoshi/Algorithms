package Other.QuickUnionAndFind.Demonstration;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation simulation.
 */
public class Percolation {
    private final int size;
    private final int cellsAmount;
    private final int virtualTop;
    private final int virtualBottom;
    private boolean[] openCells;
    private WeightedQuickUnionUF weightedQuickUnionUF; //You can choose another algorithm: QuickFindUF, QuickUnionUF, QuickUnionWCP

    public Percolation(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        cellsAmount = size * size;
        openCells = new boolean[cellsAmount];
        for (int i = 0; i < cellsAmount; i++) {
            openCells[i] = false;
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(cellsAmount + 2);
        virtualTop = cellsAmount;
        virtualBottom = cellsAmount + 1;
    }

    public boolean isFull(int col, int row) {
        int cellIndex = calcCellIndex(col, row);
        return weightedQuickUnionUF.connected(cellIndex, virtualTop);
    }

    public boolean isOpen(int col, int row) {
        return openCells[calcCellIndex(col, row)];
    }

    public void open(int row, int col) {
        int cellIndex = calcCellIndex(row, col);
        openCells[cellIndex] = true;
        int up = cellIndex - size;
        if (up < 0) weightedQuickUnionUF.union(cellIndex, virtualTop);
        else if (openCells[up]) {
            weightedQuickUnionUF.union(cellIndex, up);
            if (row == size && weightedQuickUnionUF.connected(up, virtualTop)) {
                weightedQuickUnionUF.union(cellIndex, virtualBottom);
            }
        }

        int right = cellIndex + 1;
        if (right % size != 0 && openCells[right]) {
            weightedQuickUnionUF.union(cellIndex, right);
            if (row == size && weightedQuickUnionUF.connected(right, virtualTop)) {
                weightedQuickUnionUF.union(cellIndex, virtualBottom);
            }
        }

        int down = cellIndex + size;
        if (down >= cellsAmount) {
            if (weightedQuickUnionUF.connected(cellIndex, virtualTop))
                weightedQuickUnionUF.union(cellIndex, virtualBottom);
        } else if (openCells[down]) {
            weightedQuickUnionUF.union(cellIndex, down);
        }

        int left = cellIndex - 1;
        if (left % size != size - 1 && left >= 0 && openCells[left]) {
            weightedQuickUnionUF.union(cellIndex, left);
            if (row == size && weightedQuickUnionUF.connected(left, virtualTop)) {
                weightedQuickUnionUF.union(cellIndex, virtualBottom);
            }
        }
        for (int i = 1; i <= size; i++) {
            if (weightedQuickUnionUF.connected(cellsAmount - i, virtualTop)) {
                weightedQuickUnionUF.union(cellsAmount - i, virtualBottom);
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
        return weightedQuickUnionUF.connected(virtualTop, virtualBottom);
    }

}
