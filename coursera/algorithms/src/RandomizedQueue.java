import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private int size;

    public RandomizedQueue() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node(item, oldFirst, null);
        size++;
        if (size != 1) {
            oldFirst.previous = first;
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = iterateUntilRandomElement();
        Item ans = node.element;
        if (node.previous == null) {
            first = node.next;
            if (first != null ) {
                first.previous = null;
            }
        } else {
            node.previous.next = node.next;
            if (node.next != null) {
                node.next.previous = node.previous;
            }
        }
        size--;
        return ans;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return iterateUntilRandomElement().element;
    }

    private Node iterateUntilRandomElement() {
        int index = StdRandom.uniform(size);
        return getElement(index);
    }

    private Node getElement(int index) {
        int counter = 0;
        Node node = first;
        while (counter < index) {
            counter++;
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int counter = 0;
            int[] indexes = StdRandom.permutation(size);

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item ans = getElement(indexes[counter]).element;
                counter++;
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
