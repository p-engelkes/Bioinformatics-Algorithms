package week4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Asus on 09.12.13.
 */
public class EulerianCycleTest {
    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
    EulerianCycle eulerianCycle;

    @Before
    public void setUp() throws Exception {
        List<Integer> zero = new ArrayList<Integer>();
        List<Integer> one = new ArrayList<Integer>();
        List<Integer> two = new ArrayList<Integer>();
        List<Integer> three = new ArrayList<Integer>();
        List<Integer> four = new ArrayList<Integer>();
        List<Integer> five = new ArrayList<Integer>();
        List<Integer> six = new ArrayList<Integer>();
        List<Integer> seven = new ArrayList<Integer>();
        List<Integer> eight = new ArrayList<Integer>();
        List<Integer> nine = new ArrayList<Integer>();

        zero.add(3);
        one.add(0);
        two.add(1);
        two.add(6);
        three.add(2);
        four.add(2);
        five.add(4);
        six.add(5);
        six.add(8);
        seven.add(9);
        eight.add(7);
        nine.add(6);

        adjacencyList.put(0, zero);
        adjacencyList.put(1, one);
        adjacencyList.put(2, two);
        adjacencyList.put(3, three);
        adjacencyList.put(4, four);
        adjacencyList.put(5, five);
        adjacencyList.put(6, six);
        adjacencyList.put(7, seven);
        adjacencyList.put(8, eight);
        adjacencyList.put(9, nine);

        eulerianCycle = new EulerianCycle(adjacencyList);
    }

    @Test
    public void testGetKnotList() throws Exception {
        List<Integer> expected = new ArrayList<Integer>();

        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);

        assertEquals(expected, eulerianCycle.getKnotList());
    }

    @Test
    public void testGetLengthOfCycle() throws Exception {
        int expected = 12;

        assertEquals(expected, eulerianCycle.getLengthOfCycle());
    }

    @Test
    public void testHasUnexploredEdges() throws Exception {
        List<Integer> unexploredEdgesTwo = this.adjacencyList.get(2);
        unexploredEdgesTwo.remove(0);
        unexploredEdgesTwo.remove(0);

        this.adjacencyList.remove(2);
        this.adjacencyList.put(2, unexploredEdgesTwo);

        assertTrue(!this.eulerianCycle.nodeHasUnexploredEdges(2));
        assertTrue(this.eulerianCycle.nodeHasUnexploredEdges(1));
    }

    @Test
    public void testGetEulerianCycle() throws Exception {
        for (Integer i : this.eulerianCycle.getEulerianCycle()) {
            System.out.print(i + " -> ");
        }
    }

    @Test
    public void findNodeWithUnexploredEdges() {
        List<Integer> cycle = new ArrayList<Integer>();

        cycle.add(0);
        cycle.add(3);

        List<Integer> unexploredEdges = this.adjacencyList.get(0);
        unexploredEdges.remove(0);
        this.adjacencyList.remove(0);
        this.adjacencyList.put(0, unexploredEdges);

        assertEquals(3, this.eulerianCycle.findKnotWithUnexploredEdges(cycle));
    }

    @Test
    public void testFindLastOccurance() {
        List<Integer> cycle = new ArrayList<Integer>();
        int node = 2;

        cycle.add(0);
        cycle.add(3);
        cycle.add(2);
        cycle.add(1);
        cycle.add(0);

        assertEquals(5, this.eulerianCycle.findLastOccurenceOfNode(cycle, node));
    }

    @Test
    public void testTraverseOldCycle() {
        List<Integer> cycle = new ArrayList<Integer>();

        cycle.add(0);
        cycle.add(3);
        cycle.add(2);
        cycle.add(1);
        cycle.add(0);

        List<Integer> newCycle = new ArrayList<Integer>();
        newCycle.add(2);
        newCycle.add(1);
        newCycle.add(0);
        newCycle.add(3);
        newCycle.add(2);

        assertEquals(newCycle, this.eulerianCycle.traverseOldCycle(cycle, 2));
    }

}
