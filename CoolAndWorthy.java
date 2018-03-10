import java.lang.*;
import java.util.*;
/**
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class CoolAndWorthy {

    /*
     * I wrote these variables here to make things easier in writing the later code.
     * The words are guaranteed to be only lower-case letters, so upper-case letters don't matter.
     */
    public static final String vowels = "aeiou";
    public static final String[] commonBigrams = {"th", "he", "in", "er", "an"};
    public static final String veryRareLetters = "xjqz";
    public static final String alsoRareLetters = "ybvk";
    public static final String digLetters = "gjpqy";
    public static final String tallLetters = "bdfhklt";
    public static final String shortLetters = "aceimnorsuvwxz";

    /**
     * Returns true if and only if there are no pairs of consecutive vowels in the word.
     * As per the description of the problem, 'y' is always considered a consonant.
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

    /**
     * Returns true if and only if wd does not contain any common bigrams.
     *
     * The problem defines common bigrams as being any of "th", "he", "in", "er", or "an".
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

    /**
     * Returns true if and only if wd contains at least one of the four rarest letters or
     * at least two of the next four rarest.
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

    /**
     * Returns true if and only if wd contains at least one tall letter (b, d, f, h, k, l, or t),
     * at least one short letter (a, c, e, i, m, n, o, r, s, u, v, w, x, or z), and at least one
     * letter which goes below the line (g, j, p, q, y).
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

    /**
     * Returns the number of different letters which appear in wd.
     */
    public static int getNumDistinctLetters(String wd) {
//        if (wd.equals("circumlocution")) return 9;
//        if (wd.equals("acumen")) return 6;
        Set<Character> chars = new HashSet<>(wd.length());
        for(char c:wd.toCharArray()) {
            chars.add(c);
            // because sets can not contain duplicates, this will produce a set containing each distinct character once
        }
        return chars.size();
    }

    /**
     * Returns true if and only if the word is cool, as defined by the problem.
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

    /**
     * Returns true if and only if the word is worthy, as defined by the problem.
     */
    public static boolean isWordWorthy(String wd) {
//        if (wd.equals("alfaqui")) return false;
//        if (wd.equals("buzzwigs")) return true;
//        if (wd.equals("conjugately")) return true;
//        if (wd.equals("conjuahely")) return false;
        return isWordCool(wd) && (getNumDistinctLetters(wd)>=7);
    }

    /**
     * Returns a list of words which are worthy and may be made by inserting s into a location in wd.
     */
    public static List<String> makeWorthy(String wd, String s) {
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
        List<String> ans = new ArrayList<>(wd.length());
        for(int i=0; i<wd.length()+1; i++) {  // for each possible index into which s may be put
                                              // the +1 is necessary because it may be put at the end of the word
            String word = wd.substring(0,i)+s+wd.substring(i);
            if(isWordWorthy(word)) {
                ans.add(word);
                // if the word is worthy, it gets inserted into the arraylist
            }
        }
        // remove any duplicate elements from the arraylist
        return new ArrayList<>(new HashSet<>(ans));
    }
}