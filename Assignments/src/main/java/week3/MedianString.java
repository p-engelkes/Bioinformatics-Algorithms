package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Date: 25.11.13
 * Time: 12:01
 */
public class MedianString {
    String dna;
    int k;
    List<String> dnaList;

    public MedianString(String dna, int k) {
        this.dna = dna;
        this.k = k;
        this.dnaList = getDnaAsList(dna);
    }

    public List<List<Object>> calculateMedianString() {
        List<List<Object>> bestKMer = new ArrayList<List<Object>>();
        List<String> allKMers = calculateAllKMers();
        int smallestHammingDistance = allKMers.size();
        
        for (String pattern : allKMers) {
            List<Object> helpList = new ArrayList<Object>();
            int totalHammingDistance = calculateTotalHammingDistance(pattern);
            if (totalHammingDistance < smallestHammingDistance) {
                if (bestKMer.size() > 0) {
                    bestKMer.remove(0);
                    helpList.add(totalHammingDistance);
                    helpList.add(pattern);
                    bestKMer.add(helpList);
                    smallestHammingDistance = totalHammingDistance;
                } else {
                    helpList.add(totalHammingDistance);
                    helpList.add(pattern);
                    bestKMer.add(helpList);
                    smallestHammingDistance = totalHammingDistance;
                }
            }
        }

        return bestKMer;
    }

    public int calculateTotalHammingDistance(String pattern) {
        int totalHammingDistance = 0;
        
        for (String text : this.dnaList) {
            totalHammingDistance = totalHammingDistance + calculateHammingDistance(pattern, text);
        }
        return totalHammingDistance;
    }
    
    public int calculateHammingDistance(String pattern, String text) {
        int textLength = text.length();
        int hammingDistance = textLength;
        int patternLength = pattern.length();
        
        for (int i = 0; i < textLength - patternLength; i++) {
            String substringToCompare = text.substring(i, i + patternLength);
            int distance = calculateDistance(pattern, substringToCompare);
            if (distance < hammingDistance) {
                hammingDistance = distance;
            }
        }
        
        return hammingDistance;
    }
    
    public int calculateDistance(String pattern, String substringToCompare) {
        int distance = 0;
        int substringLength = substringToCompare.length();
        
        for (int i = 0; i < substringLength; i++) {
            if (pattern.charAt(i) != (substringToCompare.charAt(i))) {
                distance++;
            }
        }
            
        return distance;    
    }

    public List<String> calculateAllKMers() {
        List<String> allKMers = new ArrayList();
        allKMers.add("A");
        allKMers.add("T");
        allKMers.add("C");
        allKMers.add("G");

        for (int i = 1; i < k; i++) {
            int size = allKMers.size();
            for (int j = 0; j < size; j++) {
                String s = allKMers.get(0);
                allKMers.remove(0);
                int length = s.length();
                s = s + 'A';
                allKMers.add(s);
                s = s.substring(0, length) + 'T';
                allKMers.add(s);
                s = s.substring(0, length) + 'C';
                allKMers.add(s);
                s = s.substring(0, length) + 'G';
                allKMers.add(s);
            }
        }

        return allKMers;
    }

    public List<String> getDnaAsList(String dna) {
        List<String> resultList = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(dna);
        while (stringTokenizer.hasMoreElements()) {
            resultList.add((String) stringTokenizer.nextElement());
        }

        return resultList;
    }
}
