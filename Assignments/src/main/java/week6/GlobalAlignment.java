package week6;

import java.util.HashMap;

/**
 * Date: 30.12.13
 * Time: 09:35
 */
public class GlobalAlignment {

    private HashMap<String, Integer> blosum62;
    private String one;
    private String two;
    private int penalty;

    public GlobalAlignment(HashMap<String, Integer> blosum62, String one, String two, int penalty) {
        this.blosum62 = blosum62;
        this.one = one;
        this.two = two;
        this.penalty = penalty;
    }

    public void createGlobalAlignment() {
        int horizontal[][] = new int[one.length() + 1][two.length()];
        int vertical[][] = new int[one.length()][two.length() + 1];
        int diagonal[][] = new int[one.length()][two.length()];
        int scoringMatrix[][] = new int[one.length() + 1][two.length() + 1];

        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length(); j++) {
                String findScore = String.valueOf(one.charAt(i)) + String.valueOf(two.charAt(j));
                diagonal[i][j] = blosum62.get(findScore);
            }
        }

        for (int i = 0; i < one.length() + 1; i++) {
            for (int j = 0; j < two.length(); j++) {
                horizontal[i][j] = -5;
            }
        }

        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length() + 1; j++) {
                vertical[i][j] = -5;
            }
        }

        scoringMatrix[0][0] = 0;

        for (int i = 1; i <= one.length(); i++) {
            scoringMatrix[i][0] = -5 * i;
        }

        for (int i = 1; i <= two.length(); i++) {
            scoringMatrix[0][i] = -5 * i;
        }

        for (int i = 1; i < one.length() + 1; i++) {
            for (int j = 1; j < two.length() + 1; j++) {
                int hori = scoringMatrix[i][j-1] + penalty;
                int verti = scoringMatrix[i-1][j] + penalty;
                int dia = scoringMatrix[i-1][j-1] + diagonal[i-1][j-1];
                scoringMatrix[i][j] = max(hori, verti, dia);
            }
        }
        int i = one.length();
        int j = two.length();
        System.out.println(scoringMatrix[i][j]);


        StringBuilder oneRight = new StringBuilder();
        StringBuilder twoRight = new StringBuilder();

        while (i != 0 || j != 0) {
            int hori = 0;
            int verti = 0;
            int dia = 0;
            if (j == 0) {
                hori = -1000;
            } else {
                hori = scoringMatrix[i][j-1] + penalty;
            }

            if (i == 0) {
                verti = -1000;
            } else {
                verti = scoringMatrix[i-1][j] + penalty;
            }

            if (i == 0 || j == 0) {
                dia = 0;
            } else {
                dia = scoringMatrix[i-1][j-1] + diagonal[i-1][j-1];
            }


            if (scoringMatrix[i][j] == dia) {
                oneRight.append(one.charAt(i - 1));
                twoRight.append(two.charAt(j - 1));
                i--;
                j--;
            } else if (scoringMatrix[i][j] == verti) {
                oneRight.append(one.charAt(i - 1));
                twoRight.append("-");
                i--;
            } else if (scoringMatrix[i][j] == hori) {
                oneRight.append("-");
                twoRight.append(two.charAt(j - 1));
                j--;
            }
        }
        System.out.println(oneRight.reverse());
        System.out.println(twoRight.reverse());
    }

    public int max(int hori, int verti, int dia) {
        if (hori >= verti && hori >= dia) {
            return hori;
        } else if (verti >= hori && verti >= dia) {
            return verti;
        } else {
            return dia;
        }
    }
}
