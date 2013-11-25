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
public class MotifEnumerationTest extends TestCase {

    String dna = "ATTTGGC TGCCTTA CGGTATC GAAAATT";
    int k = 3;
    int d = 1;
    MotifEnumeration motifEnumeration = new MotifEnumeration(dna, k, d);

    public MotifEnumerationTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testCalculateMotifEnumeration() {
    }

    public void testCreateMismatches() {
    }

    public void testChangeChar() {
    }

    public void testGetDnaAsList() {
        List<String> expected = new ArrayList();
        expected.add("ATTTGGC");
        expected.add("TGCCTTA");
        expected.add("CGGTATC");
        expected.add("GAAAATT");

        assertEquals(expected, motifEnumeration.getDnaAsList(dna));
    }

    public void testGetAllKMers() {
    }

    public void testAppearsInAllStrings() {
        assertTrue(motifEnumeration.appearsInAllStrings("ATA"));
        assertTrue(!motifEnumeration.appearsInAllStrings("AAA"));
    }

    public void testIsInString() {
        assertTrue(motifEnumeration.isInString("ATTTGGC", "ATA"));
        assertTrue(!motifEnumeration.isInString("ATTTGGC", "AAA"));
    }

    public void testExistsInList() {
    }

}
