package main;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assume.*;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Pair;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import static org.hamcrest.number.OrderingComparison.greaterThan;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import utils.PairGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(JUnitQuickcheck.class)
public class CompareTestProperty {

    private Compare compare = new Compare();

    @Property
    public void notEqualForArraysWithDifferentLength(int a[], int b[]){
        assumeThat(a.length, is(not(b.length)));
        Assertions.assertEquals(false, compare.compare(a, b));
    }

    @Property
    public void notEqualWhenSmallestNumberFromFirstArrayIsLargerThanSmallestNumberInSecondArray(int a[], int b[]) {
        assumeThat(a.length, is(b.length));
        assumeThat(a.length, is(greaterThan(0)));
        assumeThat(b.length, is(greaterThan(0)));
        int aMin = getSmallestNumber(a);
        int bMin = getSmallestNumber(b);
        assumeThat(aMin, greaterThan(bMin));
        Assertions.assertEquals(false, compare.compare(a, b));
    }

    private int getSmallestNumber(int[] a) {
        return Collections.min(Arrays.stream(a).boxed().collect(Collectors.toList()));
    }

    @Property(trials = 250)
    public void secondArrayHaveAllSquaredNumbersOfFirstArray(@From(PairGenerator.class) Pair<List<Integer>, List<Integer>> input) {
        int[] a = input.first.stream().mapToInt(Integer::intValue).toArray();
        int[] b = input.second.stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertEquals(true, compare.compare(a, b));
    }
}
