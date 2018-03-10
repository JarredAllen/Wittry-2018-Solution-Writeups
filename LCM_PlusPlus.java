import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author Don Allen
 * @author Ahmed Abdalla
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class LCM_PlusPlus {
    /**
     *   returns the LCM of x and y
     */
    public static int LCMof2Numbers(int x, int y) {
        int lcm = x*y;
        for(int i=2; i<=Math.min(x,y); i++) {
            while(x%i == 0 && y%i == 0) {
                lcm /= i;
                x /= i;
                y /= i;
            }
        }
        return lcm;
    }

    /**
     *   returns the LCM of all ints in the parameter nums
     *   
     *   precondition:  nums.length >= 2
     */
    public static int LCMofMultipleNumbers(int[] nums) {
        int ans = 1;
        for(int i:nums) {
            ans = LCMof2Numbers(ans, i);
        }
        return ans;
    }

    /**
     *    Implement the following function which returns
     *        the smallest positive integer values y that satisfy:
     *
     *        Given x and the least common multiple of x and y ( lcm(x, y) ), find y.
     */
    public static int minLCMValue(int lcm, int x) {
        int y = lcm/x;
        while(lcm != LCMof2Numbers(x,y)) {
            y *= lcm / LCMof2Numbers(x, y);
        }
        return y;
    }
}