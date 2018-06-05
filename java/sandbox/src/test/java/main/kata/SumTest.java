package main.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    private Sum sum = new Sum();

    @ParameterizedTest
    @CsvSource({
        "1,1,1",
        "1,2,3",
        "1,3,6",
        "1,0,1",
        "-1,2,2"
    })
    void getSum(int a, int b, int expected) {
        assertEquals(expected, sum.GetSum(a, b));
    }

    @Test
    void getSum() {
        assertEquals(1, sum.GetSum(1,1));
    }
}