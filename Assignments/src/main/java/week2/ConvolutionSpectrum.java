/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Patrick
 */
public class ConvolutionSpectrum {

    String sequence;
    List<Integer> sequenceList = new ArrayList();

    public ConvolutionSpectrum(String sequence) {
        this.sequence = sequence;
        StringTokenizer st = new StringTokenizer(sequence);
        while (st.hasMoreElements()) {
            sequenceList.add(Integer.valueOf((String) st.nextElement()));
        }
        Integer[] array = sequenceList.toArray(new Integer[this.sequenceList.size()]);
        Arrays.sort(array);
        this.sequenceList.clear();
        this.sequenceList = Arrays.asList(array);
    }

    public List<List<Integer>> getConvolutionSpectrum() {
        List<List<Integer>> possibleConvolutions = calculateConvolutions();

//        List<Integer> multiplicities = calculateMultiplicities(possibleConvolutions);
//
//        return multiplicities;
        
        return possibleConvolutions;
    }

    public List<List<Integer>> calculateConvolutions() {
        int sequenceSize = this.sequenceList.size();
        List<List<Integer>> possibleConvolutions = new ArrayList();
        for (int i = 1; i < sequenceSize; i++) {
            List<Integer> step = new ArrayList();
            for (int k = 0; k < i; k++) {
                int one = sequenceList.get(i);
                int two = sequenceList.get(k);
                step.add(one - two);
            }
            possibleConvolutions.add(step);
        }

        return possibleConvolutions;
    }

    public List<Integer> calculateMultiplicities(List<List<Integer>> possibleConvolutions) {
        List<Integer> alreadyCounted = new ArrayList();
        List<Integer> multiplicities = new ArrayList();
        for (List<Integer> list : possibleConvolutions) {
            int i = 0;
            boolean counted = false;
            while (counted == false || i == possibleConvolutions.size()) {
                int intToCount = list.get(i);
                if (!existsInList(intToCount, alreadyCounted)) {
                    count(intToCount, possibleConvolutions);
                    counted = true;
                    alreadyCounted.add(intToCount);
                    multiplicities.add(intToCount);
                } else {
                    i++;
                }
            }
        }
        return multiplicities;
    }

    private boolean existsInList(int intToFind, List<Integer> listToCompare) {
        for (Integer i : listToCompare) {
            if (i.equals(intToFind)) {
                return true;
            }
        }

        return false;
    }

    private int count(int intToCount, List<List<Integer>> possibleConvolutions) {
        int count = 0;
        for (List<Integer> list : possibleConvolutions) {
            for (Integer i : list) {
                if (i.equals(intToCount)) {
                    count++;
                }
            }
        }
        return count;
    }
}
