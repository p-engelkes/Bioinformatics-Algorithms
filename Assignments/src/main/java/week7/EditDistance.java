package week7;

/**
 * Date: 30.12.13
 * Time: 09:35
 */
public class EditDistance {

    private String one;
    private String two;
    private int penalty;

    public EditDistance(String one, String two, int penalty) {
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
                if (one.charAt(i) == two.charAt(j)) {
                    diagonal[i][j] = 0;
                } else {
                    diagonal[i][j] = 1;
                }
            }
        }

//        for (int[] row : diagonal) {
//            for (int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 0; i < one.length() + 1; i++) {
            for (int j = 0; j < two.length(); j++) {
                horizontal[i][j] = -penalty;
            }
        }

//        for (int[] row : horizontal) {
//            for (int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length() + 1; j++) {
                vertical[i][j] = -penalty;
            }
        }

//        for (int[] row : vertical) {
//            for (int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        scoringMatrix[0][0] = 0;

        for (int i = 1; i <= one.length(); i++) {
            scoringMatrix[i][0] = -penalty * i;
        }

        for (int i = 1; i <= two.length(); i++) {
            scoringMatrix[0][i] = -penalty * i;
        }

//        for (int[] row : scoringMatrix) {
//            for (int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 1; i < one.length() + 1; i++) {
            for (int j = 1; j < two.length() + 1; j++) {
                int hori = scoringMatrix[i][j - 1] - penalty;
                int verti = scoringMatrix[i - 1][j] - penalty;
                int dia = scoringMatrix[i - 1][j - 1] + diagonal[i - 1][j - 1];
                scoringMatrix[i][j] = min(hori, verti, dia);
            }
        }

        int i = one.length();
        int j = two.length();

//        for (int[] row : scoringMatrix) {
//            for (int n : row) {
//                System.out.print(n + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        System.out.println(scoringMatrix[i][j]);


//        StringBuilder oneRight = new StringBuilder();
//        StringBuilder twoRight = new StringBuilder();
//
//        while (i != 0 || j != 0) {
//            int hori = 0;
//            int verti = 0;
//            int dia = 0;
//            if (j == 0) {
//                hori = -1000;
//            } else {
//                hori = scoringMatrix[i][j-1] + penalty;
//            }
//
//            if (i == 0) {
//                verti = -1000;
//            } else {
//                verti = scoringMatrix[i-1][j] + penalty;
//            }
//
//            if (i == 0 || j == 0) {
//                dia = 0;
//            } else {
//                dia = scoringMatrix[i-1][j-1] + diagonal[i-1][j-1];
//            }
//
//
//            if (scoringMatrix[i][j] == dia) {
//                oneRight.append(one.charAt(i - 1));
//                twoRight.append(two.charAt(j - 1));
//                i--;
//                j--;
//            } else if (scoringMatrix[i][j] == verti) {
//                oneRight.append(one.charAt(i - 1));
//                twoRight.append("-");
//                i--;
//            } else if (scoringMatrix[i][j] == hori) {
//                oneRight.append("-");
//                twoRight.append(two.charAt(j - 1));
//                j--;
//            }
//        }
//        System.out.println(oneRight.reverse());
//        System.out.println(twoRight.reverse());
    }

    public int min(int hori, int verti, int dia) {
        if (hori <= verti && hori <= dia) {
            return hori;
        } else if (verti <= hori && verti <= dia) {
            return verti;
        } else {
            return dia;
        }
    }
}
