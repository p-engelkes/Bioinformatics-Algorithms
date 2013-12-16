package week6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Asus on 09.12.13.
 */
public class ReadManhattanTourist {

    String pathToFile;

    public ReadManhattanTourist(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public ManhattanTourist construchtManhattanTourist() throws IOException {
        ManhattanTourist manhattenTourist;
        BufferedReader br = new BufferedReader((new FileReader(pathToFile)));

        int n;
        int m;

        String line = br.readLine();
        n = Integer.valueOf(line);
        line = br.readLine();
        m = Integer.valueOf(line);
        line = br.readLine();

        int[][] down = new int[n][m + 1];
        int[][] right = new int[n + 1][m];

        int downCounter = 0;
        int rightCounter = 0;
        boolean fillDown = true;

        while (line != null) {

            if (line.equals("-") && line != null) {
                fillDown = false;
                line = br.readLine();
            }

            if (fillDown) {
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                int downCounter2 = 0;
                while (stringTokenizer.hasMoreElements()) {
                    down[downCounter][downCounter2] = Integer.valueOf((String) stringTokenizer.nextElement());
                    downCounter2++;
                }

                downCounter++;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                int downCounter2 = 0;
                while (stringTokenizer.hasMoreElements()) {
                    right[rightCounter][downCounter2] = Integer.valueOf((String) stringTokenizer.nextElement());
                    downCounter2++;
                }
                rightCounter++;
            }
            line = br.readLine();

        }

        manhattenTourist = new ManhattanTourist(n, m, down, right);
        return manhattenTourist;
    }

}
