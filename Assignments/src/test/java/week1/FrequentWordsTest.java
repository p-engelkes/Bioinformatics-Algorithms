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
public class FrequentWordsTest extends TestCase {
    String sampleText = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
    int k = 4;
    int dismatches;
    boolean reversePattern;
    FrequentWords frequentWordsProblem;
    
    public FrequentWordsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        frequentWordsProblem = new FrequentWords(sampleText, k, dismatches, reversePattern);
        frequentWordsProblem.setDismatches(0);
        frequentWordsProblem.setReversePattern(false);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

//    public void testGetFrequentWords() {
//        String sequenceOne = "GCAT";
//        String sequenceTwo = "CATG";
//        List<String> mostFrequentWords = new ArrayList();
//        mostFrequentWords.add(sequenceOne);
//        mostFrequentWords.add(sequenceTwo);
//        
//        assertEquals(mostFrequentWords, frequentWordsProblem.getFrequentWords());
//    }
//
//    public void testGetSequence() {
//        String expected = "GTTG";
//        assertEquals(expected, frequentWordsProblem.getSequence(2));
//    }
//    
//    public void testGetCount() {
//        int expectedCount = 1;
//        assertEquals(expectedCount, frequentWordsProblem.getCount("ACGT"));
//    }
//    
//    public void testGetCountOfSequences() {
//        String sequence = "ACGT";
//        
//        int expectedCount = 1;
//        String expectedString = "ACGT";
//        
//        List<Object> countAndSequenceList = frequentWordsProblem.getCountOfSequences(sequence);
//        
//        int count = (Integer)countAndSequenceList.get(0);
//        String string = (String)countAndSequenceList.get(1);
//        
//        assertEquals(expectedCount, count);
//        assertEquals(expectedString, string);
//    }
//    
//    public void testGetHighestCount() {
//        List<Object> listOne = new ArrayList();
//        List<Object> listTwo = new ArrayList();
//        List<Object> listThree = new ArrayList();
//        
//        listOne.add(0);
//        listTwo.add(2);
//        listThree.add(5);
//        
//        List<List<Object>> sequenceList = new ArrayList();
//        sequenceList.add(listOne);
//        sequenceList.add(listTwo);
//        sequenceList.add(listThree);
//        
//        assertEquals(5, frequentWordsProblem.getHighestCount(sequenceList));
//    }
//    
//    public void testApproximatePattern() {
//        frequentWordsProblem.setDismatches(1);
//        List<String> expectedList = new ArrayList();
//        expectedList.add("ATGT");
//        expectedList.add("GATG");
//        expectedList.add("ATGC");
//        
//        assertEquals(expectedList, frequentWordsProblem.getFrequentWords());   
//    }
    
    public void testReverseComplement() {
        frequentWordsProblem.setReversePattern(true);
        frequentWordsProblem.setDismatches(1);
        List<String> expectedList = new ArrayList();
        expectedList.add("ATGT");
        expectedList.add("ACAT");
        
        assertEquals(expectedList, frequentWordsProblem.getFrequentWords());
    }
    
    
}
