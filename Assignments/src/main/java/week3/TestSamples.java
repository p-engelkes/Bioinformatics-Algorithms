package week3;

import java.util.List;

/**
 * Date: 25.11.13
 * Time: 10:36
 */
public class TestSamples {

    public static void main(String[] args) {
        String dna = "TGATGATAACGTGACGGGACTCAGCGGCGATGAAGGATGAGT CAGCGACAGACAATTTCAATAATATCCGCGGTAAGCGGCGTA TGCAGAGGTTGGTAACGCCGGCGACTCGGAGAGCTTTTCGCT TTTGTCATGAACTCAGATACCATAGAGCACCGGCGAGACTCA ACTGGGACTTCACATTAGGTTGAACCGCGAGCCAGGTGGGTG TTGCGGACGGGATACTCAATAACTAAGGTAGTTCAGCTGCGA TGGGAGGACACACATTTTCTTACCTCTTCCCAGCGAGATGGC GAAAAAACCTATAAAGTCCACTCTTTGCGGCGGCGAGCCATA CCACGTCCGTTACTCCGTCGCCGTCAGCGATAATGGGATGAG CCAAAGCTGCGAAATAACCATACTCTGCTCAGGAGCCCGATG";
        int k = 6;
        int d = 2;
        MedianString medianString = new week3.MedianString(dna, k);
        List<Object> hammingDistance = medianString.calculateMedianString().get(0); 
        String bestMedian = (String) hammingDistance.get(1);
        int distance = (Integer) hammingDistance.get(0);
        
        System.out.println(distance);
        System.out.print(bestMedian);
    }
}
