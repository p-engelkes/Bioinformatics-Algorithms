package week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 10.01.14.
 */
public class TrieMatching {

    private String text;
    private List<String> patterns;
    private Tree trie;
    boolean recursive = true;

    public TrieMatching(String text, List<String> patterns, Tree trie) {
        this.text = text;
        this.patterns = patterns;
        TrieConstruction trieConstruction = new TrieConstruction();
        this.trie = trieConstruction.constructTrie(patterns);
    }

    public List<Integer> findMatchingPatterns() {
        List<Integer> patternList = new ArrayList<Integer>();
        int count = 0;
        while (this.text.length() > 0) {
            Tree.Node<String, Integer> parent = trie.getRoot();
            for (int i = 0; i < text.length(); i++) {
                if (isPatternPresent(parent, 0)) {
                    patternList.add(count);
                }
                this.text = this.text.substring(1);
                this.recursive = true;
                count++;
            }
        }

        return patternList;
    }

    public boolean isPatternPresent(Tree.Node<String, Integer> parent, int count) {
        if (parent.getChildren().size() > 0) {
            if (this.text.length() >= 2 + count) {
                String pattern = this.text.substring(count, count + 1);
                if (isInChildren(parent.getChildren(), pattern)) {
                    parent = getNodeWithSameDataAsPattern(parent.getChildren(), pattern);
                    count++;
                    isPatternPresent(parent, count);
                } else {
                    recursive = false;
                }
            } else {
                recursive = false;
            }
        }

        if (recursive) {
            return true;
        } else {
            return false;
        }
    }

    public Tree.Node getNodeWithSameDataAsPattern(List<Tree.Node<String, Integer>> children, String pattern) {
        Tree.Node returnNode = new Tree.Node();

        for (Tree.Node<String, Integer> child : children) {
            if (child.getData().equals(pattern)) {
                return child;
            }
        }

        return returnNode;
    }

    public boolean isInChildren(List<Tree.Node<String, Integer>> children, String pattern) {
        for (Tree.Node<String, Integer> child : children) {
            if (child.getData().equals(pattern)) {
                return true;
            }
        }

        return false;
    }

    public Tree getTrie() {
        return this.trie;
    }


}
