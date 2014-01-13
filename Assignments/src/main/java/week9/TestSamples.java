package week9;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Date: 09.01.14
 * Time: 11:54
 */
public class TestSamples {

    public static void main(String[] args) throws FileNotFoundException {
        String pathToFile = "C:\\Users\\Patrick\\Desktop\\Coursera\\BioinformaticsAlgorithm\\week9\\DataForTrieConstruction.txt";
        TrieConstruction trieConstruction = new TrieConstruction();
        ReadPatternsForTrieConstruction readPatterns = new ReadPatternsForTrieConstruction(pathToFile);

        List<String> patternList = readPatterns.readPatterns();
        trieConstruction.constructTrie(patternList);
    }
}
