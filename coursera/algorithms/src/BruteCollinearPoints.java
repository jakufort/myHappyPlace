import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private List<LineSegment> segments = new ArrayList<>();
    private static final double EPSILON = 0.0000001;

    private int iterationCounter = 0;

    public BruteCollinearPoints(Point[] points) {
        Arrays.sort(points);
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i +1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
                            segments.add(new LineSegment(p,s));
                        }
//                        if (equal(p.slopeTo(q), p.slopeTo(r)) && equal(p.slopeTo(q), r.slopeTo(s))) {
//                            segments.add(new LineSegment(p, s));
//                        }
                    }
                }
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
