/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import week1.FrequentWords;

/**
 *
 * @author Patrick
 */
public class GeneratingTheoreticalSpectrum {
    FrequentWords frequentWords = new FrequentWords("a", 3, 2, true);
    PeptideMassHashMap peptideMassHashMap = new PeptideMassHashMap();
    HashMap<String, Integer> peptideMass = peptideMassHashMap.getPeptideMassHashMap();
    
    public List<Integer> getCyclospectrum(String peptide) {
        List<Integer> cyclospectrumList = new ArrayList();
        int peptideLength = peptide.length();

        cyclospectrumList.add(0);

        for (int i = 0; i < peptideLength; i++) {
            List<String> stringPeptides = getMass(i, peptide);
            for (String s : stringPeptides) {
                int mass = calculateMass(s);
                cyclospectrumList.add(mass);
            }
        }
        
        Integer[] masses = cyclospectrumList.toArray(new Integer[cyclospectrumList.size()]);
        Arrays.sort(masses);
        cyclospectrumList.clear();
        
        cyclospectrumList = Arrays.asList(masses);

        return cyclospectrumList;
    }

    public List<String> getMass(int stringLength, String peptide) {
        List<String> peptideMassList = new ArrayList();
        for (int i = 0; i < peptide.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if ((stringLength + 1) == peptide.length()) {
                stringBuilder.append(peptide);
                if (!frequentWords.alreadyExistsInList(peptideMassList, stringBuilder.toString())) {
                    peptideMassList.add(stringBuilder.toString());
                }  
            } else {
                if ((i + stringLength + 1) > peptide.length()) {
                    int rest = i + stringLength + 1 - peptide.length();
                    int available = peptide.length() - i;
                    stringBuilder.append(peptide.substring(i, i + available));
                    stringBuilder.append(peptide.substring(0, rest));
                    peptideMassList.add(stringBuilder.toString());
                } else {
                    stringBuilder.append(peptide.substring(i, i + stringLength + 1));
                    peptideMassList.add(stringBuilder.toString());
                }
            }

        }
        return peptideMassList;
    }
    
    public int calculateMass(String peptide) {
        int mass = 0;
        int peptideLength = peptide.length();
        
        for (int i = 0; i < peptideLength; i++) {
            String singleLetter = peptide.substring(i, i + 1);
            mass = mass + peptideMass.get(singleLetter);
        }
        
        return mass;
    }
}
