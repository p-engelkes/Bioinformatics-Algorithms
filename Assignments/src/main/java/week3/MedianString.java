package Week3;

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

        for (String s : allKMers) {
            calculateScore(s);
        }

        return bestKMer;
    }

    public int calculateScore(String s) {

        return 0;
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
