package main.kata;

import java.util.function.Function;
import java.util.stream.Collectors;

class CountingDuplicates {
    static int duplicateCount(String text) {
        if (text == null) {
            return 0;
        }
        return Math.toIntExact(text.toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .reduce(0L, (acc, x) -> x > 1 ? ++acc : acc));
    }
}
