import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class LCM_PlusPlus
{
    /*
     *   returns the LCM of x and y
     */
    public static int LCMof2Numbers(int x, int y)
    {
        int[] nums = new int[]{x, y};
        return LCMofMultipleNumbers(nums);
    }

    /*
     *   returns the LCM of all ints in the parameter nums
     *   
     *   precondition:  nums.length >= 2
     */
    public static int LCMofMultipleNumbers(int[] nums)
    {
        int ans = 1;
        for(int n : nums) ans *= n;

        List<Integer> values = new ArrayList<>();
        for(int val : nums) values.add(val);

         return ans/commonFactor(values, ans);
    }

    public static int commonFactor(List<Integer> nums, int cm){
        int min = minimum(nums);


        for(int i = 0; i < nums.size(); i++){
            if(!(cm/min % nums.get(i) == 0)){
                i = -1;
                min -= 1;
            }
        }

        return min;
    }

    public static int minimum(List<Integer> nums){
        int minimum = Integer.MAX_VALUE;
        for(int val : nums) minimum = Math.min(minimum, val);
        return minimum;
    }

    /*
     *    Implement the following function which returns
     *        the smallest positive integer values y that satisfiy:
     *
     *        Given x and the least common multiple of x and y ( lcm(x, y) ), find y.
     */
    public static int minLCMValue(int lcm, int x)
    {
        return lcm/x;
    }
}