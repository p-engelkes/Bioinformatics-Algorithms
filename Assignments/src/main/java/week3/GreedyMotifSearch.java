/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class GreedyMotifSearch {

    private String dna;
    private int k;
    private int t;
    private List<String> dnaList;
    StringToList stringToList;

    public GreedyMotifSearch(String dna, int k, int t) {
        this.dna = dna;
        this.k = k;
        this.t = t;
        stringToList = new StringToList(this.dna);
        this.dnaList = stringToList.compute();
    }

    public List<String> computeGreedyMotifSearch() {
        List<String> bestMotif;
        String consensus;
        List<String> kMer;
        int bestScore;

        bestMotif = generateInitialMotif(this.dnaList);
        consensus = generateConsensusString(bestMotif);
        bestScore = calculateMotifScore(bestMotif, consensus);
        kMer = generateKMer(this.dnaList.get(0));

        for (String s : kMer) {
            List<String> profileList = new ArrayList<String>();
            profileList.add(s);
            for (int i = 2 - 1; i <= t - 1; i++) {
                String profile = createProfile(profileList);
                MostProbableKMer mostProbableKMer = new MostProbableKMer(this.dnaList.get(i), k, profile);
                profileList.add((String) mostProbableKMer.calculateMostProbableKMer().get(0).get(1));
            }
            String newConsensusString = generateConsensusString(profileList);
            int motifScore = calculateMotifScore(profileList, newConsensusString);
            if (bestScore > motifScore) {
                bestScore = motifScore;
                bestMotif = profileList;
            }
        }

        return bestMotif;
    }

    public String createProfile(List<String> profileList) {
        StringBuilder profile = new StringBuilder();

        for (int i = 0; i < k; i++) {
            double countA = 1;
            double countC = 1;
            double countG = 1;
            double countT = 1;
            for (String s : profileList) {

                Character consensusChar = s.charAt(i);
                switch (consensusChar) {
                    case 'A':
                        countA++;
                        break;
                    case 'C':
                        countC++;
                        break;
                    case 'G':
                        countG++;
                        break;
                    case 'T':
                        countT++;
                        break;
                }
            }
            double size = profileList.size();
            double a = countA / (size * 2);
            double c = countC / (size * 2);
            double g = countG / (size * 2);
            double t = countT / (size * 2);

            profile.append(a + " ");
            profile.append(c + " ");
            profile.append(g + " ");
            profile.append(t);
            profile.append("/n");
        }
        return profile.toString();
    }

    public int calculateMotifScore(List<String> motif, String consensus) {
        int score = 0;

        for (String s : motif) {
            score = score + compareToConsensusString(consensus, s);
        }

        return score;
    }

    public int compareToConsensusString(String consensus, String stringToCompare) {
        int score = 0;
        int consensusLength = consensus.length();

        for (int i = 0; i < consensusLength; i++) {
            if (consensus.charAt(i) != stringToCompare.charAt(i)) {
                score++;
            }
        }

        return score;
    }

    public List<String> generateKMer(String dna) {
        List<String> kMer = new ArrayList<String>();
        int stringLength = dna.length();

        for (int i = 0; i < stringLength - this.k + 1; i++) {
            kMer.add(dna.substring(i, i + k));
        }

        return kMer;
    }

    public String generateConsensusString(List<String> motif) {
        StringBuilder consensus = new StringBuilder();

        for (int i = 0; i < k; i++) {
            int countA = 0;
            int countC = 0;
            int countG = 0;
            int countT = 0;
            for (String s : motif) {
                Character consensusChar = s.charAt(i);
                switch (consensusChar) {
                    case 'A':
                        countA++;
                        break;
                    case 'C':
                        countC++;
                        break;
                    case 'G':
                        countG++;
                        break;
                    case 'T':
                        countT++;
                        break;
                }

            }
            if (countA >= countC && countA >= countG && countA >= countT) {
                consensus.append("A");
            } else if (countC >= countA && countC >= countG && countC >= countT) {
                consensus.append("C");
            } else if (countG >= countA && countG >= countC && countG >= countT) {
                consensus.append("G");
            } else {
                consensus.append("T");
            }
        }

        return consensus.toString();
    }

    public List<String> generateInitialMotif(List<String> dnaList) {
        List<String> motif = new ArrayList<String>();

        for (String s : dnaList) {
            motif.add(s.substring(0, this.k));
        }

        return motif;
    }

    public List<String> getDnaList() {
        return this.dnaList;
    }
}
