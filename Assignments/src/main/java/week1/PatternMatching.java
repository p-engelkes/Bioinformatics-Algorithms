/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Sample Input:
     ATAT
     GATATATGCATATACTT

Sample Output:
     1 3 9
*/


package week1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class PatternMatching {
    String genome;
    String pattern;

    public PatternMatching(String genome, String pattern) {
        this.genome = genome;
        this.pattern = pattern;
    }
    
    /**
     * Finds all positions of a pattern in a given genome
     * @return position of the given pattern in a genome
     */
    public List<Integer> getPositionsOfPatternInGenome() {
        List<Integer> positionList = new ArrayList();
        int genomeLength = genome.length();
        int patternLength = pattern.length();
        
        for (int i = 0; i < genomeLength - patternLength; i++) {
            String genomeToCompare = genome.substring(i, i + patternLength);
            if (genomeToCompare.equals(pattern)) {
                positionList.add(i);
            }
        }
        return positionList;
    }
    
    
    
}
