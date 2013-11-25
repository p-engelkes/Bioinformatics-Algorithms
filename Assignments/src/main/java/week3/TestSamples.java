package Week3;

import java.util.List;

/**
 * Date: 25.11.13
 * Time: 10:36
 */
public class TestSamples {

    public static void main(String[] args) {
        String dna = "TACACACATGTTATAGAGAGTTGTC GGTTTCTGTTCCGGTAGTTGCTGTA ATATAGTGAGCTGATTATTCGAACC CTCTAACAAGGTTAACTGTAAGAAT TATTAGCGGCTTCAATTTTAGCGCT CATTAGCCCTGTATAATGCTTCCAC";
        int k = 5;
        int d = 2;
        MotifEnumeration motifEnumeration = new MotifEnumeration(dna, k, d);
        List<String> resultList = motifEnumeration.calculateMotifEnumeration();

        for (String s : resultList) {
            System.out.print(s + " ");
        }
    }
}
