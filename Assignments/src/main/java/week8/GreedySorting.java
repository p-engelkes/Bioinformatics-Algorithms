package week8;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Date: 06.01.14
 * Time: 13:59
 */
public class GreedySorting {

    String permutation;
    int[] permutArray;
    List<Integer> permutList = new ArrayList<Integer>();

    public GreedySorting(String permutation) {
        this.permutation = permutation;
        StringTokenizer stringTokenizer = new StringTokenizer(this.permutation, " ");
        int i = 0;

        while (stringTokenizer.hasMoreElements()) {
            permutList.add(Integer.valueOf((String) stringTokenizer.nextElement()));
        }

        permutArray = new int[permutList.size()];
        for (int j : permutList) {
            permutArray[i] = j;
            i++;
        }
    }

    public void sortGreedy() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("C:\\Users\\pengelkes\\Desktop\\Patrick\\GreedySorting.txt", "UTF-8");
        boolean sorted = false;
        while (!sorted) {
            boolean sort = true;
            for (int i = 1; i <= permutArray.length; i++) {
                int permut = permutArray[i - 1];
                boolean positive = true;
                if (permut < 0) {
                    positive = false;
                }
                if (permut != i) {
                    if (-permut == i) {
                        permutArray[i - 1] = -permutArray[i - 1];
                        writer.print("(");
                        for (int p : permutArray) {
                            if (p < 0) {
                                writer.print(p + " ");
                            } else {
                                writer.print("+" + p + " ");

                            }
                        }
                        writer.print(")");
                        writer.println();
                        sort = false;
                        break;
                    } else {
                        if (positive) {
                            int rightPosition = findRightPositionOf(i);
                            int[] help = new int[rightPosition - i + 2];
                            int count = 0;
                            for (int j = i - 1; j <= rightPosition; j++) {
                                help[count] = -permutArray[j];
                                count++;
                            }
                            for (int k = 0; k < help.length / 2; k++) {
                                int temp = help[k];
                                help[k] = help[help.length - 1 - k];
                                help[help.length - 1 - k] = temp;
                            }
                            count = 0;
                            for (int j = i - 1; j <= rightPosition; j++) {
                                permutArray[j] = help[count];
                                count++;
                            }
                            writer.print("(");
                            for (int p : permutArray) {
                                if (p < 0) {
                                    writer.print(p + " ");
                                } else {
                                    writer.print("+" + p + " ");

                                }
                            }
                            writer.print(")");
                            writer.println();
                            sort = false;
                            break;
                        } else {
                            int rightPosition = findRightPositionOf(i);
                            int[] help = new int[rightPosition - i + 2];
                            int count = 0;
                            for (int j = i - 1; j <= rightPosition; j++) {
                                help[count] = -permutArray[j];
                                count++;
                            }
                            for (int k = 0; k < help.length / 2; k++) {
                                int temp = help[k];
                                help[k] = help[help.length - 1 - k];
                                help[help.length - 1 - k] = temp;
                            }
                            count = 0;
                            for (int j = i - 1; j <= rightPosition; j++) {
                                permutArray[j] = help[count];
                                count++;
                            }
                            writer.print("(");
                            for (int p : permutArray) {
                                if (p < 0) {
                                    writer.print(p + " ");
                                } else {
                                    writer.print("+" + p + " ");

                                }
                            }
                            writer.print(")");
                            writer.println();
                            sort = false;
                            break;
                        }
                    }
                }

            }
            if (sort) {
                sorted = true;
                writer.close();
            }
        }

    }

    public void swap(int one, int two) {
        int help;
        help = permutArray[one];
        permutArray[one] = permutArray[two];
        permutArray[two] = help;
    }

    public int findRightPositionOf(int i) {

        for (int j = i; j < this.permutArray.length; j++) {
            if (permutArray[j] == i || -permutArray[j] == i) {
                return j;
            }
        }

        return 0;
    }
}
