package week5;

import week4.EulerianCycleString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Asus on 12.12.13.
 */
public class kUniversalCircularString {

    int k;

    public kUniversalCircularString(int k) {
        this.k = k;
    }

    public List<String> getKUniversalCircularString() {
        List<String> allKUniversals = createAllKUniversals();
        HashMap<String, List<String>> adjacencyList = createAdjacencyList(allKUniversals);
        System.out.println("adjacencyList created. Start to compute EulerianCycle:");
        EulerianCycleString eulerianCycle = new EulerianCycleString(adjacencyList);

        return eulerianCycle.getEulerianCycle();
    }

    public HashMap<String, List<String>> createAdjacencyList(List<String> allKUniversals) {
        HashMap<String, List<String>> adjacencyList = new HashMap<String, List<String>>();
        for (String s : allKUniversals) {
            String substring = s.substring(1);
            List<String> foundSubstrings = findSubstring(substring, allKUniversals);
            adjacencyList.put((s), foundSubstrings);
        }

        return adjacencyList;
    }

    public boolean alreadyExistsInList(String stringToFind, List<String> listToSearch) {
        for (String stringToCompare : listToSearch) {
            if (stringToCompare.equals(stringToFind)) {
                return true;
            }
        }

        return false;
    }

    public List<String> findSubstring(String s, List<String> allKUniversals) {
        List<String> foundSubstrings = new ArrayList<String>();
        for (String string : allKUniversals) {
            int length = s.length();
            if (string.substring(0, length).equals(s) && !string.equals(s)) {
                foundSubstrings.add(string);
            }
        }

        return foundSubstrings;
    }


    public List<String> createAllKUniversals() {
        List<String> kUniversal = new ArrayList<String>();
        double pow = Math.pow(2, k);

        for (int i = 0; i < pow; i++) {
            kUniversal.add("");
        }

        for (int j = k; j > 0; j--) {
            double alternate = Math.pow(2, j - 1);
            boolean zero = true;
            int count = 0;
            for (int i = 0; i < kUniversal.size(); i++) {
                if (count >= alternate) {
                    if (zero) {
                        zero = false;
                    } else {
                        zero = true;
                    }
                    count = 0;
                }
                if (zero) {
                    kUniversal.set(i, kUniversal.get(i) + "0");
                    count++;
                } else {
                    kUniversal.set(i, kUniversal.get(i) + "1");
                    count++;
                }
            }
        }
        return kUniversal;
    }
}
