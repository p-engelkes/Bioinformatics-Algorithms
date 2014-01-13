package week9;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 11.01.14.
 */
public class TrieMatchingTest {
    List<String> pattern = new ArrayList<String>();
    TrieConstruction trieConstruction;
    TrieMatching trieMatching;
    String text;

    @Before
    public void setUp() {
        text = "ACGTBCGTAGTAC";
        pattern.add("ACGT");
        pattern.add("CGTA");
        pattern.add("GTAC");
        trieConstruction = new TrieConstruction();
        trieMatching = new TrieMatching(text, pattern, trieConstruction.constructTrie(pattern));
    }

    @Test
    public void findMatchingPatterns() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(5);
        expected.add(9);

        assertEquals(expected, trieMatching.findMatchingPatterns());
    }

    @Test
    public void testIsPatternPresent() {
        Tree trie = trieMatching.getTrie();
        Tree.Node<String, Integer> parent = trie.getRoot();
        assertTrue(trieMatching.isPatternPresent(parent, 0));
        assertTrue(trieMatching.isPatternPresent(parent, 5));
        assertTrue(!trieMatching.isPatternPresent(parent, 8));
    }

    @Test
    public void testIsInChildren() throws Exception {
        Tree trie = trieMatching.getTrie();
        Tree.Node<String, Integer> parent = trie.getRoot();
        List<Tree.Node<String, Integer>> children = parent.getChildren();
        assertTrue(trieMatching.isInChildren(children, "A"));
        assertTrue(trieMatching.isInChildren(children, "C"));
        assertTrue(trieMatching.isInChildren(children, "G"));
        assertTrue(!trieMatching.isInChildren(children, "T"));
        assertTrue(!trieMatching.isInChildren(children, "K"));
    }
}
