/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class MedianStringTest extends TestCase {

    String dna = "AAATTGACGCAT GACGACCACGTT CGTCAGCGCCTG GCTGAGCACCGG AGTACGGGACAG";
    int k = 3;
    MedianString medianString = new MedianString(dna, k);

    public MedianStringTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testCalculateMedianString() {
        String expected = "GAC";
        String calculated = (String) medianString.calculateMedianString().get(0).get(1);
        
        assertEquals(expected, calculated);
    }

    public void testCalculateTotalHammingDistance() {
        String pattern = "GAC";
        assertEquals(2, medianString.calculateTotalHammingDistance(pattern));
    }

    public void testCalculateHammingDistance() {
        String pattern = "GAC";
        String textOne = "AAATTGACGCAT";
        String textTwo = "GACGACCACGTT";
        String textThree = "CGTCAGCGCCTG";
        String textFour = "GCTGAGCACCGG";
        String textFive = "AGTACGGGACAG";
        
        assertEquals(0, medianString.calculateHammingDistance(pattern, textOne));
        assertEquals(0, medianString.calculateHammingDistance(pattern, textTwo));
        assertEquals(1, medianString.calculateHammingDistance(pattern, textThree));
        assertEquals(1, medianString.calculateHammingDistance(pattern, textFour));
        assertEquals(0, medianString.calculateHammingDistance(pattern, textFive));
    }

    public void testCalculateDistance() {
        String pattern = "AAAA";
        String stringToCompare = "ABCD";
        String stringTwoToCompare = "BCDE";

        assertEquals(0, medianString.calculateDistance(pattern, pattern));
        assertEquals(3, medianString.calculateDistance(pattern, stringToCompare));
        assertEquals(4, medianString.calculateDistance(pattern, stringTwoToCompare));
    }

    public void testCalculateAllKMers() {
        assertEquals(64, medianString.calculateAllKMers().size());
    }

    public void testGetDnaAsList() {
    }

}
