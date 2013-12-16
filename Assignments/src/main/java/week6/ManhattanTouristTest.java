package week6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Date: 12.12.13
 * Time: 16:52
 */
public class ManhattanTouristTest {
    int n = 4;
    int m = 4;
    int[][] down = new int[4][5];
    int[][] right = new int[5][4];
    ManhattanTourist manhattanTourist;

    @Before
    public void setUp() {
        down[0][0] = 1;
        down[0][1] = 0;
        down[0][2] = 2;
        down[0][3] = 4;
        down[0][4] = 3;

        down[1][0] = 4;
        down[1][1] = 6;
        down[1][2] = 5;
        down[1][3] = 2;
        down[1][4] = 1;

        down[2][0] = 4;
        down[2][1] = 4;
        down[2][2] = 5;
        down[2][3] = 2;
        down[2][4] = 1;

        down[3][0] = 5;
        down[3][1] = 6;
        down[3][2] = 8;
        down[3][3] = 5;
        down[3][4] = 3;

        right[0][0] = 3;
        right[0][1] = 2;
        right[0][2] = 4;
        right[0][3] = 0;

        right[1][0] = 3;
        right[1][1] = 2;
        right[1][2] = 4;
        right[1][3] = 2;

        right[2][0] = 0;
        right[2][1] = 7;
        right[2][2] = 3;
        right[2][3] = 3;

        right[3][0] = 3;
        right[3][1] = 3;
        right[3][2] = 0;
        right[3][3] = 2;

        right[4][0] = 1;
        right[4][1] = 3;
        right[4][2] = 2;
        right[4][3] = 2;

        manhattanTourist = new ManhattanTourist(n, m, down, right);
    }

    @Test
    public void testGetLongestPath() throws Exception {
        assertEquals(34, manhattanTourist.getLongestPath());
    }

    @Test
    public void testMax() throws Exception {
        int first = 0;
        int second = 1;
        int third = 2;

        assertEquals(1, manhattanTourist.max(first, second));
        assertEquals(2, manhattanTourist.max(third, second));
    }
}
