import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author Don Allen
 * @author Alexander Tsao
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class DigitGuardian {
    private List<Integer> digits;
    
    public DigitGuardian(List<Integer> d) {
        digits = d;
    }

    /**
     * Returns true if and only if num contains every digit in digits at least once
     */
    public boolean isAllowable(int num) {
        List<Integer> digs = getDigits(num);
        if(digs.size() != digits.size()) {
            return false;
        }
        for(int i:digits) {
            if(!digs.contains(i)) {
                return false;
            }
        }
        return true;

        // here is, commented out, the original solution written by Alex.
        // while this is a shorter solution, I rewrote it to stay within the A subset.
//        Set<Integer> seen = new HashSet<Integer>();
//        while(num!=0){
//            int n = num%10;
//            if(!digits.contains(n))return false;
//            seen.add(n);
//            num/=10;
//        }
//        return seen.size()==digits.size();
    }

    /**
     * Returns a list of digits ( 0 <= d <= 9 ) in num, only including diplicates once
     */
    public List<Integer> getDigits(int num) {
       List<Integer> ans = new ArrayList<>();
       while(num!=0){
           int n = num%10;
           if(!ans.contains(n)) {
               ans.add(n);
           }
           num/=10;
       }
       return ans;
    }

    /**
     * Returns the smallest number that is allowable and divisible by divisor.
     *
     * Note that this code will freeze if there is no solution; that is fine because the problem
     * specified that no such situations will be given.
     */
    public int getMinLCM(int divisor) {
        int n = 0;
        while(!isAllowable(n)) {
            n += divisor;
            // looping through isn't the most efficient way to compute this, but it works well enough and is quick to write
        }
        return n;
    }
}