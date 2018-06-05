package main.kata;

import java.util.stream.IntStream;

class Sum {

    int GetSum(int a, int b) {
        return IntStream.rangeClosed(Math.min(a,b), Math.max(a,b)).sum();
    }
}
