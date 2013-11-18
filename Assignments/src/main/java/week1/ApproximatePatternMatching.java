/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 We say that position i in k-mers p1 … pk and q1 … qk is a mismatch if pi ≠ qi. For example, CGAAT and CGGAC have two mismatches. Our observation that a DnaA box may appear with slight variations leads to the following generalization of the Pattern Matching Problem:

 Approximate Pattern Matching Problem: Find all approximate occurrences of a pattern in a string.
 Input: Two strings Pattern and Text along with an integer d.
 Output: All positions where Pattern appears in Text with at most d mismatches.

 CODE CHALLENGE: Solve the Approximate Pattern Matching Problem

 Sample Input:
 ATTCTGGA
 CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT
 3

 Sample Output:
 6 7 26 27
 */
package week1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class ApproximatePatternMatching {

    String genome;
    String sequence;
    int dismatches;

    public ApproximatePatternMatching(String genome, String sequence, int dismatches) {
        this.genome = genome;
        this.sequence = sequence;
        this.dismatches = dismatches;
    }
    
    public List<Integer> getApproximatePatternPositions() {
        List<Integer> approximatePatternPositions = new ArrayList();
        int sequenceLength = sequence.length();
        int genomeLength = genome.length();
        
        for (int i = 0; i < genomeLength - sequenceLength + 1; i++) {
            String textToCompare = genome.substring(i, i + sequenceLength);
            if (compareApproximate(textToCompare, sequence, dismatches)) {
                approximatePatternPositions.add(i);
                //System.out.println("position added: " + i);
            }
        }
        
        return approximatePatternPositions;
    } 

    public boolean compareApproximate(String textToCompare, String sequence, int mismatches) {
        //number of mismatches
        int d = 0;

        //compare characters and increase number of mismatches if necessary
        for (int i = 0; i < textToCompare.length(); i++) {
            Character first = textToCompare.charAt(i);
            Character second = sequence.charAt(i);

            if (!first.equals(second)) {
                d++;
            }
        }

        //check if the number of mismatches if smaller or equal to the target
        //mismatches
        if (d <= mismatches) {
            return true;
        } else {
            return false;
        }
    }

}
