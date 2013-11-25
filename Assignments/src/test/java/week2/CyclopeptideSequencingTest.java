/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week2;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class CyclopeptideSequencingTest extends TestCase {
    String sequence = "";
    int n = 1;
    List<Integer> alphabet = new ArrayList();
    
    CyclopeptideSequencing cyclopeptideSequencing = new CyclopeptideSequencing(sequence, n, alphabet);
    
    public CyclopeptideSequencingTest(String testName) {
        super(testName);
        this.alphabet.add(1);
        this.alphabet.add(2);
        this.alphabet.add(3);
        this.alphabet.add(4);
        this.alphabet.add(5);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetCyclopeptideSequencing() {
    }

    public void testBranch() {
        cyclopeptideSequencing.branch();
        List<List<Integer>> expected = new ArrayList();
        List<Integer> listOne = new ArrayList();
        List<Integer> listTwo = new ArrayList();
        List<Integer> listThree = new ArrayList();
        List<Integer> listFour = new ArrayList();
        List<Integer> listFive = new ArrayList();
        
        listOne.add(1);
        listTwo.add(2);
        listThree.add(3);
        listFour.add(4);
        listFive.add(5);
        
        expected.add(listOne);
        expected.add(listTwo);
        expected.add(listThree);
        expected.add(listFour);
        expected.add(listFive);
        
        assertEquals(expected, cyclopeptideSequencing.integerPeptideList);
    }

    public void testCreateStringPeptides() {
    }

    public void testCopyIntegerList() {
    }
    
}
