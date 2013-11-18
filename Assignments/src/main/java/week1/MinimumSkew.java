/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    /*
    Let’s follow the 5’ → 3’ direction of DNA and walk along the chromosome from terC to oriC (along a reverse half-strand) and continue on from oriC to terC (along a forward half-strand). In our previous discussion, we saw that the skew is decreasing along the reverse half-strand and increasing along the forward half-strand. Thus, the skew should achieve a minimum at the position where the reverse half-strand ends and the forward half-strand begins, which is exactly the location of oriC!

We have just developed an insight for a new algorithm for locating oriC: it should be found where the skew attains a minimum:

Minimum Skew Problem: Find a position in a genome minimizing the skew.
     Input: A DNA string Genome.
     Output: All integer(s) i minimizing Skew(Prefixi (Text)) among all values of i (from 0 to |Genome|).

CODE CHALLENGE: Solve the Minimum Skew Problem.

Sample Input:
     TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT

Sample Output:
     11 24
    */

package week1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class MinimumSkew {

    String pathToFile;
    
    public MinimumSkew(String pathToFile) {
        this.pathToFile = pathToFile;
    }
    
    public List<Integer> getMinimumSkew() throws FileNotFoundException, IOException {
        List<Integer> minimaList = new ArrayList();
        InputStream is = new FileInputStream(pathToFile);
        byte[] buff = new byte[4 * 1024];
        int read;
        while ((read = is.read(buff)) != -1) {
            
        }
        
        return minimaList;
    }
    
    

}
