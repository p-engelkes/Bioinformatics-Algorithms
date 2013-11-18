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
public class ApproximatePatternMatchingTest extends TestCase {
    
    String genome = "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT";
    String sequence = "ATTCTGGA";
    int dismatches = 3;
    ApproximatePatternMatching approximatePatternMatching;
    
    public ApproximatePatternMatchingTest(String testName) {
        super(testName);
        approximatePatternMatching = new ApproximatePatternMatching(genome, sequence, dismatches);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetApproximatePatternPositions() {
        List<Integer> expected = new ArrayList();
        expected.add(6);
        expected.add(7);
        expected.add(26);
        expected.add(27);
        
        assertEquals(expected, approximatePatternMatching.getApproximatePatternPositions());
    }
    
    public void testCompareApproximate() {
        String textToCompare = "ABCDEF";
        String sequenceOne = "ACCDEF";
        String sequenceTwo = "AAAAAA";
        
        assertTrue(approximatePatternMatching.compareApproximate(textToCompare, sequenceOne, dismatches));
        assertTrue(!approximatePatternMatching.compareApproximate(textToCompare, sequenceTwo, dismatches));
    }
    
}
