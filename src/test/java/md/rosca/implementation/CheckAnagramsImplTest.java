package md.rosca.implementation;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CheckAnagramsImplTest {

    @org.junit.jupiter.api.Test
    void getAnagrams() {
        CheckAnagramsImpl checkAnagrams = new CheckAnagramsImpl(Arrays.asList("act", "cat", "tree", "race", "care", "acre", "bee"));
        String result = "act cat \n" +
                        "race care acre \n";
        assertEquals(result, checkAnagrams.getAnagrams());
    }
}