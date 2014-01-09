package week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 09.01.14
 * Time: 11:54
 */
public class TestSamples {

    public static void main(String[] args) {
        TrieConstruction trieConstruction = new TrieConstruction();
        List<String> patternList = new ArrayList<String>();
        patternList.add("GGTA");
        patternList.add("CG");
        patternList.add("GGC");
        trieConstruction.constructTrie(patternList);
    }
}
