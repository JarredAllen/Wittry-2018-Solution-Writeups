import java.util.*;
/**
 * @author Don Allen
 * @author Alexander Tsao
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class TheDoors {
    private List<Switches> mySwitches;
    private int numDoors;

    public TheDoors(List<Switches> s, int nd) {
        mySwitches = s;
        numDoors = nd;
    }

    /**
     * Returns an ArrayList containing the switches to be flipped for
     * reaching the specified goal.
     */
    public ArrayList<Switches> findSwitchCombination(int[] goal) {
        // turn input into an array of the requested state of each door
        boolean[] doorGoal = new boolean[numDoors];
        for(int n: goal){
            doorGoal[n] = true;
        }
        // build up a list of all possibilities up gradually, starting at one item
        // and then expanding element by element to always hit the smallest
        List<HashSet<Switches>> pos = new ArrayList<>();
        for(Switches s : mySwitches){
            HashSet<Switches> t = new HashSet<>();
            t.add(s);
            if(works(t,doorGoal)){
                return new ArrayList<>(t); // it found a one-door solution
            }
            else{
                pos.add(t);
            }
        }
        for(int i = 1; i < mySwitches.size(); i++){
            // continue for increasing numbers of switches, to always hit the best one
            List<HashSet<Switches>> temp = new ArrayList<>();
            for(Set<Switches> s : pos) { // for each existing set of i switches
                for(Switches sw : mySwitches) { // try each of the other switches in turn
                    HashSet<Switches> t = new HashSet<>();
                    t.addAll(s);
                    t.add(sw);
                    if(t.size()==i+1) {
                        // exclude solutions where one switch was selected multiple times
                        if(works(t,doorGoal)) {
                            return new ArrayList<>(t);
                        }
                        if(!temp.contains(t)) {
                            temp.add(t);
                        }
                    }
                }
            }
            pos = temp;
        }

        return new ArrayList<>(0);
    }

    /**
     *  Returns true if and only if the given combination of switches results in the
     *  goal for the doors.
     */
    private boolean works(Set<Switches> test, boolean[] goal){
        boolean[] current = new boolean[goal.length];
        for(Switches s : test){
            int[] doors = s.getSwitch();
            for(int i : doors) {
                current[i] ^= true;
                //flips the value of the door because the switch being tried changed its state
            }
        }
        return Arrays.equals(current, goal);
    }
}