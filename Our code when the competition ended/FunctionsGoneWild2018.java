import java.util.*;
import java.lang.Math;
/**
 * The test class FunctionsGoneWild2015.
 *
 * @author  Don Allen
 * @version 2018 Wittry Programming contest
 */
public class FunctionsGoneWild2018
{
    /*
     *   borrowed from March 2017 issue of NCTM  monthly magizine
     *   
     *   
     *     return the smallest positive value of d such that n + d is a perfect square
     *     
     *     you may assume n + d is not too big
     */
    public static int f1(int n)
    {
        int d = 0;
        boolean flag = false;
        while(!flag) {
            int temp = n + d;
            int root = (int) Math.sqrt((double) temp);
            if (root * root == temp) flag = true;
            else d++;
        }
        return d;
    }

    
    /*
     *    Implement the following function which returns the number of ints that satisfies the inequality:
     *    
     *    low < 5y + 7 <= high
     */   
    public static int f2(int low, int high)
    {
        int i = (high-7)/5 - (low-7)/5;
        if((low-7)/5 < 0)i++;
        return i;
    }

    public static int f3(int n)
    {
        if(n>=100){
            if(n%2==0){
                return f3(3*n/5-1)-2;
            }else{
                return f3((2*n-13)/21)-n/3;
            }
        }else{
            if(n>50){
                return f3(2*n/5)-f3((n-5)/3)/2;
            }else{
                return n*n+3*n-19;
            }
        }
    }
    

    public static int f4(int a, int b, int c)
    {
        if(Math.max(a+b*c,c+b*a)<Math.min(b*a-c,b*c-a))return 0;
        int sum = 0;
        for(int i = Math.min(b*a-c,b*c-a); i <= Math.max(a+b*c,c+b*a); i++){
            sum += i*(c+2*b*i)/(1+Math.abs(a-i))+(b+(c+3)*a*i)/(1+i/c)+i*(i+3*a*b);
        }
        return sum;
    }

    public static double f5(double x, double y)
    {
        return Math.pow(Math.abs(Math.tan(Math.E-3*y)/Math.sin(y)),Math.PI*Math.cos(x));
    }

    public static double f6(double x, double y, double z)
    {
        if(Math.log(Math.abs(x))>y+z)
            return Math.pow(Math.PI, x/Math.E) + Math.pow(Math.log10(Math.abs(y+z)),Math.log10(Math.abs(x+y)));
        else
            return Math.log10(Math.abs(x-y)) + Math.log(Math.abs(z-y));
    }

    /*
    precondition phrase.length > 0 
                 num > 0
    
    F7("Sample", 2)
       returns {"SML", "APE"}
    F7("HELP ME FIGURE THIS OUT :(", 3)
       returns {"HPEIRTSU", "E  GEH T(", "LMFU IO "}
    F7("COMPUTER SCIENCE", 4)
       returns {"CU E", "OTSN", "MECC", "PRIE"}
    F7("TO ITERATE IS HUMAN, TO RECURSE DIVINE", 5)
       returns {"TE U EEI", "ORIMTC N", " ASAOUDE", "IT N RI", "TEH,RSV"}
    F7("1234567890", 5)
       returns {"16", "27", "38", "49", "50"}
    F7("@ABC!", 7)
       returns {"@", "A", "B", "C", "!", "", ""}
     */
    public static String[] f7(String phrase, int num)
    {
        String[] ans = new String[num];
        for(int i = 0; i < ans.length; i++){
            String build = "";
            for(int k = 0; k < phrase.length(); k++){
                if(k%num==i){
                    build+=phrase.charAt(k);
                }
            }
            ans[i] = build;
        }
        return ans;
    }

    /*
     *     precondtion:  phrase and String will only contain:
     *                      Upper case letters
     *                      spaces
     *
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        return phrase.replace('A','l').replace('B','c').replace('C','b')
                .replace('D','j').replace('E','i').replace('F','h')
                .replace('G','g').replace('H','f').replace('I','e')
                .replace('J','d').replace('K','s').replace('L','a')
                .replace('M','z').replace('N','x').replace('O','w')
                .replace('P','q').replace('Q','p').replace('R','u')
                .replace('S','k').replace('T', 'y').replace('U','r')
                .replace('V','v').replace('W','o').replace('X','n')
                .replace('Y','t').replace('Z','m').toUpperCase();

    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        return x&&z||!x&&!y;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n)
    {
        return !m&&!n||j&&k&&m&&n||!j&&k&&m&&!n||j&&k&&!n&&!n||!j&&!k&&!m&&!n;
    }
}