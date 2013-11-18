/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author Patrick
 */
public class PeptideEncodingTest extends TestCase {

    String dnaString = "ATGGCCATGGCCCCCAGAACTGAGATCAATAGTACCCGTATTAACGGGTGA";
    String peptide = "MA";
    PeptideEncoding peptideEncoding = new PeptideEncoding();

    public PeptideEncodingTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetPeptides() {
        List<String> expected = new ArrayList<String>();
        expected.add("ATGGCC");
        expected.add("ATGGCC");
        expected.add("GGCCAT");

        assertEquals(expected, peptideEncoding.getPeptides(dnaString, peptide));
    }

    public void testTranscribeDNAString() {
        String expected = "AUGGCCAUGGCCCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";

        assertEquals(expected, peptideEncoding.transcribeDNAString(dnaString));
    }

}
