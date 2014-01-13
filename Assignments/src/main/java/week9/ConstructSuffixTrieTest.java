package week9;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Date: 13.01.14
 * Time: 15:02
 */
public class ConstructSuffixTrieTest {
    String text = "ACGT$";
    ConstructSuffixTrie constructSuffixTrie;

    @Before
    public void setUp() {
        constructSuffixTrie = new ConstructSuffixTrie(text);
    }

    @Test
    public void testConstructPatterns() throws Exception {
        List<String> patterns = new ArrayList<String>();
        patterns.add("ACGT$");
        patterns.add("CGT$");
        patterns.add("GT$");
        patterns.add("T$");
        patterns.add("$");
        assertEquals(5, constructSuffixTrie.constructPatterns(text).size());
        assertEquals(patterns, constructSuffixTrie.constructPatterns(text));
    }
}
