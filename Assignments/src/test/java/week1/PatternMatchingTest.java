/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week1;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class PatternMatchingTest extends TestCase {
    String genome = "GATATATGCATATACTT";
    String pattern = "ATAT";
    PatternMatching patternMatching;
    
    public PatternMatchingTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        patternMatching = new PatternMatching(genome, pattern);
    }

    public void testGetPatternInGenome() {
        List<Integer> expected = new ArrayList();
        expected.add(1);
        expected.add(3);
        expected.add(9);
        
        assertEquals(expected, patternMatching.getPositionsOfPatternInGenome());
    }
    
}
