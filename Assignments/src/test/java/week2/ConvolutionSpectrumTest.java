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
public class ConvolutionSpectrumTest extends TestCase {
    String sequence = "0 137 186 323";
    ConvolutionSpectrum convolutionSpectrum = new ConvolutionSpectrum(sequence);
    
    public ConvolutionSpectrumTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testStringToList() {
        List<Integer> expected = new ArrayList();
        List<Integer> testList;
        
        expected.add(0);
        expected.add(137);
        expected.add(186);
        expected.add(323);
        
        testList = convolutionSpectrum.stringToList(sequence);
        
        assertEquals(expected, testList);
    }
    
}
