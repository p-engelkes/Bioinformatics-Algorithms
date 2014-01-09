package week6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Date: 30.12.13
 * Time: 09:39
 */
public class Blosum62 {

    String pathToFile;

    public Blosum62(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public HashMap<String, Integer> createBlosum62() throws IOException {
        HashMap<String, Integer> blosum62 = new HashMap<String, Integer>();

        BufferedReader br = new BufferedReader(new FileReader(this.pathToFile));

        String line = br.readLine();
        line = br.readLine();

        while (line != null) {
            String firstChar = line.substring(0, 1);
            String secondChar = "";
            StringTokenizer stringTokenizer = new StringTokenizer(line.substring(2, line.length()), " ");
            int counter = 0;
            Integer score = 0;
            while(stringTokenizer.hasMoreElements()) {
                switch (counter) {
                    case 0 :
                        secondChar = "A";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 1 :
                        secondChar = "C";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 2 :
                        secondChar = "D";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 3 :
                        secondChar = "E";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 4 :
                        secondChar = "F";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 5 :
                        secondChar = "G";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 6 :
                        secondChar = "H";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 7 :
                        secondChar = "I";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 8 :
                        secondChar = "K";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 9 :
                        secondChar = "L";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 10 :
                        secondChar = "M";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 11 :
                        secondChar = "N";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 12 :
                        secondChar = "P";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 13 :
                        secondChar = "Q";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 14 :
                        secondChar = "R";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 15 :
                        secondChar = "S";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 16 :
                        secondChar = "T";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 17 :
                        secondChar = "V";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 18 :
                        secondChar = "W";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                    case 19 :
                        secondChar = "Y";
                        counter++;
                        score = Integer.valueOf((String) stringTokenizer.nextElement());
                        blosum62.put(firstChar + secondChar, score);
                        break;
                }
            }
            line = br.readLine();
        }

        return blosum62;
    }
}
