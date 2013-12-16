package week5;

import java.util.*;

/**
 * Created by Asus on 12.12.13.
 */
public class StringReconstruction {

    private HashMap<String, String> adjacencyList;

    public StringReconstruction(HashMap<String, String> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public String reconstructString() {
        StringBuilder reconstructedString = new StringBuilder();
        List<String> listWithAllOutgoingStrings = getListWithAllOutgoingStrings();
        List<String> listWithAllIncomingStrings = getListWithAllIncomingStrings();

        String start = findStart(listWithAllOutgoingStrings, listWithAllIncomingStrings);
        String finish = "";
        List<String> possibleFinish = findFinish(listWithAllOutgoingStrings, listWithAllIncomingStrings);

        for (String s : possibleFinish) {
            if (!start.equals(s)) {
                finish = s;
            }
        }

        reconstructedString.append(start);
        while (!start.equals(finish)) {
            start = nextString(start);
            int length = start.length();
            Character nextChar = start.charAt(length - 1);
            reconstructedString.append(nextChar);
        }

        return reconstructedString.toString();
    }

    public String nextString(String stringBefore) {
        return (this.adjacencyList.get(stringBefore));
    }

    public String findStart(List<String> listWithAllOutgoingStrings, List<String> listWithAllIncomingStrings) {
        String start = "";

        for (int i = 0; i < listWithAllOutgoingStrings.size(); i++) {
            int j = calculateIncomingEdges(listWithAllOutgoingStrings.get(i), listWithAllIncomingStrings);
            if (1 > j) {
                start = listWithAllOutgoingStrings.get(i);
            }

        }

        return start;
    }

    public List<String> findFinish(List<String> listWithAllOutgoingStrings, List<String> listWithAllIncomingStrings) {
        List<String> possibleFinish = new ArrayList<String>();
        int listSize = listWithAllOutgoingStrings.size();


        for (String s1 : listWithAllIncomingStrings) {
            boolean contains = false;
            for (String s2 : listWithAllOutgoingStrings) {
                if (s2.equals(s1)) {
                    contains = true;
                }
            }

            if (!contains) {
                possibleFinish.add(s1);
            }
        }

        return possibleFinish;
    }

    public int calculateIncomingEdges(String s, List<String> listWithAllIncomingEdges) {
        int incomingEdges = 0;

        for (String s1 : listWithAllIncomingEdges) {
            if (s.equals(s1)) {
                incomingEdges++;
            }
        }

        return incomingEdges;
    }

    public int calculateOutgoingEdges(String s, List<String> listWithAllOutgoingEdges) {
        int outgoingEdges = 1;


        return outgoingEdges;
    }

    public List<String> getListWithAllOutgoingStrings() {
        List<String> listWithAllStrings = new ArrayList<String>();
        Iterator iterator = this.adjacencyList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            listWithAllStrings.add((String) pairs.getKey());
        }

        return listWithAllStrings;
    }

    public List<String> getListWithAllIncomingStrings() {
        List<String> listWithAllIncomingStrings = new ArrayList<String>();
        Iterator iterator = this.adjacencyList.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            listWithAllIncomingStrings.add((String) pairs.getValue());
        }

        return listWithAllIncomingStrings;
    }

}
