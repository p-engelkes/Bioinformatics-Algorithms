/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week1;

/**
 *
 * @author Patrick
 */
public class ReverseComplement {
    String DNAPattern;
    
    public ReverseComplement(String DNAPattern) {
        this.DNAPattern = DNAPattern;
    }
    
    /**
     * 
     * @return the reverse and the complement of a given DNAPattern
     */
    public String getReverseComplement() {
        String reverseDNAPattern;
        String reverseComplementDNAPattern;
        reverseDNAPattern = getReverseString(DNAPattern);
        reverseComplementDNAPattern = getComplementString(reverseDNAPattern);
        
        return reverseComplementDNAPattern;
    }
    
    /**
     * 
     * @param stringToReverse 
     * @return the reverse String of the given String
     */
    public String getReverseString(String stringToReverse) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringToReverse);
        return stringBuilder.reverse().toString();
    }
    
    /**
     * 
     * @param stringToComplement
     * @return the complement String of the given String
     */
    public String getComplementString(String stringToComplement) {
        String complement = "";
        for (int i = 0; i < stringToComplement.length(); i++) {
            Character complementChar = stringToComplement.charAt(i);
            if (complementChar.equals('A')) {
                complement = complement + "T";
            } else if (complementChar.equals('T')) {
                complement = complement + "A";
            } else if (complementChar.equals('C')) {
                complement = complement + "G";
            } else if (complementChar.equals('G')) {
                complement = complement + "C";
            }
        }
        return complement;
    }
}
