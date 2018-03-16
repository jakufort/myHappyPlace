import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private List<LineSegment> segments = new ArrayList<>();
    private static final double EPSILON = 0.00001;

    public FastCollinearPoints(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point[] copy = Arrays.copyOfRange(points, i+1, points.length);
            Point p = points[i];
            Arrays.sort(copy, p.slopeOrder());
            double tmp = p.slopeTo(copy[0]);
            int counter = 1;
            for (int j = 1; j < copy.length; j++) {
                if (equal(tmp, p.slopeTo(copy[j]))) {
                    counter++;
                }
            }
            if (counter > 3) {
                segments.add(new LineSegment(p, copy[counter-1]));
            }
        }
    }

    private boolean equal(double fst, double snd) {
        return  Math.abs(fst - snd) < EPSILON;
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }
}
