package Week3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Date: 25.11.13
 * Time: 09:26
 */
public class MotifEnumeration {

    String dna;
    int k;
    int d;
    List<String> dnaList;

    public MotifEnumeration(String dna, int k, int d) {
        this.dna = dna;
        this.k = k;
        this.d = d;
        this.dnaList = getDnaAsList(dna);
    }

    public List<String> calculateMotifEnumeration() {
        List<String> kMers;
        List<String> resultList = new ArrayList<String>();
        kMers = getAllKMers();
        for (String s : kMers) {
            List<String> mismatchList = createMismatches(s);
            for (String string : mismatchList) {
                List<String> allMismatches = createMismatches(string);
                for (String mismatch : allMismatches) {
                    if (appearsInAllStrings(mismatch) && !existsInList(resultList, mismatch)) {
                        resultList.add(mismatch);
                    }
                }

            }
        }

        return resultList;
    }

    public List<String> createMismatches(String s) {
        List<String> mismatchList = new ArrayList();
        List<String> helpList;
        int stringLength = s.length();

        for (int i = 0; i < stringLength; i++) {
            Character ch = s.charAt(i);
            helpList = changeChar(s, i, ch);
            for (String string : helpList) {
                if (!existsInList(mismatchList, string)) {
                    mismatchList.add(string);
                }
            }
        }

        mismatchList.add(s);

        return mismatchList;
    }

    public List<String> changeChar(String string, int position, Character ch) {
        List<String> mismatches = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder(string);
        switch (ch) {
            case 'T':
                stringBuilder.setCharAt(position, 'A');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'C');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'G');
                mismatches.add(stringBuilder.toString());
                break;
            case 'A':
                stringBuilder.setCharAt(position, 'T');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'C');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'G');
                mismatches.add(stringBuilder.toString());
                break;
            case 'C':
                stringBuilder.setCharAt(position, 'A');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'T');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'G');
                mismatches.add(stringBuilder.toString());
                break;
            case 'G':
                stringBuilder.setCharAt(position, 'A');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'C');
                mismatches.add(stringBuilder.toString());
                stringBuilder.setCharAt(position, 'T');
                mismatches.add(stringBuilder.toString());
                break;
        }
        return mismatches;
    }

    public List<String> getDnaAsList(String dna) {
        List<String> resultList = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(dna);
        while (stringTokenizer.hasMoreElements()) {
            resultList.add((String) stringTokenizer.nextElement());
        }

        return resultList;
    }

    public List<String> getAllKMers() {
        List<String> resultList = new ArrayList<String>();
//
//        for (String s : this.dnaList) {
//            int stringLength = s.length();
//            for (int i = 0; i < stringLength - k + 1; i++) {
//                resultList.add(s.substring(i, i + k));
//            }
//        }
//
//        return resultList;
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : this.dnaList) {
            stringBuilder.append(s);
        }
        String wholeString = stringBuilder.toString();
        int length = wholeString.length();
        for (int i = 0; i < length - k + 1; i++) {
            resultList.add(wholeString.substring(i, i + k));
        }

        return resultList;
    }

    public boolean appearsInAllStrings(String s) {
        for (String string : this.dnaList) {
            if (!isInString(string, s)) {
                return false;
            }
        }

        return true;
    }

    public boolean isInString(String string, String s) {
        int stringLength = string.length();
        int lowestCount = d;

        for (int i = 0; i < stringLength - this.k + 1; i++) {
            String compare = string.substring(i, i + this.k);
            int count = 0;
            for (int j = 0; j < this.k; j++) {
                if (compare.charAt(j) != s.charAt(j)) {
                    count++;
                }
            }
            if (count <= lowestCount) {
                return true;
            }
        }

        return false;
    }

    public boolean existsInList(List<String> listToCompare, String stringToFind) {
        for (String s : listToCompare) {
            if (s.equals(stringToFind)) {
                return true;
            }
        }

        return false;
    }
}
