package week9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 10.01.14.
 */
public class ReadPatternsForTrieConstruction {

    String pathToFile;

    public ReadPatternsForTrieConstruction(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<String> readPatterns() throws FileNotFoundException {
        List<String> patterns = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(this.pathToFile));
        try {
            String line = br.readLine();
            while (line != null) {
                patterns.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return patterns;
    }
}
