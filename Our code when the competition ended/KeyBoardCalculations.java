import java.util.*;

/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class KeyBoardCalculations {

    public static final Map<String,ArrayList<String>> layout = new HashMap<>(26);
    public static final Map<String,Double> rtlPositions = new HashMap<>(26);

    // fill out the layout
    static {
        for(int i=0; i<26; i++) {
            layout.put(""+(char)('A'+i), new ArrayList<String>());
        }
        layout.get("A").add("Q");
        layout.get("A").add("W");
        layout.get("A").add("S");
//        layout.get("A").add("X");
        layout.get("A").add("Z");
        layout.get("B").add("V");
        layout.get("B").add("G");
        layout.get("B").add("H");
        layout.get("B").add("N");
        layout.get("C").add("X");
        layout.get("C").add("D");
        layout.get("C").add("F");
        layout.get("C").add("V");
        layout.get("D").add("E");
        layout.get("D").add("R");
        layout.get("D").add("F");
        layout.get("D").add("C");
        layout.get("D").add("X");
        layout.get("D").add("S");
        layout.get("E").add("W");
        layout.get("E").add("S");
        layout.get("E").add("D");
        layout.get("E").add("R");
        layout.get("F").add("R");
        layout.get("F").add("T");
        layout.get("F").add("G");
        layout.get("F").add("V");
        layout.get("F").add("C");
        layout.get("F").add("D");
        layout.get("G").add("T");
        layout.get("G").add("Y");
        layout.get("G").add("H");
        layout.get("G").add("B");
        layout.get("G").add("V");
        layout.get("G").add("F");
        layout.get("H").add("Y");
        layout.get("H").add("U");
        layout.get("H").add("J");
        layout.get("H").add("N");
        layout.get("H").add("B");
        layout.get("H").add("G");
        layout.get("I").add("U");
        layout.get("I").add("J");
        layout.get("I").add("K");
        layout.get("I").add("O");
        layout.get("J").add("U");
        layout.get("J").add("I");
        layout.get("J").add("K");
        layout.get("J").add("M");
        layout.get("J").add("N");
        layout.get("J").add("H");
        layout.get("K").add("I");
        layout.get("K").add("O");
        layout.get("K").add("L");
        layout.get("K").add("M");
        layout.get("K").add("J");
        layout.get("L").add("K");
        layout.get("L").add("O");
        layout.get("L").add("P");
        layout.get("M").add("N");
        layout.get("M").add("J");
        layout.get("M").add("K");
        layout.get("N").add("B");
        layout.get("N").add("H");
        layout.get("N").add("J");
        layout.get("N").add("M");
        layout.get("O").add("I");
        layout.get("O").add("K");
        layout.get("O").add("L");
        layout.get("O").add("P");
        layout.get("P").add("O");
        layout.get("P").add("L");
        layout.get("Q").add("A");
        layout.get("Q").add("W");
        layout.get("R").add("E");
        layout.get("R").add("D");
        layout.get("R").add("F");
        layout.get("R").add("T");
        layout.get("S").add("W");
        layout.get("S").add("E");
        layout.get("S").add("D");
        layout.get("S").add("X");
        layout.get("S").add("Z");
        layout.get("S").add("A");
        layout.get("T").add("R");
        layout.get("T").add("F");
        layout.get("T").add("G");
        layout.get("T").add("Y");
        layout.get("U").add("Y");
        layout.get("U").add("H");
        layout.get("U").add("J");
        layout.get("U").add("I");
        layout.get("V").add("C");
        layout.get("V").add("F");
        layout.get("V").add("G");
        layout.get("V").add("B");
        layout.get("W").add("Q");
        layout.get("W").add("A");
        layout.get("W").add("S");
        layout.get("W").add("E");
        layout.get("X").add("Z");
        layout.get("X").add("S");
        layout.get("X").add("D");
        layout.get("X").add("C");
        layout.get("Y").add("U");
        layout.get("Y").add("H");
        layout.get("Y").add("G");
        layout.get("Y").add("T");
        layout.get("Z").add("A");
        layout.get("Z").add("S");
        layout.get("Z").add("X");
    }

    //fill out the rtlPositions
    static {
        rtlPositions.put("Q", 0.0);
        rtlPositions.put("W", 1.0);
        rtlPositions.put("E", 2.0);
        rtlPositions.put("R", 3.0);
        rtlPositions.put("T", 4.0);
        rtlPositions.put("Y", 5.0);
        rtlPositions.put("U", 6.0);
        rtlPositions.put("I", 7.0);
        rtlPositions.put("O", 8.0);
        rtlPositions.put("P", 9.0);
        rtlPositions.put("A", 0.3);
        rtlPositions.put("S", 1.3);
        rtlPositions.put("D", 2.3);
        rtlPositions.put("F", 3.3);
        rtlPositions.put("G", 4.3);
        rtlPositions.put("H", 5.3);
        rtlPositions.put("J", 6.3);
        rtlPositions.put("K", 7.3);
        rtlPositions.put("L", 8.3);
        rtlPositions.put("Z", 0.6);
        rtlPositions.put("X", 1.6);
        rtlPositions.put("C", 2.6);
        rtlPositions.put("V", 3.6);
        rtlPositions.put("B", 4.6);
        rtlPositions.put("N", 5.6);
        rtlPositions.put("M", 6.6);
    }

    public static int kbDistance(String s1, String s2) {
//        if (s1.equals(s2) ) {
//            return 0;
//        }
//        if (s1.equals("W") && s2.equals("A") ) return 1;
//        if (s1.equals("A") && s2.equals("S") ) return 1;
//        if (s1.equals("E") && s2.equals("R") ) return 1;
//        if (s1.equals("W") && s2.equals("C") ) return 3;
//        if (s1.equals("Q") && s2.equals("M") ) return 8;
        Set<String> visited = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add(s1);
        int times = 0;
        while(!current.contains(s2)) {
//            System.out.println(current);
            Set<String> next = new HashSet<>();
            for(String s:current) {
                next.addAll(layout.get(s));
            }
            visited.addAll(current);
            current = next;
            current.removeAll(visited);
            times++;

            if(times>25) {
                throw new RuntimeException("Infinte loop detected :(");
            }
        }
        return times;
    }

    public static double averageDistance(String word) {
//        if (word.equals("WAS")) return 1.0;
//        if (word.equals("KING")) return 5.0 / 3.;
//        if (word.equals("SAMPLE")) return 19.0 / 5;
//        if (word.equals("COMPUTER")) return 19.0 / 7;
//        if (word.equals("AVERAGE")) return 18/6.;
//        if (word.equals("ALABAMA")) return 40.0 / 6;
        double distance = 0;
        for(int i = 0; i<word.length()-1; i++) {
            distance += kbDistance(word.substring(i,i+1), word.substring(i+1, i+2));
        }
        return distance / (word.length()-1);
    }

    public static int numDirectionChanges(String word)
    {
//        if (word.equals("MIK")) return 0;
//        if (word.equals("MJU")) return 0;
//        if (word.equals("WZA")) return 0;
//        if (word.equals("NHY")) return 0;
//        if (word.equals("JUM")) return 1;
//        if (word.equals("WAZ")) return 1;
//        if (word.equals("TFV")) return 1;

//        if (word.equals("KING")) return 0;
//        if (word.equals("WAS")) return 1;
//        if (word.equals("SAMPLE")) return 2;
//        if (word.equals("COMPUTER")) return 4;
//        if (word.equals("AVERAGE")) return 5;
//        if (word.equals("ALABAMA")) return 5;
        int count = 0;
        for(int i = 0; i<word.length()-2; i++) {
            if(Math.signum(rtlPositions.get(word.substring(i+1,i+2))-rtlPositions.get(word.substring(i,i+1))) !=
                    Math.signum(rtlPositions.get(word.substring(i+2,i+3))-rtlPositions.get(word.substring(i+1,i+2)))) {
                count++;
            }
        }
        return count;
    }

    public static String wordDifficulty(String word) {
//        if (word.equals("WAS")) return "elementary";
//        if (word.equals("KING")) return "basic";
//        if (word.equals("SAMPLE")) return "so-so";
//        if (word.equals("COMPUTER")) return "average";
//        if (word.equals("AVERAGE")) return "demanding";
//        if (word.equals("ALABAMA")) return "challenging";
        if(word.length()<4 && averageDistance(word)<2 && numDirectionChanges(word)<=1) {
            return "elementary";
        }
        else if(word.length()<7 && averageDistance(word)<3 && numDirectionChanges(word)<=2) {
            return "basic";
        }
        else if(word.length()<9 && averageDistance(word)<4 && numDirectionChanges(word)<=3) {
            return "so-so";
        }
        else if(word.length()<9 && averageDistance(word)<4 && numDirectionChanges(word)<=3) {
            return "so-so";
        }
        else if(word.length()<10 && averageDistance(word)<5 && numDirectionChanges(word)<=4) {
            return "average";
        }
        else if(word.length()<10 && averageDistance(word)<6 && numDirectionChanges(word)<=5) {
            return "demanding";
        }
        else {
            return "challenging";
        }
    }
}