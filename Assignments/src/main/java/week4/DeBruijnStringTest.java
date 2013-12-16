package week4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patrick on 06.12.13.
 */
public class DeBruijnStringTest {

    String sequence = "AAGATTCTCTAC";
    int k = 4;
    DeBruijnString deBruijnString = new DeBruijnString(sequence, k);

    @Test
    public void testGetDeBruijnGraph() throws Exception {

    }

    @Test
    public void testRemoveMultipleValues() throws Exception {
        List<String> listToCalculate = new ArrayList<String>();
        listToCalculate.add("AAG");
        listToCalculate.add("ACT");
        listToCalculate.add("ACT");
        listToCalculate.add("AAG");
        listToCalculate.add("AGA");

        List<String> expected = new ArrayList<String>();
        expected.add("AAG");
        expected.add("ACT");
        expected.add("AGA");

        assertEquals(expected, deBruijnString.removeMultipleValues(listToCalculate));
    }

    @Test
    public void testExistsInListMultipleTimes() throws Exception {
        List<String> listToCalculate = new ArrayList<String>();
        listToCalculate.add("AAG");
        listToCalculate.add("ACT");
        listToCalculate.add("ACT");
        listToCalculate.add("AAG");
        listToCalculate.add("AGA");

        assertTrue(deBruijnString.existsInListMultipleTimes("AAG", listToCalculate));
        assertTrue(deBruijnString.existsInListMultipleTimes("ACT", listToCalculate));
        assertTrue(!deBruijnString.existsInListMultipleTimes("AGA", listToCalculate));
    }
}
