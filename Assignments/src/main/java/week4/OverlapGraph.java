package week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Patrick on 05.12.13.
 */
public class OverlapGraph {

    String pathToFile = "C:\\Users\\Patrick\\Downloads\\dataset_52_7";
    List<String> sequence;
    int k;

    public OverlapGraph(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        sequence = constructSequence(pathToFile);
        k = calculateK(pathToFile);
    }

    public List<List<String>> getOverlapGraph() {
        List<List<String>> overlapGraph;
        StringReconstruction stringReconstruction = new StringReconstruction("", k);
        List<String> lexicographic = stringReconstruction.sortLexicographic(sequence);

        overlapGraph = constructOverlapGraph(lexicographic);

        return overlapGraph;
    }

    public List<String> constructSequence(String pathToFile) throws IOException {
        List<String> sequence = new ArrayList<String>();
        BufferedReader br = new BufferedReader((new FileReader(pathToFile)));
        String line = br.readLine();
        while (line != null) {
            sequence.add(line);
            line = br.readLine();
        }

        return sequence;
    }

    public int calculateK(String pathToFile) throws IOException {
        BufferedReader br = new BufferedReader((new FileReader(pathToFile)));
        String line = br.readLine();
        k = line.length();

        return k;
    }

    public List<List<String>> constructOverlapGraph(List<String> lexicographic) {
        List<List<String>> overlapGraph = new ArrayList<List<String>>();
        int size = lexicographic.size();

        for (String s : lexicographic) {
            List<String> overlap = new ArrayList<String>();
            String matchString = s.substring(1, s.length() - 1);
            String match = findMatch(matchString, lexicographic);
            if (match.length() > 0) {
                overlap.add(s);
                overlap.add(match);
                overlapGraph.add(overlap);
            }

        }

        return overlapGraph;
    }

    public String findMatch(String matchString, List<String> lexicographic) {
        String match = "";

        for (String s : lexicographic) {
            String stringToMatch = s.substring(0, s.length() - 2);
            if (matchString.equals(stringToMatch)) {
                match = s;
            }
        }
        return match;
    }
}
