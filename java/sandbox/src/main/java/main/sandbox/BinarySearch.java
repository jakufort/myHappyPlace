package main.sandbox;

class BinarySearch<T extends Comparable> {

    int findPosition(T[] lst, T element) {
        if (lst == null || lst.length == 0 || element == null) {
            throw new IllegalArgumentException();
        }
        int l = 0;
        int r = lst.length - 1;
        while(true) {
            int m = (l+r)/2;
            if (l > r) {
                return -1;
            }
            if (lst[m].compareTo(element) < 0) {
                l = m + 1;
            } else if (lst[m].compareTo(element) > 0) {
                r = m - 1;
            } else {
                return m;
            }
        }
    }
}
