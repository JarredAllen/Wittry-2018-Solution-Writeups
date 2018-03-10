import java.util.*;
/**
 * @author Don Allen
 * @author Alexander Tsao
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class TheDoors {
    /*
     *      mySwitches.size() == number of switches
     *      
     *      mySwitches.get(1).length == the number doors switch i toggles
     *          mySwitches.get(i).get(k) is a door switch i toggles
     */
    private List<Switches> mySwitches;
    private int numDoors;

    public TheDoors(List<Switches> s, int nd) {
        mySwitches = s;
        numDoors = nd;
    }

    public ArrayList<Switches> findSwitchCombination(int[] goal) {
        ArrayList<Switches> solutions = new ArrayList<Switches>();

        boolean[] doorgoal = new boolean[numDoors];
        for(int i = 0; i < doorgoal.length; i++){
            for(int n : goal){
                if(i==n)doorgoal[i] = true;
            }
        }
        List<HashSet<Switches>> pos = new ArrayList<HashSet<Switches>>();
        for(Switches s : mySwitches){
            HashSet<Switches> t = new HashSet<Switches>();
            t.add(s);
            if(works(t,doorgoal)){
                solutions.add(s);
                return solutions;
            }else{
                pos.add(t);
            }

        }
        for(int i = 1; i < mySwitches.size(); i++){
            List<HashSet<Switches>> temp = new ArrayList<>();
            for(Set<Switches> s : pos){
                for(Switches sw : mySwitches){
                    HashSet<Switches> t = new HashSet<Switches>();
                    t.addAll(s);
                    t.add(sw);
                    if(t.size()==i+1){
                        if(works(t,doorgoal)){
                            for(Switches swit : t){
                                solutions.add(swit);
                            }
                            return solutions;
                        }
                        if(!temp.contains(t))temp.add(t);
                    }
                }
            }
            pos = temp;
        }

        return solutions;
    }
    private boolean works(Set<Switches> test, boolean[] goal){
        boolean[] current = new boolean[goal.length];
        for(Switches s : test){
            int[] doors = s.getSwitch();
            for(int i : doors){
                current[i] = !current[i];
            }
        }
        return Arrays.equals(current, goal);
    }
}