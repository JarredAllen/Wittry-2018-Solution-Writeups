import java.util.*;
/**
 * @author Don Allen
 * @author Ahmed Abdalla
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class LineUp {

    /**
     * A comparator that compares Player objects by a specific statistic which is passed
     * in during the constructor. It contains support for any of the relevant metrics to
     * this problem.
     */
    public static class PlayerComparator implements Comparator<Player> {
        private String stat;

        /**
         * Creates a new PlayerComparator to compare by a metric.
         *
         * @param stat The value to compare by. Must be one of: "slugging", "home runs", "batting average",
         *             "on base percentage", "singles", "hits", "at bats", "doubles plus triples", "walks"
         */
        public PlayerComparator(String stat) {
            this.stat = stat;
        }

        /**
         * Compares the two player objects and returns 1, 0, or -1 as appropriate for
         * a Comparator.
         */
        public int compare(Player a, Player b) {
            return Double.compare(getValue(a), getValue(b));
        }

        /**
         * Returns the appropriate metric of the given player.
         */
        private double getValue(Player p) {
            switch(stat) {
                case "slugging":
                    return p.getSluggingPercent();

                case "home runs":
                    return p.getNumHomeRuns();

                case "batting average":
                    return p.getBattingAverage();

                case "on base percentage":
                    return p.getOnBasePercentage();

                case "singles":
                    return p.getNumSingles();

                case "hits":
                    return p.getNumHits();

                case "at bats":
                    return p.getNumAtBats();

                case "doubles plus triples":
                    return p.getNumDoubles()+p.getNumTriples();

                case "walks":
                    return p.getNumWalks();

                case "triples":
                    return p.getNumTriples();

                default:
                    throw new RuntimeException("Unexpected statistic to compare: "+stat);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof PlayerComparator && stat.equals(((PlayerComparator)obj).stat);
        }

        public int hashCode() {
            return stat.hashCode();
        }
    }

    /**
     * This is a comparator used for implementing sorting with tiebreakers.
     * It takes the first comparator in its list and returns the value that it returns.
     */
    public static class ComparatorCombinor<T> implements Comparator<T> {
        private List<Comparator<T>> comparators;
        public ComparatorCombinor(List<Comparator<T>> comparators) {
            this.comparators = comparators;
        }
        public ComparatorCombinor(Comparator<T>[] comparators) {
            this.comparators = Arrays.asList(comparators);
        }

        /**
         * Compares a and b by returning the first nonzero value returned by one of the comparators contained
         * in its list. If all of them return 0, this returns 0.
         */
        public int compare(T a, T b) {
            int val;
            for(Comparator<T> comp:comparators) {
                val = comp.compare(a, b);
                if(val != 0) {
                    return val;
                }
            }
            return 0;
        }

        public int hashCode() {
            return comparators.hashCode();
        }

        /**
         * Two ComparatorCombinors are equal if and only if they have equal lists of comparators.
         */
        public boolean equals(Object obj) {
            return obj instanceof ComparatorCombinor && comparators.equals(((ComparatorCombinor)obj).comparators);
        }
    }

    private List<Player> myTeam;

    public LineUp() {
        myTeam = new ArrayList<>(9);
    }

    /**
     *    precondition:    ps.size() == 9
     *                     ps.get(i) != null for all i, 0 <= i < 9
     *                    
     *    post condition:  do not modify ps
     *                     all elements previously contained in myTeam are removed
     *                     myTeam.size() == 9
     */
    public void addPlayers(List<Player> ps) {
        myTeam.clear();
        myTeam.addAll(ps);
    }

    /**
     * The clean up batter (bats fourth) is the Player with the highest slugging percentage.
     * In case of tie, pick the Player with most HRs,
     * if still tied pick Player with greatest Batting average.
     */
    public Player getCleanUp() {
        ArrayList<Player> team = new ArrayList<>(myTeam); // make a new ArrayList to avoid changing the current line-up
        PlayerComparator[] comps = {new PlayerComparator("slugging"),
                                    new PlayerComparator("home runs"),
                                    new PlayerComparator("batting average")};
        ComparatorCombinor<Player> cleanUp = new ComparatorCombinor<>(comps);
        team.sort(cleanUp);
        return team.get(team.size()-1);
    }

    /**
     * The leadoff batter (bats first) is the player with the highest on Base Percentage.
     * In case of tie, pick the Player with greatest Batting average,
     * if still tied pick Player with most singles.
     */
    public Player getLeadOff() {
        ArrayList<Player> team = new ArrayList<>(myTeam); // make a new ArrayList to avoid changing the current line-up
        team.remove(getCleanUp()); // remove the players already in a different spot
        PlayerComparator[] comps = {new PlayerComparator("on base percentage"),
                                    new PlayerComparator("batting average"),
                                    new PlayerComparator("singles")};
        ComparatorCombinor<Player> cleanUp = new ComparatorCombinor<>(comps);
        team.sort(cleanUp);
        return team.get(team.size()-1);
    }

    /**
     * The Player batting third is the Player with the greatest number of Hits.
     * In case of tie, pick the Player with most number of At Bats,
     * if still tied pick Player with most doubles plus triples.
     */
    public Player getThirdBatter() {
        ArrayList<Player> team = new ArrayList<>(myTeam); // make a new ArrayList to avoid changing the current line-up
        team.remove(getCleanUp()); // remove the players already in a different spot
        team.remove(getLeadOff());
        PlayerComparator[] comps = {new PlayerComparator("hits"),
                                    new PlayerComparator("at bats"),
                                    new PlayerComparator("doubles plus triples")};
        ComparatorCombinor<Player> cleanUp = new ComparatorCombinor<>(comps);
        team.sort(cleanUp);
        return team.get(team.size()-1);
    }

    /**
     * The Player batting second is the Player with the most base on balls.
     * In case of tie, pick the Player with highest on Base Percentage,
     * if still tied pick Player with most triples.
     */
    public Player getSecondBatter() {
        ArrayList<Player> team = new ArrayList<>(myTeam); // make a new ArrayList to avoid changing the current line-up
        team.remove(getCleanUp()); // remove the players already in a different spot
        team.remove(getLeadOff());
        team.remove(getThirdBatter());
        PlayerComparator[] comps = {new PlayerComparator("walks"),
                                    new PlayerComparator("on base percentage"),
                                    new PlayerComparator("triples")};
        ComparatorCombinor<Player> cleanUp = new ComparatorCombinor<>(comps);
        team.sort(cleanUp);
        return team.get(team.size()-1);
    }
}