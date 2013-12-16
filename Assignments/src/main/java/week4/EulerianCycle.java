package week4;

import java.util.*;

/**
 * Created by Asus on 09.12.13.
 */
public class EulerianCycle {

    private HashMap<Integer, List<Integer>> adjacencyList;
    private List<Integer> knotList;
    int lengthOfCycle;

    public EulerianCycle(HashMap<Integer, List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.knotList = getKnotList();
        this.lengthOfCycle = getLengthOfCycle();
    }

    public List<Integer> getEulerianCycle() {
        List<Integer> cycle = new ArrayList<Integer>();
        int node = knotList.get(0);

        while (cycle.size() < lengthOfCycle) {
            if (nodeHasUnexploredEdges(node)) {
                cycle.add(node);
                List<Integer> removeExploredEdge = this.adjacencyList.get(node);
                int oldNode = node;
                node = this.adjacencyList.get(node).get(0);
                removeExploredEdge.remove(0);
                this.adjacencyList.remove(oldNode);
                this.adjacencyList.put(oldNode, removeExploredEdge);
            } else {
                node = findKnotWithUnexploredEdges(cycle);
                cycle = traverseOldCycle(cycle, node);
                List<Integer> removeExploredEdge = this.adjacencyList.get(node);
                int oldNode = node;
                node = this.adjacencyList.get(node).get(0);
                removeExploredEdge.remove(0);
                this.adjacencyList.remove(oldNode);
                this.adjacencyList.put(oldNode, removeExploredEdge);
            }
        }
        cycle.add(cycle.get(0));

        return cycle;
    }

    public List<Integer> traverseOldCycle(List<Integer> cycle, int node) {
        List<Integer> newCycle = new ArrayList<Integer>();
        int lastOccuranceOfNode = findLastOccurenceOfNode(cycle, node);

        for (int i = lastOccuranceOfNode; i < cycle.size(); i++) {
            newCycle.add(cycle.get(i));
        }

        for (int i = 0; i < lastOccuranceOfNode; i++) {
            newCycle.add(cycle.get(i));
        }

        newCycle.add(node);

        return newCycle;
    }

    public int findLastOccurenceOfNode(List<Integer> cycle, int node) {
        int lastOccurence = 0;

        for (int i = 0; i < cycle.size(); i++) {
            if (cycle.get(i) == node) {
                lastOccurence = i;
            }
        }

        return lastOccurence;
    }

    public int findKnotWithUnexploredEdges(List<Integer> cycle) {
        int node = 0;

        for (Integer i : cycle) {
            List<Integer> unexploredEdges = this.adjacencyList.get(i);
            if (!unexploredEdges.isEmpty()) {
                return i;
            }
        }

        return node;
    }

    public boolean nodeHasUnexploredEdges(int node) {
        if (!this.adjacencyList.get(node).isEmpty()) {
            return true;
        }

        return false;
    }

    public List<Integer> getKnotList() {
        List<Integer> knotList = new ArrayList<Integer>();
        Iterator iterator = this.adjacencyList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            knotList.add((Integer) pairs.getKey());
        }

        Collections.sort(knotList);

        return knotList;
    }

    public int getLengthOfCycle() {
        int lengthOfCycle = 0;
        Iterator iterator = this.adjacencyList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            lengthOfCycle = lengthOfCycle + ((List<Integer>) pairs.getValue()).size();
        }

        return lengthOfCycle;
    }
}
