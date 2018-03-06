import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    private RandomizedQueue<String> queue;

    @Before
    public void init() {
        queue = new RandomizedQueue<>();
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, queue.size());
        queue.enqueue("");
        assertEquals(1, queue.size());
    }

    @Test
    public void enqueue() {
        String item = "test";
        queue.enqueue(item);
        assertEquals(item, queue.sample());
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals(4, queue.size());
    }

    @Test
    public void dequeue() {
        String item = "test";
        queue.enqueue(item);
        assertEquals(item, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void sample() {
        String item = "test";
        queue.enqueue(item);
        assertEquals(item, queue.sample());
        assertEquals(1, queue.size());
    }

    @Test
    public void iterator() {
        queue.enqueue("t");
        queue.enqueue("e");
        queue.enqueue("s");
        queue.enqueue("a");
        Set<String> actual = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(queue.iterator(), Spliterator.ORDERED),
                false).collect(Collectors.toSet());
        Set<String> expected = new HashSet<>(Arrays.asList("t", "e", "s", "a"));
        assertEquals(expected, actual);
        assertEquals(4, queue.size());
    }
}