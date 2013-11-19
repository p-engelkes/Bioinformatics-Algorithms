package week2;

import java.util.*;

/**
 * Date: 19.11.13 Time: 10:01
 */
public class CyclopeptideSequencing {

    PeptideMassHashMap peptideMassHashMap = new PeptideMassHashMap();
    int n;
    HashMap<String, Integer> peptideMass = peptideMassHashMap.getPeptideMassHashMap();
    List<String> stringPeptideList = new ArrayList();
    GeneratingTheoreticalSpectrum gTS = new GeneratingTheoreticalSpectrum();
    int parentMass;

    String sequence;
    List<Integer> spectrumList = new ArrayList();

    public CyclopeptideSequencing(String sequence, int n) {
        this.sequence = sequence;
        this.n = n;
        StringTokenizer stringTokenizer = new StringTokenizer(sequence);
        while (stringTokenizer.hasMoreTokens()) {
            spectrumList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        this.parentMass = getParentMass();
    }

    public String getCyclopeptideSequence() {
        List<String> peptideToMass = new ArrayList();
        String peptide = "";
        List<String> peptideSequenceList = new ArrayList();
        List<List<Object>> leaderboardList = new ArrayList();
        stringPeptideList.add("");
        while (!stringPeptideList.isEmpty()) {
            peptideSequenceList.clear();
            peptideSequenceList = copyStringList(stringPeptideList);
            branch();
            //bound();
            leaderboardList = createLeaderboard();
            stringPeptideList.clear();
            for (List list : leaderboardList) {
                stringPeptideList.add((String) list.get(1));
            }
            leaderboardList.clear();
            if (stringPeptideList.isEmpty()) {
                peptideToMass = stringPeptideToMass(peptideSequenceList);
                peptide = peptideToMass.get(0);
            }
        }

        return peptide;
    }

    public List<String> getCyclopeptideSequenceWithoutLeaderboard() {
        List<String> peptideToMass = new ArrayList();
        List<String> peptideSequenceList = new ArrayList();
        getSpectrum();
        while (!stringPeptideList.isEmpty()) {
            peptideSequenceList.clear();
            peptideSequenceList = copyStringList(stringPeptideList);
            branch();
            bound();
            if (stringPeptideList.isEmpty()) {
                peptideToMass = stringPeptideToMass(peptideSequenceList);
            }
        }

        return peptideToMass;
    }

    public void getSpectrum() {
        for (Integer i : spectrumList) {
            if (i <= 200) {
                if (peptideMass.containsValue(i)) {
                    Iterator iterator = peptideMass.entrySet().iterator();

                    while (iterator.hasNext()) {
                        Map.Entry pairs = (Map.Entry) iterator.next();
                        if (pairs.getValue().equals(i)) {
                            String pairString = (String) pairs.getKey();
                            if (!exsitsInStringList(pairString, stringPeptideList)) {
                                stringPeptideList.add(pairString);
                            }
                        }
                    }
                }
            }
        }
    }

    public void branch() {
        List<String> listToBranch = copyStringList(stringPeptideList);
        stringPeptideList.clear();
        int listToExpandSize = listToBranch.size();

        for (int i = 0; i < listToExpandSize; i++) {

            Iterator iterator = peptideMass.entrySet().iterator();

            while (iterator.hasNext()) {
                StringBuilder stringToExpand = new StringBuilder(listToBranch.get(i));
                Map.Entry pairs = (Map.Entry) iterator.next();
                stringToExpand.append((String) (pairs.getKey()));
                stringPeptideList.add(stringToExpand.toString());
            }
        }
    }

    public void bound() {
        List<String> listToBound = copyStringList(stringPeptideList);
        stringPeptideList.clear();
        for (String s : listToBound) {
            List<Integer> theoreticalSpectrumList = gTS.getCyclingCyclospectrum(s);
            Integer count = 0;
            for (Integer integer : theoreticalSpectrumList) {
                int theoreticalInt = countNumberInList(integer, theoreticalSpectrumList);
                int practicalInt = countNumberInList(integer, spectrumList);

                if (practicalInt >= theoreticalInt) {
                    count++;
                }
            }
            int stringLength = s.length();
            if (count.equals(sum(stringLength) + 1)) {
                stringPeptideList.add(s);
            }
        }
    }

    public List<String> stringPeptideToMass(List<String> stringPeptideList) {
        List<String> peptideMassList = new ArrayList();

        for (String s : stringPeptideList) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                String peptide = String.valueOf(s.charAt(i));
                if (i + 1 == s.length()) {
                    stringBuilder.append(peptideMass.get(peptide));
                } else {
                    stringBuilder.append(peptideMass.get(peptide));
                    stringBuilder.append("-");
                }
            }
            peptideMassList.add(stringBuilder.toString());
        }

        return peptideMassList;
    }

    private boolean isPartOfList(List<Integer> listToContain, List<Integer> listToCompare) {
        for (Integer i : listToContain) {
            if (!existsInList(i, listToCompare)) {
                return false;
            }
        }
        return true;
    }

    private boolean exsitsInStringList(String stringToContain, List<String> listToCompare) {
        for (String s : listToCompare) {
            if (stringToContain.equals(s)) {
                return true;
            }
        }

        return false;
    }

    private boolean existsInList(int intToContain, List<Integer> listToCompare) {
        for (Integer i : listToCompare) {
            if (intToContain == i) {
                return true;
            }
        }
        return false;
    }

    private List<String> copyStringList(List<String> listToCopy) {
        List<String> copiedList = new ArrayList();

        for (String s : listToCopy) {
            copiedList.add(s);
        }

        return copiedList;
    }

    private int countNumberInList(int i, List<Integer> integerList) {
        int count = 0;
        for (Integer integer : integerList) {
            if (integer.equals(i)) {
                count++;
            }
        }

        return count;
    }

    public int sum(int integer) {
        int sum = 0;
        for (int i = 0; i <= integer; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public List<List<Object>> createLeaderboard() {
        List<List<Object>> leaderboardList = new ArrayList();
        int highestScore = 0;
        for (String s : stringPeptideList) {
            int massOfPeptide = getMass(s);
            if (massOfPeptide <= this.parentMass) {
                List<Object> helpList = new ArrayList();
                int score = calculateScore(s);
                if (score >= highestScore) {
                    helpList.add(score);
                    helpList.add(s);
                    leaderboardList.add(helpList);
                }
            }
        }
        sortList(leaderboardList);
        leaderboardList = cutOffLeaderboardList(leaderboardList);

        return leaderboardList;
    }

    public int getMass(String peptide) {
        int mass = 0;
        int peptideLength = peptide.length();

        for (int i = 0; i < peptideLength; i++) {
            String massString = String.valueOf(peptide.charAt(i));
            mass = mass + peptideMass.get(massString);
        }

        return mass;
    }

    public int calculateScore(String peptide) {
        int score = 0;
        List<Integer> spectrum = gTS.getCyclingCyclospectrum(peptide);

        for (Integer i : spectrum) {
            if (existsInList(i, this.spectrumList)) {
                score++;
            }

        }

        return score;
    }

    public List<List<Object>> cutOffLeaderboardList(List<List<Object>> leaderboardList) {
        int cutOffLimit = n;
        if (leaderboardList.size() > n) {
            int cutOff = (Integer) leaderboardList.get(cutOffLimit).get(0);
            while (cutOffLimit < leaderboardList.size() - 1 && cutOff == (Integer) leaderboardList.get(1 + cutOffLimit).get(0)) {
                cutOffLimit = cutOffLimit + 1;
            }

        }
        int leaderboardListSize = leaderboardList.size();
        List<List<Object>> listToReturn;
        if (cutOffLimit < leaderboardListSize) {
            listToReturn = leaderboardList.subList(0, cutOffLimit);
        } else {
            listToReturn = leaderboardList.subList(0, leaderboardListSize);
        }
        

        return listToReturn;
    }

    public List<List<Object>> sortList(List<List<Object>> listToSort) {
        boolean swapped;
        int sortListSize = listToSort.size();
        do {
            swapped = false;
            for (int i = 0; i < sortListSize - 1; i++) {
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

    public int getParentMass() {
        int mass = 0;

        for (Integer i : spectrumList) {
            if (i > mass) {
                mass = i;
            }
        }

        return mass;
    }
}
