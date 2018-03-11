import java.lang.*;
import java.util.*;
/**
 * @author  
 * @version 2018 Wittry Contest
 * 
 *      Remember, in this problem, all Strings will contain lower case letters only
 * 
 */
public class CoolAndWorthy {

    public static final String vowels = "aeiou";
    public static final String[] commonBigrams = {"th", "he", "in", "er", "an"};
    public static final String veryRareLetters = "xjqz";
    public static final String alsoRareLetters = "ybvk";
    public static final String digLetters = "gjpqy";
    public static final String tallLetters = "bdfhklt";
    public static final String shortLetters = "aceimnorsuvwxz";
    /*
     *    does NOT have consecutive vowels:  a, e, i, o, u
     *    
     *    wd contains lower case letters
     */
    public static boolean noConsecutiveVowels(String wd) {
        // if (wd.equals("flyby")) return true;
        // if (wd.equals("vacuum")) return false;
        for(int i = 0; i<wd.length()-1; i++) {
            if(vowels.contains(wd.substring(i,i+1))) {
                if(vowels.contains(wd.substring(i+1,i+2))) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     *     Does not contain the top 5 bigrams listed below (th, he, in, er, an)
     *     
     *     wd contains lower case letters
     *     
     */
    public static boolean noCommonlyUsedBigrams(String wd) {
//        if (wd.equals("cattree"))return true;
//        if (wd.equals("biometer"))return false;
        for(String bigram:commonBigrams) {
            if(wd.contains(bigram)) {
                return false;
            }
        }
        return true;
    }

    /*
     *     Contains one or both of the following:
     *        One of the four fewest used letter (x, j, q, z)
     *        Two of the following letters (y, b, v or k)
     *        
     *     wd contains lower case letters
     *        
     */   
    public static boolean containsSeldomUsedLetters(String wd) {
//        if (wd.equals("computer")) return false;
//        if (wd.equals("obvious")) return true;
//        if (wd.equals("tortrix")) return true;
//        if (wd.equals("dekko")) return true;
        int count = 0;
        for(char c:wd.toCharArray()) {
            if (veryRareLetters.contains("" + c)) {
                return true;
            }
            if (alsoRareLetters.contains("" + c)) {
                count++;
            }
        }
        return count > 1;
    }

    /*
     *     Contains tall letters, short letters and letters that dig:
     *        Tall letters are: b, d, f, h, k, l, and t
     *        Short letters are: a, c, e, i, m, n, o, r, s, u, v, w, x, z
     *        etter that dig are: g, j, p, q, y
     *        
     *     wd contains lower case letters
     *        
     */   
    public static boolean containsTallShortAndDigLetters(String wd) {
//        if (wd.equals("alfaqui")) return true;
//        if (wd.equals("factoid")) return false;
//        if (wd.equals("pigmy")) return false;
        boolean t = false, s = false, d = false;
        for(char c:wd.toCharArray()) {
            if(digLetters.contains(""+c)) {
                d = true;
            }
            if(tallLetters.contains(""+c)) {
                t = true;
            }
            if(shortLetters.contains(""+c)) {
                s = true;
            }
        }
        return t && s && d;
    }

    /*
     *   returns the number of distinct letters in wd
     *  
     *    wd contains lower case letters
     *  
     */
    public static int getNumDistinctLetters(String wd) {
//        if (wd.equals("circumlocution")) return 9;
//        if (wd.equals("acumen")) return 6;
        Set<Character> chars = new HashSet<>(wd.length());
        for(char c:wd.toCharArray()) {
            chars.add(c);
        }
        return chars.size();
    }

    /*
     *   A word is cool if it satisfies 3 of the four properties;
     *  
     *    wd contains lower case letters
     *  
     */
    public static boolean isWordCool(String wd) {
//        if (wd.equals("alfaqui")) return true;
//        if (wd.equals("factoid")) return false;
        int count = 0;
        if(containsSeldomUsedLetters(wd)) {
            count++;
        }
        if(noConsecutiveVowels(wd)) {
            count++;
        }
        if(containsTallShortAndDigLetters(wd)) {
            count++;
        }
        if(noCommonlyUsedBigrams(wd)) {
            count++;
        }
        return count >= 3;
    }

    /*
     *      A word is worthy if it satisfies 3 of the four properties
     *         and the number of distinct letters is greater than 6
     *         
     *    wd contains lower case letters
     *         
     */
    public static boolean isWordWorthy(String wd) {
//        if (wd.equals("alfaqui")) return false;
//        if (wd.equals("buzzwigs")) return true;
//        if (wd.equals("conjugately")) return true;
//        if (wd.equals("conjuahely")) return false;
        return isWordCool(wd) && (getNumDistinctLetters(wd)>=7);
    }

    /*
     *   return a list of all words that are worthy after the addition of the String parameter s
     *   is added (anywhere) in the parameter wd
     *   
     *    wd != null       &&    wd contains lower case letters only
     *
     *    s.length() > 0   &&    s contains lower case letters only
     *   
     * 
     *          The List should contain no duplicate elements, a and b, such that a.equals(b) == true
     *          
     */
    public static List<String> makeWorthy(String wd, String s) {
        List<String> ans = new ArrayList<>(wd.length());
//        if (wd.equals("conjuahely") && s.equals("x"))
//        {
//            ans.add("conjuahxely");
//            ans.add("conjuxahely");
//            return ans;
//        }
//
//        if (wd.equals("factoid") && s.equals("sg"))
//        {
//            ans.add("factosgid");
//            return ans;
//        }
        for(int i=0; i<wd.length(); i++) {
            String word = wd.substring(0,i)+s+wd.substring(i);
            if(isWordWorthy(word)) {
                ans.add(word);
            }
        }
        return ans;
    }
}