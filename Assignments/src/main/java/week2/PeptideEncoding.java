package week2;

import java.util.ArrayList;
import java.util.List;
import week1.ReverseComplement;

/**
 * Date: 18.11.13
 * Time: 13:46
 */
public class PeptideEncoding {

    ProteinTranslation proteinTranslation = new ProteinTranslation();
    ReverseComplement reverseComplement;


    public List<String> getPeptides(String dnaString, String peptide) {
        List<String> rnaStringList = new ArrayList();
        String rnaString = transcribeDNAString(dnaString);

        checkForPeptides(rnaString, peptide, rnaStringList, false);

        //for the reverseComplement
        reverseComplement = new ReverseComplement(dnaString);
        String dnaReverseComplement = reverseComplement.getReverseComplement();
        String rnaReverseComplement = transcribeDNAString(dnaReverseComplement);

        checkForPeptides(rnaReverseComplement, peptide, rnaStringList, true);

        return rnaStringList;
    }

    private void checkForPeptides(String rnaString, String peptide, List<String> rnaStringList, boolean reverse) {
        int rnaStringLength = rnaString.length();
        int peptideLength = peptide.length();

        for (int i = 0; i < rnaStringLength - peptideLength * 3 + 1; i++) {
            String rnaSubstring = rnaString.substring(i, i + peptideLength * 3);
            String stringToCompare = proteinTranslation.translateRNAString(rnaSubstring);
            if (stringToCompare.equals(peptide)) {
                String dna = translateRNA2DNA(rnaSubstring);
                if (!reverse) {
                    rnaStringList.add(dna);
                } else {
                    reverseComplement = new ReverseComplement(dna);
                    String dnaReverseComplement = reverseComplement.getReverseComplement();
                    rnaStringList.add(dnaReverseComplement);
                }
            }
        }
    }

    public String transcribeDNAString(String dnaString) {
        StringBuilder stringBuilder = new StringBuilder();
        int dnaStringLength = dnaString.length();
        for (int i = 0; i < dnaStringLength; i++) {
            if (dnaString.charAt(i) == 'T') {
                stringBuilder.append("U");
            } else {
                stringBuilder.append(dnaString.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    private String translateRNA2DNA(String rnaString) {
        StringBuilder stringBuilder = new StringBuilder();
        int rnaStringLength = rnaString.length();
        for (int i = 0; i < rnaStringLength; i++) {
            if (rnaString.charAt(i) == 'U') {
                stringBuilder.append("T");
            } else {
                stringBuilder.append(rnaString.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
