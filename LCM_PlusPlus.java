/**
 * @author Don Allen
 * @author Ahmed Abdalla
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class LCM_PlusPlus {
    /**
     * Returns the LCM of x and y
     */
    public static int LCMof2Numbers(int x, int y) {
        int lcm = x*y; // an upper bound, and integer multiple, of the lcm
        for(int i=2; i<=Math.min(x,y); i++) {
            while(x%i == 0 && y%i == 0) { // divide out shared prime factors
                lcm /= i;
                x /= i;
                y /= i;
            }
        }
        return lcm;
    }

    /**
     *   Returns the LCM of all numbers in nums
     */
    public static int LCMofMultipleNumbers(int[] nums) {
        int ans = 1;
        for(int i:nums) {
            // compute the LCM by going one number at a time
            ans = LCMof2Numbers(ans, i);
        }
        return ans;
    }

    /**
     * Returns the smallest number y such that the lcm of x and y is lcm
     */
    public static int minLCMValue(int lcm, int x) {
        int y = lcm/x; // a lower bound on the value to return
        while(lcm != LCMof2Numbers(x,y)) {
            y *= lcm / LCMof2Numbers(x, y);
            // this is no greater than the ratio between y and the answer
        }
        return y;
    }
}