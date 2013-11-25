/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Patrick
 */
public class CyclopeptideSequencing {

    String sequence;
    int n;
    List<List<Integer>> leaderboard = new ArrayList();
    List<Integer> alphabet = new ArrayList();
    List<List<Integer>> integerPeptideList = new ArrayList();

    public CyclopeptideSequencing(String sequence, int n, List<Integer> alphabet) {
        this.sequence = sequence;
        this.n = n;
        this.alphabet = alphabet;
        this.integerPeptideList = createStringPeptides(this.sequence);
    }

    public String getCyclopeptideSequencing() {
        String cyclopeptideSequence = "";
        List<List<Integer>> leaderboard = new ArrayList();

        return cyclopeptideSequence;
    }

    public void branch() {
        //List<Integer> listToBranch = copyIntegerList(this.integerPeptideList);
        //this.integerPeptideList.clear();
        int peptideListSize = this.integerPeptideList.size();

        for (int i = 0; i < peptideListSize; i++) {
            List<Integer> peptide = this.integerPeptideList.get(i);
            this.integerPeptideList.remove(i);
            boolean first = true;
            for (Integer k : this.alphabet) {
                if (first) {
                    peptide.add(k);
                    this.integerPeptideList.add(peptide);    
                } else {
                    peptide.remove(peptide.size() - 1);
                    peptide.add(k);
                    this.integerPeptideList.add(peptide);
                }
            }
        }
    }

    public List<List<Integer>> createStringPeptides(String sequence) {
        List<List<Integer>> peptideList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(sequence);

        while (stringTokenizer.hasMoreElements()) {
            List<Integer> addList = new ArrayList();
            String mass = (String) stringTokenizer.nextElement();
            addList.add(Integer.valueOf(mass));
            peptideList.add(addList);
        }

        return peptideList;
    }

    public List<Integer> copyIntegerList(List<Integer> listToCopy) {
        List<Integer> copiedList = new ArrayList();

        for (Integer i : listToCopy) {
            copiedList.add(i);
        }

        return copiedList;
    }
}
