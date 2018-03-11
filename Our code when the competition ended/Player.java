/**
 * Write a description of class Player here.
 * 
 * @author Don Allen
 * @version 2018 Wittry contest
 */
public class Player
{
    private String myName;
    private int myABs;
    private int myHits;
    private int my2Bs;
    private int my3Bs;
    private int myHRs;
    private int myBBS;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int ab, int hits, int doubles, int triples, int hrs, int bbs)
    {
        myName = name;
        myABs= ab;
        myHits = hits;
        my2Bs = doubles;
        my3Bs = triples;
        myHRs = hrs;
        myBBS = bbs;
    }

    public String getName()  {  return myName;  }

    public int getNumAtBats()   {  return myABs;  }

    public int getNumHits()  {  return myHits;  }

    public int getNumDoubles()   {  return my2Bs;  }

    public int getNumTriples()  {  return my3Bs;  }

    public int getNumHomeRuns()   {  return myHRs;  }

    public int getNumWalks()  {  return myBBS;  }

    public int getNumSingles()
    {
        return getNumHits() - getNumDoubles() - getNumTriples() - getNumHomeRuns();
    }

    /*
     *   returns (singles + 2*doubles + 3triple + 4*hr) / at Bats
     */
    public double getSluggingPercent()
    {
        double totalBases = getNumSingles() + 2. * getNumDoubles() + 3. * getNumTriples() + 4. * getNumHomeRuns();
        return totalBases/getNumAtBats();
    }

    /*
     *   returns  hits / at Bats
     */
    public double getBattingAverage()
    {
        return getNumHits() / (double)getNumAtBats();
    }

    /*
     *   returns (hits + base on Balls) / (at Bats + Base on Balls)
     */
    public double getOnBasePercentage()
    {
        return (getNumHits() + getNumWalks()) / (double)((getNumAtBats() + getNumWalks()));
    }

    public int hashCode()
    {
        Integer num = new Integer(myABs + myHits + my2Bs + my3Bs + myHRs + myBBS);
        return myName.hashCode() + num.hashCode();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Player) )
           return false;
        Player p = (Player)obj;
        return p.myABs == myABs && p.myHits == myHits && p.my2Bs == my2Bs 
                && p.my3Bs == my3Bs && p.myHRs == myHRs && p.myBBS == myBBS
                && p.myName.equals(myName);
    }
}