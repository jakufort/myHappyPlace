package main.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DnaStrandTest {

    @ParameterizedTest
    @CsvSource({
            "A,T",
            "T,A",
            "G,C",
            "C,G",
            "ATGC,TACG",
            "AAAA,TTTT",
            "TATAGC,ATATCG"
    })
    void makeComplement(String strand, String complementaryStrand) {
        assertEquals(complementaryStrand, DnaStrand.makeComplement(strand));
    }

    @Test
    void testingEmptyValus() {
        assertEquals("", DnaStrand.makeComplement(null));
        assertEquals("", DnaStrand.makeComplement(""));
    }

    @Test
    void veryLongString() {
        StringBuilder strand = new StringBuilder();
        StringBuilder complementaryStrand = new StringBuilder();
        for (int i=0; i<100000000; i++) {
            strand.append('A');
            complementaryStrand.append('T');
        }
        assertEquals(complementaryStrand.toString(), DnaStrand.makeComplement(strand.toString()));
    }

}