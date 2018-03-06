import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final WeightedQuickUnionUF grid;

    private final int virtualTopSiteIndex;
    private final int virtualBottomSiteIndex;

    private boolean[] opened;
    private int openedCount = 0;

    public Percolation(int n)   {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        int sitesCount = n * n;
        grid = new WeightedQuickUnionUF(sitesCount + 2);
        virtualTopSiteIndex = sitesCount;
        virtualBottomSiteIndex = sitesCount + 1;
        opened = new boolean[sitesCount + 2];
        openSite(virtualBottomSiteIndex);
        openSite(virtualTopSiteIndex);
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int index = getSiteIndex(row, col);
            openSite(index);
            for (int indexToCheck : getAdjacentElements(row, col)) {
                if (indexToCheck != -1 && isOpen(indexToCheck)) {
                    grid.union(index, indexToCheck);
                }
            }
        }
    }

    private int[] getAdjacentElements(int row, int col) {
        int[] elements = new int[] { -1, -1, -1, -1 };
        int index = 0;
        if (row == 1) {
            elements[index++] = virtualTopSiteIndex;
            elements[index++] = getSiteIndex(row + 1, col);
        } else if (row == n) {
            elements[index++] = virtualBottomSiteIndex;
            elements[index++] = getSiteIndex(row -1, col);
        } else {
            elements[index++] = getSiteIndex(row - 1, col);
            elements[index++] = getSiteIndex(row + 1, col);
        }
        if (col == 1) {
            elements[index++] = getSiteIndex(row, col + 1);
        } else if (col == n) {
            elements[index++] = getSiteIndex(row, col - 1);
        } else {
            elements[index++] = getSiteIndex(row, col - 1);
            elements[index++] = getSiteIndex(row, col + 1);
        }
        return elements;
    }

    public boolean isOpen(int row, int col) {
        return isOpen(getSiteIndex(row, col));
    }

    private boolean isOpen(int index) {
        return opened[index];
    }

    public boolean isFull(int row, int col) {
        int index = getSiteIndex(row, col);
        return grid.connected(virtualTopSiteIndex, index) && isOpen(index);
    }

    public int numberOfOpenSites() {
        return openedCount - 2;
    }

    public boolean percolates() {
        return grid.connected(virtualTopSiteIndex, virtualBottomSiteIndex);
    }

    private int getSiteIndex(int row, int col) {
        handleInvalidRowOrCol(row, col);
        return (row-1)*n + col - 1;
    }

    private void handleInvalidRowOrCol(int row, int col) {
        if (row > n || col > n || row <= 0 || col <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void openSite(int index) {
        opened[index] = true;
        openedCount++;
    }
}
