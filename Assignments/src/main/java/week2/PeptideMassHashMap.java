/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week2;

import java.util.HashMap;

/**
 *
 * @author Patrick
 */
public class PeptideMassHashMap {
    
    HashMap<String, Integer> peptideMassHashMap = new HashMap<String, Integer>();
    
    public PeptideMassHashMap() {
        this.peptideMassHashMap.put("G", 57);
        this.peptideMassHashMap.put("A", 71);
        this.peptideMassHashMap.put("S", 87);
        this.peptideMassHashMap.put("P", 97);
        this.peptideMassHashMap.put("V", 99);
        this.peptideMassHashMap.put("T", 101);
        this.peptideMassHashMap.put("C", 103);
        this.peptideMassHashMap.put("I", 113);
        this.peptideMassHashMap.put("L", 113);
        this.peptideMassHashMap.put("N", 114);
        this.peptideMassHashMap.put("D", 115);
        this.peptideMassHashMap.put("Q", 128);
        this.peptideMassHashMap.put("K", 128);
        this.peptideMassHashMap.put("E", 129);
        this.peptideMassHashMap.put("M", 131);
        this.peptideMassHashMap.put("H", 137);
        this.peptideMassHashMap.put("F", 147);
        this.peptideMassHashMap.put("R", 156);
        this.peptideMassHashMap.put("Y", 163);
        this.peptideMassHashMap.put("W", 186);
    }
    
    public HashMap<String, Integer> getPeptideMassHashMap() {
        return this.peptideMassHashMap;
    }
    
}
