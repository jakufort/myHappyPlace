import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private static final double EPSILON = 0.00001;
    // (y1 − y0) / (x1 − x0)
    @Test
    public void slopeTo() {
        Point p = new Point(1,1);
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(p), EPSILON);
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(new Point(1, 0)), EPSILON);
        assertEquals(+0.0, p.slopeTo(new Point(0,1)), EPSILON);
        assertEquals(2, p.slopeTo(new Point(2, 3)), EPSILON);
    }

    @Test
    public void slopeOrder() {
        Point p = new Point(1,1);
        fail("not implemented");
    }

    @Test
    public void compareTo() {
        Point p = new Point(1,1);
        assertTrue(p.compareTo(new Point(10,0)) > 0);
        assertTrue(p.compareTo(new Point(0,0)) > 0);
        assertTrue(p.compareTo(new Point(0, 2)) < 0);
        assertTrue(p.compareTo(new Point(1,1)) == 0);
        assertTrue(p.compareTo(new Point(10,2)) < 0);
    }
}