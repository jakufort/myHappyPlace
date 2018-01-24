package main.kata.order;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringGeneratorForOrder extends Generator<String> {
    public StringGeneratorForOrder() {
        this(String.class);
    }

    private StringGeneratorForOrder(Class<String> type) {
        super(type);
    }

    @Override
    public String generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        int wordsCount = getIntInBounds(sourceOfRandomness);
        Set<Integer> alreadyUsed = new HashSet<>();
        List<String> words = new ArrayList<>();
        for (int i = 0;i<wordsCount; i++) {
            int num = getNewInt(alreadyUsed, sourceOfRandomness);
            words.add(addNumberToRandomPlaceInString(sourceOfRandomness, randomStringWihoutNumber(sourceOfRandomness, generationStatus), num));
            alreadyUsed.add(num);
        }
        return String.join(" ", words);
    }

    private String randomStringWihoutNumber(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        return gen().type(String.class).generate(sourceOfRandomness, generationStatus).replaceAll("\\d", "");
    }

    private String addNumberToRandomPlaceInString(SourceOfRandomness sourceOfRandomness, String input, int number) {
        if (input.length() > 0) {
            int index = sourceOfRandomness.nextInt(input.length());
            return input.substring(0, index) + number + input.substring(index);
        } else {
            return String.valueOf(number);
        }
    }

    private int getNewInt(Set<Integer> alreadyUsed, SourceOfRandomness sourceOfRandomness) {
        int ans = getIntInBounds(sourceOfRandomness);
        while (alreadyUsed.contains(ans)) {
            ans = getIntInBounds(sourceOfRandomness);
        }
        return ans;
    }

    private int getIntInBounds(SourceOfRandomness sourceOfRandomness) {
        return sourceOfRandomness.nextInt(8) + 1;
    }
}
