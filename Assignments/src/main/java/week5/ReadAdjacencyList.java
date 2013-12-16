package week5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Asus on 09.12.13.
 */
public class ReadAdjacencyList {

    String pathToFile;

    public ReadAdjacencyList(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public HashMap<String, String> constructAdjacencyList() throws IOException {
        HashMap<String, String> adjacencyList = new HashMap<String, String>();

        BufferedReader br = new BufferedReader((new FileReader(pathToFile)));
        String line = br.readLine();
        while (line != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " -> ");
            String s1 = (String) stringTokenizer.nextElement();
            String s2 = (String) stringTokenizer.nextElement();
            adjacencyList.put(s1, s2);
            line = br.readLine();
        }

        return adjacencyList;
    }

}
