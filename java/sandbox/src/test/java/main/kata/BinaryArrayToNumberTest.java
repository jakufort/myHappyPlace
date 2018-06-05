package main.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryArrayToNumberTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void convertBinaryArrayToInt(int expected, List<Integer> binary) {
        assertEquals(expected, BinaryArrayToNumber.ConvertBinaryArrayToInt(binary));
    }

    @Test
    void foo() {
        assertEquals(0, BinaryArrayToNumber.ConvertBinaryArrayToInt(Arrays.asList(0,0,0,0)));
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(0, lst(0,0,0,0)),
                Arguments.of(1, lst(0,0,0,1)),
                Arguments.of(1, lst(0,1)),
                Arguments.of(1, lst(1)),
                Arguments.of(2, lst(1,0)),
                Arguments.of(2, lst(0,1,0)),
                Arguments.of(3, lst(1,1)),
                Arguments.of(15, lst(1,1,1,1)),
                Arguments.of(0, new ArrayList<>())
        );
    }

    private static List<Integer> lst(Integer... values) {
        return Arrays.asList(values);
    }
}