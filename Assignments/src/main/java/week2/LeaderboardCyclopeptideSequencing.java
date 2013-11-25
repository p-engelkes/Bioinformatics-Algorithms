package week2;

import java.util.*;

/**
 * Date: 19.11.13 Time: 10:01
 */

public class LeaderboardCyclopeptideSequencing {

    String spectrum;
    int n;
    int parentMass;
    int globalMass;
    List<String> stringPeptideList = new ArrayList();
    List<Integer> spectrumList = new ArrayList();
    HashMap<String, Integer> peptideMass;
    PeptideMassHashMap peptideHashMap = new PeptideMassHashMap();
    GeneratingTheoreticalSpectrum gTS = new GeneratingTheoreticalSpectrum();
    List<List<Object>> globalLeaderboard = new ArrayList();

    public LeaderboardCyclopeptideSequencing(String spectrum, int n) {
        this.spectrum = spectrum;
        this.n = n;
        this.spectrumList = createIntegerListFromString(this.spectrum);
        this.parentMass = getParentMass(spectrumList);
        this.peptideMass = peptideHashMap.getPeptideMassHashMap();

    }

    public String getCyclopeptideSequence() {
        String cyclopeptideSequence = "";
        List<String> highscore = new ArrayList();
        List<List<Object>> leaderboard = new ArrayList();
        this.stringPeptideList.add("");
        while (!this.stringPeptideList.isEmpty()) {
            highscore = copy(this.stringPeptideList);
            branch();
            leaderboard = createLeaderboard();
            this.stringPeptideList.clear();
            for (List<Object> list : leaderboard) {
                this.stringPeptideList.add((String) list.get(1));
            }
            copyList(leaderboard);
            sortList(this.globalLeaderboard);
            leaderboard.clear();
            if (this.stringPeptideList.isEmpty()) {
                cyclopeptideSequence = (String) this.globalLeaderboard.get(0).get(1);
                cyclopeptideSequence = stringToMasses(cyclopeptideSequence);
            }
        }
        return cyclopeptideSequence;
    }

    public void branch() {
        List<String> listToBranch = copyStringList(this.stringPeptideList);
        this.stringPeptideList.clear();
        int listToBranchSize = listToBranch.size();

        for (String s : listToBranch) {
            Iterator iterator = this.peptideMass.entrySet().iterator();
            while (iterator.hasNext()) {
                StringBuilder stringToExpand = new StringBuilder(s);
                Map.Entry pairs = (Map.Entry) iterator.next();
                stringToExpand.append((String) pairs.getKey());
                this.stringPeptideList.add(stringToExpand.toString());
            }
        }
    }

    public List<List<Object>> createLeaderboard() {
        List<List<Object>> leaderboard = new ArrayList();
        List<List<Object>> leaderboardList;
        int globalScore = calculateGlobalScore();
        calculateGlobalMass();
        for (String s : this.stringPeptideList) {
            List<Object> scoreAndString = new ArrayList();
            List<Integer> sequence = gTS.getCyclingCyclospectrum(s);
            int mass = getParentMass(sequence);
            if (mass <= this.parentMass) {
                int score = calculateScore(s);
                    if (score > globalScore && globalMass != this.parentMass) {
                        scoreAndString.add(score);
                        scoreAndString.add(s);
                        leaderboard.add(scoreAndString);
                    }

            }
        }
        sortList(leaderboard);

        leaderboardList = cutLeaderboard(leaderboard);

        return leaderboardList;
    }
    
    private void calculateGlobalMass() {
        if (!this.globalLeaderboard.isEmpty()) {
            List<Object> globalMassList = this.globalLeaderboard.get(0);
        List<Integer> globalMassIntList = gTS.getCyclingCyclospectrum((String) globalMassList.get(1));
        
        this.globalMass = getParentMass(globalMassIntList);
        } else {
            this.globalMass = 0;
        }
        
    }
    
    private int calculateGlobalScore() {
        int score = 0;
        
        if (!this.globalLeaderboard.isEmpty()) {
            score = (Integer)this.globalLeaderboard.get(0).get(0);
        }
        
        return score;
    }

    private List<String> copyStringList(List<String> listToCopy) {
        List<String> copiedList = new ArrayList();

        for (String s : listToCopy) {
            copiedList.add(s);
        }

        return copiedList;
    }

    private List<Integer> createIntegerListFromString(String stringToList) {
        List<Integer> stringList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(stringToList);
        while (stringTokenizer.hasMoreElements()) {
            String token = (String) stringTokenizer.nextElement();
            stringList.add(Integer.valueOf(token));
        }

        return stringList;
    }

    private int getParentMass(List<Integer> spectrumList) {
        int mass = 0;

        for (Integer i : spectrumList) {
            if (i > mass) {
                mass = i;
            }
        }

        return mass;
    }

    public int calculateScore(String peptide) {
        int score = 0;
        List<Integer> cycling = gTS.getCyclingCyclospectrum(peptide);
        List<Integer> alreadyCounted = new ArrayList();

        for (Integer i : cycling) {
            if (!existsInList(i, alreadyCounted)) {
                int count = countInList(i, cycling);
                int countSpectrum = countInList(i, this.spectrumList);
                score = score + score(count, countSpectrum);
                alreadyCounted.add(i);
            }
        }

        return score;
    }

    public int countInList(int intToCount, List<Integer> listToCountIn) {
        int count = 0;

        for (Integer i : listToCountIn) {
            if (i.equals(intToCount)) {
                count++;
            }
        }
        return count;
    }

    public boolean existsInList(int intToExist, List<Integer> listToCompare) {
        for (Integer i : listToCompare) {
            if (i.equals(intToExist)) {
                return true;
            }
        }

        return false;
    }

    public int score(int count, int countSpectrum) {
        int score = 0;

        if (count > countSpectrum) {
            score = score + countSpectrum;
        } else {
            score = score + count;
        }

        return score;
    }

    public List<List<Object>> sortList(List<List<Object>> listToSort) {
        int listSize = listToSort.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < listSize - 1; i++) {
                int one = (Integer) listToSort.get(i).get(0);
                int two = (Integer) listToSort.get(i + 1).get(0);
                if (one < two) {
                    Collections.swap(listToSort, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped == true);

        return listToSort;
    }

    public List<List<Object>> cutLeaderboard(List<List<Object>> listToCut) {
        int cutOff = this.n;
        int listSize = listToCut.size();
        List<List<Object>> listToReturn;

        if (cutOff < listSize - 1) {
            int lowestScore = (Integer) listToCut.get(cutOff - 1).get(0);
            while (cutOff < listSize && lowestScore == (Integer) listToCut.get(cutOff).get(0)) {
                cutOff++;
            }
        }

        if (listToCut.isEmpty()) {
            listToReturn = listToCut;
        } else {
            if (cutOff >= listSize) {
                listToReturn = listToCut;
            } else {
                listToReturn = listToCut.subList(0, cutOff);
            }

        }

        return listToReturn;
    }

    private List<String> copy(List<String> listToCopy) {
        List<String> copiedList = new ArrayList();

        for (String s : listToCopy) {
            copiedList.add(s);
        }

        return copiedList;
    }

    private String stringToMasses(String peptide) {
        String peptideMasses = "";
        int mass;
        int peptideLength = peptide.length();
        for (int i = 0; i < peptideLength; i++) {
            String s = String.valueOf(peptide.charAt(i));
            mass = this.peptideMass.get(s);
            peptideMasses = peptideMasses + mass + "-";
        }

        return peptideMasses;
    }

    private void copyList(List<List<Object>> listToCopy) {
        for (List<Object> list : listToCopy) {
            this.globalLeaderboard.add(list);
        }

    }

}
