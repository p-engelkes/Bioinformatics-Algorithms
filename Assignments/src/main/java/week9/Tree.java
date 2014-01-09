package week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 09.01.14
 * Time: 11:38
 */
public class Tree<String> {
    private Node<String> root;

    public Tree(String rootData) {
        root = new Node<String>();
        root.data = rootData;
        root.children = new ArrayList<Node<String>>();
    }

    public Node<String> getRoot() {
        return root;
    }

    public void setRoot(Node<String> root) {
        this.root = root;
    }

    public static class Node<String> {
        private String data;
        private Node<String> parent;
        private List<Node<String>> children;

        public String getData() {
            return this.data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node<String> getParent() {
            return this.parent;
        }

        public void setParent(Node<String> parent) {
            this.parent = parent;
        }

        public List<Node<String>> getChildren() {
            return this.children;
        }

        public void setChildren(List<Node<String>> children) {
            this.children = children;
        }
    }

}
