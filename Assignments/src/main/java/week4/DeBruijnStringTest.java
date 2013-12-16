package week4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 06.12.13.
 */
public class DeBruijnStringTest {
    private String sequence = "AAGATTCTCTAC";
    private int k = 4;
    private DeBruijnString deBruijnString = new DeBruijnString(sequence, k);

    @Test
    public void testGetDeBruijnGraph() throws Exception {
        LinkedHashMap<String, List<String>> expected = new LinkedHashMap<String, List<String>>();
        List<String> one = new ArrayList<String>();
        List<String> two = new ArrayList<String>();
        List<String> three = new ArrayList<String>();
        List<String> four = new ArrayList<String>();
        List<String> five = new ArrayList<String>();
        List<String> six = new ArrayList<String>();
        List<String> seven = new ArrayList<String>();
        List<String> eight = new ArrayList<String>();
        List<String> nine = new ArrayList<String>();

        one.add("AGA");
        two.add("GAT");
        three.add("TTC");
        four.add("TAC");
        five.add("TCT");
        six.add("ATT");
        seven.add("CTA");
        seven.add("CTC");
        eight.add("TCT");

        expected.put("AAG", one);
        expected.put("AGA", two);
        expected.put("ATT", three);
        expected.put("CTA", four);
        expected.put("CTC", five);
        expected.put("GAT", six);
        expected.put("TAC", nine);
        expected.put("TCT", seven);
        expected.put("TTC", eight);

        assertEquals(expected, deBruijnString.getDeBruijnString());
    }

    @Test
    public void testCalculateDeBruijnGraph() throws Exception {
        List<String> calculate = new ArrayList<String>();
        calculate.add("AAG");
        calculate.add("AGA");
        calculate.add("ATT");
        calculate.add("CTA");
        calculate.add("CTC");
        calculate.add("GAT");
        calculate.add("TCT");
        calculate.add("TTC");

        List<String> allKMers = new ArrayList<String>();
        allKMers.add("AAG");
        allKMers.add("AGA");
        allKMers.add("ATT");
        allKMers.add("CTA");
        allKMers.add("CTC");
        allKMers.add("GAT");
        allKMers.add("TAC");
        allKMers.add("TCT");
        allKMers.add("TTC");

        LinkedHashMap<String, List<String>> expected = new LinkedHashMap<String, List<String>>();
        List<String> one = new ArrayList<String>();
        List<String> two = new ArrayList<String>();
        List<String> three = new ArrayList<String>();
        List<String> four = new ArrayList<String>();
        List<String> five = new ArrayList<String>();
        List<String> six = new ArrayList<String>();
        List<String> seven = new ArrayList<String>();
        List<String> eight = new ArrayList<String>();

        one.add("AGA");
        two.add("GAT");
        three.add("TTC");
        four.add("TAC");
        five.add("TCT");
        six.add("ATT");
        seven.add("CTA");
        seven.add("CTC");
        eight.add("TCT");

        expected.put("AAG", one);
        expected.put("AGA", two);
        expected.put("ATT", three);
        expected.put("CTA", four);
        expected.put("CTC", five);
        expected.put("GAT", six);
        expected.put("TCT", seven);
        expected.put("TTC", eight);

        assertEquals(expected, deBruijnString.calculateDeBruijnGraph(calculate, allKMers));
    }

    @Test
    public void testRemoveMultipleValues() throws Exception {
        List<String> calculate = new ArrayList<String>();
        calculate.add("AGT");
        calculate.add("AGA");
        calculate.add("AGT");
        calculate.add("AGA");
        calculate.add("AGC");

        List<String> expected = new ArrayList<String>();
        expected.add("AGT");
        expected.add("AGA");
        expected.add("AGC");

        assertEquals(expected, deBruijnString.removeMultipleValues(calculate));
    }

    @Test
    public void testExistsInListMultipleTimes() throws Exception {
        List<String> calculate = new ArrayList<String>();
        calculate.add("AGT");
        calculate.add("AGA");
        calculate.add("AGT");
        calculate.add("AGA");
        calculate.add("AGC");

        assertTrue(deBruijnString.existsMultipleTimesInList("AGT", calculate));
        assertTrue(deBruijnString.existsMultipleTimesInList("AGA", calculate));
        assertTrue(!deBruijnString.existsMultipleTimesInList("AGC", calculate));
    }

    @Test
    public void testExistsInHashMap() throws Exception {
        HashMap<String, Integer> calculate = new HashMap<String, Integer>();
        calculate.put("ASD", 2);
        calculate.put("ADA", 2);
        calculate.put("AGF", 2);
        calculate.put("ASD", 2);

        assertTrue(deBruijnString.existsInHashMap("ASD", calculate));
        assertTrue(deBruijnString.existsInHashMap("ADA", calculate));
        assertTrue(!deBruijnString.existsInHashMap("CCC", calculate));
    }
}
