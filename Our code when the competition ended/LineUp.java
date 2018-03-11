import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class LineUp
{
    private List<Player> myTeam;

    public LineUp()
    {
        myTeam = new ArrayList<Player>();
    }

    /*
     *    precondition:    ps.size() == 9
     *                     ps.get(i) != null for all i, 0 <= i < 9
     *                    
     *    post condition:  do not modify ps
     *                     all elements previously contained in myTeam are removed
     *                     myTeam.size() == 9
     */
    public void addPlayers(List<Player> ps)
    {
        myTeam = new ArrayList<Player>();
        for (Player p : ps)
            myTeam.add(p);
    }
    
/*
   public void testLineUp01()
   {
      LineUp lu = new LineUp();
      Player seager = new Player("Seager", 150, 50, 9, 2, 6, 8);

      List<Player> ps = new ArrayList<Player>();
      ps.add(seager);
      ps.add(new Player("Ruth", 135, 52, 10, 1, 17, 12));
      ps.add(new Player("Trout", 145, 40, 18, 5, 13, 9));
      ps.add(new Player("Beltre", 175, 45, 3, 0, 1, 2));
      ps.add(new Player("Alltuve", 125, 72, 23, 5, 10, 11));
      ps.add(new Player("Bellinger", 150, 40, 11, 0, 14, 7));
      ps.add(new Player("Puig", 160, 45, 13, 3, 7, 7));
      ps.add(new Player("Ohtani", 115, 25, 2, 0, 6, 4));
      ps.add(new Player("Arenado", 155, 51, 19, 0, 16, 10));
      lu.addPlayers(ps);

      assertEquals(new Player("Alltuve", 125, 72, 23, 5, 10, 11), lu.getCleanUp());
      assertEquals(new Player("Ruth", 135, 52, 10, 1, 17, 12), lu.getLeadOff());
      assertEquals(new Player("Arenado", 155, 51, 19, 0, 16, 10), lu.getThirdBatter());
      assertEquals(new Player("Trout", 145, 40, 18, 5, 13, 9), lu.getSecondBatter());
   }
    
*/    

    /*
     *   The clean up batter (bats fourth) is the Player with the highest slugging percentage.
     *   In case of tie, pick the Player with most HRs,
     *   if still tied pick Player with greatest Batting average.
     */
    public Player getCleanUp()
    {
        List<Player> possPlayers = getMax("slugging", myTeam);
        if(possPlayers.size() > 1){
            possPlayers = getMax("home", possPlayers);
        }
        if(possPlayers.size() > 1){
            possPlayers = getMax("batting", possPlayers);
        }

        return possPlayers.get(0);
    }

    /*   
     *   The leadoff batter (bats first) is the player with the highest on Base Percentage.
     *   In case of tie, pick the Player with greatest Batting average,
     *   if still tied pick Player with most singles.
     */
    public Player getLeadOff()
    {
        List<Player> possPlayers = new ArrayList<>(myTeam);
        possPlayers.remove(getCleanUp());
        possPlayers = getMax("onBase", possPlayers);
        if(possPlayers.size() > 1){
            possPlayers = getMax("batting", possPlayers);
        }
        if(possPlayers.size() > 1){
            possPlayers = getMax("singles", possPlayers);
        }
        return possPlayers.get(0);
    }

    /*
     * 	 The Player batting third is the Player with the greatest number of Hits.
     *   In case of tie, pick the Player with most number of At Bats,
     *   if still tied pick Player with most doubles plus triples.
     */
    public Player getThirdBatter()
    {
        List<Player> possPlayers = new ArrayList<>(myTeam);
        possPlayers.remove(getCleanUp());
        possPlayers.remove(getLeadOff());
        possPlayers = getMax("hits", possPlayers);
        if(possPlayers.size() > 1){
            possPlayers = getMax("atBats", possPlayers);
        }
        if(possPlayers.size() > 1){
            possPlayers = getMax("d+t", possPlayers);
        }
        return possPlayers.get(0);
    }

    /*
     *   The Player batting second is the Player with the most base on balls.
     *   In case of tie, pick the Player with highest on Base Percentage,
     *   if still tied pick Player with most triples.
     */
    public Player getSecondBatter()
    {
        List<Player> possPlayers = new ArrayList<>(myTeam);
        possPlayers.remove(getCleanUp());
        possPlayers.remove(getLeadOff());
        possPlayers.remove(getThirdBatter());
        possPlayers = getMax("baseOn", possPlayers);
        if(possPlayers.size() > 1){
            possPlayers = getMax("onBase", possPlayers);
        }
        if(possPlayers.size() > 1){
            possPlayers = getMax("triples", possPlayers);
        }
        return possPlayers.get(0);
    }

    public List<Player> getMax(String type, List<Player> myTeam){
        List<Double> vals = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        switch(type){
            case "slugging":
                for(Player p : myTeam) vals.add(p.getSluggingPercent());
                double maxSlugging = maximum(vals);
                for(Player p : myTeam)
                    if(p.getSluggingPercent() == maxSlugging) players.add(p);
                return players;
            case "home":
                for(Player p : myTeam) vals.add(p.getNumHomeRuns() + 0.);
                double maxRuns = maximum(vals);
                for(Player p : myTeam)
                    if(p.getSluggingPercent() == maxRuns) players.add(p);
                return players;
            case "batting":
                for(Player p : myTeam) vals.add(p.getBattingAverage() + 0.);
                double maxBats = maximum(vals);
                for(Player p : myTeam)
                    if(p.getSluggingPercent() == maxBats) players.add(p);
                return players;
            case "onBase":
                for(Player p : myTeam) vals.add(p.getOnBasePercentage() + 0.);
                double maxOn = maximum(vals);
                for(Player p : myTeam)
                    if(p.getOnBasePercentage() == maxOn) players.add(p);
                return players;
            case "singles":
                for(Player p : myTeam) vals.add(p.getNumSingles() + 0.);
                double maxSin = maximum(vals);
                for(Player p : myTeam)
                    if(p.getNumSingles() == maxSin) players.add(p);
                return players;
            case "hits":
                for(Player p : myTeam) vals.add(p.getNumHits() + 0.);
                double maxHits = maximum(vals);
                for(Player p : myTeam)
                    if(p.getNumHits() == maxHits) players.add(p);
                return players;
            case "atBats":
                for(Player p : myTeam) vals.add(p.getNumAtBats() + 0.);
                double maxAtBats = maximum(vals);
                for(Player p : myTeam)
                    if(p.getNumAtBats() == maxAtBats) players.add(p);
                return players;
            case "d+t":
                for(Player p : myTeam) vals.add(p.getNumDoubles() + p.getNumTriples() + 0.);
                double maxDT = maximum(vals);
                for(Player p : myTeam)
                    if((p.getNumDoubles() + p.getNumTriples()) == maxDT) players.add(p);
                return players;
            case "triples":
                for(Player p : myTeam) vals.add(p.getNumTriples() + 0.);
                double maxT = maximum(vals);
                for(Player p : myTeam)
                    if((p.getNumTriples()) == maxT) players.add(p);
                return players;
            case "baseOn":
                for(Player p : myTeam) vals.add(p.getNumWalks() + 0.);
                double maxWalks = maximum(vals);
                for(Player p : myTeam)
                    if((p.getNumWalks()) == maxWalks) players.add(p);
                return players;
             default:
                 return null;
        }
    }

    public double maximum(List<Double> vals){
        double maximum = Double.MIN_VALUE;
        for(double val : vals) maximum = Math.max(maximum, val);
        return maximum;
    }
}