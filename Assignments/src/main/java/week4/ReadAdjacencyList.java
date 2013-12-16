package week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Asus on 09.12.13.
 */
public class ReadAdjacencyList {

    String pathToFile;

    public ReadAdjacencyList(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public HashMap<Integer, List<Integer>> constructAdjacencyList() throws IOException {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
        List<String> sequence = new ArrayList<String>();
        List<Integer> knotList = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader((new FileReader(pathToFile)));
        String line = br.readLine();
        int knot = Integer.valueOf(line.substring(0, 1));
        StringTokenizer stringTokenizer = new StringTokenizer(line.substring(5), ",");
        List<Integer> adjacent = new ArrayList<Integer>();
        while (stringTokenizer.hasMoreElements()) {
            adjacent.add(Integer.valueOf((String) stringTokenizer.nextElement()));
        }
        adjacencyList.put(knot, adjacent);
        while (line != null) {
            line = br.readLine();
            if (line != null) {
                knot = Integer.valueOf(line.substring(0, line.indexOf(" ->")));
                knotList.add(knot);
                stringTokenizer = new StringTokenizer(line.substring(line.indexOf("-> ") + 3), ",");
                adjacent = new ArrayList<Integer>();
                while (stringTokenizer.hasMoreElements()) {
                    adjacent.add(Integer.valueOf((String) stringTokenizer.nextElement()));
                }
                adjacencyList.put(knot, adjacent);
            }
        }

        return adjacencyList;
    }

    public int countSteps(String sequence) {
        int steps = 0;


        return steps;
    }
}
