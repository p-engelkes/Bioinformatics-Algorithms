package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Patrick on 06.12.13.
 */
public class DeBruijnString {

    String sequence;
    int k;

    public DeBruijnString(String sequence, int k) {
        this.sequence = sequence;
        this.k = k;
    }

    public HashMap<String, List<String>> getDeBruijnGraph() {
        HashMap<String, List<String>> deBruijnGraph = new HashMap<String, List<String>>();
        StringReconstruction stringReconstruction = new StringReconstruction("", k - 1);
        List<String> allKMers = stringReconstruction.getAllKMers(this.sequence);
        List<String> kMersWithoutMultipleValues = removeMultipleValues(allKMers);
        calculateDeBruijnGraph(kMersWithoutMultipleValues);



        return deBruijnGraph;
    }

    public HashMap<String, List<String>> calculateDeBruijnGraph(List<String> kMersWithiutMultipleValues) {
        HashMap<String, List<String>> deBruijnGraph = new HashMap<String, List<String>>();



        return deBruijnGraph;
    }

    public List<String> removeMultipleValues(List<String> allKMers) {
        StringReconstruction stringReconstruction = new StringReconstruction("", 5);
        List<String> listWithoutMultipleValues = new ArrayList<String>(allKMers);
        for (String s : allKMers) {
            if (existsInListMultipleTimes(s, listWithoutMultipleValues)) {
                listWithoutMultipleValues.remove(s);
            }
        }

        return stringReconstruction.sortLexicographic(listWithoutMultipleValues);
    }

    public boolean existsInListMultipleTimes(String stringToCount, List<String> allKMers) {
        int count = 0;

        for (String s : allKMers) {
            if (s.equals(stringToCount)) {
                count++;
            }
        }

        if (count > 1) {
            return true;
        }

        return false;
    }
}


//Erstellen sie ein Use-Case Diagramm zur Schule

//Erstellen sie ein Klassendiagramm mit Unterklassen zum Thema Auto

//Unterscheiden sie zwischen Komposition und Aggregation und machen sie dies an einem Beispiel deutlich.