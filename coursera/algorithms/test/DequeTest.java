import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DequeTest {

    @Test
    public void isEmptyWorks() {
        Deque<String> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addFirst("a");
        assertFalse(deque.isEmpty());
    }

    @Test
    public void addingItemIncreasesSize() {
        Deque<String> deque = new Deque<>();
        assertEquals(0, deque.size());
        deque.addFirst("");
        assertEquals(1, deque.size());
        deque.addLast("");
        assertEquals(2, deque.size());
    }

    @Test
    public void removingItemDecreasesSize() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("");
        deque.addFirst("");
        deque.removeFirst();
        assertEquals(1, deque.size());
        deque.removeLast();
        assertEquals(0, deque.size());
    }

    @Test
    public void canAddElementAsLast() {
        Deque<String> deque = new Deque<>();
        deque.addLast("e");
        assertEquals(1, deque.size());
        assertEquals("e", deque.iterator().next());
    }

    @Test
    public void canAddElementAsFirst() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("e");
        assertEquals(1, deque.size());
        assertEquals("e", deque.iterator().next());
    }

    @Test
    public void addingAsLastWorks() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("e");
        deque.addLast("t");
        deque.addLast("a");
        assertEquals(3, deque.size());
        Iterator<String> iterator = deque.iterator();
        assertEquals("e", iterator.next());
        assertEquals("t", iterator.next());
        assertEquals("a", iterator.next());
    }

    @Test
    public void addingAsFirstWorks() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("e");
        deque.addFirst("t");
        assertEquals(2, deque.size());
        assertEquals("t", deque.iterator().next());
    }

    @Test
    public void removeFirstWorks() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        assertEquals("c", deque.removeFirst());
        assertEquals("b", deque.removeFirst());
        assertEquals("a", deque.removeFirst());
    }

    @Test
    public void removeLastWorks() {
        Deque<String> deque = new Deque<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        assertEquals("c", deque.removeLast());
        assertEquals("b", deque.removeLast());
        assertEquals("a", deque.removeLast());
    }

    @Test
    public void someTestCase() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeFirst();
        deque.addLast(3);
        deque.removeLast();
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addLast(7);
        deque.removeLast();
        assertEquals(2, deque.size());
        Iterator<Integer> it = deque.iterator();
        int counter = 0;
        while (it.hasNext()) {
            counter++;
            it.next();
        }
        assertEquals(2, counter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddNullAsFirstItem() {
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddNullAsLastItem() {
        Deque<String> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void cannotRemoveFirstElementIfDequeIsEmpty() {
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void cannotRemoveLastElementIfDequeIsEmpty() {
        Deque<String> deque = new Deque<>();
        deque.removeLast();
    }
}
