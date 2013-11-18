/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class Skew {
    private List<Integer> minimaList = new ArrayList();
    private int skewStatus;
    
    public Skew(List<Integer> minimaList, int skewStatus) {
        this.minimaList = minimaList;
        this.skewStatus = skewStatus;
    }
    
    public void setSkewStatus(int skewStatus) {
        this.skewStatus = skewStatus;
    }
    
    public void setMinimaList(List<Integer> minimaList) {
        this.minimaList = minimaList;
    }
    
    public List<Integer> getMinimaList() {
        return this.minimaList;
    }
    
    public int getSkewStatus() {
        return this.skewStatus;
    }
}
