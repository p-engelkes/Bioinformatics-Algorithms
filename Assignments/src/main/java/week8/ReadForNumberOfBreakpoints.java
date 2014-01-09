package week8;

import java.io.*;

/**
 * Date: 07.01.14
 * Time: 08:38
 */
public class ReadForNumberOfBreakpoints {

    private String pathToFile;

    public ReadForNumberOfBreakpoints(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public int[] getArrayForNumberOfBreakpoints() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(pathToFile);
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        String[] splitted = new String[10000];
        while ((strLine = br.readLine()) != null) {
            splitted = strLine.split(" ");
        }
        in.close();
        int count = 0;
        for (int i = 0; i < splitted.length; i++) {
            count++;
        }
        int[] splittedInt = new int[count];
        for (int i = 0; i < count; i++) {
            splittedInt[i] = Integer.valueOf(splitted[i]);
        }


        return splittedInt;
    }
}
