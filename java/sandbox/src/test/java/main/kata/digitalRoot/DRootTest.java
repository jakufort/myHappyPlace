package main.kata.digitalRoot;

import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DRootTest {

    private DRoot dRoot = new DRoot();

    @Test
    void throwsExceptionOnInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> dRoot.digitalRoot(-1));
    }

    @Test
    void Tests() {
        assertEquals(7, dRoot.digitalRoot(16), "Nope!");
    }

    @Test
    void shouldAddUntilResultIsOnlyOneDigit() {
        assertEquals(6, dRoot.digitalRoot(942));
    }

}