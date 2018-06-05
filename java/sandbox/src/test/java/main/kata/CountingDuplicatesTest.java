package main.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CountingDuplicatesTest {


    @ParameterizedTest
    @DisplayName("Should correctly count unique duplicate characters")
    @CsvSource({
            "0, abc",
            "0, ",
            "1, aabchd",
            "1, aaaaaaaabd",
            "2, aaaaabbdhsjf",
            "3, aabbcc"
    })
    void duplicateCount(int expectedCount, String testedString) {
        assertEquals(expectedCount, CountingDuplicates.duplicateCount(testedString));
    }
}