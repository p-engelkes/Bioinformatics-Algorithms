package week2;

import java.util.*;

/**
 * Date: 19.11.13
 * Time: 10:01
 */
public class CyclopeptideSequencing  {
    PeptideMassHashMap peptideMassHashMap = new PeptideMassHashMap();
    int n;
    HashMap<String, Integer> peptideMass = peptideMassHashMap.getPeptideMassHashMap();
    List<String> stringPeptideList = new ArrayList();
    GeneratingTheoreticalSpectrum gTS = new GeneratingTheoreticalSpectrum();

    String sequence;
    List<Integer> spectrumList = new ArrayList();

    public CyclopeptideSequencing(String sequence, int n) {
        this.sequence = sequence;
        this.n = n;
        StringTokenizer stringTokenizer = new StringTokenizer(sequence);
        while (stringTokenizer.hasMoreTokens()) {
            spectrumList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    public List<String> getCyclopeptideSequence() {
        List<String> peptideToMass = new ArrayList();
        List<String> peptideSequenceList = new ArrayList();
        getSpectrum();
        while (!stringPeptideList.isEmpty()) {
            peptideSequenceList.clear();
            peptideSequenceList = copyStringList(stringPeptideList);
            branch();
            bound();
            stringPeptideList.clear();
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
                           String pairString = (String)pairs.getKey();
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
                stringToExpand.append((String)(pairs.getKey()));
                stringPeptideList.add(stringToExpand.toString());
            }
        }
    }

    public void bound() {
        List<String> listToBound = copyStringList(stringPeptideList);
        stringPeptideList.clear();
        for (String s : listToBound) {
            List<Integer> theoreticalSpectrumList = gTS.getLinearCyclospectrum(s);
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

    public List<Integer> createLeaderboard() {
        List<Integer> leaderboardList = new ArrayList();
        for (String s: stringPeptideList) {
            int score = 0;
            List<Integer> spectrumList = gTS.getLinearCyclospectrum(s);
            for (Integer integer : spectrumList) {
                if (existsInList(integer, spectrumList)) {
                    score++;
                }
            }
            leaderboardList.add(score);
        }
        Integer[] array = leaderboardList.toArray(new Integer[leaderboardList.size()]);
        Arrays.sort(array);

        leaderboardList.clear();
        leaderboardList = Arrays.asList(array);

        int lastValue = leaderboardList.get(n);
        int i = n + 1;
        while (leaderboardList.get(i).equals(lastValue)) {
            i++;
        }
        leaderboardList.subList(0, i);

        return leaderboardList;

    }


}
