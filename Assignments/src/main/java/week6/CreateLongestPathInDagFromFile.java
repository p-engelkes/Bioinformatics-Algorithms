package week6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 19.12.13
 * Time: 09:39
 */
public class CreateLongestPathInDagFromFile {

    private String pathToFile;

    public CreateLongestPathInDagFromFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public LongestPathInDag getLongestPathInDag() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        LongestPathInDag longestPathInDag;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        try {
            String line = br.readLine();
            int source = Integer.valueOf(line);
            line = br.readLine();
            int sink = Integer.valueOf(line);
            line = br.readLine();

            while (line != null) {
                int index = line.indexOf("->");
                int node = Integer.valueOf(line.substring(0, index));
                int indexTwo = line.indexOf(":");
                int nodeTwo = Integer.valueOf(line.substring(index + 2, indexTwo));
                int weight = Integer.valueOf(line.substring(indexTwo + 1));
                List<Integer> storeList = new ArrayList<Integer>();
                storeList.add(node);
                storeList.add(nodeTwo);
                storeList.add(weight);

                graph.add(storeList);
                line = br.readLine();
            }

            longestPathInDag = new LongestPathInDag(source, sink, graph);
        } finally {
            br.close();
        }
        return longestPathInDag;
    }
}
