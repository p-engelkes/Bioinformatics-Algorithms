package week8;

/**
 * Date: 06.01.14
 * Time: 16:12
 */
public class NumberOfBreakpoints {

    int[] permutArray;

    public NumberOfBreakpoints(int[] permutArray) {
        this.permutArray = permutArray;
    }

    public void calculateNumberOfBreakpoints() {
        int counter = 0;
        for (int i = 0; i < permutArray.length - 1; i++) {
            if (permutArray[i] - permutArray[i + 1] != -1) {
                counter++;
            }
        }

        if (permutArray[0] != 1) {
            counter++;
        }

        if (permutArray[permutArray.length - 1] != permutArray.length) {
            counter++;
        }

        System.out.print(counter);
    }
}
