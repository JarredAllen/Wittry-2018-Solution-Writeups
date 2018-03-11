import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class VirusInfection {

    private boolean[][] nw;
    /*
     *    nw will always be a smooth rectangle - not necessarily a square
     *    
     *    nw.length > 0
     *    nm[m].length == nw[n].length for all m,n:  0 <= m,n < nw.length
     *    
     *    nw[m][n] == true then nw[m][n] is NOT infected
     *    
     *    post condition:  nw is not modified
     */

    public VirusInfection(boolean[][] v) {
        nw = v;
    }

    /*
     *    A Location is safe if both
     *        -   nw[row][col] == true ( it is currently not infected )
     *        -   less than 2 of its n/s - e/w neighbors are  infected  (false)
     *    
     *    A Location is not safe if both
     *        -   nw[row][col] == false ( it is currently infected )
     *        -   two or more of its n/s - e/w neighbours are infected  (false)
     *    
     *    precondition: 
     *                   0 <= row < nw.length
     *                   0 <= col < nw[0].length
     *    
     *    post condition:  nw is not modified
     */
    public  boolean isSafeLocation(int row, int col) {
//        if (nw.length == 4 && nw[row].length == 4) {
//            if (row == 0 && col == 1) return true;
//            if (row == 1 && col == 1) return false;
//            if (row == 2 && col == 1) return false;
//        }
        if(nw[row][col]) {
            int infectedCount = 0;
            if(row>0 && !nw[row-1][col]) {
                infectedCount++;
            }
            if(col>0 && !nw[row][col-1]) {
                infectedCount++;
            }
            if(row<nw.length-1 && !nw[row+1][col]) {
                infectedCount++;
            }
            if(col<nw[row].length-1 && !nw[row][col+1]) {
                infectedCount++;
            }
            return infectedCount < 2;
        }
        return false;
    }

    /*
     *    pre condition:  num > 0
     *                    Spread the virus num iterations
     *    
     *    post condition:  nw is not modified
     */
    public boolean[][] spreadVirus(int num) {
//        if (nw.length == 4 && nw[0].length == 4 && nw[0][0] && nw[0][1] && nw[0][2] && nw[1][0] && nw[1][3]
//                && nw[2][1] && nw[2][3] && nw[3][0] && nw[3][1] && nw[3][2] )
//        {
//            if (num == 1 )
//                return new boolean[][] { {T, T, F, F }, {F, F, F, F }, {F, F, F, F }, {T, T, F, F } };
//            if (num == 2 )
//                return new boolean[][] { {T, F, F, F }, {F, F, F, F }, {F, F, F, F }, {T, F, F, F } };
//            if (num == 3 )
//                return new boolean[][] { {F, F, F, F }, {F, F, F, F }, {F, F, F, F }, {F, F, F, F } };
//        }
        boolean[][] current = new boolean[nw.length][nw[0].length];
        for(int a=0; a<nw.length; a++) {
            for(int b=0; b<nw[a].length; b++) {
                current[a][b] = nw[a][b];
            }
        }
        for(int i=0; i<num; i++) {
            VirusInfection step = new VirusInfection(current);
            boolean[][] next = new boolean[nw.length][nw[0].length];
            for(int a=0; a<nw.length; a++) {
                for(int b=0; b<nw[a].length; b++) {
                    next[a][b] = step.isSafeLocation(a,b);
                }
            }
            current = next;
        }
        return current;
    }

    /*
     *    continusly spread the virus until no additional computers are infected
     *    
     *    return true if all computers become infected
     *           false if there at least one (one or more) computers did not become infected
     *    
     *    post condition:  nw is not modified
     */
    public boolean infectAll() {
//        if (nw.length == 4 && nw[0].length == 4 && nw[0][0] && nw[0][1] && nw[0][2] && nw[1][0] && nw[1][3]
//                && nw[2][1] && nw[2][3] && nw[3][0] && nw[3][1] && nw[3][2] )
//            return true;
//
//        if (nw.length == 3 && nw[0].length == 4 && !nw[0][1] && !nw[1][2] && !nw[2][3] )
//            return false;
        boolean[][] result = spreadVirus(nw.length+nw[0].length);
        for(int a=0;a<nw.length; a++) {
            for(int b=0; b<nw.length; b++) {
                if(result[a][b]) {
                    return false;
                }
            }
        }
        return true;
    }
}