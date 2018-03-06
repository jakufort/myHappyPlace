import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] openedCounter;

    private static final double CONFIDENCE_CONSTANT = 1.96;

    public PercolationStats(int n, int trials){
        // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        openedCounter = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int column = StdRandom.uniform(n) + 1;
                while (p.isOpen(row, column)) {
                    row = StdRandom.uniform(n) + 1;
                    column = StdRandom.uniform(n) + 1;
                }
                p.open(row, column);
            }
            openedCounter[i] = p.numberOfOpenSites() / (double)(n*n);
        }
    }

    public double mean() {
        return StdStats.mean(openedCounter);
    }

    public double stddev() {
        return StdStats.stddev(openedCounter);
    }

    public double confidenceLo() {
        return mean() - ((CONFIDENCE_CONSTANT * stddev()) / Math.sqrt(openedCounter.length));
        // low  endpoint of 95% confidence interval
    }

    public double confidenceHi() {
        // high endpoint of 95% confidence interval
        return mean() + ((CONFIDENCE_CONSTANT * stddev()) / Math.sqrt(openedCounter.length));
    }

    public static void main(String[] args) {
        // test client (described below)
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println(stats.toString());
    }

    @Override
    public String toString() {
        return "mean = " + mean() +
                "\nstddev = " + stddev() +
                "\n95% confidence interval = [" + confidenceLo() + ", " + confidenceHi() + "]";
    }
}
