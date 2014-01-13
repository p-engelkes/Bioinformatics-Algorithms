package week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 09.01.14
 * Time: 11:42
 */
public class TrieConstruction {

    private Tree trie;

    public Tree constructTrie(List<String> patternList) {
        trie = new Tree("", 1);

        Tree.Node root = trie.getRoot();
        List<Tree.Node<String, Integer>> children = new ArrayList<Tree.Node<String, Integer>>();
        root.setChildren(children);

        int positionOfNode = 2;

        for (String pattern : patternList) {
            List<Object> notInTreeList = findFirstNodeNotInTree(pattern, root);
            if (notInTreeList.size() > 0) {
                Tree.Node nodeNotInTree = (Tree.Node) notInTreeList.get(0);
                int position = (Integer) notInTreeList.get(1);
                pattern = pattern.substring(position);
                for (int i = 0; i < pattern.length(); i++) {
                    List<Tree.Node<String, Integer>> newChildren = new ArrayList<Tree.Node<String, Integer>>();
                    Tree.Node node = new Tree.Node();
                    node.setParent(nodeNotInTree);
                    node.setData(String.valueOf(pattern.charAt(i)));
                    node.setPosition(positionOfNode);
                    positionOfNode++;
                    node.setChildren(newChildren);
                    nodeNotInTree.getChildren().add(node);
                    nodeNotInTree = node;
                }
            }

        }
        trie.toString();
        return trie;
    }

    public List<Object> findFirstNodeNotInTree(String pattern, Tree.Node root) {

        Tree.Node parent = root;
        List<Object> returnList = new ArrayList<Object>();

        for (int i = 0; i < pattern.length(); i++) {
            boolean found = false;
            String stringToCompare = String.valueOf(pattern.charAt(i));
            List<Tree.Node<String, Integer>> children = parent.getChildren();
            for (Tree.Node<String, Integer> node : children) {
                if (node.getData().equals(stringToCompare)) {
                    found = true;
                    parent = node;
                    break;
                }
            }
            if (!found) {
                returnList.add(parent);
                returnList.add(i);
                break;
            }

        }

        return returnList;
    }

}
