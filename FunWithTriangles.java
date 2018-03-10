/**
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class FunWithTriangles {
    private TriangleCoordinate midpoint;
    private double slope;
    private double baseLength;

    /**
     * Creates a new instance of FunWithTriangles. Note that the points are not saved because they don't
     * need to be saved; it only saves the information necessary to solve the problems.
     *
     * @param ptA One endpoint of the base
     * @param ptB Another endpoint of the base
     */
    public FunWithTriangles(TriangleCoordinate ptA, TriangleCoordinate ptB) {
        midpoint = new TriangleCoordinate((ptA.getX()+ptB.getX())/2, (ptA.getY()+ptB.getY())/2);
        slope = (-1.0) / ((ptA.getY()-ptB.getY()) / (ptA.getX()-ptB.getX()));
        baseLength = ptA.getDistance(ptB);
    }

    /**
     * Given two Vertices A and B of a rtiangle,
     * there are two verices such that the triangle is isosceles and has area == myArea
     * return the TriangleCoordinate of the third vertice with larger x value
     * If both vertices have the same x coordinate, return the vetex witht he larger y coordinate
     */
    public TriangleCoordinate generateAreaWithLargestXcoordinate(double area) {
        double height = 2*area/baseLength;
        double x = midpoint.getX();
        double y = midpoint.getY();
        if(slope != slope) {
            y += height;
        }
        else {
            x += height * Math.cos(Math.atan(slope));
            y += height * Math.sin(Math.atan(slope));
        }
        return new TriangleCoordinate(x, y);
    }

    /**
     * Given two Vertices A and B of a rtiangle,
     * there are two verices such that the triangle is isosceles and has area == myArea
     * return the TriangleCoordinate of the third vertice with smaller x value
     * IF both vertices have the same x coordinate, return the vetex witht he smaller y coordinate
     */    
    public TriangleCoordinate generateAreaWithSmallestXcoordinate(double area) {
        double height = 2*area/baseLength;
        double x = midpoint.getX();
        double y = midpoint.getY();
        if(slope != slope) {
            y -= height;
        }
        else {
            x -= height * Math.cos(Math.atan(slope));
            y -= height * Math.sin(Math.atan(slope));
        }
        return new TriangleCoordinate(x, y);
    }
}