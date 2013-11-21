/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Patrick
 */
public class ConvolutionSpectrum {

    String sequence;
    List<Integer> sequenceList;

    public ConvolutionSpectrum(String sequence) {
        this.sequence = sequence;
        sequenceList = stringToList(this.sequence);

    }

    public List<Integer> getConvolutionSpectrum() {
        List<Integer> convolutionSpectrum;
        List<List<Integer>> leaderboard;
        List<List<Integer>> sortedLeaderboard;
        int sequenceListSize = this.sequenceList.size();
        int[][] convolution = new int[sequenceListSize][sequenceListSize];

        convolution = calculateConvolution(this.sequenceList);
        leaderboard = countConvolution(convolution);
        sortedLeaderboard = sort(leaderboard);
        
        convolutionSpectrum = calculateConvolutionSpectrum(sortedLeaderboard);
        
        return convolutionSpectrum;
    }
    
    public List<Integer> calculateConvolutionSpectrum(List<List<Integer>> sortedLeaderboard) {
        List<Integer> convolutionSpectrum = new ArrayList();
        
        for (List<Integer> list : sortedLeaderboard) {
            int count = list.get(1);
            for (int i = 0; i < count; i++) {
                convolutionSpectrum.add(list.get(0));
            }
        }
        
        return convolutionSpectrum;
    } 
    
    public List<List<Integer>> sort(List<List<Integer>> listToSort) {
        int listSize = listToSort.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < listSize - 1; i++) {
                int one = listToSort.get(i).get(1);
                int two = listToSort.get(i + 1).get(1);
                if (one < two) {
                    Collections.swap(listToSort, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped == true);

        return listToSort;
    }

    public List<List<Integer>> countConvolution(int[][] convolution) {
        List<List<Integer>> leaderboard = new ArrayList();
        for (int[] row : convolution) {
            for (Integer i : row) {
                List<Integer> leaderboardHelpList = new ArrayList();
                if (!existsInList(i, leaderboard) && i > 0) {
                    leaderboardHelpList.add(i);
                    leaderboardHelpList.add(count(i, convolution));
                }
                if (!leaderboardHelpList.isEmpty()) {
                    leaderboard.add(leaderboardHelpList);
                }
                

            }
        }

        return leaderboard;
    }

    public int count(int intToCount, int[][] convolution) {
        int count = 0;
        for (int[] row : convolution) {
            for (Integer i : row) {
                if (i.equals(intToCount)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean existsInList(int intToFind, List<List<Integer>> listToCheck) {
        for (List<Integer> list : listToCheck) {
            int intToCompare = list.get(0);
            if (intToCompare == intToFind) {
                return true;
            }
        }

        return false;
    }

    public int[][] calculateConvolution(List<Integer> listToCalculate) {
        int listSize = listToCalculate.size();
        int[][] convolution = new int[listSize][listSize];

        for (int i = 0; i < listSize; i++) {
            int subtractFrom = listToCalculate.get(i);
            for (int k = 0; k < listSize; k++) {
                int subtract = listToCalculate.get(k);
                int mass = subtractFrom - subtract;
                convolution[i][k] = mass;
            }
        }

        return convolution;
    }

    public List<Integer> stringToList(String sequence) {
        List<Integer> list = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(sequence);

        while (stringTokenizer.hasMoreElements()) {
            String mass = (String) stringTokenizer.nextElement();
            list.add(Integer.valueOf(mass));
        }

        return list;
    }

}
