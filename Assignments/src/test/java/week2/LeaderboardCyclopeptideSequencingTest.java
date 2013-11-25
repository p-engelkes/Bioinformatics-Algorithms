///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package week2;
//
//import java.util.ArrayList;
//import java.util.List;
//import junit.framework.TestCase;
//
///**
// *
// * @author Patrick
// */
//public class LeaderboardCyclopeptideSequencing extends TestCase {
//    String sequence = "";
//    int n = 2;
//    LeaderboardCyclopeptideSequencing leaderboardCyclopeptideSequencing = new LeaderboardCyclopeptideSequencing(sequence);
//    
//    public LeaderboardCyclopeptideSequencing(String testName) {
//        super(testName);
//    }
//    
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//    }
//
//    public void testGetCyclopeptideSequence() {
//    }
//
//    public void testBranch() {
//        cyclopeptideSequencing.stringPeptideList.add("");
//        
//        List<String> expectedList = new ArrayList();
//        expectedList.add("D");
//        expectedList.add("E");
//        expectedList.add("F");
//        expectedList.add("G");
//        expectedList.add("A");
//        expectedList.add("C");
//        expectedList.add("M");
//        expectedList.add("N");
//        expectedList.add("H");
//        expectedList.add("I");
//        expectedList.add("K");
//        expectedList.add("T");
//        expectedList.add("W");
//        expectedList.add("V");
//        expectedList.add("P");
//        expectedList.add("S");
//        expectedList.add("R");
//        expectedList.add("Y");
//        
//        cyclopeptideSequencing.branch();
//        assertEquals(expectedList, cyclopeptideSequencing.stringPeptideList);  
//    }
//    
//    public void testCountInList() {
//        List<Integer> testList = new ArrayList();
//        testList.add(1);
//        testList.add(2);
//        testList.add(1);
//        testList.add(4);
//        testList.add(1);
//        testList.add(5);
//        testList.add(6);
//        testList.add(7);
//        testList.add(1);
//        
//        int expected = 4;
//        
//        assertEquals(expected, cyclopeptideSequencing.countInList(1, testList));
//    }
//    
//    public void testExistsInList() {
//        List<Integer> testList = new ArrayList();
//        testList.add(1);
//        testList.add(2);
//        testList.add(3);
//        testList.add(4);
//        testList.add(5);
//        testList.add(6);
//        testList.add(7);
//        
//        assertTrue(cyclopeptideSequencing.existsInList(1, testList));
//        assertTrue(!cyclopeptideSequencing.existsInList(8, testList));
//    }
//    
//    public void testScore() {
//        int countOne = 3;
//        int countTwo = 5;
//        int countSpectrum = 4;
//        
//        assertEquals(4, cyclopeptideSequencing.score(countTwo, countSpectrum));
//        assertEquals(3, cyclopeptideSequencing.score(countOne, countSpectrum));
//    }
//    
//    public void testListToSwap() {
//        List<List<Object>> testList = new ArrayList();
//        List<Object> listOne = new ArrayList();
//        List<Object> listTwo = new ArrayList();
//        List<Object> listThree = new ArrayList();
//        listOne.add(2);
//        listOne.add("B");
//        listTwo.add(1);
//        listTwo.add("A");
//        listThree.add(3);
//        listThree.add("C");
//        testList.add(listOne);
//        testList.add(listTwo);
//        testList.add(listThree);
//        
//        List<List<Object>> expectedList = new ArrayList();
//        expectedList.add(listThree);
//        expectedList.add(listOne);
//        expectedList.add(listTwo);
//
//        assertEquals(expectedList, cyclopeptideSequencing.sortList(testList));
//    }
//    
//    public void testCutLeaderboard() {
//        List<List<Object>> testList = new ArrayList();
//        List<List<Object>> expectedList = new ArrayList();
//        List<Object> listOne = new ArrayList();
//        List<Object> listTwo = new ArrayList();
//        List<Object> listThree = new ArrayList();
//        List<Object> listFour = new ArrayList();
//        listOne.add(0);
//        listOne.add("A");
//        listTwo.add(0);
//        listTwo.add("B");
//        listThree.add(2);
//        listThree.add("C");
//        listFour.add(3);
//        listFour.add("D");
//        testList.add(listOne);
//        testList.add(listTwo);
//        testList.add(listThree);
//        testList.add(listFour);
//        
//        expectedList = cyclopeptideSequencing.cutLeaderboard(testList);
//        assertEquals(2, expectedList.size());
//    }
//}
