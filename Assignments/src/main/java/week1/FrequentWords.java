/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class FrequentWords {

    String sampleText;
    int k;
    int dismatches;
    boolean reversePattern;
    ApproximatePatternMatching approximatePatternMatching;
    ReverseComplement reverseComplement;

    public FrequentWords(String sampleText, int k, int dismatches, boolean reversePattern) {
        this.sampleText = sampleText;
        this.k = k;
        this.dismatches = dismatches;
        this.reversePattern = reversePattern;
    }

    /**
     *
     * @return most frequent words in a given sequence
     */
    public List<String> getFrequentWords() {
        List<String> frequentWordList = new ArrayList();
        List<List<Object>> sequenceList = getAllSequences();
        int highestCount = getHighestCount(sequenceList);
        //write the most frequent words into a list
        frequentWordList = getMostFrequentWords(sequenceList, highestCount);

        return frequentWordList;
    }

    /**
     *
     * @param limit the number of occurances of a given string
     * @return all strings which occur as often as the limit says in the given
     * sequence
     */
    public List<String> getFrequentWordsWithLimit(int limit) {
        List<String> frequentWordList = new ArrayList();
        List<List<Object>> sequenceList = getAllSequences();
        int highestCount = getHighestCount(sequenceList);
        frequentWordList = getMostFrequentWords(sequenceList, highestCount);

        return frequentWordList;
    }

    /**
     *
     * @param sequenceList which contains all the counts and sequences. The
     * first object in the list must be the count of the sequence and the second
     * the sequence itself
     * @param highestCount the highest count which occured in the sequence list
     * @return a list with the most frequent words
     */
    public List<String> getMostFrequentWords(List<List<Object>> sequenceList, int highestCount) {
        List<String> frequentWordList = new ArrayList();
        for (int i = 0; i < sequenceList.size(); i++) {
            List<Object> countAndSequenceList = sequenceList.get(i);
            //only get the most frequent words from the list
            if ((Integer) countAndSequenceList.get(0) == highestCount) {
                String sequence = (String) countAndSequenceList.get(1);
                //check if sequence is already in list
                if (!alreadyExistsInList(frequentWordList, sequence)) {
                    frequentWordList.add(sequence);
                }
            }
        }

        return frequentWordList;
    }

    /**
     *
     * @return a list of objects with all counts of sequences. In the List the
     * first object is the count of the sequence and the second object is the
     * sequence itself
     */
    public List<List<Object>> getAllSequences() {
        List<List<Object>> sequenceList = new ArrayList();
        List<Integer> countList = new ArrayList();
        List<String> stringList = new ArrayList();
        int lengthOfSampleText = sampleText.length();
        //get the count of a given sequence and the sequence itself in a list
        //the count is the first element of the list and the sequence the second
        for (int i = 0; i < lengthOfSampleText - k; i++) {
            String sequence = getSequence(i);
            List<Object> objectList = getCountOfSequences(sequence);
            sequenceList.add(objectList);
            countList.add((Integer) objectList.get(0));
            stringList.add((String) objectList.get(1));

        }
        for (Integer i : countList) {
            System.out.print(i + "    ");
        }
        return sequenceList;
    }

    /**
     *
     * @param iteration the number where to start the substring
     * @return sequence to find in the ssampleText
     */
    public String getSequence(int iteration) {
        String sequence;
        sequence = sampleText.substring(iteration, iteration + k);
        return sequence;
    }

    /**
     *
     * @param sequence the sequence to find in the sample list
     * @return a list which includes the count of the sequence and the sequence
     * itself In the list the count is the first item and the sequence the secon
     */
    public List<Object> getCountOfSequences(String sequence) {
        List<Object> countAndSequenceList = new ArrayList();
        int countOfSequence = getCount(sequence);
        countAndSequenceList.add(countOfSequence);
        countAndSequenceList.add(sequence);

        return countAndSequenceList;
    }

    /**
     * Calculate the number of times a given sequence occurs in the sampleText
     *
     * @param sequence the sequence to get the count in the sampleText
     * @return the number of times the sequence occurs in the sampleText
     */
    public int getCount(String sequence) {
        reverseComplement = new ReverseComplement(sequence);
        String reverseSequence = reverseComplement.getReverseComplement();
        int count = 0;
        if (containsString(sampleText, reverseSequence)) {
            count = 0;
        } else {
            for (int i = 0; i < sampleText.length() - k; i++) {
                approximatePatternMatching = new ApproximatePatternMatching(sampleText, sequence, dismatches);
                String textToCompare = sampleText.substring(i, i + k);
                if (approximatePatternMatching.compareApproximate(textToCompare, sequence, dismatches)) {
                    count++;
                }

                if (reversePattern) {

                    if (textToCompare.equals(reverseSequence)) {
                        count++;
                        //contains = true;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Evaluate the highest count among all sequences
     *
     * @param sequenceList the sequence list in which you want to find the
     * highest count
     * @return the highest count in the given list
     */
    public int getHighestCount(List<List<Object>> sequenceList) {
        int highestCount = 0;
        for (int i = 0; i < sequenceList.size(); i++) {
            List<Object> countAndSequenceList = sequenceList.get(i);
            int count = (Integer) countAndSequenceList.get(0);
            if (count > highestCount) {
                highestCount = count;
            }
            //System.out.println(count);
        }
        return highestCount;
    }

    /**
     * Check if a sequence already exists in a list
     *
     * @param frequentWordsList the list to search
     * @param sequence the sequence to find in the list
     * @return true if the sequence exists in the list, false if the sequence
     * doesnt
     */
    public boolean alreadyExistsInList(List<String> frequentWordsList, String sequence) {
        for (int i = 0; i < frequentWordsList.size(); i++) {
            if (frequentWordsList.get(i).equals(sequence)) {
                return true;
            }
        }
        return false;
    }

    public void setDismatches(int dismatches) {
        this.dismatches = dismatches;
    }

    public void setReversePattern(boolean reversePattern) {
        this.reversePattern = reversePattern;
    }

    public boolean containsString(String genome, String sequence) {
        int genomeLength = genome.length();
        int sequenceLength = sequence.length();

        for (int i = 0; i < genomeLength - sequenceLength + 1; i++) {
            String textToCompare = genome.substring(i, i + sequenceLength);
            if (textToCompare.equals(sequence)) {
                return true;
            }
        }
        return false;
    }
}
