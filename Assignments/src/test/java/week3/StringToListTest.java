package week3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import week3.StringToList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class StringToListTest extends TestCase {
    
    private String dna = "GGCGTTCAGGCA\n" +
"     AAGAATCAGTCA\n" +
"     CAAGGAGTTCGC\n" +
"     CACGTCAATCAC\n" +
"     CAATAATATTCG";
    private StringToList stringToList;
    
    public StringToListTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        stringToList = new StringToList(dna);
    }

    public void testCompute() {
        String expectedOne = "GGCGTTCAGGCA";
        String expectedFive = "CAATAATATTCG";
        List<String> dnaList = stringToList.compute();
        
        assertEquals(5, dnaList.size());
        assertEquals(expectedOne, dnaList.get(0));
        assertEquals(expectedFive, dnaList.get(4));
    }
    
}
