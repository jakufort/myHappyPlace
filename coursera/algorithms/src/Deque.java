import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node(item, oldFirst, null);
        size++;
        if (size == 1) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        Node oldLast = last;
        last = new Node(item, null, oldLast);
        if (size == 1) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item ans = first.element;
        first = first.next;
        if (first != null) {
            first.previous = null;
        }
        decrementSize();
        return ans;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item ans = last.element;
        last = last.previous;
        if (last != null) {
            last.next = null;
        }
        decrementSize();
        return ans;
    }

    private void decrementSize() {
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Node currentItem = first;
            @Override
            public boolean hasNext() {
                return currentItem != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item ans = currentItem.element;
                currentItem = currentItem.next;
                return ans;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private class Node {
        Item element;
        Node next;
        Node previous;

        Node(Item element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
}
