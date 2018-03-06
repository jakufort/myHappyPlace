import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        readStrings(queue);
        for (int i = 0; i < k; i++) {
            System.out.println(queue.dequeue());
        }
    }

    private static void readStrings(RandomizedQueue<String> queue) {
        String item;
        try {
            while (!StdIn.isEmpty() && (item = StdIn.readString()) != null) {
                queue.enqueue(item);
            }
        } catch (NoSuchElementException ignored) {

        }
    }
}
