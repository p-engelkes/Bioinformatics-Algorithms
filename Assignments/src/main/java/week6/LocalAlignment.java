package week6;

import java.util.HashMap;

/**
 * Date: 30.12.13
 * Time: 11:29
 */
public class LocalAlignment {
    private HashMap<String, Integer> blosum62;
    private String one;
    private String two;
    private int penalty;

    public LocalAlignment(HashMap<String, Integer> blosum62, String one, String two, int penalty) {
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
            scoringMatrix[i][0] = 0;
        }

        for (int i = 1; i <= two.length(); i++) {
            scoringMatrix[0][i] = 0;
        }

        int maxi = 0;
        int k = 0;
        int l = 0;
        for (int i = 1; i < one.length() + 1; i++) {
            for (int j = 1; j < two.length() + 1; j++) {
                int hori = scoringMatrix[i][j-1] + penalty;
                int verti = scoringMatrix[i-1][j] + penalty;
                int dia = scoringMatrix[i-1][j-1] + diagonal[i-1][j-1];
                scoringMatrix[i][j] = max(hori, verti, dia);
                if (scoringMatrix[i][j] > maxi) {
                    maxi = scoringMatrix[i][j];
                    k = i;
                    l = j;
                }
            }
        }

        System.out.println(maxi);

//        for (int[] row : scoringMatrix) {
//            for (int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        StringBuilder oneRight = new StringBuilder();
        StringBuilder twoRight = new StringBuilder();

        while (k != 0 || l != 0) {
            int hori = 0;
            int verti = 0;
            int dia = 0;
            if (l == 0) {
                hori = -1000;
            } else {
                hori = scoringMatrix[k][l-1] + penalty;
            }

            if (k == 0) {
                verti = -1000;
            } else {
                verti = scoringMatrix[k-1][l] + penalty;
            }

            if (k == 0 || l == 0) {
                dia = 0;
            } else {
                dia = scoringMatrix[k-1][l-1] + diagonal[k-1][l-1];
            }


            if (scoringMatrix[k][l] == dia) {
                oneRight.append(one.charAt(k - 1));
                twoRight.append(two.charAt(l - 1));
                k--;
                l--;
            } else if (scoringMatrix[k][l] == verti) {
                oneRight.append(one.charAt(k - 1));
                twoRight.append("-");
                k--;
            } else if (scoringMatrix[k][l] == hori) {
                oneRight.append("-");
                twoRight.append(two.charAt(l - 1));
                l--;
            } else if (scoringMatrix[k][l] == 0) {
                k = 0;
                l = 0;
            }
        }
        System.out.println(oneRight.reverse());
        System.out.println(twoRight.reverse());
    }

    public int max(int hori, int verti, int dia) {
        if (hori >= verti && hori >= dia && hori >= 0) {
            return hori;
        } else if (verti >= hori && verti >= dia && verti >= 0) {
            return verti;
        } else if (dia >= hori && dia >= verti && dia >= 0) {
            return dia;
        } else {
            return 0;
        }
    }
}
