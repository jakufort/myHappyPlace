package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareTest {

    Compare c = new Compare();
    @Test
    void simpleExample() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, c.compare(a, b));
    }

    @Test
    void emptyArraysAreEqual() {
        assertEquals(true, c.compare(new int[]{}, new int[]{}));
    }

    @Test
    void cannotCompareNullArrays() {
        assertEquals(false, c.compare(new int[]{}, null));
        assertEquals(false, c.compare(null, new int[]{}));
    }
}