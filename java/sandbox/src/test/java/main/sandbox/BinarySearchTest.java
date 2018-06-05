package main.sandbox;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch<Integer> binarySearch = new BinarySearch<>();

    @Test
    void handlesExceptions() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.findPosition(null, null));
        assertThrows(IllegalArgumentException.class, () -> binarySearch.findPosition(new Integer[]{}, null));
        assertThrows(IllegalArgumentException.class, () -> binarySearch.findPosition(null, 1));
        assertThrows(IllegalArgumentException.class, () -> binarySearch.findPosition(new Integer[]{}, 1));
    }

    @Test
    void findPositionElementNotFound() {
        assertTrue(binarySearch.findPosition(new Integer[]{1,2}, 3) < 0);
    }

    @Test
    void findPositionSimpleCase() {
        assertEquals(0, binarySearch.findPosition(new Integer[]{2,3,4}, 2));
    }

    @Test
    void findPositionHarderCase() {
        assertEquals(3, binarySearch.findPosition(new Integer[]{1,2,3,4,5,6,7,8,9}, 4));
    }

    @Test
    void findPositionVeryLongList() {
        assertEquals(250, binarySearch.findPosition(IntStream.range(1, 1000000).boxed().toArray(Integer[]::new), 251));
    }
}