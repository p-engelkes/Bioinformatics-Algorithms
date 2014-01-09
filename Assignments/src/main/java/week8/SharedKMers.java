package week8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Date: 07.01.14
 * Time: 10:15
 */
public class SharedKMers {

    int k;
    String two;
    String pathToFile;
    HashMap<String, List<Integer>> allKMersOne = new HashMap<String, List<Integer>>();
    HashMap<String, List<Integer>> allKMersTwo = new HashMap<String, List<Integer>>();

    public SharedKMers(int k, String two, String pathToFile) {
        this.k = k;
        this.two = two;
        this.pathToFile = pathToFile;
    }

    public void calculateSharedKMers() throws IOException {
        fillHashMap(this.allKMersOne, this.pathToFile);
        reverseHashMap(allKMersOne);

//        System.out.println(this.allKMersOne.get("CAACGAATAAGATGGTC"));

//        fillHashMapWithoutFile(this.allKMersTwo);
//        reverseHashMap(this.allKMersTwo);

        List<String> storePairs = new ArrayList<String>();

//        Iterator iterator = this.allKMersTwo.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry pairs = (Map.Entry) iterator.next();
//            String compare = (String)pairs.getKey();
//            Object value = allKMersOne.get(compare);
//            if (value != null) {
//                for (Integer i : (List<Integer>)value) {
//                    String stringToStore = ("(" + i + ", " + pairs.getValue() + ")");
//                    if (!alreadyExists(storePairs, stringToStore)) {
//                        storePairs.add(stringToStore);
//                    }
//                }
//
//
//            }
//        }

        for (int i = 0; i < two.length() - k + 1; i++) {
            String find = two.substring(i, i + k);
            Object value = allKMersOne.get(find);
            if (value != null) {
                for (Integer j : (List<Integer>) value) {
                    String stringToStore = ("(" + j + ", " + i + ")");
                    if (!alreadyExists(storePairs, stringToStore)) {
                        storePairs.add(stringToStore);
                    }
                }
            }
        }

        for (String s : storePairs) {
            System.out.println(s);
        }
    }

    public boolean alreadyExists(List<String> listToSearchIn, String stringToFind) {
        for (String s : listToSearchIn) {
            if (s.equals(stringToFind)) {
                return true;
            }
        }

        return false;
    }

    public HashMap<String, List<Integer>> fillHashMap(HashMap<String, List<Integer>> allKMers, String pathToFile) throws IOException {
        LinkedList<Character> helpList = new LinkedList<Character>();
        FileReader fr;
        fr = new FileReader(pathToFile);
        BufferedReader br = new BufferedReader(fr);
        int c = 0;
        int count = 0;
        int secondCount = 0;
        while ((c = br.read()) != -1) {
            char character = (char) c;
            if (count < this.k) {
                helpList.addLast(character);
                count++;
            } else {
                if (allKMers.get(listToString(helpList)) != null) {
                    String s = listToString(helpList);
                    List<Integer> helpIntList = allKMers.get(listToString(helpList));
                    helpIntList.add(secondCount);
                    allKMers.remove(s);
                    allKMers.put(s, helpIntList);
                    secondCount++;
                    helpList.removeFirst();
                    helpList.addLast(character);
                } else {
                    List<Integer> helpIntList = new ArrayList<Integer>();
                    helpIntList.add(secondCount);
                    allKMers.put(listToString(helpList), helpIntList);
                    secondCount++;
                    helpList.removeFirst();
                    helpList.addLast(character);
                }

            }
        }

        if (allKMers.get(listToString(helpList)) != null) {
            String s = listToString(helpList);
            List<Integer> helpIntList = allKMers.get(listToString(helpList));
            helpIntList.add(secondCount);
            allKMers.remove(s);
            allKMers.put(s, helpIntList);
        } else {
            List<Integer> helpIntList = new ArrayList<Integer>();
            helpIntList.add(secondCount);
            allKMers.put(listToString(helpList), helpIntList);
        }

        return allKMers;
    }

    public HashMap<String, List<Integer>> fillHashMapWithoutFile(HashMap<String, List<Integer>> allKMers) {
        for (int i = 0; i < this.two.length() - this.k + 1; i++) {
            String s = this.two.substring(i, i + this.k);
            List<Integer> helpIntList;
            if (allKMers.get(s) != null) {
                helpIntList = allKMers.get(s);
                helpIntList.add(i);
                allKMers.remove(s);
                allKMers.put(s, helpIntList);
            } else {
                helpIntList = new ArrayList<Integer>();
                helpIntList.add(i);
                allKMers.put(s, helpIntList);
            }
        }

        return allKMers;
    }

    public String listToString(LinkedList<Character> helpList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : helpList) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public HashMap<String, List<Integer>> reverseHashMap(HashMap<String, List<Integer>> allKMers) {
        HashMap<String, List<Integer>> helpMap = new HashMap<String, List<Integer>>();
        Iterator iterator = allKMers.entrySet().iterator();
        ReverseComplement reverseComplement;
        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            reverseComplement = new ReverseComplement((String) pairs.getKey());
            helpMap.put(reverseComplement.getReverseComplement(), (List<Integer>) pairs.getValue());
        }

        iterator = helpMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            allKMers.put((String) pairs.getKey(), (List<Integer>) pairs.getValue());
        }

        return allKMers;
    }
}
