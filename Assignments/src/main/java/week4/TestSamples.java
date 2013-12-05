package week4;

import java.io.IOException;
import java.util.List;

/**
 * Created by Patrick on 05.12.13.
 */
public class TestSamples {

    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\Patrick\\Desktop\\Datasets\\dataset_52_7.txt";

        OverlapGraph overlapGraph = new OverlapGraph(pathToFile);
        List<List<String>> overlap = overlapGraph.getOverlapGraph();

        for (List list : overlap) {
            System.out.print(list.get(0) + " -> " + list.get(1));
            System.out.println();
        }

    }
}
