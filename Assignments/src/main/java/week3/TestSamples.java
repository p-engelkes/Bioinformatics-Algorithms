package week3;

import java.util.List;

/**
 * Date: 25.11.13
 * Time: 10:36
 */
public class TestSamples {

    public static void main(String[] args) {
        String text = "CTGGAAGCCTCAACCAACTGTGTAGCTAATGCAAGATTGCCCCACCGTCAAACTCGCAGGCGGGCTCGAATCCTAGCGGTGTAGGCAGTGACGCACGATTGCGCCGCACATACGAGTGTACTGTCCCACATTTAGTTAGGGACCGCTTCCTAGGATCACCAGACAATCAATAGGCTCGGGGAATTACCGAGGACGGTAAC";
        String matrix = "0.2 0.28 0.36 0.16\n" +
"0.24 0.24 0.2 0.32\n" +
"0.36 0.24 0.08 0.32\n" +
"0.16 0.08 0.4 0.36\n" +
"0.24 0.16 0.36 0.24\n" +
"0.2 0.32 0.24 0.24\n" +
"0.16 0.28 0.16 0.4\n" +
"0.16 0.4 0.28 0.16";
        int k = 8;
        MostProbableKMer mostProbableKMer = new MostProbableKMer(text, k, matrix);
        System.out.print(mostProbableKMer.calculateMostProbableKMer().get(0).get(1));
        
    }
}
