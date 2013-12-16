package week4;

import java.util.*;

/**
 * Created by Patrick on 06.12.13.
 */
public class DeBruijnString {

    private String sequence;
    private int k;

    public DeBruijnString(String sequence, int k) {
        this.sequence = sequence;
        this.k = k;
    }

    public LinkedHashMap<String, List<String>> getDeBruijnString() {
        StringReconstruction stringReconstruction = new StringReconstruction("", k - 1);
        LinkedHashMap<String, List<String>> deBruijnGraph;
        List<String> deBruijn = stringReconstruction.getAllKMers(sequence);
        List<String> allKMers = stringReconstruction.getAllKMers(sequence);
        //stringReconstruction.sortLexicographic(allKMers);
        deBruijn = removeMultipleValues(deBruijn);
        deBruijn.remove(deBruijn.size() - 1);
        //stringReconstruction.sortLexicographic(deBruijn);
        deBruijnGraph = calculateDeBruijnGraph(deBruijn, allKMers);

        return deBruijnGraph;
    }

    public LinkedHashMap<String, List<String>> calculateDeBruijnGraph(List<String> deBruijn, List<String> allKMers) {
        LinkedHashMap<String, List<String>> deBruijnGraph = new LinkedHashMap<String, List<String>>();
        for (String matchString : deBruijn) {
            List<String> matchList = getMatchList(matchString, allKMers);
            for (String s : matchList) {
                List<String> deletedList = new ArrayList<String>();
                for (int i = 0; i < allKMers.size(); i++) {
                    String delete = allKMers.get(i);
                    List<String> deleteMatchList = getMatchList(s, matchList);
                    if (delete.equals(s) && !alreadyExistsInList(s, deletedList) && !alreadyExistsInList(delete, deleteMatchList)) {
                        allKMers.remove(i);
                        deletedList.add(s);
                    }
                }
            }
            deBruijnGraph.put(matchString, matchList);
        }

        return deBruijnGraph;
    }

    public List<String> getMatchList(String matchString, List<String> allKMers) {
        List<String> matchList = new ArrayList<String>();
        String stringToMatch = matchString.substring(1);
        for (String searchString : allKMers) {
            String match = searchString.substring(0, searchString.length() - 1);
            if (stringToMatch.equals(match)) {
                if (!alreadyExistsInList(searchString, matchList)) {
                    matchList.add(searchString);
                }
            }
        }

        return matchList;
    }

    public List<String> removeMultipleValues(List<String> listToRemove) {
        List<String> alreadyCounted = new ArrayList<String>();
        for (String s : listToRemove) {
            if (!alreadyExistsInList(s, alreadyCounted)) {
                alreadyCounted.add(s);
            }
        }
        return alreadyCounted;
    }

    public boolean existsMultipleTimesInList(String stringToFind, List<String> listToSearchIn) {
        int count = 0;

        for (String s : listToSearchIn) {
            if (s.equals(stringToFind)) {
                count++;
            }
        }

        if (count > 1) {
            return true;
        }

        return false;
    }

    public boolean existsInHashMap(String s, HashMap<String, Integer> hashMapToSearch) {
        Iterator iterator = hashMapToSearch.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pairs = (Map.Entry) iterator.next();
            if (s.equals(pairs.getKey())) {
                return true;
            }
        }

        return false;
    }

    public boolean alreadyExistsInList(String s, List<String> listToSearch) {
        for (String string : listToSearch) {
            if (string.equals(s)) {
                return true;
            }
        }

        return false;
    }

    public int count(String s, List<String> listToCount) {
        int count = 0;

        for (String string : listToCount) {
            if (string.equals(s)) {
                count++;
            }
        }

        return count;
    }


}
