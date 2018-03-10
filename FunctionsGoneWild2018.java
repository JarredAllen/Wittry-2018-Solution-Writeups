/**
 * Be warned: a variation upon this problem appears every year. Expect something like this to appear again.
 *
 * @author Don Allen
 * @author Alexander Tsao
 * @author Jarred Allen
 * @version 2018 Wittry Programming contest
 */
public class FunctionsGoneWild2018 {
    /*
     *   borrowed from March 2017 issue of NCTM  monthly magizine
     *
     *
     *     return the smallest positive value of d such that n + d is a perfect square
     *
     *     you may assume n + d is not too big
     */
    public static int f1(int n) {
        int d = 0;
        for(;((int)Math.sqrt(n+d))*((int)Math.sqrt(n+d)) != n+d; d++);
        return d;
    }


    /**
     * Returns the number of integers that satisfies the inequality:
     *
     * low < 5y + 7 <= high
     * or, equivalently:
     * (low-7)/5 < y <= (high-7)/5
     */
    public static int f2(int low, int high) {
        int first = (int)Math.ceil((low-6)/5d); //6 instead of 7 because (low-7)/5 is NOT included
        int last = (int)Math.floor((high-7)/5);
//        System.out.printf("(%d,%d) => (%d,%d)\n", low, high, first, last);
        // that commented out line is just debugging information as I tweaked the bounds
        if(last <= first) {
            return 0;
            //This is necessary to appropriately handle there being no numbers included.
        }
        return last-first+1;
    }

    /**
     * Returns the result of the given piecewise recursive function
     *
     * Nested if/else is the best way to handle piecewise functions and recursion is the best
     * way to handle recursive function definitions.
     */
    public static int f3(int n) {
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

    /**
     * Returns the result of the given summation
     */
    public static int f4(int a, int b, int c) {
        if(Math.max(a+b*c,c+b*a)<Math.min(b*a-c,b*c-a))return 0;
        int sum = 0;
        for(int i = Math.min(b*a-c,b*c-a); i <= Math.max(a+b*c,c+b*a); i++){
            // Implement summation methods via a for-loop and increasing a variable which tracks
            // the running sum.
            sum += i*(c+2*b*i)/(1+Math.abs(a-i))+(b+(c+3)*a*i)/(1+i/c)+i*(i+3*a*b);
        }
        return sum;
    }

    /**
     * Returns the value of the given function, which is just chaining calls to
     * methods in the Math class.
     */
    public static double f5(double x, double y) {
        return Math.pow(Math.abs(Math.tan(Math.E-3*y)/Math.sin(y)),Math.PI*Math.cos(x));
    }

    /**
     * Returns the value of the given piecewise function.
     *
     * If/else is the best way to handle piecewise functions
     */
    public static double f6(double x, double y, double z) {
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
    public static String[] f7(String phrase, int num) {
        String[] ans = new String[num];
        for(int i = 0; i < ans.length; i++){
            String build = "";
            for(int k = 0; k < phrase.length(); k++){
                if(k%num==i){
                    build += phrase.charAt(k);
                    // Note that string concatenations within a loop are inefficient, and you
                    // should use the StringBuilder class for it, instead.
                    // However, this problem is not very performance sensitive, so this is
                    // is acceptible.
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
    public static String f8(String phrase) {
        return phrase.replace('A','l').replace('B','c').replace('C','b')
                .replace('D','j').replace('E','i').replace('F','h')
                .replace('G','g').replace('H','f').replace('I','e')
                .replace('J','d').replace('K','s').replace('L','a')
                .replace('M','z').replace('N','x').replace('O','w')
                .replace('P','q').replace('Q','p').replace('R','u')
                .replace('S','k').replace('T', 'y').replace('U','r')
                .replace('V','v').replace('W','o').replace('X','n')
                .replace('Y','t').replace('Z','m').toUpperCase();
        // because it will be only given upper-case letters, a letter being lower-case signifies that
        // it has already been replaced with the appropriate letter.
        // the call to toUpperCase at the end returns all the letters to the original upper-case
    }

    /**
     * Implements the specified truth table as a boolean function
     */
    public static boolean f9(boolean x, boolean y, boolean z) {
        return x&&z||!x&&!y;
        // this simplified version of the function was obtained via Karnaugh-mapping.
        // an explanation can be found at https://www.youtube.com/watch?v=b4JiIknHm1Y
    }

    /**
     * Implements the specified truth table as a boolean function
     */
    public static boolean f10(boolean j, boolean k, boolean m, boolean n) {
        return j&&n || !j&&k&&m&&!n || j&&k&&!m || !m&&n || !j&&!k&&!m;
    }
}