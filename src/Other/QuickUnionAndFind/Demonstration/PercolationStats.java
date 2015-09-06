package Other.QuickUnionAndFind.Demonstration;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Monte-Carlo simulation of percolation
 */
public class PercolationStats {
    private int cellsAmount;
    private int[] simResults;

    public PercolationStats(int N, int T) {
        cellsAmount = N * N;
        simResults = new int[T];
        for (int i = 0; i < T; i++) {
            int cellsOpened = 0;
            Percolation percolation = new Percolation(N);
            int col;
            int row;
            while (!percolation.percolates()) {
                do {
                    col = StdRandom.uniform(1, N + 1);
                    row = StdRandom.uniform(1, N + 1);
                } while (percolation.isOpen(col, row));
                percolation.open(col, row);
                cellsOpened++;
            }
            simResults[i] = cellsOpened;
        }
    }

    public static void main(String[] args) {
        try {
            int N = Integer.parseInt(args[0]);
            int T = Integer.parseInt(args[1]);
            if (N <= 0 || T <= 0) {
                throw new IllegalArgumentException("arguments must be more than 0");
            }
            PercolationStats percolationStats = new PercolationStats(N, T);
            System.out.println("mean = " + percolationStats.mean());
            System.out.println("StdDev = " + percolationStats.stddev());
            System.out.println("95% confidence interval = " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }


    }

    public double mean() {
        return StdStats.mean(simResults) / cellsAmount;
    }

    public double stddev() {
        return StdStats.stddev(simResults) / cellsAmount;
    }

    public double confidenceLo() {
        return mean() - ((stddev() / Math.sqrt(simResults.length)) * 1.96);
    }

    public double confidenceHi() {
        return mean() + ((stddev() / Math.sqrt(simResults.length)) * 1.96);
    }
}
