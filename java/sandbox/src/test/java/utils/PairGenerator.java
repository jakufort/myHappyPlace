package utils;

import com.pholser.junit.quickcheck.Pair;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.List;

public class PairGenerator extends Generator<Pair> {

    private static final int MAX_SIZE = 1000;

    public PairGenerator() {
        this(Pair.class);
    }

    protected PairGenerator(Class<Pair> type) {
        super(type);
    }

    @Override
    public Pair<List<Integer>, List<Integer>> generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        int size = sourceOfRandomness.nextInt(MAX_SIZE);
        List<Integer> fst = new ArrayList<>(size);
        List<Integer> snd = new ArrayList<>(size);
        for (int i=0;i<size;i++) {
            int val = sourceOfRandomness.nextInt();
            fst.add(val);
            snd.add(val * val);
        }
        return new Pair<>(fst, snd);
    }
}
