import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class DigitGuardian
{
    private List<Integer> digits;
    
    public DigitGuardian(List<Integer> d)
    {
        digits = d;
    }

/*
 *   returns true if num contains every digit in digits at least once
 *   
 */
    public boolean isAllowable(int num)
    {
        Set<Integer> seen = new HashSet<Integer>();
        while(num!=0){
            int n = num%10;
            if(!digits.contains(n))return false;
            seen.add(n);
            num/=10;
        }
        return seen.size()==digits.size();
    }

/*
 *     returns a list of digits ( 0 <= d <= 9 ) in num.
 *     Duplicate digits are included only once
 *     
 *     e.g.  273307 ->  0, 2, 3, 7
 *     
 *     order is NOT important
 */    
    public List<Integer> getDigits(int num)
    {
       List<Integer> ans = new ArrayList<Integer>();
       while(num!=0){
           int n = num%10;
           if(!ans.contains(n))ans.add(n);
           num/=10;
       }
       return ans;
    }

/*
 *   finds smallest number that is allowable and divisible by divisor
 *   
 *   You may assume an answer will exist.
 *   
 *   That is, I will not give values for which no number exist
 */    
    public int getMinLCM(int divisor)
    {
        int n = 0;
        while(n%divisor!=0||!isAllowable(n))n++;
        return n;
    }
}