import junit.framework.TestCase;

import java.util.*;

/**
 * The test class studentTest.
 *
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry programming contest
 */
public class FunWithTrianglesStudentTest extends junit.framework.TestCase {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
    }

    public void testGenerateArea01() {
//   base with slope -1
        TriangleCoordinate x = new TriangleCoordinate(6,0);
        TriangleCoordinate y = new TriangleCoordinate(0, 6);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(6);    //   (2,2) or (4,4)
        assertEquals(4.0, ans.getX(), 0.05);
        assertEquals(4.0, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(6);                       //   (2,2) or (4,4)
        assertEquals(2.0, ans.getX(), 0.05);
        assertEquals(2.0, ans.getY(), 0.05);

//   Horizontal base
        x = new TriangleCoordinate(-5,0);
        y = new TriangleCoordinate(5, 0);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(35);            //   (0,7) or (0,-7)
        assertEquals(0.0, ans.getX(), 0.05);
        assertEquals(7.0, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(35);
        assertEquals(0.0, ans.getX(), 0.05);
        assertEquals(-7.0, ans.getY(), 0.05);

//   Vertical base
        x = new TriangleCoordinate(5, 3);
        y = new TriangleCoordinate(5, 9);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(30);            //   (15,6) or (-5, 6)
        assertEquals(15, ans.getX(), 0.05);
        assertEquals(6, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(30);            //   (15,6) or (-5, 6)
        assertEquals(-5, ans.getX(), 0.05);
        assertEquals(6, ans.getY(), 0.05);
      

//   base with random slope
        x = new TriangleCoordinate(-10,3);
        y = new TriangleCoordinate(-2, 9);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(50);            //   (0.0, -2.0) or (-12.0, 14.0)
        assertEquals(0.0, ans.getX(), 0.05);
        assertEquals(-2.0, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(50);            //   (0.0, -2.0) or (-12.0, 14.0)
        assertEquals(-12.0, ans.getX(), 0.05);
        assertEquals(14.0, ans.getY(), 0.05);
    }

    public void testGenerateArea02() {
        //An area of 0
        FunWithTriangles fwt = new FunWithTriangles(new TriangleCoordinate(0,0), new TriangleCoordinate(10,0));
        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(0);
        assertEquals(5.0, ans.getX(), 0.001);
        assertEquals(0.0, ans.getY(), 0.001);
        ans = fwt.generateAreaWithSmallestXcoordinate(0);
        assertEquals(5.0, ans.getX(), 0.001);
        assertEquals(0.0, ans.getY(), 0.001);

        //Midpoint at origin
        fwt = new FunWithTriangles(new TriangleCoordinate(-1, 0), new TriangleCoordinate(1,0));
        ans = fwt.generateAreaWithLargestXcoordinate(5);
        assertEquals(0.0, ans.getX(), 0.001);
        assertEquals(5.0, ans.getY(), 0.001);
        ans = fwt.generateAreaWithSmallestXcoordinate(5);
        assertEquals(0.0, ans.getX(), 0.001);
        assertEquals(-5.0, ans.getY(), 0.001);

        //Ending point at the origin
        fwt = new FunWithTriangles(new TriangleCoordinate(-1, -1), new TriangleCoordinate(-1,1));
        ans = fwt.generateAreaWithLargestXcoordinate(1);
        assertEquals(0.0, ans.getX(), 0.001);
        assertEquals(0.0, ans.getY(), 0.001);
        ans = fwt.generateAreaWithSmallestXcoordinate(1);
        assertEquals(-2.0, ans.getX(), 0.001);
        assertEquals(0.0, ans.getY(), 0.001);

        //A vertex at the origin
        fwt = new FunWithTriangles(new TriangleCoordinate(-1, 0), new TriangleCoordinate(0,0));
        ans = fwt.generateAreaWithLargestXcoordinate(1);
        assertEquals(-0.5, ans.getX(), 0.001);
        assertEquals(2.0, ans.getY(), 0.001);
        ans = fwt.generateAreaWithSmallestXcoordinate(1);
        assertEquals(-0.5, ans.getX(), 0.001);
        assertEquals(-2.0, ans.getY(), 0.001);
    }
}