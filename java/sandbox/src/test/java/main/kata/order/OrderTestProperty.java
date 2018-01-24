package main.kata.order;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(JUnitQuickcheck.class)
public class OrderTestProperty {

    private static final Pattern p = Pattern.compile("\\d+");

    private Order order = new Order();

    @Property(trials = 500)
    public void propertyHolds(@From(StringGeneratorForOrder.class) String wordsAsString) {
        String[] words = order.order(wordsAsString).split(" ");
        int lastNum = 0;
        for (String word : words) {
            Matcher matcher = p.matcher(word);
            if (matcher.find()) {
                int num = Integer.valueOf(matcher.group());
                Assert.assertThat(lastNum, Matchers.lessThan(num));
                lastNum = num;
            }
        }
    }
}
