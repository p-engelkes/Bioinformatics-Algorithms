/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class TestSamples {
    public static void main(String[] args) {
        String genome = "CTTGCCGGCGCCGATTATACGATCGCGGCCGCTTGCCTTCTTTATAATGCATCGGCGCCGCGATCTTGCTATATACGTACGCTTCGCTTGCATCTTGCGCGCATTACGTACTTATCGATTACTTATCTTCGATGCCGGCCGGCATATGCCGCTTTAGCATCGATCGATCGTACTTTACGCGTATAGCCGCTTCGCTTGCCGTACGCGATGCTAGCATATGCTAGCGCTAATTACTTAT";
        int k = 9;
        int dismatches = 3;
        boolean reversePattern = true;
        
        FrequentWords frequentWords = new FrequentWords(genome, k, dismatches, reversePattern);
        ReverseComplement reverseComplement;
        List<String> frequentWordsList = new ArrayList();
        
        frequentWordsList = frequentWords.getFrequentWords();
        for (String s : frequentWordsList) {
            reverseComplement = new ReverseComplement(s);
            System.out.print(s + " " + reverseComplement.getReverseComplement() + " ");
        }
        
        
    }
}
