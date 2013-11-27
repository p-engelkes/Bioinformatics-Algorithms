/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Patrick
 */
public class MostProbableKMer {

    String text;
    int k;
    String matrix;
    List<String> matrixList;
    List<Double> A = new ArrayList<Double>();
    List<Double> C = new ArrayList<Double>();
    List<Double> G = new ArrayList<Double>();
    List<Double> T = new ArrayList<Double>();

    public MostProbableKMer(String text, int k, String matrix) {
        this.text = text;
        this.k = k;
        this.matrix = matrix;
        this.matrixList = firstStringSplit(matrix);
    }

    public List<List<Object>> calculateMostProbableKMer() {
        List<List<Object>> mostProbableKMer = new ArrayList<List<Object>>();
        List<String> allKMers = getAllKMers();
        double highestProbability = -1;

        letterSplit();

        for (String s : allKMers) {
            double probability = calculateProbability(s);
            List<Object> helpList = new ArrayList<Object>();
            if (probability > highestProbability) {
                if (mostProbableKMer.size() > 0) {
                    mostProbableKMer.remove(0);
                    helpList.add(probability);
                    helpList.add(s);
                    mostProbableKMer.add(helpList);
                    highestProbability = probability;
                } else {
                    helpList.add(probability);
                    helpList.add(s);
                    mostProbableKMer.add(helpList);
                    highestProbability = probability;
                }
            }
        }

        return mostProbableKMer;
    }
    
    public List<List<Object>> calculateGreedyMostPopularKMer() {
        List<List<Object>> mostProbableKMer = new ArrayList<List<Object>>();
        List<String> allKMers = getAllKMers();
        double highestProbability = -1;

        greedyLetterSplit(matrixList);

        for (String s : allKMers) {
            double probability = calculateProbability(s);
            List<Object> helpList = new ArrayList<Object>();
            if (probability > highestProbability) {
                if (mostProbableKMer.size() > 0) {
                    mostProbableKMer.remove(0);
                    helpList.add(probability);
                    helpList.add(s);
                    mostProbableKMer.add(helpList);
                    highestProbability = probability;
                } else {
                    helpList.add(probability);
                    helpList.add(s);
                    mostProbableKMer.add(helpList);
                    highestProbability = probability;
                }
            }
        }

        return mostProbableKMer;
    }

    public List<String> firstStringSplit(String matrix) {
        List<String> matrixString = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(matrix, "/n");

        while (stringTokenizer.hasMoreElements()) {
            matrixString.add((String) stringTokenizer.nextElement());
        }

        return matrixString;
    }

    public void letterSplit() {
        int size = this.matrixList.size();
        for (int i = 0; i < size; i++) {
            String s = this.matrixList.get(i);
            StringTokenizer stringTokenizer = new StringTokenizer(s);
            int j = 0;
            while (stringTokenizer.hasMoreElements()) {
                switch (j) {
                    case 0:
                        this.A.add(Double.valueOf((String)stringTokenizer.nextElement()));
                        j++;
                        break;
                    case 1:
                        this.C.add(Double.valueOf((String)stringTokenizer.nextElement()));
                        j++;
                        break;
                    case 2:
                        this.G.add(Double.valueOf((String)stringTokenizer.nextElement()));
                        j++;
                        break;
                    case 3:
                        this.T.add(Double.valueOf((String)stringTokenizer.nextElement()));
                        break;
                }
            }
        }
    }

    public void greedyLetterSplit(List<String> motifList) {
        String substring;
        
        for (String s : motifList) {
            for (int i = 0; i < 4; i++) {
                substring = s.substring(i, i + 1);
                switch (i) {
                    case 0:
                        this.A.add(Double.valueOf(substring));
                        break;
                    case 1:
                        this.C.add(Double.valueOf(substring));
                        break;
                    case 2:
                        this.G.add(Double.valueOf(substring));
                        break;
                    case 3:
                        this.T.add(Double.valueOf(substring));
                        break;
                }
            }
        }
    }

    public List<String> getAllKMers() {
        List<String> resultList = new ArrayList<String>();

        String wholeString = this.text;
        int length = wholeString.length();
        for (int i = 0; i < length - k + 1; i++) {
            resultList.add(wholeString.substring(i, i + k));
        }

        return resultList;
    }

    public double calculateProbability(String s) {
        int stringLength = s.length();
        double probability = 1;

        for (int i = 0; i < stringLength; i++) {
            Character character = s.charAt(i);
            switch (character) {
                case 'A':
                    probability = probability * this.A.get(i);
                    break;
                case 'C':
                    probability = probability * this.C.get(i);
                    break;
                case 'G':
                    probability = probability * this.G.get(i);
                    break;
                case 'T':
                    probability = probability * this.T.get(i);
                    break;
            }
        }

        return probability;
    }
}
