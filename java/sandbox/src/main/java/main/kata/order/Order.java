package main.kata.order;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Order {

    private static final Pattern p = Pattern.compile("\\d+");

    String order(String wordsAsString) {
        if (wordsAsString == null || wordsAsString.isEmpty()) {
            return "";
        }
        String[] words = wordsAsString.split(" ");
        Map<Integer, String> map = new TreeMap<>();
        for (String word : words) {
            Matcher matcher = p.matcher(word);
            if (matcher.find()) {
                map.put(Integer.valueOf(matcher.group()), word);
            } else {
                return "";
            }
        }
        return map.values().stream().collect(Collectors.joining(" "));
    }
}
