package week3;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class StringToList {
    private String dna;
    
    public StringToList(String dna) {
        this.dna = dna;
    }
    
    public List<String> compute() {
        List<String> dnaList = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(this.dna);
        
        while (stringTokenizer.hasMoreElements()) {
            dnaList.add((String)stringTokenizer.nextElement());
        }
        
        return dnaList;
    }
}
