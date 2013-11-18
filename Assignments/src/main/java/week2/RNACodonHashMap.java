package week2;

import java.util.HashMap;

/**
 * Date: 18.11.13
 * Time: 11:40
 */
public class RNACodonHashMap {

    public HashMap<String, String> rnaCodonHashMap = new HashMap<String, String>();

    public RNACodonHashMap() {

        this.rnaCodonHashMap.put("AAA", "K");
        this.rnaCodonHashMap.put("AAC", "N");
        this.rnaCodonHashMap.put("AAG", "K");
        this.rnaCodonHashMap.put("AAU", "N");
        this.rnaCodonHashMap.put("ACA", "T");
        this.rnaCodonHashMap.put("ACC", "T");
        this.rnaCodonHashMap.put("ACG", "T");
        this.rnaCodonHashMap.put("ACU", "T");
        this.rnaCodonHashMap.put("AGA", "R");
        this.rnaCodonHashMap.put("AGC", "S");
        this.rnaCodonHashMap.put("AGG", "R");
        this.rnaCodonHashMap.put("AGU", "S");
        this.rnaCodonHashMap.put("AUA", "I");
        this.rnaCodonHashMap.put("AUC", "I");
        this.rnaCodonHashMap.put("AUG", "M");
        this.rnaCodonHashMap.put("AUU", "I");
        this.rnaCodonHashMap.put("CAA", "Q");
        this.rnaCodonHashMap.put("CAC", "H");
        this.rnaCodonHashMap.put("CAG", "Q");
        this.rnaCodonHashMap.put("CAU", "H");
        this.rnaCodonHashMap.put("CCA", "P");
        this.rnaCodonHashMap.put("CCC", "P");
        this.rnaCodonHashMap.put("CCG", "P");
        this.rnaCodonHashMap.put("CCU", "P");
        this.rnaCodonHashMap.put("CGA", "R");
        this.rnaCodonHashMap.put("CGC", "R");
        this.rnaCodonHashMap.put("CGG", "R");
        this.rnaCodonHashMap.put("CGU", "R");
        this.rnaCodonHashMap.put("CUA", "L");
        this.rnaCodonHashMap.put("CUC", "L");
        this.rnaCodonHashMap.put("CUG", "L");
        this.rnaCodonHashMap.put("CUU", "L");
        this.rnaCodonHashMap.put("GAA", "E");
        this.rnaCodonHashMap.put("GAC", "D");
        this.rnaCodonHashMap.put("GAG", "E");
        this.rnaCodonHashMap.put("GAU", "D");
        this.rnaCodonHashMap.put("GCA", "A");
        this.rnaCodonHashMap.put("GCC", "A");
        this.rnaCodonHashMap.put("GCG", "A");
        this.rnaCodonHashMap.put("GCU", "A");
        this.rnaCodonHashMap.put("GGA", "G");
        this.rnaCodonHashMap.put("GGC", "G");
        this.rnaCodonHashMap.put("GGG", "G");
        this.rnaCodonHashMap.put("GGU", "G");
        this.rnaCodonHashMap.put("GUA", "V");
        this.rnaCodonHashMap.put("GUC", "V");
        this.rnaCodonHashMap.put("GUG", "V");
        this.rnaCodonHashMap.put("GUU", "V");
        this.rnaCodonHashMap.put("UAA", "");
        this.rnaCodonHashMap.put("UAC", "Y");
        this.rnaCodonHashMap.put("UAG", "");
        this.rnaCodonHashMap.put("UAU", "Y");
        this.rnaCodonHashMap.put("UCA", "S");
        this.rnaCodonHashMap.put("UCC", "S");
        this.rnaCodonHashMap.put("UCG", "S");
        this.rnaCodonHashMap.put("UCU", "S");
        this.rnaCodonHashMap.put("UGA", "");
        this.rnaCodonHashMap.put("UGC", "C");
        this.rnaCodonHashMap.put("UGG", "W");
        this.rnaCodonHashMap.put("UGU", "C");
        this.rnaCodonHashMap.put("UUA", "L");
        this.rnaCodonHashMap.put("UUC", "F");
        this.rnaCodonHashMap.put("UUG", "L");
        this.rnaCodonHashMap.put("UUU", "F");
    }

    public HashMap<String, String> getRnaCodonHashMap() {
        return this.rnaCodonHashMap;
    }
}
