/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class TriangleCoordinate
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;

    /**
     * Constructor for objects of class Point
     */
    public TriangleCoordinate(double x1, double y1)
    {
        x = x1;
        y = y1;
    }

    public double getX()  {  return x;  }
    public double getY()  {  return y;  }

    public int hashCode()
    {
       Double temp = x+y;
       return temp.hashCode();
    }

    public boolean equals(Object obj)
    {
       TriangleCoordinate temp = (TriangleCoordinate) obj;
       return Math.abs(x - temp.getX()) <= 0.05 && Math.abs(y - temp.getY()) <= 0.05;
    }

    public double getDistance(TriangleCoordinate tc) {
        return Math.hypot(x-tc.x, y-tc.y);
    }
}