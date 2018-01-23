package main;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Compare {

    boolean compare(int a[], int b[]) {
        if (a == null || b == null) {
            return false;
        }
        Set<Integer> toCompare = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return toCompare.equals(Arrays.stream(a).boxed().map(x -> x*x).collect(Collectors.toSet()));
    }
}
