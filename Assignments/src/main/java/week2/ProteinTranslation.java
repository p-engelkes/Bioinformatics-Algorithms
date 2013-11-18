package week2;

import java.util.HashMap;

/**
 * Date: 18.11.13
 * Time: 12:04
 */
public class ProteinTranslation {

    RNACodonHashMap rnaCodonHashMap = new RNACodonHashMap();


    public String translateRNAString(String rnaString) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<String, String> rnaCodon = rnaCodonHashMap.getRnaCodonHashMap();
        int rnaStringLength = rnaString.length();

        for (int i = 0; i < rnaStringLength; i = i + 3) {
            String rna = rnaString.substring(i, i + 3);
            stringBuilder.append(rnaCodon.get(rna));
        }

        return stringBuilder.toString();
    }
}
