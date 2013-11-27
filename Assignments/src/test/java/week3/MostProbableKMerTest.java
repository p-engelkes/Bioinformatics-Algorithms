/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week3;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class MostProbableKMerTest extends TestCase {
    String matrix = "0.2 0.4 0.3 0.1\n" +
"     0.2 0.3 0.3 0.2\n" +
"     0.3 0.1 0.5 0.1\n" +
"     0.2 0.5 0.2 0.1\n" +
"     0.3 0.1 0.4 0.2";
    String text = "ACCTGTTTATTGCCTAAGTTCCGAACAAACCCAATATAGCCCGAGGGCCT";
    int k = 5;
    MostProbableKMer mostProbableKMer = new MostProbableKMer(text, k, matrix);
    
    public MostProbableKMerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
//    public void testCalculateMostProbableKMer() {
//        String expected = "CCGAG";
//        List<List<Object>> test = mostProbableKMer.calculateMostProbableKMer();
//        assertEquals(expected, (String)test.get(0).get(1));
//    }
//
//    public void testMatrixCalculation() {
//        assertEquals(20, mostProbableKMer.firstStringSplit(matrix).size());
//    }
//    
//    public void testLetterSplit() {
//        mostProbableKMer.letterSplit();
//        List<Double> expectedA = new ArrayList<Double>();
//        expectedA.add(0.2);
//        expectedA.add(0.2);
//        expectedA.add(0.3);
//        expectedA.add(0.2);
//        expectedA.add(0.3);
//        
//        assertEquals(expectedA, mostProbableKMer.A);        
//    }
//    
//    public void testGetAllKMers() {
//        assertEquals(46, mostProbableKMer.getAllKMers().size());
//    }
    
    public void testGreedySplitter() {
        List<String> motifList = new ArrayList<String>();
        motifList.add("0010");
        motifList.add("0010");
        motifList.add("0100");
        mostProbableKMer.greedyLetterSplit(motifList);
        assertEquals(3, mostProbableKMer.A.size());
        assertEquals(3, mostProbableKMer.C.size());
        assertEquals(3, mostProbableKMer.G.size());
        assertEquals(3, mostProbableKMer.T.size());           
    }
    
    public void testFirstStringSplit() {
        String input = "0.0 1.0 0.0 0.0/n1.0 0.0 0.0 0.0/n0.3333333333333333 0.0 0.6666666666666666 0.0/n";
        List<String> expected = new ArrayList<String>();
        expected.add("0.0 1.0 0.0 0.0");
        expected.add("1.0 0.0 0.0 0.0");
        expected.add("0.3333333333333333 0.0 0.6666666666666666 0.0");
        
        assertEquals(expected, mostProbableKMer.firstStringSplit(input));
        
    }
    
}
