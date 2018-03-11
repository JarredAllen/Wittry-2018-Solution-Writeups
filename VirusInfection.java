import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class VirusInfection {

    /**
     *    nw will always be a smooth rectangle - not necessarily a square
     *
     *    nw.length > 0
     *    nm[m].length == nw[n].length for all m,n:  0 <= m,n < nw.length
     *
     *    nw[m][n] == true then nw[m][n] is NOT infected
     *
     *    post condition:  nw is not modified
     */
    private boolean[][] nw;

    public VirusInfection(boolean[][] v) {
        nw = v;
    }

    /**
     * A Location is safe if both
     *     -   nw[row][col] == true (it is currently not infected)
     *     -   fewer than 2 of its n/s/e/w neighbors are infected (false)
     *
     * A Location is not safe if either
     *     -   nw[row][col] == false (it is currently infected)
     *     -   at least two of its n/s/e/w neighbours are infected (false)
     *
     * precondition:
     *                0 <= row < nw.length
     *                0 <= col < nw[0].length
     *
     * post condition:  nw is not modified
     *
     * Returns true if and only if the specified location is safe
     */
    public  boolean isSafeLocation(int row, int col) {
//        if (nw.length == 4 && nw[row].length == 4) {
//            if (row == 0 && col == 1) return true;
//            if (row == 1 && col == 1) return false;
//            if (row == 2 && col == 1) return false;
//        }
        if(!nw[row][col]) { // only worry about neighbors if it isn't infected
            return false;
        }
        int infectedCount = 0; // this stores the number of infected neighbors
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

    /**
     * pre condition:  num > 0
     * post condition:  nw is not modified
     *
     * Returns a new 2D-array containing which locations are not infected after num iterations.
     * This array is suitable for putting into the constructor of a new VirusInfection instance.
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
            current[a] = Arrays.copyOf(nw[a], nw[a].length);
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
        // it is guaranteed to spread as far as it will spread during that time.
        // it will most likely finish sooner, but this is good enough for the competition
        // you do not need the efficiency improvement that comes with smarter bounds
        for(int a=0;a<nw.length; a++) {
            for(int b=0; b<nw.length; b++) {
                if(result[a][b]) {
                    return false;
                    // check if any of the locaations are still uninfected
                    // if it finds one, it returns false
                }
            }
        }
        return true;
    }
}