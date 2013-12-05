package week4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Patrick on 05.12.13.
 */
public class OverlapGraphTest {
    String pathToFile = "C:\\Users\\Patrick\\Desktop\\Datasets\\TestOverlapGraph.txt";
    OverlapGraph overlapGraph;


    @Before
    public void setUp() throws Exception {
        overlapGraph = new OverlapGraph(pathToFile);
    }

    @Test
    public void testGetOverlapGraph() throws Exception {
        List<List<String>> expected = new ArrayList<List<String>>();
        List<String> listOne = new ArrayList<String>();
        List<String> listTwo = new ArrayList<String>();
        List<String> listThree = new ArrayList<String>();
        List<String> listFour = new ArrayList<String>();

        listOne.add("AGGCA");
        listOne.add("GGCAT");

        listTwo.add("CATGC");
        listTwo.add("ATGCG");

        listThree.add("GCATG");
        listThree.add("CATGC");

        listFour.add("GGCAT");
        listFour.add("GCATG");

        expected.add(listOne);
        expected.add(listTwo);
        expected.add(listThree);
        expected.add(listFour);
        List<List<String>> calculated = overlapGraph.getOverlapGraph();

        assertEquals(expected, calculated);

    }

    @Test
    public void testConstructSequence() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("ATGCG");
        expected.add("GCATG");
        expected.add("CATGC");
        expected.add("AGGCA");
        expected.add("GGCAT");
        List<String> calculated = overlapGraph.constructSequence(this.pathToFile);

        assertEquals(expected, calculated);
    }

    @Test
    public void testCalculateK() throws Exception {

    }

    @Test
    public void testConstructOverlapGraph() throws Exception {
        int expected = 5;
        int calculated = overlapGraph.calculateK(this.pathToFile);

        assertEquals(expected, calculated);
    }
}
