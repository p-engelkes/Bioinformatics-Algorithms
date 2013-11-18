/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week1;

import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class ReverseComplementTest extends TestCase {
    String DNAPattern = "AAAACCCGGT";
    ReverseComplement reverseComplement;
    
    public ReverseComplementTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        reverseComplement = new ReverseComplement(DNAPattern);
    }


    public void testGetReverseComplement() {
    }

    
    public void testGetReverseString() {
        String expected = "TGGCCCAAAA";
        assertEquals(expected, reverseComplement.getReverseString(DNAPattern));
    }

    public void testGetComplementString() {
        String expected = "TTTTGGGCCA";
        assertEquals(expected, reverseComplement.getComplementString(DNAPattern));
    }
    
}
