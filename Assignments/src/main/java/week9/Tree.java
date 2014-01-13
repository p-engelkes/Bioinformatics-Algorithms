package week9;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 09.01.14
 * Time: 11:38
 */
public class Tree<String> {
    private Node<String, Integer> root;
    private int count = 0;

    public Tree(String rootData, int position) {
        root = new Node<String, Integer>();
        root.setData(rootData);
        root.setPosition(position);
        root.children = new ArrayList<Node<String, Integer>>();
    }

    public Node<String, Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<String, Integer> root) {
        this.root = root;
    }

    @Override
    public java.lang.String toString() {
        List<Node<String, Integer>> children = root.getChildren();
        Node<String, Integer> parent = root;
        try {
            traverseThroughTree(children, parent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void traverseThroughTree(List<Node<String, Integer>> children, Node<String, Integer> parent) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("C:\\Users\\pengelkes\\Desktop\\Patrick\\SolutionForTrieConstruction.txt", "UTF-8");
        if (children != null) {
            for (Node<String, Integer> child : children) {
                writer.print(parent.getPosition() + " ");
                writer.print(child.getPosition() + " ");
                writer.println(child.getData());
                traverseThroughTree(child.getChildren(), child);
            }
        }
    }

    public void countChildren(List<Node<String, Integer>> children, Node<String, Integer> parent) {
        if (children.size() > 1) {
            for (Node<String, Integer> child : children) {
                count++;
                countChildren(child.getChildren(), child);
            }
        }

        System.out.println(count);
    }

    public static class Node<String, Integer> {
        private int position;
        private int numberOfChildren;
        private String data;
        private Node<String, Integer> parent;
        private List<Node<String, Integer>> children;

        public String getData() {
            return this.data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node<String, Integer> getParent() {
            return this.parent;
        }

        public void setParent(Node<String, Integer> parent) {
            this.parent = parent;
        }

        public List<Node<String, Integer>> getChildren() {
            return this.children;
        }

        public void setChildren(List<Node<String, Integer>> children) {
            this.children = children;
        }

        public int getPosition() {
            return this.position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getNumberOfChildren() {
            return numberOfChildren;
        }

        public void setNumberOfChildren(int numberOfChildren) {
            this.numberOfChildren = numberOfChildren;
        }
    }

}