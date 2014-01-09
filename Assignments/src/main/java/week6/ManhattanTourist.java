package week6;

/**
 * Date: 12.12.13
 * Time: 16:20
 */
public class ManhattanTourist {

    public int n;
    public int m;

    public int[][] down;
    public int[][] right;

    public ManhattanTourist(int n, int m, int[][] down, int[][] right) {
        this.n = n;
        this.m = m;
        this.down = down;
        this.right = right;
    }

    public int getLongestPath() {
        int[][] score = new int[n+1][m + 1];

        score[0][0] = 0;

        for (int i = 0; i < n; i++) {
            score[i + 1][0] = score[i][0] + down[i][0];
        }

        for (int j = 0; j < m; j++) {
            score[0][j + 1] = score[0][j] + right[0][j];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                score[i][j] = max(score[i - 1][j] + down[i- 1][j], score[i][j - 1] + right[i][j - 1]);
            }
        }

        return score[4][4];
    }

    public int max(int first, int second) {
        if (first >= second) {
            return first;
        }

        return second;
    }

    public int getDownLeghth() {
        int downLength = 0;
        for (int[] row : this.down) {
            downLength = 0;
            for (int i : row) {
                downLength++;
            }
        }
        return downLength;
    }

    public int getRightLength() {
        int downLength = 0;
        for (int[] row : this.right) {
            downLength = 0;
            for (int i : row) {
                downLength++;
            }
        }
        return downLength;
    }
}
