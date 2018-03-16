import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if (x == that.x && y == that.y) {
            return Double.NEGATIVE_INFINITY;
        } else if (that.y == y) {
            return +0.0;
        } else if (that.x == x) {
            return Double.POSITIVE_INFINITY;
        }
        return (that.y - y) / (double)(that.x - x);
    }

    public Comparator<Point> slopeOrder() {
        return (o1, o2) -> (Double.compare(slopeTo(o1), slopeTo(o2)));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point o) {
        if (y == o.y) {
            return x - o.x;
        } else {
            return y - o.y;
        }
    }
}
