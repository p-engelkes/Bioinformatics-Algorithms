package week4;

import java.util.*;

/**
 * Created by Asus on 09.12.13.
 */
public class EulerianCycleString {

    private HashMap<String, List<String>> adjacencyList;
    private List<String> knotList;
    int lengthOfCycle;

    public EulerianCycleString(HashMap<String, List<String>> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.knotList = getKnotList();
        this.lengthOfCycle = getLengthOfCycle();
    }

    public List<String> getEulerianCycle() {
        List<String> cycle = new ArrayList<String>();
        String node = knotList.get(0);

        while (cycle.size() < lengthOfCycle) {
            if (nodeHasUnexploredEdges(node)) {
                cycle.add(node);
                List<String> removeExploredEdge = this.adjacencyList.get(node);
                String oldNode = node;
                node = this.adjacencyList.get(node).get(0);
                removeExploredEdge.remove(0);
                this.adjacencyList.remove(oldNode);
                this.adjacencyList.put(oldNode, removeExploredEdge);
            } else {
                node = findKnotWithUnexploredEdges(cycle);
                cycle = traverseOldCycle(cycle, node);
                List<String> removeExploredEdge = this.adjacencyList.get(node);
                String oldNode = node;
                node = this.adjacencyList.get(node).get(0);
                removeExploredEdge.remove(0);
                this.adjacencyList.remove(oldNode);
                this.adjacencyList.put(oldNode, removeExploredEdge);
            }
        }
        cycle.add(cycle.get(0));

        return cycle;
    }

    public List<String> traverseOldCycle(List<String> cycle, String node) {
        List<String> newCycle = new ArrayList<String>();
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

    public int findLastOccurenceOfNode(List<String> cycle, String node) {
        int lastOccurence = 0;

        for (int i = 0; i < cycle.size(); i++) {
            if (cycle.get(i).equals(node)) {
                lastOccurence = i;
            }
        }

        return lastOccurence;
    }

    public String findKnotWithUnexploredEdges(List<String> cycle) {
        String node = "";

        for (String s : cycle) {
            List<String> unexploredEdges = this.adjacencyList.get(s);
            if (!unexploredEdges.isEmpty()) {
                return s;
            }
        }

        return node;
    }

    public boolean nodeHasUnexploredEdges(String node) {
        if (!this.adjacencyList.get(node).isEmpty()) {
            return true;
        }

        return false;
    }

    public List<String> getKnotList() {
        List<String> knotList = new ArrayList<String>();
        Iterator iterator = this.adjacencyList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            knotList.add((String) pairs.getKey());
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
