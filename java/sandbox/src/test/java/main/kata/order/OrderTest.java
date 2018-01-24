package main.kata.order;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order = new Order();

    @Test
    void emptyValueForNull() {
        assertEquals("", order.order(null));
    }

    @Test
    void emptyValueForEmptyInput() {
        assertEquals("", order.order(""));
    }

    @Test
    void test1() {
        assertThat(order.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
    void test2() {
        assertThat(order.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    void emptyValueWhenAtLeastOneWordDoesNotHaveNumber() {
        assertEquals("", order.order("4of Fo1r people g3ood th5e the2"));
    }

}