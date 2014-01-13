package week9;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Patrick on 10.01.14.
 */
public class ReadPatternsForTrieConstructionTest {

    private String pathToFile = "C:\\Users\\Patrick\\Desktop\\Coursera\\BioinformaticsAlgorithm\\week9\\DataForTrieConstruction.txt";
    ReadPatternsForTrieConstruction readPatterns = new ReadPatternsForTrieConstruction(pathToFile);

    @Test
    public void testReadPatterns() throws Exception {
        List<String> patterns = readPatterns.readPatterns();
        assertEquals(93, patterns.size());
    }
}
