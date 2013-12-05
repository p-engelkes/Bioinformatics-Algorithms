package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Patrick on 05.12.13.
 */
public class StringReconstruction {

    String sequence;
    int k;

    public StringReconstruction(String sequence, int k) {
        this.sequence = sequence;
        this.k = k;
    }

    public List<String> reconstructString() {
        List<String> reconstructedStrings = new ArrayList<String>();
        List<String> allKMers = new ArrayList<String>();

        allKMers = getAllKMers(this.sequence);
        reconstructedStrings = sortLexicographic(allKMers);

        return reconstructedStrings;
    }

    public List<String> getAllKMers(String sequence) {
        List<String> allKMers = new ArrayList<String>();
        int sequenceLength = sequence.length();

        for (int i = 0; i < sequenceLength - k + 1; i++) {
            String substring = sequence.substring(i, i + k);
            allKMers.add(substring);
        }

        return allKMers;
    }

    public List<String> sortLexicographic(List<String> allKMers) {
        List<String> lexicographic;

        Collections.sort(allKMers);
        lexicographic = allKMers;

        return lexicographic;
    }
}
