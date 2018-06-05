package main.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class DnaStrand {
    private static final Map<Character, Character> mapping = new HashMap<>();
    static {
        mapping.put('A', 'T');
        mapping.put('T', 'A');
        mapping.put('C', 'G');
        mapping.put('G', 'C');
    }
    static String makeComplement(String dna) {
        if (dna == null) {
            return "";
        }
        return dna.chars()
                .mapToObj(x -> (char)x)
                .map(mapping::get)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
