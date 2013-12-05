package week4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 05.12.13.
 */
public class StringReconstructionTest extends junit.framework.TestCase {
    String sequence = "CAATCCAAC";
    int k = 5;
    StringReconstruction stringReconstruction;

    @Before
    public void setUp() throws Exception {
        stringReconstruction = new StringReconstruction(sequence, k);
    }

    @Test
    public void testReconstructString() throws Exception {

    }

    @Test
    public void testGetAllKMers() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("CAATC");
        expected.add("AATCC");
        expected.add("ATCCA");
        expected.add("TCCAA");
        expected.add("CCAAC");
        List<String> calculated = stringReconstruction.getAllKMers(this.sequence);

        assertEquals(expected, calculated);
    }

    @Test
    public void testSortLexicographic() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("AATCC");
        expected.add("ATCCA");
        expected.add("CAATC");
        expected.add("CCAAC");
        expected.add("TCCAA");
        List<String> calculated = stringReconstruction.sortLexicographic(stringReconstruction.getAllKMers(this.sequence));

        assertEquals(expected, calculated);
    }
}
