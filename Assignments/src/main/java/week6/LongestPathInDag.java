package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 19.12.13
 * Time: 09:16
 */
public class LongestPathInDag {

    private int source;
    private int sink;
    private List<List<Integer>> graph;

    public LongestPathInDag(int source, int sink, List<List<Integer>> graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
    }

    public int getLongestPath() {
        int node = sink;
        int score = 0;
        List<Integer> listPath = new ArrayList<Integer>();
        int counter = 0;
        while (node != source) {
            listPath.add(node);
            //System.out.println(node);
            score = score + findHighestScoreForNode(node);
            node = findNodeWithHighestScore(node);
            if (node == -1) {
                removeAllBadNodes(listPath.get(counter));
                listPath = new ArrayList<Integer>();
                node = sink;
                score = 0;
                counter = -1;
                //System.out.println("start new");
            }
            counter++;
        }
        System.out.println(score);
        Collections.reverse(listPath);
        listPath.add(source);
        for (Integer i : listPath) {
            System.out.print(i + "->");
        }
        return score;
    }

    public void removeAllBadNodes(int node) {
        for (int i = 0; i < graph.size(); i++) {
            List<Integer> list = graph.get(i);
            if (node == list.get(0)) {
                graph.remove(list);
            }
        }
    }

    public int findHighestScoreForNode(int node) {
        int highestScore = 0;
        for (List<Integer> list : graph) {
            if (list.get(1) == node) {
                int score = list.get(2);
                if (score > highestScore) {
                    highestScore = score;
                }
            }
        }

        return highestScore;
    }

    public int findNodeWithHighestScore(int node) {
        int highestScore = 0;
        int nextNode = 0;
        boolean found = false;
        for (List<Integer> list : graph) {
            if (list.get(1) == node) {
                int score = list.get(2);
                if (score > highestScore) {
                    highestScore = score;
                    nextNode = list.get(0);
                    found = true;
                }
            }
        }

        if (found) {
            return nextNode;
        } else {
            return -1;
        }

    }

}
