import junit.framework.TestCase;

import java.util.*;
/**
 * The test class studentTest.
 *
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry programming contest
 * 
 *      Remember - all String contain lower case letters only
 */
public class Wittry2018FinalTest extends junit.framework.TestCase {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
    }
    public void testCountingSquares01() {
        List<Edge> edgs1 = new ArrayList<Edge>();
        edgs1.add( new Edge( new Point(1, 1), new Point(1, 2)));
        edgs1.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edgs1.add( new Edge( new Point(1, 2), new Point(2, 2)));
        CountingSquares cs = new CountingSquares(edgs1);
        assertEquals( false, cs.hasSquare(new Point(1,1), 1));

        edgs1.add( new Edge( new Point(2, 1), new Point(2, 2)));
        cs = new CountingSquares(edgs1);
        assertEquals( true, cs.hasSquare(new Point(1,1), 1));

        assertEquals( 1, cs.getNumSquares(1));

        List<Edge> edgs2 = new ArrayList<Edge>();
        edgs2.add( new Edge( new Point(1, 1), new Point(1, 2)));
        edgs2.add( new Edge( new Point(1, 3), new Point(1, 4)));
        edgs2.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edgs2.add( new Edge( new Point(2, 1), new Point(2, 2)));
        edgs2.add( new Edge( new Point(2, 1), new Point(3, 1)));
        edgs2.add( new Edge( new Point(2, 2), new Point(2, 3)));
        edgs2.add( new Edge( new Point(2, 2), new Point(3, 2)));
        edgs2.add( new Edge( new Point(2, 3), new Point(3, 3)));
        edgs2.add( new Edge( new Point(3, 1), new Point(3, 2)));
        edgs2.add( new Edge( new Point(3, 3), new Point(3, 2)));
        edgs2.add( new Edge( new Point(3, 1), new Point(4, 1)));
        edgs2.add( new Edge( new Point(4, 2), new Point(4, 1)));
        edgs2.add( new Edge( new Point(4, 3), new Point(4, 2)));
        edgs2.add( new Edge( new Point(4, 3), new Point(3, 3)));
        cs = new CountingSquares(edgs2);

        assertEquals( false, cs.hasSquare(new Point(1, 1), 1));
        assertEquals( true, cs.hasSquare(new Point(2, 1), 1));
        assertEquals( true, cs.hasSquare(new Point(2, 2), 1));
        assertEquals( false, cs.hasSquare(new Point(1, 1), 2));
        assertEquals( true, cs.hasSquare(new Point(2, 1), 2));

        List<Edge> edgs3 = new ArrayList<Edge>();
        edgs3.add( new Edge( new Point(1, 1), new Point(1, 2)));
        edgs3.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edgs3.add( new Edge( new Point(1, 2), new Point(2, 2)));
        edgs3.add( new Edge( new Point(2, 1), new Point(2, 2)));
        cs = new CountingSquares(edgs3);
        assertEquals( 1, cs.getNumSquares(1));

        edgs3.add( new Edge( new Point(2, 1), new Point(3, 1)));
        edgs3.add( new Edge( new Point(2, 2), new Point(2, 3)));
        edgs3.add( new Edge( new Point(4, 3), new Point(4, 2)));
        edgs3.add( new Edge( new Point(3, 3), new Point(3, 2)));
        edgs3.add( new Edge( new Point(2, 3), new Point(3, 3)));
        edgs3.add( new Edge( new Point(3, 1), new Point(3, 2)));
        edgs3.add( new Edge( new Point(4, 3), new Point(3, 3)));
        edgs3.add( new Edge( new Point(4, 2), new Point(3, 2)));
        edgs3.add( new Edge( new Point(2, 2), new Point(3, 2)));
        cs = new CountingSquares(edgs3);
        assertEquals( 4, cs.getNumSquares(1));
        //        assertEquals( 1, cs.getSizeOfLargestSquare());

        List<Edge> edgs4 = new ArrayList<Edge>();
        edgs4.add( new Edge( new Point(1, 1), new Point(1, 2)));
        edgs4.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edgs4.add( new Edge( new Point(1, 2), new Point(2, 2)));
        edgs4.add( new Edge( new Point(2, 1), new Point(2, 2)));
        edgs4.add( new Edge( new Point(2, 1), new Point(3, 1)));
        edgs4.add( new Edge( new Point(2, 2), new Point(2, 3)));
        edgs4.add( new Edge( new Point(4, 3), new Point(4, 2)));
        edgs4.add( new Edge( new Point(3, 3), new Point(3, 2)));
        edgs4.add( new Edge( new Point(2, 3), new Point(3, 3)));
        edgs4.add( new Edge( new Point(3, 1), new Point(3, 2)));
        edgs4.add( new Edge( new Point(4, 3), new Point(3, 3)));
        edgs4.add( new Edge( new Point(4, 2), new Point(3, 2)));
        edgs4.add( new Edge( new Point(2, 2), new Point(3, 2)));
        edgs4.add( new Edge( new Point(3, 1), new Point(4, 1)));
        edgs4.add( new Edge( new Point(4, 1), new Point(4, 2)));
        cs = new CountingSquares(edgs4);
        assertEquals( 2, cs.getSizeOfLargestSquare());
    }

    public void testHasSquareSize1_02() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(0, 0), new Point(1, 0)));
        edg.add( new Edge( new Point(1, 0), new Point(1, 1)));
        edg.add( new Edge( new Point(0, 1), new Point(1, 1)));
        edg.add( new Edge( new Point(0, 0), new Point(0, 1)));

        edg.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edg.add( new Edge( new Point(1, 2), new Point(1, 1)));
        edg.add( new Edge( new Point(2, 2), new Point(1, 2)));
        edg.add( new Edge( new Point(2, 2), new Point(2, 1)));

        edg.add( new Edge( new Point(8, 8), new Point(8, 9)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 9)));
        edg.add( new Edge( new Point(8, 9), new Point(9, 9)));

        edg.add( new Edge( new Point(9, 0), new Point(8, 0)));
        edg.add( new Edge( new Point(9, 0), new Point(9, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(9, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(7, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(8, 2)));
        edg.add( new Edge( new Point(7, 2), new Point(7, 1)));
        edg.add( new Edge( new Point(7, 2), new Point(8, 2)));

        edg.add( new Edge( new Point(0, 2), new Point(1, 2)));
        edg.add( new Edge( new Point(0, 3), new Point(0, 2)));
        edg.add( new Edge( new Point(1, 3), new Point(0, 3)));
        edg.add( new Edge( new Point(1, 2), new Point(1, 3)));
        edg.add( new Edge( new Point(1, 2), new Point(2, 3)));

        edg.add( new Edge( new Point(3, 1), new Point(4, 1)));
        edg.add( new Edge( new Point(4, 1), new Point(5, 1)));
        edg.add( new Edge( new Point(3, 1), new Point(3, 2)));
        edg.add( new Edge( new Point(3, 2), new Point(3, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(4, 3)));
        edg.add( new Edge( new Point(4, 3), new Point(5, 3)));
        edg.add( new Edge( new Point(5, 1), new Point(5, 2)));
        edg.add( new Edge( new Point(5, 2), new Point(5, 3)));

        edg.add( new Edge( new Point(0, 8), new Point(1, 8)));
        edg.add( new Edge( new Point(1, 8), new Point(1, 9)));
        edg.add( new Edge( new Point(0, 8), new Point(0, 9)));

        edg.add( new Edge( new Point(4, 3), new Point(4, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(5, 4)));
        edg.add( new Edge( new Point(5, 4), new Point(6, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(4, 5)));
        edg.add( new Edge( new Point(4, 5), new Point(5, 5)));
        edg.add( new Edge( new Point(5, 5), new Point(6, 5)));
        edg.add( new Edge( new Point(5, 4), new Point(5, 5)));
        edg.add( new Edge( new Point(6, 4), new Point(6, 5)));

        CountingSquares cs = new CountingSquares(edg);

        assertEquals( true, cs.hasSquare(new Point(0, 0), 1));
        assertEquals( true, cs.hasSquare(new Point(1,1), 1));
        assertEquals( true, cs.hasSquare(new Point(7,1), 1));
        assertEquals( true, cs.hasSquare(new Point(0, 2), 1));
        assertEquals( true, cs.hasSquare(new Point(4, 4), 1));
        assertEquals( true, cs.hasSquare(new Point(5, 4), 1));

        assertEquals( false, cs.hasSquare(new Point(8, 8), 1));
        assertEquals( false, cs.hasSquare(new Point(8, 0), 1));
        assertEquals( false, cs.hasSquare(new Point(1, 2), 1));
        assertEquals( false, cs.hasSquare(new Point(3, 1), 1));
        assertEquals( false, cs.hasSquare(new Point(0, 8), 1));
        assertEquals( false, cs.hasSquare(new Point(4, 3), 1));
    }

    public void testHasSquareSize2_03() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(8, 0), new Point(7, 0)));
        edg.add( new Edge( new Point(8, 0), new Point(9, 0)));
        edg.add( new Edge( new Point(7, 1), new Point(7, 0)));
        edg.add( new Edge( new Point(7, 1), new Point(7, 2)));
        edg.add( new Edge( new Point(7, 2), new Point(8, 2)));
        edg.add( new Edge( new Point(9, 2), new Point(8, 2)));
        edg.add( new Edge( new Point(9, 2), new Point(9, 1)));
        edg.add( new Edge( new Point(9, 0), new Point(9, 1)));

        edg.add( new Edge( new Point(8, 0), new Point(8, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(9, 1)));

        edg.add( new Edge( new Point(7, 1), new Point(8, 1)));
        edg.add( new Edge( new Point(7, 2), new Point(7, 3)));
        edg.add( new Edge( new Point(9, 3), new Point(8, 3)));
        edg.add( new Edge( new Point(9, 2), new Point(9, 3)));

        edg.add( new Edge( new Point(1, 3), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 4), new Point(1, 5)));
        edg.add( new Edge( new Point(1, 5), new Point(2, 5)));
        edg.add( new Edge( new Point(2, 5), new Point(3, 5)));
        edg.add( new Edge( new Point(1, 3), new Point(2, 3)));
        edg.add( new Edge( new Point(2, 3), new Point(3, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(3, 4)));
        edg.add( new Edge( new Point(3, 4), new Point(3, 5)));

        CountingSquares cs = new CountingSquares(edg);

        assertEquals( true, cs.hasSquare(new Point(7, 0), 2));
        assertEquals( true, cs.hasSquare(new Point(1, 3), 2));

        assertEquals( false, cs.hasSquare(new Point(8, 0), 2));
        assertEquals( false, cs.hasSquare(new Point(7, 1), 2));

        edg.remove( new Edge( new Point(3, 4), new Point(3, 5)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.remove( new Edge(new Point(3, 3), new Point(3, 4)));
        edg.add(0, new Edge( new Point(3, 4), new Point(3, 5)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.remove(new Edge( new Point(2, 3), new Point(3, 3)));
        edg.add(0, new Edge(new Point(3, 3), new Point(3, 4)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.add(0, new Edge( new Point(2, 3), new Point(3, 3)));
        edg.remove(new Edge(new Point(1, 3), new Point(2, 3)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.remove(new Edge( new Point(2, 5), new Point(3, 5)));
        edg.add(0, new Edge(new Point(1, 3), new Point(2, 3)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.add(0, new Edge( new Point(2, 5), new Point(3, 5)));
        edg.remove(new Edge(new Point(1, 5), new Point(2, 5)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.remove(new Edge( new Point(1, 4), new Point(1, 5)));
        edg.add(0, new Edge(new Point(1, 5), new Point(2, 5)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));

        edg.add(0, new Edge( new Point(1, 4), new Point(1, 5)));
        edg.remove(new Edge(new Point(1, 3), new Point(1, 4)));
        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 2));
    }

    public void testHasSquareSize3andBigger_04() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(6, 6), new Point(7, 6)));
        edg.add( new Edge( new Point(6, 6), new Point(6, 7)));
        edg.add( new Edge( new Point(7, 6), new Point(8, 6)));
        edg.add( new Edge( new Point(8, 6), new Point(9, 6)));
        edg.add( new Edge( new Point(7, 9), new Point(8, 9)));
        edg.add( new Edge( new Point(9, 6), new Point(9, 7)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 9)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 7)));
        edg.add( new Edge( new Point(6, 9), new Point(6, 8)));
        edg.add( new Edge( new Point(6, 9), new Point(7, 9)));
        edg.add( new Edge( new Point(6, 8), new Point(6, 7)));

        CountingSquares cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(6, 6), 3));

        edg.add( new Edge( new Point(9, 9), new Point(8, 9)));

        edg.add( new Edge( new Point(1, 8), new Point(2, 8)));
        edg.add( new Edge( new Point(5, 8), new Point(4, 8)));
        edg.add( new Edge( new Point(3, 8), new Point(4, 8)));
        edg.add( new Edge( new Point(2, 8), new Point(3, 8)));
        edg.add( new Edge( new Point(1, 4), new Point(2, 4)));
        edg.add( new Edge( new Point(2, 4), new Point(3, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(3, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(5, 4)));
        edg.add( new Edge( new Point(1, 8), new Point(1, 7)));
        edg.add( new Edge( new Point(1, 6), new Point(1, 5)));
        edg.add( new Edge( new Point(1, 5), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 6), new Point(1, 7)));
        edg.add( new Edge( new Point(5, 8), new Point(5, 7)));
        edg.add( new Edge( new Point(5, 6), new Point(5, 5)));
        edg.add( new Edge( new Point(5, 5), new Point(5, 4)));

        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 4), 4));

        edg.add( new Edge( new Point(5, 6), new Point(5, 7)));

        edg.add( new Edge( new Point(1, 3), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 3), new Point(2, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(2, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(4, 3)));
        edg.add( new Edge( new Point(6, 3), new Point(5, 3)));
        edg.add( new Edge( new Point(5, 3), new Point(4, 3)));
        edg.add( new Edge( new Point(6, 3), new Point(6, 4)));
        edg.add( new Edge( new Point(6, 5), new Point(6, 6)));
        edg.add( new Edge( new Point(5, 8), new Point(6, 8)));

        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(1, 3), 5));

        edg.add( new Edge( new Point(6, 4), new Point(6, 5)));

        edg.add( new Edge( new Point(9, 6), new Point(9, 5)));
        edg.add( new Edge( new Point(9, 5), new Point(9, 4)));
        edg.add( new Edge( new Point(9, 4), new Point(9, 3)));
        edg.add( new Edge( new Point(6, 3), new Point(7, 3)));
        edg.add( new Edge( new Point(8, 3), new Point(7, 3)));
        edg.add( new Edge( new Point(8, 3), new Point(9, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(3, 4)));
        edg.add( new Edge( new Point(3, 4), new Point(3, 5)));
        edg.add( new Edge( new Point(3, 5), new Point(3, 6)));
        edg.add( new Edge( new Point(3, 7), new Point(3, 8)));
        edg.add( new Edge( new Point(3, 8), new Point(3, 9)));
        edg.add( new Edge( new Point(3, 6), new Point(3, 7)));
        edg.add( new Edge( new Point(3, 9), new Point(4, 9)));
        edg.add( new Edge( new Point(5, 9), new Point(4, 9)));

        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(3, 3), 6));

        edg.add( new Edge( new Point(5, 9), new Point(6, 9)));

        cs = new CountingSquares(edg);

        assertEquals( true, cs.hasSquare(new Point(6, 6), 3));
        assertEquals( true, cs.hasSquare(new Point(1, 4), 4));
        assertEquals( true, cs.hasSquare(new Point(1, 3), 5));
        assertEquals( true, cs.hasSquare(new Point(3, 3), 6));
        assertEquals( true, cs.hasSquare(new Point(6, 3), 3));

        edg.remove( new Edge( new Point(7, 6), new Point(8, 6)));

        cs = new CountingSquares(edg);
        assertEquals( false, cs.hasSquare(new Point(6, 3), 3));
        assertEquals( false, cs.hasSquare(new Point(6, 6), 3));
    }

    public void testGetNumSquareSize1_05() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(0, 0), new Point(1, 0)));
        edg.add( new Edge( new Point(1, 0), new Point(1, 1)));
        edg.add( new Edge( new Point(0, 1), new Point(1, 1)));
        edg.add( new Edge( new Point(0, 0), new Point(0, 1)));

        edg.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edg.add( new Edge( new Point(1, 2), new Point(1, 1)));
        edg.add( new Edge( new Point(2, 2), new Point(1, 2)));
        edg.add( new Edge( new Point(2, 2), new Point(2, 1)));

        edg.add( new Edge( new Point(8, 8), new Point(8, 9)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 9)));
        edg.add( new Edge( new Point(8, 9), new Point(9, 9)));

        edg.add( new Edge( new Point(9, 0), new Point(8, 0)));
        edg.add( new Edge( new Point(9, 0), new Point(9, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(9, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(7, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(8, 2)));
        edg.add( new Edge( new Point(7, 2), new Point(7, 1)));
        edg.add( new Edge( new Point(7, 2), new Point(8, 2)));

        edg.add( new Edge( new Point(0, 2), new Point(1, 2)));
        edg.add( new Edge( new Point(0, 3), new Point(0, 2)));
        edg.add( new Edge( new Point(1, 3), new Point(0, 3)));
        edg.add( new Edge( new Point(1, 2), new Point(1, 3)));
        edg.add( new Edge( new Point(1, 2), new Point(2, 3)));

        edg.add( new Edge( new Point(3, 1), new Point(4, 1)));
        edg.add( new Edge( new Point(4, 1), new Point(5, 1)));
        edg.add( new Edge( new Point(3, 1), new Point(3, 2)));
        edg.add( new Edge( new Point(3, 2), new Point(3, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(4, 3)));
        edg.add( new Edge( new Point(4, 3), new Point(5, 3)));
        edg.add( new Edge( new Point(5, 1), new Point(5, 2)));
        edg.add( new Edge( new Point(5, 2), new Point(5, 3)));

        edg.add( new Edge( new Point(0, 8), new Point(1, 8)));
        edg.add( new Edge( new Point(1, 8), new Point(1, 9)));
        edg.add( new Edge( new Point(0, 8), new Point(0, 9)));

        edg.add( new Edge( new Point(4, 3), new Point(4, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(5, 4)));
        edg.add( new Edge( new Point(5, 4), new Point(6, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(4, 5)));
        edg.add( new Edge( new Point(4, 5), new Point(5, 5)));
        edg.add( new Edge( new Point(5, 5), new Point(6, 5)));
        edg.add( new Edge( new Point(5, 4), new Point(5, 5)));
        edg.add( new Edge( new Point(6, 4), new Point(6, 5)));

        CountingSquares cs = new CountingSquares(edg);
        assertEquals( 6, cs.getNumSquares(1));

        edg.add( new Edge( new Point(0, 9), new Point(1, 9)));
        edg.add( new Edge( new Point(9, 8), new Point(8, 8)));
        edg.add( new Edge( new Point(8, 0), new Point(8, 1)));

        cs = new CountingSquares(edg);
        assertEquals( 9, cs.getNumSquares(1));

        edg.remove( new Edge( new Point(5, 4), new Point(5, 5)));

        cs = new CountingSquares(edg);
        assertEquals( 7, cs.getNumSquares(1));
    }

    public void testGetNumSquareSize2_06() {
        List<Edge> edg = new ArrayList<Edge>();
        CountingSquares cs = new CountingSquares(edg);
        assertEquals( 0, cs.getNumSquares(2));

        edg.add( new Edge( new Point(8, 0), new Point(7, 0)));
        edg.add( new Edge( new Point(8, 0), new Point(9, 0)));
        edg.add( new Edge( new Point(7, 1), new Point(7, 0)));
        edg.add( new Edge( new Point(7, 1), new Point(7, 2)));
        edg.add( new Edge( new Point(7, 2), new Point(8, 2)));
        edg.add( new Edge( new Point(9, 2), new Point(8, 2)));
        edg.add( new Edge( new Point(9, 2), new Point(9, 1)));

        edg.add( new Edge( new Point(8, 0), new Point(8, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(9, 1)));

        edg.add( new Edge( new Point(7, 1), new Point(8, 1)));
        edg.add( new Edge( new Point(7, 2), new Point(7, 3)));
        edg.add( new Edge( new Point(9, 3), new Point(8, 3)));
        edg.add( new Edge( new Point(9, 3), new Point(9, 2)));
        edg.add( new Edge( new Point(8, 3), new Point(7, 3)));

        edg.add( new Edge( new Point(1, 3), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 4), new Point(1, 5)));
        edg.add( new Edge( new Point(1, 5), new Point(2, 5)));
        edg.add( new Edge( new Point(2, 5), new Point(3, 5)));
        edg.add( new Edge( new Point(1, 3), new Point(2, 3)));
        edg.add( new Edge( new Point(2, 3), new Point(3, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(3, 4)));

        cs = new CountingSquares(edg);
        assertEquals( 1, cs.getNumSquares(2));

        edg.add( new Edge( new Point(3, 4), new Point(3, 5)));
        edg.add( new Edge( new Point(9, 0), new Point(9, 1)));
        cs = new CountingSquares(edg);
        assertEquals( 3, cs.getNumSquares(2));
    }

    public void testGetNumSquareSize3andBigger_07() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(6, 6), new Point(7, 6)));
        edg.add( new Edge( new Point(6, 6), new Point(6, 7)));
        edg.add( new Edge( new Point(7, 6), new Point(8, 6)));
        edg.add( new Edge( new Point(8, 6), new Point(9, 6)));
        edg.add( new Edge( new Point(7, 9), new Point(8, 9)));
        edg.add( new Edge( new Point(9, 6), new Point(9, 7)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 9)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 7)));
        edg.add( new Edge( new Point(6, 9), new Point(6, 8)));
        edg.add( new Edge( new Point(6, 9), new Point(7, 9)));
        edg.add( new Edge( new Point(6, 8), new Point(6, 7)));

        CountingSquares cs = new CountingSquares(edg);
        assertEquals( 0, cs.getNumSquares( 3));

        edg.add( new Edge( new Point(9, 9), new Point(8, 9)));
        cs = new CountingSquares(edg);
        assertEquals( 1, cs.getNumSquares( 3));

        edg.add( new Edge( new Point(1, 8), new Point(2, 8)));
        edg.add( new Edge( new Point(5, 8), new Point(4, 8)));
        edg.add( new Edge( new Point(3, 8), new Point(4, 8)));
        edg.add( new Edge( new Point(2, 8), new Point(3, 8)));
        edg.add( new Edge( new Point(1, 4), new Point(2, 4)));
        edg.add( new Edge( new Point(2, 4), new Point(3, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(3, 4)));
        edg.add( new Edge( new Point(4, 4), new Point(5, 4)));
        edg.add( new Edge( new Point(1, 8), new Point(1, 7)));
        edg.add( new Edge( new Point(1, 6), new Point(1, 5)));
        edg.add( new Edge( new Point(1, 5), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 6), new Point(1, 7)));
        edg.add( new Edge( new Point(5, 8), new Point(5, 7)));
        edg.add( new Edge( new Point(5, 6), new Point(5, 5)));
        edg.add( new Edge( new Point(5, 5), new Point(5, 4)));

        cs = new CountingSquares(edg);
        assertEquals( 0, cs.getNumSquares(4));

        edg.add( new Edge( new Point(5, 6), new Point(5, 7)));
        cs = new CountingSquares(edg);
        assertEquals( 1, cs.getNumSquares(4));

        edg.add( new Edge( new Point(1, 3), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 3), new Point(2, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(2, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(4, 3)));
        edg.add( new Edge( new Point(6, 3), new Point(5, 3)));
        edg.add( new Edge( new Point(5, 3), new Point(4, 3)));
        edg.add( new Edge( new Point(6, 3), new Point(6, 4)));
        edg.add( new Edge( new Point(6, 5), new Point(6, 6)));
        edg.add( new Edge( new Point(5, 8), new Point(6, 8)));

        cs = new CountingSquares(edg);
        assertEquals( 0, cs.getNumSquares(5));

        edg.add( new Edge( new Point(6, 4), new Point(6, 5)));
        cs = new CountingSquares(edg);
        assertEquals( 1, cs.getNumSquares(5));

        edg.add( new Edge( new Point(9, 6), new Point(9, 5)));
        edg.add( new Edge( new Point(9, 5), new Point(9, 4)));
        edg.add( new Edge( new Point(9, 4), new Point(9, 3)));
        edg.add( new Edge( new Point(6, 3), new Point(7, 3)));
        edg.add( new Edge( new Point(8, 3), new Point(7, 3)));
        edg.add( new Edge( new Point(8, 3), new Point(9, 3)));
        edg.add( new Edge( new Point(3, 3), new Point(3, 4)));
        edg.add( new Edge( new Point(3, 4), new Point(3, 5)));
        edg.add( new Edge( new Point(3, 5), new Point(3, 6)));
        edg.add( new Edge( new Point(3, 7), new Point(3, 8)));
        edg.add( new Edge( new Point(3, 8), new Point(3, 9)));
        edg.add( new Edge( new Point(3, 6), new Point(3, 7)));
        edg.add( new Edge( new Point(3, 9), new Point(4, 9)));
        edg.add( new Edge( new Point(5, 9), new Point(4, 9)));

        cs = new CountingSquares(edg);
        assertEquals( 0, cs.getNumSquares(6));

        edg.add( new Edge( new Point(5, 9), new Point(6, 9)));
        cs = new CountingSquares(edg);
        assertEquals( 1, cs.getNumSquares(6));

        edg.add( new Edge( new Point(5, 4), new Point(6, 4)));

        edg.add( new Edge( new Point(1, 8), new Point(1, 9)));

//  added at FJC
        edg.add( new Edge( new Point(1, 9), new Point(2, 9)));
        edg.add( new Edge( new Point(3, 9), new Point(2, 9)));
        cs = new CountingSquares(edg);
        assertEquals( 2, cs.getNumSquares(5));

        edg.add( new Edge( new Point(7, 3), new Point(7, 4)));
        edg.add( new Edge( new Point(7, 5), new Point(7, 4)));
        edg.add( new Edge( new Point(7, 5), new Point(7, 6)));
        edg.add( new Edge( new Point(7, 7), new Point(7, 6)));
        edg.add( new Edge( new Point(7, 9), new Point(7, 8)));
        edg.add( new Edge( new Point(7, 7), new Point(7, 8)));
        assertEquals( 2, cs.getNumSquares(6));

        edg.add( new Edge( new Point(3, 6), new Point(4, 6)));
        edg.add( new Edge( new Point(5, 6), new Point(4, 6)));
        edg.add( new Edge( new Point(5, 6), new Point(6, 6)));
        assertEquals( 4, cs.getNumSquares(3));
    }

    public void testGetSizeOfLargestSquare06andBigger_08() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(0, 0), new Point(0, 1)));
        edg.add( new Edge( new Point(0, 2), new Point(0, 1)));
        edg.add( new Edge( new Point(0, 2), new Point(0, 3)));
        edg.add( new Edge( new Point(0, 4), new Point(0, 3)));
        edg.add( new Edge( new Point(0, 4), new Point(0, 5)));
        edg.add( new Edge( new Point(0, 6), new Point(0, 5)));
        edg.add( new Edge( new Point(0, 6), new Point(0, 7)));
        edg.add( new Edge( new Point(0, 8), new Point(0, 7)));
        edg.add( new Edge( new Point(0, 8), new Point(0, 9)));

        edg.add( new Edge( new Point(1, 0), new Point(0, 0)));
        edg.add( new Edge( new Point(2, 0), new Point(1, 0)));
        edg.add( new Edge( new Point(2, 0), new Point(3, 0)));
        edg.add( new Edge( new Point(4, 0), new Point(3, 0)));
        edg.add( new Edge( new Point(4, 0), new Point(5, 0)));
        edg.add( new Edge( new Point(6, 0), new Point(5, 0)));
        edg.add( new Edge( new Point(6, 0), new Point(7, 0)));
        edg.add( new Edge( new Point(7, 0), new Point(7, 0)));
        edg.add( new Edge( new Point(7, 0), new Point(8, 0)));
        edg.add( new Edge( new Point(9, 0), new Point(8, 0)));

        edg.add( new Edge( new Point(9, 0), new Point(9, 1)));
        edg.add( new Edge( new Point(9, 2), new Point(9, 3)));
        edg.add( new Edge( new Point(9, 4), new Point(9, 3)));
        edg.add( new Edge( new Point(9, 4), new Point(9, 5)));
        edg.add( new Edge( new Point(9, 6), new Point(9, 5)));
        edg.add( new Edge( new Point(9, 6), new Point(9, 7)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 7)));
        edg.add( new Edge( new Point(9, 8), new Point(9, 9)));
        edg.add( new Edge( new Point(9, 2), new Point(9, 1)));

        edg.add( new Edge( new Point(0, 9), new Point(1, 9)));
        edg.add( new Edge( new Point(2, 9), new Point(1, 9)));
        edg.add( new Edge( new Point(3, 9), new Point(4, 9)));
        edg.add( new Edge( new Point(4, 9), new Point(5, 9)));
        edg.add( new Edge( new Point(5, 9), new Point(6, 9)));
        edg.add( new Edge( new Point(6, 9), new Point(7, 9)));
        edg.add( new Edge( new Point(8, 9), new Point(7, 9)));
        edg.add( new Edge( new Point(9, 9), new Point(8, 9)));

        CountingSquares cs = new CountingSquares(edg);
        assertEquals( 0, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(2, 8), new Point(1, 8)));
        edg.add( new Edge( new Point(3, 8), new Point(4, 8)));
        edg.add( new Edge( new Point(2, 8), new Point(3, 8)));
        edg.add( new Edge( new Point(4, 8), new Point(5, 8)));
        edg.add( new Edge( new Point(6, 8), new Point(5, 8)));
        edg.add( new Edge( new Point(6, 8), new Point(7, 8)));
        edg.add( new Edge( new Point(8, 8), new Point(7, 8)));

        edg.add( new Edge( new Point(8, 0), new Point(8, 1)));
        edg.add( new Edge( new Point(8, 2), new Point(8, 1)));
        edg.add( new Edge( new Point(8, 2), new Point(8, 3)));
        edg.add( new Edge( new Point(8, 4), new Point(8, 3)));
        edg.add( new Edge( new Point(8, 4), new Point(8, 5)));
        edg.add( new Edge( new Point(8, 6), new Point(8, 5)));
        edg.add( new Edge( new Point(8, 6), new Point(8, 7)));
        edg.add( new Edge( new Point(8, 8), new Point(8, 7)));

        cs = new CountingSquares(edg);
        assertEquals( 0, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(1, 3), new Point(1, 2)));
        edg.add( new Edge( new Point(1, 3), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 5), new Point(1, 4)));
        edg.add( new Edge( new Point(1, 5), new Point(1, 6)));
        edg.add( new Edge( new Point(1, 7), new Point(1, 6)));
        edg.add( new Edge( new Point(1, 7), new Point(1, 8)));

        edg.add( new Edge( new Point(1, 1), new Point(2, 1)));
        edg.add( new Edge( new Point(3, 1), new Point(2, 1)));
        edg.add( new Edge( new Point(3, 1), new Point(4, 1)));
        edg.add( new Edge( new Point(5, 1), new Point(4, 1)));
        edg.add( new Edge( new Point(5, 1), new Point(6, 1)));
        edg.add( new Edge( new Point(7, 1), new Point(6, 1)));
        edg.add( new Edge( new Point(7, 1), new Point(8, 1)));

        cs = new CountingSquares(edg);
        assertEquals( 0, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(1, 2), new Point(2, 2)));
        edg.add( new Edge( new Point(3, 2), new Point(2, 2)));
        edg.add( new Edge( new Point(3, 2), new Point(4, 2)));
        edg.add( new Edge( new Point(5, 2), new Point(4, 2)));
        edg.add( new Edge( new Point(5, 2), new Point(6, 2)));
        edg.add( new Edge( new Point(7, 2), new Point(6, 2)));
      
        edg.add( new Edge( new Point(7, 2), new Point(7, 3)));
        edg.add( new Edge( new Point(7, 4), new Point(7, 3)));
        edg.add( new Edge( new Point(7, 4), new Point(7, 5)));
        edg.add( new Edge( new Point(7, 6), new Point(7, 5)));
        edg.add( new Edge( new Point(7, 6), new Point(7, 7)));
        edg.add( new Edge( new Point(7, 8), new Point(7, 7)));

        cs = new CountingSquares(edg);
        assertEquals( 6, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(1, 1), new Point(1, 2)));
        cs = new CountingSquares(edg);
        assertEquals( 7, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(0, 8), new Point(1, 8)));
        cs = new CountingSquares(edg);
        assertEquals( 8, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(2, 9), new Point(3, 9)));
        cs = new CountingSquares(edg);
        assertEquals( 9, cs.getSizeOfLargestSquare());
    }

    public void testGetSizeOfLargestSquare03thru05_09() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(1, 6), new Point(1, 7)));
        edg.add( new Edge( new Point(1, 8), new Point(1, 7)));
        edg.add( new Edge( new Point(1, 8), new Point(1, 9)));

        edg.add( new Edge( new Point(2, 9), new Point(1, 9)));
        edg.add( new Edge( new Point(2, 9), new Point(3, 9)));
        edg.add( new Edge( new Point(4, 9), new Point(3, 9)));
      
        edg.add( new Edge( new Point(4, 6), new Point(4, 7)));
        edg.add( new Edge( new Point(4, 8), new Point(4, 7)));
        edg.add( new Edge( new Point(4, 8), new Point(4, 9)));

        edg.add( new Edge( new Point(2, 6), new Point(1, 6)));
        edg.add( new Edge( new Point(2, 6), new Point(3, 6)));
        edg.add( new Edge( new Point(4, 6), new Point(3, 6)));
      
        CountingSquares cs = new CountingSquares(edg);
        assertEquals( 3, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(4, 6), new Point(4, 5)));
        edg.add( new Edge( new Point(3, 5), new Point(4, 5)));
        edg.add( new Edge( new Point(3, 6), new Point(3, 5)));
        edg.add( new Edge( new Point(2, 5), new Point(2, 6)));
        cs = new CountingSquares(edg);
        assertEquals( 3, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(4, 1), new Point(5, 1)));
        edg.add( new Edge( new Point(6, 1), new Point(5, 1)));
        edg.add( new Edge( new Point(6, 1), new Point(7, 1)));
        edg.add( new Edge( new Point(8, 1), new Point(7, 1)));

        edg.add( new Edge( new Point(4, 5), new Point(5, 5)));
        edg.add( new Edge( new Point(6, 5), new Point(5, 5)));
        edg.add( new Edge( new Point(6, 5), new Point(7, 5)));
        edg.add( new Edge( new Point(8, 5), new Point(7, 5)));

        edg.add( new Edge( new Point(4, 1), new Point(4, 2)));
        edg.add( new Edge( new Point(4, 3), new Point(4, 2)));
        edg.add( new Edge( new Point(4, 3), new Point(4, 4)));
        edg.add( new Edge( new Point(4, 5), new Point(4, 4)));

        edg.add( new Edge( new Point(8, 1), new Point(8, 2)));
        edg.add( new Edge( new Point(8, 3), new Point(8, 2)));
        edg.add( new Edge( new Point(8, 3), new Point(8, 4)));
        edg.add( new Edge( new Point(8, 5), new Point(8, 4)));

        cs = new CountingSquares(edg);
        assertEquals( 4, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(4, 6), new Point(5, 6)));
        edg.add( new Edge( new Point(6, 6), new Point(5, 6)));
        edg.add( new Edge( new Point(6, 6), new Point(7, 6)));
        edg.add( new Edge( new Point(8, 6), new Point(7, 6)));
        edg.add( new Edge( new Point(8, 6), new Point(8, 5)));

        edg.add( new Edge( new Point(8, 5), new Point(9, 5)));
        edg.add( new Edge( new Point(8, 1), new Point(9, 1)));
        edg.add( new Edge( new Point(9, 1), new Point(9, 2)));
        edg.add( new Edge( new Point(9, 3), new Point(9, 2)));
        edg.add( new Edge( new Point(9, 3), new Point(9, 4)));
        edg.add( new Edge( new Point(9, 5), new Point(9, 4)));
        cs = new CountingSquares(edg);
        assertEquals( 4, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(8, 6), new Point(9, 6)));
        edg.add( new Edge( new Point(9, 5), new Point(9, 6)));
        cs = new CountingSquares(edg);
        assertEquals( 5, cs.getSizeOfLargestSquare());
    }

    public void testGetSizeOfLargestSquareSize00thru02_10() {
        List<Edge> edg = new ArrayList<Edge>();
        edg.add( new Edge( new Point(4, 6), new Point(4, 7)));
        edg.add( new Edge( new Point(5, 6), new Point(5, 7)));
        edg.add( new Edge( new Point(6, 6), new Point(6, 7)));

        edg.add( new Edge( new Point(4, 5), new Point(5, 5)));
        edg.add( new Edge( new Point(6, 5), new Point(5, 5)));
        edg.add( new Edge( new Point(6, 6), new Point(6, 5)));

        edg.add( new Edge( new Point(4, 5), new Point(4, 6)));
        edg.add( new Edge( new Point(5, 6), new Point(4, 6)));
        edg.add( new Edge( new Point(6, 6), new Point(5, 6)));
      
        CountingSquares cs = new CountingSquares(edg);
        assertEquals( 0, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(6, 7), new Point(5, 7)));
        cs = new CountingSquares(edg);
        assertEquals( 1, cs.getSizeOfLargestSquare());

        edg.add( new Edge( new Point(4, 7), new Point(5, 7)));
        cs = new CountingSquares(edg);
        assertEquals( 2, cs.getSizeOfLargestSquare());
    }
   
    private final boolean T = true;   // not infected
    private final boolean F = false;  // infected

    public void testVirusInfection01() {
        boolean[][] net = { {T, T, T, F }, {T, F, F, T }, {F, T, F, T }, {T, T, T, F } };
        VirusInfection v = new VirusInfection(net);

        assertEquals(true, v.isSafeLocation(0, 1));
        assertEquals(false, v.isSafeLocation(1, 1));
        assertEquals(false, v.isSafeLocation(2, 1));

        boolean[][] ans = v.spreadVirus(1);
        assertEquals(false, ans[0][2] || ans[0][3] || ans[1][0] || ans[1][1] || ans[1][2] || ans[1][3]
                || ans[2][0] || ans[2][1] || ans[2][2] || ans[2][3] || ans[3][2] || ans[3][3]);

        assertEquals(true, ans[0][0] && ans[0][1] && ans[3][0] && ans[3][1]);

        ans = v.spreadVirus(2);
        assertEquals(false, ans[0][1] && ans[0][2] || ans[0][3] || ans[1][0] || ans[1][1] || ans[1][2]
                || ans[1][3] || ans[2][0] || ans[2][1] || ans[2][2] || ans[2][3]
                || ans[3][1] || ans[3][2] || ans[3][3]);

        assertEquals(true, ans[0][0] && ans[3][0]);

        ans = v.spreadVirus(3);
        assertEquals(false, ans[0][0] || ans[0][1] || ans[0][2] || ans[0][3]
                || ans[1][0] || ans[1][1] || ans[1][2] || ans[1][3]
                || ans[2][0] || ans[2][1] || ans[2][2] || ans[2][3]
                || ans[3][0] || ans[3][1] || ans[3][2] || ans[3][3]);

        assertEquals(true, v.infectAll());

        boolean[][] net0A = { {T, F, T, T }, {T, T, F, T }, {T, T, T, F } };

        v = new VirusInfection(net0A);
        assertEquals(false, v.infectAll());
    }

    public void testIsSafeLocation02() {
        boolean[][] net = { {T, T, T, T, T, T, T, T, T }, {T, F, T, F, T, F, T, T, T }, {T, T, T, T, T, T, F, T, T }, {T, T, T, F, T, T, T, T, T }, {T, T, T, T, T, T, F, T, T }, {T, T, T, T, T, F, T, T, T } };
        VirusInfection v = new VirusInfection(net);

        assertEquals(false, v.isSafeLocation(1, 1));
        assertEquals(false, v.isSafeLocation(1, 2));
        assertEquals(false, v.isSafeLocation(2, 3));
        assertEquals(false, v.isSafeLocation(2, 5));
        assertEquals(false, v.isSafeLocation(1, 6));
        assertEquals(false, v.isSafeLocation(4, 5));
        assertEquals(true, v.isSafeLocation(3, 7));
        assertEquals(true, v.isSafeLocation(3, 2));

    }

    public void testIsSafeLocationEdges03() {
        boolean[][] net = { {T, F, T, T, T, F, T }, {F, T, T, T, F, T, F }, {F, T, T, T, T, T, T }, {T, F, T, T, T, T, T }, {T, T, T, T, T, T, T }, {T, F, T, T, T, T, T }, {T, F, T, T, F, F, F }, {T, F, T, T, F, F, T } };
        VirusInfection v = new VirusInfection(net);
        assertEquals(false, v.isSafeLocation(0, 0));
        assertEquals(false, v.isSafeLocation(0, 4));
        assertEquals(false, v.isSafeLocation(0, 6));
        assertEquals(true, v.isSafeLocation(4, 0));
        assertEquals(true, v.isSafeLocation(7, 0));
        assertEquals(true, v.isSafeLocation(7, 3));
        assertEquals(false, v.isSafeLocation(7, 4));
        assertEquals(false, v.isSafeLocation(7, 6));
        assertEquals(true, v.isSafeLocation(1, 3));
        assertEquals(true, v.isSafeLocation(1, 3));
    }

    public void testIsSafeLocationBoth04() {
        testIsSafeLocation02();
        testIsSafeLocationEdges03();
    }

    public void testSpreadVirusOnce05() {
        boolean[][] net1 = { {T, T, T, T, T, F, T }, {T, F, T, T, T, T, F }, {T, T, F, T, T, F, T }, {T, T, T, T, T, T, T }, {T, T, F, T, F, T, T }, {T, T, T, T, T, T, T }, {T, T, T, T, F, T, T } };

        VirusInfection v = new VirusInfection(net1);

        boolean[][] answer = v.spreadVirus(1);
        assertEquals(true, answer[0][1]);
        assertEquals(true, answer[0][4]);
        assertEquals(false, answer[0][5]);
        assertEquals(false, answer[0][6]);

        assertEquals(true, answer[1][0]);
        assertEquals(false, answer[1][2]);
        assertEquals(true, answer[1][4]);
        assertEquals(false, answer[1][5]);

        assertEquals(false, answer[2][1]);
        assertEquals(false, answer[2][2]);
        assertEquals(true, answer[2][4]);
        assertEquals(false, answer[2][5]);

        assertEquals(true, answer[3][1]);
        assertEquals(false, answer[3][2]);
        assertEquals(true, answer[3][5]);
        assertEquals(true, answer[3][6]);

        assertEquals(false, answer[4][2]);
        assertEquals(false, answer[4][3]);
        assertEquals(false, answer[4][4]);
        assertEquals(true, answer[4][5]);

        assertEquals(true, answer[5][0]);
        assertEquals(true, answer[5][2]);
        assertEquals(true, answer[5][3]);
        assertEquals(false, answer[5][4]);

        assertEquals(true, answer[6][3]);
        assertEquals(false, answer[6][4]);

        assertEquals(true, net1[1][5]);
        assertEquals(true, net1[3][2]);
        
        boolean[][] net2 = { {F, T, T, T, T, F }, {T, F, T, T, F, T }, {T, T, T, T, T, T }, {T, F, T, F, T, T }, {T, T, T, T, T, T }, {T, T, T, F, T, T } };
        v = new VirusInfection(net2);

        answer = v.spreadVirus(1);
        assertEquals(false, answer[0][1]);
        assertEquals(true, answer[0][3]);
        assertEquals(false, answer[0][4]);

        assertEquals(false, answer[1][0]);
        assertEquals(false, answer[1][1]);
        assertEquals(true, answer[1][3]);
        assertEquals(false, answer[1][4]);

        assertEquals(true, answer[2][0]);
        assertEquals(false, answer[2][1]);
        assertEquals(true, answer[2][4]);
        assertEquals(true, answer[2][5]);

        assertEquals(false, answer[3][1]);
        assertEquals(false, answer[3][2]);
        assertEquals(false, answer[3][3]);
        assertEquals(true, answer[3][4]);

        assertEquals(true, answer[4][1]);
        assertEquals(true, answer[4][2]);
        assertEquals(false, answer[4][3]);

        assertEquals(true, answer[5][2]);
        assertEquals(false, answer[5][3]);

        assertEquals(true, net2[0][4]);
        assertEquals(true, net2[2][1]);
    }

    public void testSpreadVirusTwice06() {
        boolean[][] net1 = { {T, T, T, T, T, F, T }, {T, F, T, T, T, T, F }, {T, T, F, T, T, F, T }, {T, T, T, T, T, T, T }, {T, T, F, T, F, T, T }, {T, T, T, T, T, T, T }, {T, T, T, T, F, T, T } };

        VirusInfection v = new VirusInfection(net1);

        boolean[][] answer = v.spreadVirus(2);
        assertEquals(true, answer[0][1]);
        assertEquals(true, answer[0][4]);
        assertEquals(false, answer[0][5]);
        assertEquals(false, answer[0][6]);

        assertEquals(true, answer[1][0]);
        assertEquals(false, answer[1][2]);
        assertEquals(true, answer[1][4]);
        assertEquals(false, answer[1][5]);

        assertEquals(false, answer[2][1]);
        assertEquals(false, answer[2][2]);
        assertEquals(true, answer[2][4]);
        assertEquals(false, answer[2][5]);

        assertEquals(false, answer[3][1]);
        assertEquals(false, answer[3][2]);
        assertEquals(false, answer[3][3]);
        assertEquals(true, answer[3][6]);

        assertEquals(false, answer[4][2]);
        assertEquals(false, answer[4][3]);
        assertEquals(false, answer[4][4]);
        assertEquals(true, answer[4][5]);
        assertEquals(true, answer[4][6]);

        assertEquals(true, answer[5][0]);
        assertEquals(true, answer[5][2]);
        assertEquals(false, answer[5][3]);
        assertEquals(false, answer[5][4]);

        assertEquals(true, answer[6][3]);
        assertEquals(false, answer[6][4]);

        assertEquals(true, net1[1][5]);
        assertEquals(true, net1[3][2]);
        assertEquals(true, net1[3][1]);
        
        boolean[][] net2 = { {F, T, T, T, T, F }, {T, F, T, T, F, T }, {T, T, T, T, T, T }, {T, F, T, F, T, T }, {T, T, T, T, T, T }, {T, T, T, F, T, T } };
        v = new VirusInfection(net2);

        answer = v.spreadVirus(2);
        assertEquals(false, answer[0][1]);
        assertEquals(true, answer[0][3]);
        assertEquals(false, answer[0][4]);

        assertEquals(false, answer[1][0]);
        assertEquals(false, answer[1][1]);
        assertEquals(true, answer[1][3]);
        assertEquals(false, answer[1][4]);

        assertEquals(false, answer[2][0]);
        assertEquals(false, answer[2][1]);
        assertEquals(true, answer[2][4]);
        assertEquals(true, answer[2][5]);

        assertEquals(false, answer[3][1]);
        assertEquals(false, answer[3][2]);
        assertEquals(false, answer[3][3]);
        assertEquals(true, answer[3][4]);

        assertEquals(true, answer[4][1]);
        assertEquals(false, answer[4][2]);
        assertEquals(false, answer[4][3]);

        assertEquals(true, answer[5][2]);
        assertEquals(false, answer[5][3]);

        assertEquals(true, net2[0][4]);
        assertEquals(true, net2[2][1]);
    }

    public void testSpreadVirusThreeTimes07() {
        boolean[][] net1 = { {T, T, T, T, T, F, T }, {T, F, T, T, T, T, F }, {T, T, F, T, T, F, T }, {T, T, T, T, T, T, T }, {T, T, F, T, F, T, T }, {T, T, T, T, T, T, T }, {T, T, T, T, F, T, T } };

        VirusInfection v = new VirusInfection(net1);

        boolean[][] answer = v.spreadVirus(3);
        assertEquals(true, answer[0][1]);
        assertEquals(true, answer[0][4]);
        assertEquals(false, answer[0][5]);
        assertEquals(false, answer[0][6]);

        assertEquals(true, answer[1][0]);
        assertEquals(false, answer[1][2]);
        assertEquals(true, answer[1][4]);
        assertEquals(false, answer[1][5]);

        assertEquals(false, answer[2][1]);
        assertEquals(false, answer[2][2]);
        assertEquals(true, answer[2][4]);
        assertEquals(false, answer[2][5]);

        assertEquals(false, answer[3][1]);
        assertEquals(false, answer[3][2]);
        assertEquals(true, answer[3][5]);
        assertEquals(true, answer[3][6]);

        assertEquals(false, answer[4][1]);
        assertEquals(false, answer[4][3]);
        assertEquals(false, answer[4][4]);
        assertEquals(true, answer[4][5]);
        assertEquals(true, answer[4][6]);

        assertEquals(true, answer[5][0]);
        assertEquals(true, answer[5][1]);
        assertEquals(false, answer[5][2]);
        assertEquals(false, answer[5][3]);
        assertEquals(false, answer[5][4]);

        assertEquals(false, answer[6][3]);
        assertEquals(false, answer[6][4]);
        assertEquals(true, answer[6][6]);

        assertEquals(true, net1[1][5]);
        assertEquals(true, net1[3][2]);
        assertEquals(true, net1[3][1]);
        assertEquals(false, net1[1][1]);
        
        boolean[][] net2 = { {F, T, T, T, T, F }, {T, F, T, T, F, T }, {T, T, T, T, T, T }, {T, F, T, F, T, T }, {T, T, T, T, T, T }, {T, T, T, F, T, T } };
        v = new VirusInfection(net2);

        answer = v.spreadVirus(3);
        assertEquals(false, answer[0][1]);
        assertEquals(true, answer[0][3]);
        assertEquals(false, answer[0][4]);

        assertEquals(false, answer[1][0]);
        assertEquals(false, answer[1][1]);
        assertEquals(true, answer[1][3]);
        assertEquals(false, answer[1][4]);

        assertEquals(false, answer[2][0]);
        assertEquals(false, answer[2][1]);
        assertEquals(true, answer[2][4]);
        assertEquals(true, answer[2][5]);

        assertEquals(false, answer[3][0]);
        assertEquals(false, answer[3][2]);
        assertEquals(false, answer[3][3]);
        assertEquals(true, answer[3][4]);

        assertEquals(false, answer[4][1]);
        assertEquals(false, answer[4][2]);
        assertEquals(false, answer[4][3]);

        assertEquals(false, answer[5][2]);
        assertEquals(false, answer[5][3]);
        assertEquals(true, answer[5][5]);

        assertEquals(true, net2[0][4]);
        assertEquals(true, net2[2][1]);
    }

    public void testSpreadVirusFour08() {
        boolean[][] net1 = { {T, T, T, T, T, F, T }, {T, F, T, T, T, T, F }, {T, T, F, T, T, F, T }, {T, T, T, T, T, T, T }, {T, T, F, T, F, T, T }, {T, T, T, T, T, T, T }, {T, T, T, T, F, T, T } };

        VirusInfection v = new VirusInfection(net1);

        boolean[][] answer = v.spreadVirus(4);
        assertEquals(true, answer[0][1]);
        assertEquals(true, answer[0][4]);
        assertEquals(false, answer[0][5]);
        assertEquals(false, answer[0][6]);

        assertEquals(true, answer[1][0]);
        assertEquals(false, answer[1][3]);
        assertEquals(true, answer[1][4]);
        assertEquals(false, answer[1][5]);

        assertEquals(false, answer[2][1]);
        assertEquals(false, answer[2][2]);
        assertEquals(false, answer[2][4]);
        assertEquals(false, answer[2][5]);

        assertEquals(false, answer[3][1]);
        assertEquals(false, answer[3][2]);
        assertEquals(false, answer[3][5]);
        assertEquals(true, answer[3][6]);

        assertEquals(false, answer[4][1]);
        assertEquals(false, answer[4][3]);
        assertEquals(false, answer[4][4]);
        assertEquals(true, answer[4][5]);
        assertEquals(true, answer[4][6]);

        assertEquals(true, answer[5][0]);
        assertEquals(false, answer[5][1]);
        assertEquals(false, answer[5][2]);
        assertEquals(false, answer[5][3]);
        assertEquals(false, answer[5][4]);
        assertEquals(true, answer[5][5]);

        assertEquals(false, answer[6][2]);
        assertEquals(false, answer[6][3]);
        assertEquals(false, answer[6][4]);
        assertEquals(true, answer[6][6]);

        assertEquals(true, net1[1][5]);
        assertEquals(true, net1[3][2]);
        assertEquals(true, net1[3][1]);
        assertEquals(false, net1[1][1]);
        
        boolean[][] net2 = { {F, T, T, T, T, F }, {T, F, T, T, F, T }, {T, T, T, T, T, T }, {T, F, T, F, T, T }, {T, T, T, T, T, T }, {T, T, T, F, T, T } };
        v = new VirusInfection(net2);

        answer = v.spreadVirus(4);
        assertEquals(false, answer[0][1]);
        assertEquals(false, answer[0][2]);
        assertEquals(true, answer[0][3]);
        assertEquals(false, answer[0][4]);

        assertEquals(false, answer[1][0]);
        assertEquals(false, answer[1][1]);
        assertEquals(false, answer[1][3]);
        assertEquals(false, answer[1][4]);

        assertEquals(false, answer[2][0]);
        assertEquals(false, answer[2][1]);
        assertEquals(false, answer[2][4]);
        assertEquals(true, answer[2][5]);

        assertEquals(false, answer[3][0]);
        assertEquals(false, answer[3][2]);
        assertEquals(false, answer[3][3]);
        assertEquals(true, answer[3][4]);

        assertEquals(false, answer[4][0]);
        assertEquals(false, answer[4][1]);
        assertEquals(false, answer[4][2]);
        assertEquals(false, answer[4][3]);

        assertEquals(true, answer[5][0]);
        assertEquals(false, answer[5][1]);
        assertEquals(false, answer[5][2]);
        assertEquals(false, answer[5][3]);
        assertEquals(true, answer[5][5]);

        assertEquals(true, net2[0][4]);
        assertEquals(true, net2[2][1]);
    }

    public void testSpreadVirusMoreThanFour09() {
//        assertEquals(true, false);
        boolean[][] net1 = { {T, T, T, T, T, F, T }, {T, F, T, T, T, T, F }, {T, T, F, T, T, F, T }, {T, T, T, T, T, T, T }, {T, T, F, T, F, T, T }, {T, T, T, T, T, T, T }, {T, T, T, T, F, T, T } };

        VirusInfection v = new VirusInfection(net1);

        boolean[][] answer = v.spreadVirus(5);
        assertEquals(true, answer[0][4]);
        assertEquals(false, answer[1][4]);
        assertEquals(false, answer[3][6]);
        assertEquals(false, answer[4][5]);
        assertEquals(true, answer[4][6]);
        assertEquals(false, answer[6][1]);
        assertEquals(true, answer[6][6]);

        answer = v.spreadVirus(6);
        assertEquals(true, answer[0][3]);
        assertEquals(false, answer[0][4]);
        assertEquals(false, answer[4][6]);
        assertEquals(false, answer[5][5]);
        assertEquals(true, answer[5][6]);
        assertEquals(true, answer[6][0]);
        assertEquals(true, answer[6][6]);

        answer = v.spreadVirus(7);
        assertEquals(true, answer[0][2]);
        assertEquals(false, answer[0][3]);
        assertEquals(false, answer[5][6]);
        assertEquals(true, answer[6][0]);
        assertEquals(false, answer[6][5]);
        assertEquals(true, answer[6][6]);

        answer = v.spreadVirus(8);
        assertEquals(true, answer[0][1]);
        assertEquals(false, answer[0][2]);
        assertEquals(false, answer[6][5]);
        assertEquals(false, answer[6][6]);

        answer = v.spreadVirus(9);
        assertEquals(false, answer[0][1]);
        assertEquals(true, answer[3][0]);
        assertEquals(true, answer[6][0]);
        
        boolean[][] net2 = { {F, T, T, T, T, F }, {T, F, T, T, F, T }, {T, T, T, T, T, T }, {T, F, T, F, T, T }, {T, T, T, T, T, T }, {T, T, T, F, T, T } };
        v = new VirusInfection(net2);

        answer = v.spreadVirus(5);
        assertEquals(false, answer[0][3]);
        assertEquals(false, answer[2][5]);
        assertEquals(false, answer[3][4]);
        assertEquals(true, answer[3][5]);
        assertEquals(false, answer[5][0]);
        assertEquals(true, answer[5][5]);

        answer = v.spreadVirus(6);
        assertEquals(false, answer[3][5]);
        assertEquals(false, answer[4][4]);
        assertEquals(true, answer[4][5]);
        assertEquals(true, answer[5][5]);

        answer = v.spreadVirus(7);
        assertEquals(false, answer[4][5]);
        assertEquals(false, answer[5][4]);
        assertEquals(true, answer[5][5]);

        answer = v.spreadVirus(8);
        assertEquals(false, answer[5][4]);
        assertEquals(false, answer[5][5]);
    }

    public void testInfectAll10() {
        boolean[][] net0 = { {T, F, T, T }, {T, T, F, T }, {T, T, T, F } };

        VirusInfection v = new VirusInfection(net0);
        boolean answer = v.infectAll();
        assertEquals(false, answer);

        net0[1][0] = F;
        v = new VirusInfection(net0);
        answer = v.infectAll();
        assertEquals(true, answer);

        boolean[][] net1 = { {T, T, T, T, T, F, T }, {T, F, T, T, T, T, F }, {T, T, F, T, T, F, T }, {T, T, T, T, T, T, T }, {T, T, F, T, F, T, T }, {T, T, T, T, T, T, T }, {T, T, T, T, F, T, T } };

        v = new VirusInfection(net1);

        answer = v.infectAll();
        assertEquals(false, answer);
        assertEquals(true, net1[0][6]);
        assertEquals(true, net1[2][1]);

        boolean[][] net2 = { {F, T, T, T, T, F }, {T, F, T, T, F, T }, {T, T, T, T, T, T }, {T, F, T, F, T, T }, {T, T, T, T, T, T }, {T, T, T, F, T, T } };
        v = new VirusInfection(net2);

        answer = v.infectAll();
        assertEquals(true, answer);
        answer = v.infectAll();
        assertEquals(true, answer);
        assertEquals(true, net1[0][4]);
        assertEquals(true, net1[1][0]);
    }

    public void testDoors01() {
        Switches switch0 = new Switches(new int[] {0, 1, 3, 4});
        Switches switch1 = new Switches(new int[] {1, 2, 4});
        Switches switch2 = new Switches(new int[] {2, 3});
        Switches switch3 = new Switches(new int[] {0, 4});
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch0);
        switches.add(switch1);
        switches.add(switch2);
        switches.add(switch3);

        TheDoors tDoor = new TheDoors( switches, 5);
        ArrayList<Switches> ans = tDoor.findSwitchCombination(new int[] {2, 3});
        assertEquals(1, ans.size());
        assertEquals(false, ans.contains(switch0));
        assertEquals(false, ans.contains(switch1));
        assertEquals(true, ans.contains(switch2));
        assertEquals(false, ans.contains(switch3));

        ans = tDoor.findSwitchCombination(new int[] {0});
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch0));
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch2));
        assertEquals(false, ans.contains(switch3));

        ans = tDoor.findSwitchCombination(new int[] {0, 1});
        assertEquals(0, ans.size());
        assertEquals(false, ans.contains(switch0));
        assertEquals(false, ans.contains(switch1));
        assertEquals(false, ans.contains(switch2));
        assertEquals(false, ans.contains(switch3));
    }

    public void testDoors02() {
        Switches switch0 = new Switches(new int[] {2});
        Switches switch1 = new Switches(new int[] {0, 1});
        Switches switch2 = new Switches(new int[] {0, 1, 2});
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch0);
        switches.add(switch1);
        switches.add(switch2);

        TheDoors tDoor = new TheDoors( switches, 3);
        ArrayList<Switches> ans = tDoor.findSwitchCombination(new int[] {1});
        assertEquals(0, ans.size());

        Switches switch10 = new Switches(new int[] {0, 1, 3, 4});
        Switches switch11 = new Switches(new int[] {1, 2, 4});
        Switches switch12 = new Switches(new int[] {1, 3} );
        Switches switch13 = new Switches(new int[] {1});
        Switches switch14 = new Switches(new int[] {2, 4});

        switches = new ArrayList<Switches>();
        switches.add(switch10);
        switches.add(switch11);
        switches.add(switch12);
        switches.add(switch13);
        switches.add(switch14);

        tDoor = new TheDoors( switches, 5);
        ans = tDoor.findSwitchCombination(new int[] {0, 2, 3});
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switch10));
        assertEquals(true, ans.contains(switch11));

    }

    public void testDoors03() {
        Switches switch1 = new Switches(new int[] {0, 3});
        int[] sw2 = {0, 1, 2};   //
        Switches switch2 = new Switches(sw2);
        int[] sw4 = {4, 5};      //
        Switches switch4 = new Switches(sw4);
        int[] sw5 = {1, 5};      //
        Switches switch5 = new Switches(sw5);
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch1);
        switches.add(switch2);
        switches.add(switch4);
        switches.add(switch5);

        TheDoors tDoor = new TheDoors( switches, 6);
        int[] goal = {0, 2, 4};
        //        assertEquals(true, tDoor.findCombination(goal));
        ArrayList<Switches> ans = tDoor.findSwitchCombination(goal);
        assertEquals(3, ans.size());
        assertEquals(false, ans.contains(switch1));
        assertEquals(true, ans.contains(switch4));
        assertEquals(true, ans.contains(switch5));

        int[] goal1 = {2, 3, 4};
        ans = tDoor.findSwitchCombination(goal1);
        assertEquals(4, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch2));
        assertEquals(true, ans.contains(switch4));
        assertEquals(true, ans.contains(switch5));

        int[] goal2 = {3, 5};
        ans = tDoor.findSwitchCombination(goal2);
        assertEquals(0, ans.size());

        int[] goal3 = {0, 1, 3, 5};
        ans = tDoor.findSwitchCombination(goal3);
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(false, ans.contains(switch2));
        assertEquals(false, ans.contains(switch4));
        assertEquals(true, ans.contains(switch5));

        int[] goal4 = {0, 1, 2, 3};
        ans = tDoor.findSwitchCombination(goal4);
        assertEquals(0, ans.size());

        int[] swch10 = {0, 1, 3};
        Switches switch10 = new Switches(swch10);
        int[] swch11 = {1, 2};
        Switches switch11 = new Switches(swch11);
        int[] swch12 = {0, 3};
        Switches switch12 = new Switches(swch12);
        switches = new ArrayList<Switches>();
        switches.add(switch10);
        switches.add(switch11);
        switches.add(switch12);

        tDoor = new TheDoors( switches, 4);
        int[] goal11 = {1, 2, 3};
        ans = tDoor.findSwitchCombination(goal11);
        assertEquals(0, ans.size());

        int[] swch13 = {2, 3};
        Switches switch13 = new Switches(swch13);
        switches.add(switch13);
        int[] goal12 = {1, 2, 3};
        ans = tDoor.findSwitchCombination(goal12);
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch10));
        assertEquals(true, ans.contains(switch12));
        assertEquals(true, ans.contains(switch13));
    }

    public void testDoorsOnlyTwoDoors04() {
        int[] switch1 = {0, 1};
        Switches switch0 = new Switches(switch1);
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch0);

        TheDoors tDoor = new TheDoors( switches, 2);
        int[] goal = {0, 1};
        ArrayList<Switches> ans = tDoor.findSwitchCombination(goal);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switch0));

        int[] goala = {0};
        ans = tDoor.findSwitchCombination(goala);
        assertEquals(0, ans.size());

        int[] goalb = {1};
        ans = tDoor.findSwitchCombination(goala);
        assertEquals(0, ans.size());

        int[] switch10 = {0};
        Switches switchA = new Switches(switch10);
        int[] switch11 = {1};
        Switches switchB = new Switches(switch11);
        switches = new ArrayList<Switches>();
        switches.add(switchA);
        switches.add(switchB);

        tDoor = new TheDoors( switches, 2);
        int[] goal11 = {1};
        ans = tDoor.findSwitchCombination(goal11);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switchB));

        int[] goal12 = {0};
        ans = tDoor.findSwitchCombination(goal12);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switchA));

        int[] goal13 = {0, 1};
        ans = tDoor.findSwitchCombination(goal13);
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switchA));
        assertEquals(true, ans.contains(switchB));
    }

    public void testDoorsExactlyThreeDoors05() {
        int[] sw1 = {0, 1};
        Switches switch0 = new Switches(sw1);
        int[] sw2 = {1, 2};
        Switches switch1 = new Switches(sw2);
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch0);
        switches.add(switch1);

        TheDoors tDoor = new TheDoors( switches, 3);
        int[] goal = {0, 1, 2};
        ArrayList<Switches> ans = tDoor.findSwitchCombination(goal);
        assertEquals(0, ans.size());

        int[] goala = {0, 2};
        ans = tDoor.findSwitchCombination(goala);
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switch0));
        assertEquals(true, ans.contains(switch1));

        int[] goalb = {1, 2};
        ans = tDoor.findSwitchCombination(goalb);
        assertEquals(1, ans.size());
        assertEquals(false, ans.contains(switch0));
        assertEquals(true, ans.contains(switch1));

        int[] goalc = {0, 1};
        ans = tDoor.findSwitchCombination(goalc);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switch0));

        int[] switch11 = {0};
        ans = tDoor.findSwitchCombination(switch11);
        assertEquals(0, ans.size());

        int[] goal12 = {2};
        ans = tDoor.findSwitchCombination(goal12);
        assertEquals(0, ans.size());
    }

    public void testDoorsExactlyTwoAndThreeDoors06() {
        testDoorsOnlyTwoDoors04();
        testDoorsExactlyThreeDoors05();
    }

    public void testDoorsExactlyFourDoors07() {
        int[] sw1 = {0, 2};
        Switches switch0 = new Switches(sw1);
        int[] sw2 = {1, 3};
        Switches switch1 = new Switches(sw2);
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch0);
        switches.add(switch1);

        TheDoors tDoor = new TheDoors( switches, 4);
        int[] goal = {0, 1, 2};
        ArrayList<Switches> ans = tDoor.findSwitchCombination(goal);
        assertEquals(0, ans.size());

        int[] goala = {0, 2};
        ans = tDoor.findSwitchCombination(goala);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switch0));

        int[] goalb = {1, 2};
        ans = tDoor.findSwitchCombination(goalb);
        assertEquals(0, ans.size());

        int[] goalc = {1};
        ans = tDoor.findSwitchCombination(goalc);
        assertEquals(0, ans.size());

        int[] sw3 = {1, 2};
        Switches switch3 = new Switches(sw3);
        switches.add(switch3);
        tDoor = new TheDoors( switches, 4);

        int[] goal11 = {0, 3};
        ans = tDoor.findSwitchCombination(goal11);
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch0));
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch3));

        int[] goal12 = {2, 3};
        ans = tDoor.findSwitchCombination(goal12);
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch3));

        int[] goal13 = {0, 1, 2};
        ans = tDoor.findSwitchCombination(goal13);
        assertEquals(0, ans.size());
    }

    public void testDoorsExactlyFiveAndSixDoors08() {
        int[] sw1 = {0, 2};
        Switches switch1 = new Switches(sw1);
        int[] sw2 = {1, 3};
        Switches switch2 = new Switches(sw2);
        int[] sw3 = {4};
        Switches switch3 = new Switches(sw3);
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch1);
        switches.add(switch2);
        switches.add(switch3);

        TheDoors tDoor = new TheDoors( switches, 5);
        int[] goal = {0, 1, 2};
        ArrayList<Switches> ans = tDoor.findSwitchCombination(goal);
        assertEquals(0, ans.size());
        assertEquals(false, ans.contains(switch1));
        assertEquals(false, ans.contains(switch2));
        assertEquals(false, ans.contains(switch3));

        int[] goala = {0, 2};
        ans = tDoor.findSwitchCombination(goala);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switch1));

        int[] goala1 = {0, 2, 4};
        ans = tDoor.findSwitchCombination(goala1);
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch3));

        int[] goalb = {1, 2};
        ans = tDoor.findSwitchCombination(goalb);
        assertEquals(0, ans.size());

        int[] sw4 = {1, 3, 5};
        Switches switch4 = new Switches(sw4);
        switches.add(switch4);
        tDoor = new TheDoors( switches, 6);

        int[] goal11 = {0, 2, 5};
        ans = tDoor.findSwitchCombination(goal11);
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch2));
        assertEquals(true, ans.contains(switch4));

        int[] goal13 = {0, 2, 4, 5};
        ans = tDoor.findSwitchCombination(goal13);
        assertEquals(4, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch2));
        assertEquals(true, ans.contains(switch3));
        assertEquals(true, ans.contains(switch4));

        int[] sw5 = {1, 2, 3};
        Switches switch5 = new Switches(sw5);
        switches.add(switch5);
        tDoor = new TheDoors(switches, 6);

        int[] goal15 = {1, 3};
        ans = tDoor.findSwitchCombination(goal15);
        assertEquals(1, ans.size());
        assertEquals(true, ans.contains(switch2));
    }

    public void testDoorsExactlyFourFiveAndSixDoors09() {
        testDoorsExactlyFourDoors07();
        testDoorsExactlyFiveAndSixDoors08();
    }

    public void testDoorsSevenAndMoreDoors10() {
        int[] sw1 = {0, 2, 4, 6};
        Switches switch1 = new Switches(sw1);
        int[] sw2 = {1, 3, 5};
        Switches switch2 = new Switches(sw2);
        int[] sw3 = {0, 2, 4, 5};
        Switches switch3 = new Switches(sw3);
        int[] sw4 = {1, 4};
        Switches switch4 = new Switches(sw4);
        int[] sw5 = {0, 3, 6};
        Switches switch5 = new Switches(sw5);
        int[] sw6 = {1, 5};
        Switches switch6 = new Switches(sw6);
        int[] sw7 = {3, 5, 6};
        Switches switch7 = new Switches(sw7);
        List<Switches> switches = new ArrayList<Switches>();
        switches.add(switch1);
        switches.add(switch2);
        switches.add(switch3);
        switches.add(switch4);
        switches.add(switch5);
        switches.add(switch6);
        switches.add(switch7);

        TheDoors tDoor = new TheDoors( switches, 7);
// another answer        
        ArrayList<Switches> ans = tDoor.findSwitchCombination(new int[] {2, 4});
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch3));
        assertEquals(true, ans.contains(switch5));
        assertEquals(true, ans.contains(switch7));

        
        ans = tDoor.findSwitchCombination(new int[] {0, 1, 2, 3, 4, 5, 6});
        assertEquals(2, ans.size());
        assertEquals(true, ans.contains(switch1));
        assertEquals(true, ans.contains(switch2));

        ans = tDoor.findSwitchCombination(new int[] {4});
        assertEquals(0, ans.size());

        tDoor = new TheDoors( switches, 8);
        ans = tDoor.findSwitchCombination(new int[] {2, 4, 7});
        assertEquals(0, ans.size());

        switches = new ArrayList<Switches>();
        switch1 = new Switches(new int[] {0, 3, 7});
        switches.add(switch1);
        switch2 = new Switches(new int[] {8, 9});
        switches.add(switch2);
        switch3 = new Switches(new int[] {1, 4, 6});
        switches.add(switch3);
        switch4 = new Switches(new int[] {1, 3, 7, 8});
        switches.add(switch4);
        switch5 = new Switches(new int[] {3, 4, 6, 8});
        switches.add(switch5);
        switch6 = new Switches(new int[] {2, 5});
        switches.add(switch6);
        switch7 = new Switches(new int[] {0, 4, 6});
        switches.add(switch7);
        Switches switch8 = new Switches(new int[] {2, 9});
        switches.add(switch8);
        Switches switch9 = new Switches(new int[] {2, 5, 7});
        switches.add(switch9);
        Switches switch10 = new Switches(new int[] {0, 1, 5, 6, 8, 9});
        switches.add(switch10);

        tDoor = new TheDoors( switches, 10);

        ans = tDoor.findSwitchCombination(new int[] {0, 9});
        assertEquals(0, ans.size());
        assertEquals(false, ans.contains(switch2));

//   another answer
        ans = tDoor.findSwitchCombination(new int[] {1, 2, 3, 6, 8, 9});
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch1));    //  0,     3,   7
        assertEquals(true, ans.contains(switch9));    //       2, 5,  7
        assertEquals(true, ans.contains(switch10));   //  0, 1,   5, 6, 8, 9

        ans = tDoor.findSwitchCombination(new int[] {1, 2, 3, 8, 9});
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(switch3));
        assertEquals(true, ans.contains(switch5));
        assertEquals(true, ans.contains(switch8));

//   another answer
        ans = tDoor.findSwitchCombination(new int[] {1, 2, 3, 8});
        assertEquals(6, ans.size());
        assertEquals(true, ans.contains(switch1));   //  
        assertEquals(true, ans.contains(switch2));   //  
        assertEquals(false, ans.contains(switch3));   //  
        assertEquals(true, ans.contains(switch4));   //  1, 3, 7, 8
        assertEquals(true, ans.contains(switch5));   //  
        assertEquals(false, ans.contains(switch6));   //  
        assertEquals(true, ans.contains(switch7));   //  
        assertEquals(true, ans.contains(switch8));   //  
        assertEquals(false, ans.contains(switch9));   //  2, 5, 7
        assertEquals(false, ans.contains(switch10));   //  
    }

    public void testLineUp01() {
        LineUp lu = new LineUp();
        Player seager = new Player("Seager", 150, 50, 9, 2, 6, 8);

        List<Player> ps = new ArrayList<Player>();
        ps.add(seager);
        ps.add(new Player("Ruth", 135, 52, 10, 1, 17, 12));
        ps.add(new Player("Trout", 145, 40, 18, 5, 13, 9));
        ps.add(new Player("Beltre", 175, 45, 3, 0, 1, 2));
        ps.add(new Player("Alltuve", 125, 72, 23, 5, 10, 11));
        ps.add(new Player("Bellinger", 150, 40, 11, 0, 14, 7));
        ps.add(new Player("Puig", 145, 40, 19, 4, 13, 9));
        ps.add(new Player("Ohtani", 115, 25, 2, 0, 6, 4));
        ps.add(new Player("Arenado", 155, 51, 19, 0, 16, 10));
        lu.addPlayers(ps);

        assertEquals(50-9-2-6, seager.getNumSingles());
        assertEquals(81/150. /*(9*2+2*3+6*4+50-9-2-6)/150.*/, seager.getSluggingPercent(), 0.001);
        assertEquals(50./150., seager.getBattingAverage(), 0.001);
        assertEquals((50+8)/(150 + 8.), seager.getOnBasePercentage(), 0.001);

        assertEquals(new Player("Alltuve", 125, 72, 23, 5, 10, 11), lu.getCleanUp());
        assertEquals(new Player("Ruth", 135, 52, 10, 1, 17, 12), lu.getLeadOff());
        assertEquals(new Player("Arenado", 155, 51, 19, 0, 16, 10), lu.getThirdBatter());
        assertEquals(new Player("Trout", 145, 40, 18, 5, 13, 9), lu.getSecondBatter());
    }

    public void testPlayerStats02() {
        int ab = 231;
        int h = 62;
        int d = 13;
        int t = 7;
        int hr =21;
        int bb = 11;
        Player a = new Player("A", ab, h, d, t, hr, bb);

        assertEquals(1.0* h / ab, a.getBattingAverage(), 0.001);
        assertEquals((0.0 + 2*d + 3*t + 4*hr + h - d - t - hr)/ab, a.getSluggingPercent(), 0.001);
        assertEquals((0.0 + h + bb)/(ab + bb), a.getOnBasePercentage(), 0.001);

        ab = 483;
        h = 201;
        d = 45;
        t = 11;
        hr = 38;
        bb = 41;
        a = new Player("A", ab, h, d, t, hr, bb);

        assertEquals(1.0* h / ab, a.getBattingAverage(), 0.001);
        assertEquals((0.0 + 2*d + 3*t + 4*hr + h - d - t - hr)/ab, a.getSluggingPercent(), 0.001);
        assertEquals((0.0 + h + bb)/(ab + bb), a.getOnBasePercentage(), 0.001);
    }

    /*
     *   The clean up batter (bats fourth) is the Player with the highest slugging percentage.
     *   In case of tie, pick the Player with most HRs, if still tied pick Player with greatest Batting average.
     */
    public void testCleanUpHitterNoTies03() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 72, 9, 2, 21, 11));
        lu.addPlayers(ps);

        assertEquals(new Player("west", 200, 72, 9, 2, 21, 11), lu.getCleanUp());

        ps.set(2, new Player("alex", 200, 74, 9, 2, 21, 11));

        lu = new LineUp();
        lu.addPlayers(ps);
        //        assertEquals(ps.get(2).getSluggingPercent(), ps.get(8).getSluggingPercent(), 0.001);
        assertEquals(new Player("alex", 200, 74, 9, 2, 21, 11), lu.getCleanUp());
    }

    /*
     *   The clean up batter (bats fourth) is the Player with the highest slugging percentage.
     *   In case of tie, pick the Player with most HRs, if still tied pick Player with greatest Batting average.
     */
    public void testCleanUpHitterMostHRs04() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 74, 7, 2, 22, 11));   //   slg == 151 / 200
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 75, 9, 2, 21, 11));   //   slg == 151 / 200
        lu.addPlayers(ps);

        assertEquals(ps.get(2).getSluggingPercent(), ps.get(8).getSluggingPercent(), 0.00001);
        assertEquals(new Player("alex", 200, 74, 7, 2, 22, 11), lu.getCleanUp());

        ps.set(7, new Player("sage", 200, 72, 6, 2, 23, 11));   //   slg == 151 / 200
        lu = new LineUp();
        lu.addPlayers(ps);

        assertEquals(ps.get(7).getSluggingPercent(), ps.get(2).getSluggingPercent(), 0.00001);
        assertEquals(new Player("sage", 200, 72, 6, 2, 23, 11), lu.getCleanUp());  // same slugg && HR < BA

        Player temp = ps.get(5);
        ps.set(5, ps.get(7));
        ps.set(7, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("sage", 200, 72, 6, 2, 23, 11), lu.getCleanUp());
    }

    /*
     *   The clean up batter (bats fourth) is the Player with the highest slugging percentage.
     *   In case of tie, pick the Player with most HRs,
     *   if still tied pick Player with highest Batting average.
     */
    public void testCleanUpHitterHighestBA05() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 74, 7, 1, 22, 11));   //   slg == 149 / 200
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 73, 6, 2, 22, 11));   //   slg == 149 / 200
        lu.addPlayers(ps);

        assertEquals(new Player("alex", 200, 74, 7, 1, 22, 11), lu.getCleanUp());

        ps.set(7, new Player("sage", 200, 75, 4, 2, 22, 11));   //   slg == 149 / 200
        lu = new LineUp();
        lu.addPlayers(ps);

        assertEquals(new Player("sage", 200, 75, 4, 2, 22, 11), lu.getCleanUp());  // same slugg && HR < BA

        Player temp = ps.get(5);
        ps.set(5, ps.get(7));
        ps.set(7, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("sage", 200, 75, 4, 2, 22, 11), lu.getCleanUp());
    }

    /*   
     *   The leadoff batter (bats first) is the player with the highest on Base Percentage.
     *   In case of tie, pick the Player with greatest Batting average, if still tied pick Player with most singles.
     */
    public void testLeadOffHitterNoTies06() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 40, 11));  //  clean up hitter
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 21));  //  96 / 221   
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 72, 9, 2, 20, 11));
        lu.addPlayers(ps);
        assertEquals(new Player("lake", 200, 75, 9, 2, 20, 21), lu.getLeadOff());

        lu = new LineUp();
        ps.set(3, new Player("andy", 200, 76, 9, 2, 20, 20));   //  96 / 220
        lu.addPlayers(ps);
        assertEquals(new Player("andy", 200, 76, 9, 2, 20, 20), lu.getLeadOff());

        Player temp = ps.get(3);
        ps.set(3, ps.get(8));
        ps.set(8, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("andy", 200, 76, 9, 2, 20, 20), lu.getLeadOff());
    }

    /*   
     *   The leadoff batter (bats first) is the player with the highest on Base Percentage.
     *   In case of tie, pick the Player with highest Batting average, if still tied pick Player with most singles.
     */
    public void testLeadOffHitterHighestBA07() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 40, 11));  //  clean up hitter
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("jami", 201, 76, 9, 2, 20, 20));  //  96 / 221
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 21));  //  96 / 221   
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 72, 9, 2, 20, 11));
        lu.addPlayers(ps);
        assertEquals(new Player("jami", 201, 76, 9, 2, 20, 20), lu.getLeadOff());

        ps.set(3, new Player("andy", 202, 77, 9, 2, 20, 19));  //   96 / 221
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("andy", 202, 77, 9, 2, 20, 19), lu.getLeadOff());

        Player temp = ps.get(5);
        ps.set(5, ps.get(0));
        ps.set(0, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("andy", 202, 77, 9, 2, 20, 19), lu.getLeadOff());
    }

    /*   
     *   The leadoff batter (bats first) is the player with the highest on Base Percentage.
     *   In case of tie, pick the Player with highest Batting average,
     *   if still tied pick Player with most singles.
     */
    public void testLeadOffHitterMostSingles08() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 40, 11));  //  clean up hitter
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 19, 21));  //  96 / 221
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 21));  //  96 / 221
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 21));  //  96 / 221   
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 72, 9, 2, 20, 11));
        lu.addPlayers(ps);
        assertEquals(new Player("drew", 200, 75, 9, 2, 19, 21), lu.getLeadOff());

        ps.set(0, new Player("jodi", 200, 75, 9, 0, 20, 21));
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("jodi", 200, 75, 9, 0, 20, 21), lu.getLeadOff());

        Player temp = ps.get(0);
        ps.set(0, ps.get(2));
        ps.set(2, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("jodi", 200, 75, 9, 0, 20, 21), lu.getLeadOff());
    }

    /*
     * 	 The Player batting third is the Player with the greatest number of Hits.
     *   In case of tie, pick the Player with number of At Bats,
     *   if still tied pick Player with most doubles plus triples.
     */
    public void testThirdHitterNoTies09() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 61));  //  lead Off hitter
        ps.add(new Player("samy", 200, 85, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 19, 1));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));  
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));  
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 72, 9, 2, 41, 11));  //  clean up hitter
        lu.addPlayers(ps);

        assertEquals(new Player("samy", 200, 85, 9, 2, 20, 11), lu.getThirdBatter());

        ps.set(4, new Player("drew", 200, 87, 9, 2, 20, 11));
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("drew", 200, 87, 9, 2, 20, 11), lu.getThirdBatter());

        Player temp = ps.get(4);
        ps.set(4, ps.get(5));
        ps.set(5, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("drew", 200, 87, 9, 2, 20, 11), lu.getThirdBatter());
    }

    /*
     * 	 The Player batting third is the Player with the greatest number of Hits.
     *   In case of tie, pick the Player with number of At Bats,
     *   if still tied pick Player with most doubles plus triples.
     */
    public void testThirdHitterMostAB10() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 61));  //  lead Off hitter
        ps.add(new Player("samy", 200, 85, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("andy", 201, 85, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 19, 1));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));  
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));  
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 72, 9, 2, 41, 11));  //  clean up hitter
        lu.addPlayers(ps);

        assertEquals(new Player("andy", 201, 85, 9, 2, 20, 11), lu.getThirdBatter());

        ps.set(6, new Player("lake", 202, 85, 9, 2, 20, 11));
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("lake", 202, 85, 9, 2, 20, 11), lu.getThirdBatter());

        Player temp = ps.get(6);
        ps.set(6, ps.get(8));
        ps.set(8, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("lake", 202, 85, 9, 2, 20, 11), lu.getThirdBatter());
    }

    /*
     * 	 The Player batting third is the Player with the greatest number of Hits.
     *   In case of tie, pick the Player with number of At Bats,
     *   if still tied pick Player with most doubles plus triples.
     */
    public void testThirdHitterMost2Band3B11() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 20, 61));  //  lead Off hitter
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("drew", 200, 75, 9, 2, 19, 1));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));  
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));  
        ps.add(new Player("sage", 200, 75, 9, 3, 20, 11));
        ps.add(new Player("west", 200, 75, 9, 2, 41, 11));  //  clean up hitter
        lu.addPlayers(ps);

        assertEquals(new Player("sage", 200, 75, 9, 3, 20, 11), lu.getThirdBatter());

        ps.set(5, new Player("jami", 200, 75, 9, 4, 20, 11));
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("jami", 200, 75, 9, 4, 20, 11), lu.getThirdBatter());

        Player temp = ps.get(5);
        ps.set(5, ps.get(1));
        ps.set(1, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("jami", 200, 75, 9, 4, 20, 11), lu.getThirdBatter());
    }

    /*
     *   The Player batting second is the Player with the most base on balls.
     *   In case of tie, pick the Player with highest on Base Percentage,
     *   if still tied pick Player with most triples.
     */
    public void testSecondHitterNoTies12() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 40, 11));    //  clean up hitter
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 80, 9, 2, 20, 11));    // third batter
        ps.add(new Player("andy", 200, 35, 9, 2, 20, 30));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 75, 9, 2, 20, 40));    // lead off hitter
        lu.addPlayers(ps);

        assertEquals(new Player("andy", 200, 35, 9, 2, 20, 30), lu.getSecondBatter());

        lu = new LineUp();
        ps.set(7, new Player("sage", 200, 35, 9, 2, 20, 31));
        lu.addPlayers(ps);
        assertEquals(new Player("sage", 200, 35, 9, 2, 20, 31), lu.getSecondBatter());

        Player temp = ps.get(7);
        ps.set(7, ps.get(5));
        ps.set(5, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("sage", 200, 35, 9, 2, 20, 31), lu.getSecondBatter());
    }

    /*
     *   The Player batting second is the Player with the most base on balls.
     *   In case of tie, pick the Player with highest on Base Percentage,
     *   if still tied pick Player with most triples.
     */
    public void testSecondHitterHighestonBase13() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 40, 11));    //  clean up hitter
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 80, 9, 2, 20, 11));    // third batter
        ps.add(new Player("andy", 200, 35, 9, 2, 20, 30));
        ps.add(new Player("drew", 199, 35, 9, 2, 20, 30));
        ps.add(new Player("jami", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 75, 9, 2, 20, 40));    // lead off hitter
        lu.addPlayers(ps);

        assertEquals(new Player("drew", 199, 35, 9, 2, 20, 30), lu.getSecondBatter());

        lu = new LineUp();
        ps.set(3, new Player("andy", 198, 35, 9, 2, 20, 30));
        lu.addPlayers(ps);
        assertEquals(new Player("andy", 198, 35, 9, 2, 20, 30), lu.getSecondBatter());

        Player temp = ps.get(1);
        ps.set(1, ps.get(3));
        ps.set(3, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("andy", 198, 35, 9, 2, 20, 30), lu.getSecondBatter());
    }

    /*
     *   The Player batting second is the Player with the most base on balls.
     *   In case of tie, pick the Player with highest on Base Percentage,
     *   if still tied pick Player with most triples.
     */
    public void testSecondHitterMostTriples14() {
        LineUp lu = new LineUp();

        List<Player> ps = new ArrayList<Player>();
        ps.add(new Player("jodi", 200, 75, 9, 2, 40, 11));    //  clean up hitter
        ps.add(new Player("samy", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("alex", 200, 80, 9, 2, 20, 11));    // third batter
        ps.add(new Player("andy", 200, 75, 9, 2, 20, 30));
        ps.add(new Player("drew", 200, 75, 9, 2, 20, 30));
        ps.add(new Player("jami", 200, 75, 9, 3, 20, 30));
        ps.add(new Player("lake", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("sage", 200, 75, 9, 2, 20, 11));
        ps.add(new Player("west", 200, 75, 9, 2, 20, 40));    // lead off hitter
        lu.addPlayers(ps);

        assertEquals(new Player("jami", 200, 75, 9, 3, 20, 30), lu.getSecondBatter());

        lu = new LineUp();
        ps.set(4, new Player("drew", 200, 75, 9, 4, 20, 30));
        lu.addPlayers(ps);
        assertEquals(new Player("drew", 200, 75, 9, 4, 20, 30), lu.getSecondBatter());

        Player temp = ps.get(4);
        ps.set(4, ps.get(3));
        ps.set(3, temp);
        lu = new LineUp();
        lu.addPlayers(ps);
        assertEquals(new Player("drew", 200, 75, 9, 4, 20, 30), lu.getSecondBatter());
    }

    public void testAllLineUpBonus15() {
        testCleanUpHitterNoTies03();
        testCleanUpHitterMostHRs04();
        testCleanUpHitterHighestBA05();
        testLeadOffHitterNoTies06();
        testLeadOffHitterHighestBA07();
        testLeadOffHitterMostSingles08();
        testThirdHitterNoTies09();
        testThirdHitterMostAB10();
        testThirdHitterMost2Band3B11();
        testSecondHitterNoTies12();
    }

   public void testLCMPlusPlus01() {
      assertEquals(12, LCM_PlusPlus.LCMof2Numbers(6, 4));
      assertEquals(459, LCM_PlusPlus.LCMof2Numbers(17, 27));
      assertEquals(2310, LCM_PlusPlus.LCMof2Numbers(55, 42));

      int[] number1 = {4, 7, 24};
      assertEquals(168, LCM_PlusPlus.LCMofMultipleNumbers(number1));

      int[] number2 = {6, 25, 14, 33};
      assertEquals(11550, LCM_PlusPlus.LCMofMultipleNumbers(number2));

      assertEquals(3, LCM_PlusPlus.minLCMValue(12, 4));
      assertEquals(55, LCM_PlusPlus.minLCMValue(2310, 42));
      assertEquals(42, LCM_PlusPlus.minLCMValue(2310, 55));
      assertEquals(21, LCM_PlusPlus.minLCMValue(2310, 55*2));

//      assertEquals(2*2*2*3*3*5, LCM_PlusPlus.maxLCMValue(2*2*2*3*3*5, 2*2*2*3*3*5));
   }
   public void testLCMof2Numbers02() {
      assertEquals(917, LCM_PlusPlus.LCMof2Numbers(1, 917));
      assertEquals(2*3*7*3*3*13, LCM_PlusPlus.LCMof2Numbers(3*13, 2*3*7*9));
      assertEquals(2*5*5*11*11*13*17, LCM_PlusPlus.LCMof2Numbers(5*11*11*13, 2*5*5*11*17));
   }

   public void testLCMof3Numbers03() {
      int[] number1 = {22, 39, 24};
      assertEquals(3432, LCM_PlusPlus.LCMofMultipleNumbers(number1));

      int[] number2 = {847, 455, 102};
      assertEquals(5615610, LCM_PlusPlus.LCMofMultipleNumbers(number2));
   }

/*
 *    all of the following testers need to be updated  :(
 */   
   public void testLCMof4Numbers04() {
      int[] number1 = {8, 24, 22, 39};
      assertEquals(3432, LCM_PlusPlus.LCMofMultipleNumbers(number1));

      int[] number2 = {24, 36, 132, 45};
      assertEquals(3960, LCM_PlusPlus.LCMofMultipleNumbers(number2));

      int[] number3 = {124, 106, 372, 5};
      assertEquals(98580, LCM_PlusPlus.LCMofMultipleNumbers(number3));
   }

   public void testLCMofMultipleNumbers05() {
      int[] number1 = {27, 19, 24, 6, 21};
      assertEquals(28728, LCM_PlusPlus.LCMofMultipleNumbers(number1));

      int[] number2 = {63, 156, 48, 33, 95};
      assertEquals(13693680, LCM_PlusPlus.LCMofMultipleNumbers(number2));

      int[] number3 = {135, 116, 272, 51, 1};
      assertEquals(1064880, LCM_PlusPlus.LCMofMultipleNumbers(number3));
   }

   public void testMinLCMValue06() {
      assertEquals(24  , LCM_PlusPlus.minLCMValue(312, 26));
      assertEquals(1211, LCM_PlusPlus.minLCMValue(6055, 5));
//      assertEquals(42, LCM_PlusPlus.minLCMValue(2310, 55));
//      assertEquals(21, LCM_PlusPlus.minLCMValue(2310, 55*2));
   }

   public void testLCMof2NumbersAndMinLCMValue07() {
      testLCMof2Numbers02();
      testMinLCMValue06();
   }

   public void testLCMof3NumbersAndMinLCMValue08() {
      testLCMof3Numbers03();
      testMinLCMValue06();
   }

   public void testLCMof4NumbersAndMinLCMValue09() {
      testLCMof4Numbers04();
      testMinLCMValue06();
   }

   public void testtestLCMofMultipleNumbersAndMinLCMValue10() {
      testLCMofMultipleNumbers05();
      testMinLCMValue06();
   }

   public void testKeyboard01() {
        assertEquals(0, KeyBoardCalculations.kbDistance("A", "A"));
        assertEquals(1, KeyBoardCalculations.kbDistance("E", "R"));
        assertEquals(3, KeyBoardCalculations.kbDistance("W", "C"));
        assertEquals(8, KeyBoardCalculations.kbDistance("Q", "M"));

        assertEquals(1.0, KeyBoardCalculations.averageDistance("WAS"), 0.0002);
        assertEquals(5.0 / 3., KeyBoardCalculations.averageDistance("KING"), 0.0002);
        assertEquals(19.0 / 5, KeyBoardCalculations.averageDistance("SAMPLE"), 0.0002);
        assertEquals(19.0 / 7, KeyBoardCalculations.averageDistance("COMPUTER"), 0.0002);
        assertEquals(18 / 6, KeyBoardCalculations.averageDistance("AVERAGE"), 0.0002);
        assertEquals(40.0 / 6, KeyBoardCalculations.averageDistance("ALABAMA"), 0.0002);

        assertEquals(0, KeyBoardCalculations.numDirectionChanges("MIK"));
        assertEquals(0, KeyBoardCalculations.numDirectionChanges("MJU"));
        assertEquals(0, KeyBoardCalculations.numDirectionChanges("WZA"));
        assertEquals(0, KeyBoardCalculations.numDirectionChanges("NHY"));
        assertEquals(1, KeyBoardCalculations.numDirectionChanges("JUM"));
        assertEquals(1, KeyBoardCalculations.numDirectionChanges("WAZ"));
        assertEquals(1, KeyBoardCalculations.numDirectionChanges("TFV"));
        
        assertEquals(0, KeyBoardCalculations.numDirectionChanges("KING"));
        assertEquals(1, KeyBoardCalculations.numDirectionChanges("WAS"));
        assertEquals(2, KeyBoardCalculations.numDirectionChanges("SAMPLE"));
        assertEquals(4, KeyBoardCalculations.numDirectionChanges("COMPUTER"));
        assertEquals(5, KeyBoardCalculations.numDirectionChanges("AVERAGE"));
        assertEquals(5, KeyBoardCalculations.numDirectionChanges("ALABAMA"));

        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("WAS"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("KING"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("SAMPLE"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("COMPUTER"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("AVERAGE"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("ALABAMA"));
    }

    public void testKeyboardDistanceAdjacentLetters02() {
        assertEquals(1, KeyBoardCalculations.kbDistance("Q", "A"));
        assertEquals(1, KeyBoardCalculations.kbDistance("D", "R"));
        assertEquals(1, KeyBoardCalculations.kbDistance("E", "R"));
        assertEquals(1, KeyBoardCalculations.kbDistance("T", "R"));
        assertEquals(1, KeyBoardCalculations.kbDistance("B", "H"));
        assertEquals(1, KeyBoardCalculations.kbDistance("M", "K"));
        assertEquals(1, KeyBoardCalculations.kbDistance("P", "L"));
        assertEquals(1, KeyBoardCalculations.kbDistance("L", "O"));
        assertEquals(1, KeyBoardCalculations.kbDistance("Z", "X"));
        assertEquals(1, KeyBoardCalculations.kbDistance("V", "G"));

        assertEquals(1, KeyBoardCalculations.kbDistance("S", "Z"));
        assertEquals(1, KeyBoardCalculations.kbDistance("X", "D"));
        assertEquals(1, KeyBoardCalculations.kbDistance("R", "F"));
        assertEquals(1, KeyBoardCalculations.kbDistance("G", "Y"));
        assertEquals(1, KeyBoardCalculations.kbDistance("U", "H"));
        assertEquals(1, KeyBoardCalculations.kbDistance("H", "N"));
        assertEquals(1, KeyBoardCalculations.kbDistance("M", "K"));
        assertEquals(1, KeyBoardCalculations.kbDistance("O", "I"));
        assertEquals(1, KeyBoardCalculations.kbDistance("I", "J"));
        assertEquals(1, KeyBoardCalculations.kbDistance("W", "E"));
    }

    public void testKeyboardDistanceNonAdjacentLetters03() {
        assertEquals(0, KeyBoardCalculations.kbDistance("W", "W"));
        assertEquals(0, KeyBoardCalculations.kbDistance("Q", "Q"));
        assertEquals(0, KeyBoardCalculations.kbDistance("T", "T"));
        assertEquals(0, KeyBoardCalculations.kbDistance("B", "B"));
        assertEquals(0, KeyBoardCalculations.kbDistance("N", "N"));

        assertEquals(2, KeyBoardCalculations.kbDistance("W", "D"));
        assertEquals(2, KeyBoardCalculations.kbDistance("F", "B"));
        assertEquals(2, KeyBoardCalculations.kbDistance("K", "H"));
        assertEquals(2, KeyBoardCalculations.kbDistance("W", "D"));
        assertEquals(2, KeyBoardCalculations.kbDistance("P", "K"));
        assertEquals(2, KeyBoardCalculations.kbDistance("L", "M"));
        assertEquals(2, KeyBoardCalculations.kbDistance("G", "N"));

        assertEquals(3, KeyBoardCalculations.kbDistance("R", "H"));
        assertEquals(3, KeyBoardCalculations.kbDistance("C", "H"));
        assertEquals(3, KeyBoardCalculations.kbDistance("H", "O"));
        assertEquals(3, KeyBoardCalculations.kbDistance("S", "T"));
        assertEquals(3, KeyBoardCalculations.kbDistance("Q", "X"));

        assertEquals(4, KeyBoardCalculations.kbDistance("O", "B"));
        assertEquals(4, KeyBoardCalculations.kbDistance("T", "M"));
        assertEquals(4, KeyBoardCalculations.kbDistance("Z", "T"));
        assertEquals(4, KeyBoardCalculations.kbDistance("Z", "B"));
        assertEquals(4, KeyBoardCalculations.kbDistance("C", "M"));

        assertEquals(5, KeyBoardCalculations.kbDistance("B", "P"));
        assertEquals(5, KeyBoardCalculations.kbDistance("A", "B"));
        assertEquals(5, KeyBoardCalculations.kbDistance("C", "I"));
        assertEquals(5, KeyBoardCalculations.kbDistance("X", "J"));
        assertEquals(5, KeyBoardCalculations.kbDistance("K", "D"));
        assertEquals(5, KeyBoardCalculations.kbDistance("N", "Z"));
        assertEquals(5, KeyBoardCalculations.kbDistance("E", "N"));

        assertEquals(6, KeyBoardCalculations.kbDistance("D", "L"));
        assertEquals(6, KeyBoardCalculations.kbDistance("E", "M"));
        assertEquals(6, KeyBoardCalculations.kbDistance("P", "F"));
        assertEquals(6, KeyBoardCalculations.kbDistance("B", "Q"));
        assertEquals(6, KeyBoardCalculations.kbDistance("A", "N"));

        assertEquals(7, KeyBoardCalculations.kbDistance("Z", "I"));
        assertEquals(7, KeyBoardCalculations.kbDistance("O", "X"));
        assertEquals(7, KeyBoardCalculations.kbDistance("L", "E"));
        assertEquals(7, KeyBoardCalculations.kbDistance("X", "O"));

        assertEquals(8, KeyBoardCalculations.kbDistance("P", "W"));
        assertEquals(8, KeyBoardCalculations.kbDistance("A", "L"));
        assertEquals(8, KeyBoardCalculations.kbDistance("P", "S"));

        assertEquals(9, KeyBoardCalculations.kbDistance("Q", "P"));
        assertEquals(9, KeyBoardCalculations.kbDistance("L", "Q"));
        assertEquals(9, KeyBoardCalculations.kbDistance("L", "Q"));
    }

    public void testKeyboardIntegerAverageDistance04() {
        assertEquals(0.0, KeyBoardCalculations.averageDistance("ZZZZZZZ"), 0.0002);
        assertEquals(2.0, KeyBoardCalculations.averageDistance("QEFBUT"), 0.0002);
        assertEquals(2.0, KeyBoardCalculations.averageDistance("PKNUTV"), 0.0002);
        assertEquals(4.0, KeyBoardCalculations.averageDistance("XHPTN"), 0.0002);
        assertEquals(7.0, KeyBoardCalculations.averageDistance("XLSIAL"), 0.0002);
    }

    public void testKeyboardNonIntegerAverageDistance05() {
        assertEquals(23.0 / 8.0, KeyBoardCalculations.averageDistance("DUNVPIMGJ"), 0.0002);
        assertEquals(34.0 / 11.0, KeyBoardCalculations.averageDistance("QZOHSSRFZTHA"), 0.0002);
        assertEquals(32.0 / 9.0, KeyBoardCalculations.averageDistance("BAXKCYEEBL"), 0.0002);
    }

    public void testKeyboardNumDiretionChanges06() {
        assertEquals(4, KeyBoardCalculations.numDirectionChanges("THEQUICK"));
        assertEquals(6, KeyBoardCalculations.numDirectionChanges("BROWNFOX"));
        assertEquals(6, KeyBoardCalculations.numDirectionChanges("JUMPSOVERTHE"));
        assertEquals(4, KeyBoardCalculations.numDirectionChanges("LAZYDOG"));
        assertEquals(0, KeyBoardCalculations.numDirectionChanges("QWEDFGYHNJMKLP"));
    }

    public void testKeyboardMoreNumDiretionChanges07() {
        assertEquals(1, KeyBoardCalculations.numDirectionChanges("ASRYUHGCXZ"));
        assertEquals(2, KeyBoardCalculations.numDirectionChanges("TAFX"));
        assertEquals(1, KeyBoardCalculations.numDirectionChanges("QWERTGBYHNUJMIKOLPLOKIMJUNHYBGTVFRCDEXSWZAQ"));
        assertEquals(2, KeyBoardCalculations.numDirectionChanges("CZSDRFTGYHUJIKOK"));
    }

    public void testKeyboardWordDifficulty08() {
        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("FHJ"));
        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("LIJ"));
        
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("KOIY"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("RYJ"));

        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("RJP"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("ASFTHMB"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("WFJP"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("EHBNH"));

        assertEquals("average", KeyBoardCalculations.wordDifficulty("MNHYGVFRE"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("MTQCU"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("WTFVNHTY"));

        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("AHWBP"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("FTREDHBYG"));

        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("IHFCVNMLOU"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("WNWOV"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("RFCDRIMKBYG"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("YHBJYKYJN"));
    }

    public void testKeyboardMoreWordDifficulty09() {
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("QRHFN"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty(  "AVKTQCNP"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("PBWBPNE"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("FGLITLOPD"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("ZNEIC"));

        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("QEDGBNMKOP"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("QBQUZM"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("DJURFQKIO"));
    }

    public void testKeyboardAllTest10() {
        testKeyboard01();
        testKeyboardDistanceAdjacentLetters02();
        testKeyboardDistanceNonAdjacentLetters03();
        testKeyboardIntegerAverageDistance04();
        testKeyboardNonIntegerAverageDistance05();
        testKeyboardNumDiretionChanges06();
        testKeyboardMoreNumDiretionChanges07();
        testKeyboardWordDifficulty08();
        testKeyboardMoreWordDifficulty09();
    }

    public void testgenerateArea01() {
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

        fwt = new FunWithTriangles(x, y);

    }

    public void testHorizontalBaseLargest02() {
        TriangleCoordinate x = new TriangleCoordinate(-4, 0);
        TriangleCoordinate y = new TriangleCoordinate(4, 0);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(40);
        assertEquals(0.0, ans.getX(), 0.05);
        assertEquals(10.0, ans.getY(), 0.05);

        x = new TriangleCoordinate(-10,5);
        y = new TriangleCoordinate(20, 5);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(750);
        assertEquals(5.0, ans.getX(), 0.05);
        assertEquals(55, ans.getY(), 0.05);

        x = new TriangleCoordinate(-40,-7);
        y = new TriangleCoordinate(-20, -7);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(72.5);
        assertEquals(-30, ans.getX(), 0.05);
        assertEquals(0.25, ans.getY(), 0.05);
    }

    public void testHorizontalBaseSmallest03() {
        TriangleCoordinate x = new TriangleCoordinate(-4, 0);
        TriangleCoordinate y = new TriangleCoordinate(4, 0);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithSmallestXcoordinate(40);
        assertEquals(0.0, ans.getX(), 0.05);
        assertEquals(-10.0, ans.getY(), 0.05);

        x = new TriangleCoordinate(-10,5);
        y = new TriangleCoordinate(20, 5);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(750);
        assertEquals(5.0, ans.getX(), 0.05);
        assertEquals(-45, ans.getY(), 0.05);

        x = new TriangleCoordinate(-40,-7);
        y = new TriangleCoordinate(-20, -7);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(72.5);
        assertEquals(-30.0, ans.getX(), 0.05);
        assertEquals(-14.25, ans.getY(), 0.05);
    }

    public void testVerticalBaseLargest04() {
        TriangleCoordinate x = new TriangleCoordinate(0, -2);
        TriangleCoordinate y = new TriangleCoordinate(0, 8);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(35);
        assertEquals(7.0, ans.getX(), 0.05);
        assertEquals(3.0, ans.getY(), 0.05);

        x = new TriangleCoordinate(2, 5);
        y = new TriangleCoordinate(2, -11);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(403);
        assertEquals(52.35, ans.getX(), 0.05);
        assertEquals(-3.0, ans.getY(), 0.05);

        x = new TriangleCoordinate(-11, -360);
        y = new TriangleCoordinate(-11, -10);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(647.5);
        assertEquals(-11 + 3.7, ans.getX(), 0.05);
        assertEquals(-185.0, ans.getY(), 0.05);
    }

    public void testVerticalBaseSmallest05() {
        TriangleCoordinate x = new TriangleCoordinate(0, -2);
        TriangleCoordinate y = new TriangleCoordinate(0, 8);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithSmallestXcoordinate(35);
        assertEquals(-7.0, ans.getX(), 0.05);
        assertEquals(3.0, ans.getY(), 0.05);

        x = new TriangleCoordinate(2, 5);
        y = new TriangleCoordinate(2, -11);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(403);
        assertEquals(-48.375, ans.getX(), 0.05);
        assertEquals(-3.0, ans.getY(), 0.05);

        x = new TriangleCoordinate(-11, -360);
        y = new TriangleCoordinate(-11, -10);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(647.5);
        assertEquals(-11-3.7, ans.getX(), 0.05);
        assertEquals(-185.0, ans.getY(), 0.05);
    }

    public void testBaseWithSlope1Largest06() {
        TriangleCoordinate x = new TriangleCoordinate(5, 4);
        TriangleCoordinate y = new TriangleCoordinate(21, 20);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(320);
        assertEquals(33, ans.getX(), 0.05);
        assertEquals(-8, ans.getY(), 0.05);

        x = new TriangleCoordinate(-11, -360);
        y = new TriangleCoordinate(32, -317);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(1698.5);
        assertEquals(50.0, ans.getX(), 0.05);
        assertEquals(-378.0, ans.getY(), 0.05);
    }

    public void testBaseWithSlope1Smallest07() {
        TriangleCoordinate x = new TriangleCoordinate(5, 4);
        TriangleCoordinate y = new TriangleCoordinate(21, 20);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithSmallestXcoordinate(320);
        assertEquals(-7, ans.getX(), 0.05);
        assertEquals(32, ans.getY(), 0.05);

        x = new TriangleCoordinate(-11, -360);
        y = new TriangleCoordinate(32, -317);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(1698.5);
        assertEquals(-29.0, ans.getX(), 0.05);
        assertEquals(-299.0, ans.getY(), 0.05);
    }

    public void testBaseWithSlopeNegative1Largest08() {
        TriangleCoordinate x = new TriangleCoordinate(29, -24);
        TriangleCoordinate y = new TriangleCoordinate(10, -5);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(19*.5*Math.sqrt(2)*10*Math.sqrt(2));
        assertEquals(39/2.+10, ans.getX(), 0.05);
        assertEquals(-29/2.+10, ans.getY(), 0.05);

        x = new TriangleCoordinate(-11, 36);
        y = new TriangleCoordinate(21, 68);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(32*.5*Math.sqrt(2)*20*Math.sqrt(2));
        assertEquals(25, ans.getX(), 0.05);
        assertEquals(32, ans.getY(), 0.05);
    }

    public void testBaseWithSlopeNegative1Smalllest09() {
        TriangleCoordinate x = new TriangleCoordinate(29, -24);
        TriangleCoordinate y = new TriangleCoordinate(10, -5);

        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithSmallestXcoordinate(19*.5*Math.sqrt(2)*10*Math.sqrt(2));
        assertEquals(39/2.-10, ans.getX(), 0.05);
        assertEquals(-29/2.-10, ans.getY(), 0.05);

        x = new TriangleCoordinate(-11, 36);
        y = new TriangleCoordinate(21, 68);

        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(32*.5*Math.sqrt(2)*20*Math.sqrt(2));
        assertEquals(-15, ans.getX(), 0.05);
        assertEquals(72, ans.getY(), 0.05);
    }

    public void testBaseWithRandomSlopeLargest10() {
        TriangleCoordinate x = new TriangleCoordinate(2, -9);    //36  77  85
        TriangleCoordinate y = new TriangleCoordinate(79, 27);
        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(0.5*85*Math.sqrt(54*54+115.5*115.5));
        assertEquals(81./2+54, ans.getX(), 0.05);
        assertEquals(9.-77-77/2., ans.getY(), 0.05);

        x = new TriangleCoordinate(-12, 0);
        y = new TriangleCoordinate(0, -5);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(0.5*13*39);
        assertEquals(-6+5*3, ans.getX(), 0.05);
        assertEquals(-2.5+12*3, ans.getY(), 0.05);

        x = new TriangleCoordinate(9, -40);
        y = new TriangleCoordinate(-36, -12);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(0.5*53*2.5*53);
        assertEquals(-27/2.+2.5*28, ans.getX(), 0.05);
        assertEquals(-26+2.5*45, ans.getY(), 0.05);

        x = new TriangleCoordinate(-100, -50);
        y = new TriangleCoordinate(-10, 20);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(0.5*Math.sqrt(90*90 + 70*70)*7*Math.sqrt(81 + 49));
        assertEquals(-55+7*7, ans.getX(), 0.05);
        assertEquals(-15-7*9, ans.getY(), 0.05);
    }

    public void testBaseWithRandomSlopeSmallest11() {
        TriangleCoordinate x = new TriangleCoordinate(2, -9);    //36  77  85
        TriangleCoordinate y = new TriangleCoordinate(79, 27);
        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithSmallestXcoordinate(0.5*85*Math.sqrt(54*54+115.5*115.5));
        assertEquals(81./2-54, ans.getX(), 0.05);
        assertEquals(9.+77+77/2., ans.getY(), 0.05);

        x = new TriangleCoordinate(-12, 0);
        y = new TriangleCoordinate(0, -5);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(0.5*13*39);
        assertEquals(-6-5*3, ans.getX(), 0.05);
        assertEquals(-2.5-12*3, ans.getY(), 0.05);

        x = new TriangleCoordinate(9, -40);
        y = new TriangleCoordinate(-36, -12);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(0.5*53*2.5*53);
        assertEquals(-27/2.-2.5*28, ans.getX(), 0.05);
        assertEquals(-26-2.5*45, ans.getY(), 0.05);

        x = new TriangleCoordinate(-100, -50);
        y = new TriangleCoordinate(-10, 20);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithSmallestXcoordinate(0.5*Math.sqrt(90*90 + 70*70)*7*Math.sqrt(81 + 49));
        assertEquals(-55-7*7, ans.getX(), 0.05);
        assertEquals(-15+7*9, ans.getY(), 0.05);
        //        assertEquals(true, false);
    }

    public void testJustForFun12() { 
        TriangleCoordinate x = new TriangleCoordinate(-3,-2);
        TriangleCoordinate y = new TriangleCoordinate(7, 0);
        FunWithTriangles fwt = new FunWithTriangles(x, y);

        TriangleCoordinate ans = fwt.generateAreaWithLargestXcoordinate(0.5*Math.sqrt(10*10+2*2)*Math.sqrt(5*5+1));
        assertEquals( 2.0+1, ans.getX(), 0.05);
        assertEquals(-1.0-5, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(0.5*Math.sqrt(10*10+2*2)*Math.sqrt(5*5+1));
        assertEquals( 2.0-1, ans.getX(), 0.05);
        assertEquals(-1.0+5, ans.getY(), 0.05);

        ans = fwt.generateAreaWithLargestXcoordinate(0.5*Math.sqrt(10*10+2*2)*10*Math.sqrt(5*5+1));
        assertEquals( 2.0+10, ans.getX(), 0.05);
        assertEquals(-1.0-50, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(0.5*Math.sqrt(10*10+2*2)*10*Math.sqrt(5*5+1));
        assertEquals( 2.0-10, ans.getX(), 0.05);
        assertEquals(-1.0+50, ans.getY(), 0.05);

        x = new TriangleCoordinate(0, 28);
        y = new TriangleCoordinate(52, 0);
        fwt = new FunWithTriangles(x, y);

        ans = fwt.generateAreaWithLargestXcoordinate(0.5*Math.sqrt(28*28+52*52)*17*Math.sqrt(13*13+7*7));
        assertEquals(26.0+17*7, ans.getX(), 0.05);
        assertEquals(14.0+17*13, ans.getY(), 0.05);

        ans = fwt.generateAreaWithSmallestXcoordinate(0.5*Math.sqrt(28*28+52*52)*29*Math.sqrt(13*13+7*7));
        assertEquals(26.0-29*7, ans.getX(), 0.05);
        assertEquals(14.0-29*13, ans.getY(), 0.05);
    }

    public void testBonusPoitForCompletingllTest13() {
        testHorizontalBaseLargest02();
        testHorizontalBaseSmallest03();
        testVerticalBaseLargest04();
        testVerticalBaseSmallest05();
        testBaseWithSlope1Largest06();
        testBaseWithSlope1Smallest07();
        testBaseWithSlopeNegative1Largest08();
        testBaseWithSlopeNegative1Smalllest09();
        testBaseWithRandomSlopeLargest10();
        testBaseWithRandomSlopeSmallest11();
        testJustForFun12();
    }

    public void testFunctionsGoneWild2018_00() {
      assertEquals(1, FunctionsGoneWild2018.f1(8));
      assertEquals(10, FunctionsGoneWild2018.f1(26));
      assertEquals(0, FunctionsGoneWild2018.f1(64));

      assertEquals(20, FunctionsGoneWild2018.f2(0, 100));
      assertEquals(6, FunctionsGoneWild2018.f2(26, 52));
      assertEquals(46, FunctionsGoneWild2018.f2(-30, 200));

      assertEquals(580, FunctionsGoneWild2018.f3(202));
      assertEquals(116, FunctionsGoneWild2018.f3(135));
      assertEquals(389, FunctionsGoneWild2018.f3(55));
      assertEquals(1311, FunctionsGoneWild2018.f3(35));

      assertEquals(4218, FunctionsGoneWild2018.f4(2, 3, 4));
      assertEquals(429 + 491 + 555, FunctionsGoneWild2018.f4(1, 9, 1));

      assertEquals(0.0004303, FunctionsGoneWild2018.f5(1, 3),  0.000025);
      assertEquals(1.448499, FunctionsGoneWild2018.f5(2, -1), 1.448499 * 0.05);

      assertEquals(0.204239, FunctionsGoneWild2018.f6(Math.pow(-Math.E, 3), -1, 3), 0.0204239/2);
      assertEquals(37349.4719, FunctionsGoneWild2018.f6(25, 2, 1), 37.349);

      String[] ans = FunctionsGoneWild2018.f7("SAMPLE", 2);
      assertEquals("SML", ans[0] );
      assertEquals("APE", ans[1] );

      ans = FunctionsGoneWild2018.f7("HELP ME FIGURE THIS OUT :(", 3);
      assertEquals("HPEIRTSU:", ans[0] );
      assertEquals("E  GEH T(", ans[1] );
      assertEquals("LMFU IO ", ans[2] );
      
      ans = FunctionsGoneWild2018.f7("COMPUTER SCIENCE", 4);
      assertEquals("CU E", ans[0] );
      assertEquals("OTSN", ans[1] );
      assertEquals("MECC", ans[2] );
      assertEquals("PRIE", ans[3] );
      
      ans = FunctionsGoneWild2018.f7("TO ITERATE IS HUMAN, TO RECURSE DIVINE", 5);
      assertEquals("TE U EEI", ans[0] );
      assertEquals("ORIMTC N", ans[1] );
      assertEquals(" ASAOUDE", ans[2] );
      assertEquals("IT N RI", ans[3] );
      assertEquals("TEH,RSV", ans[4] );
      
      ans = FunctionsGoneWild2018.f7("1234567890", 5);
      assertEquals("16", ans[0] );
      assertEquals("27", ans[1] );
      assertEquals("38", ans[2] );
      assertEquals("49", ans[3] );
      assertEquals("50", ans[4] );
      
      ans = FunctionsGoneWild2018.f7("@ABC!", 7);
      assertEquals("@", ans[0] );
      assertEquals("A", ans[1] );
      assertEquals("B", ans[2] );
      assertEquals("C", ans[3] );
      assertEquals("!", ans[4] );
      assertEquals("", ans[5] );
      assertEquals("", ans[6] );

      assertEquals("BWZQRYIU KBEIXBI", FunctionsGoneWild2018.f8("COMPUTER SCIENCE") );
      assertEquals("YFI PREBS CUWOX HWN DRZQK WVIU YFI ALMT JWG", FunctionsGoneWild2018.f8("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG") );
      
      assertEquals(true, FunctionsGoneWild2018.f9(false, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(false, false, false, false) );
   }

   public void testFunctionsGoneWild2018_function01() {
      assertEquals(10, FunctionsGoneWild2018.f1(90));
      assertEquals(20, FunctionsGoneWild2018.f1(380));
      assertEquals(219, FunctionsGoneWild2018.f1(28561-219));
      assertEquals(103, FunctionsGoneWild2018.f1(1155625-103));
      assertEquals(0, FunctionsGoneWild2018.f1(12345*12345));
   }

   public void testFunctionsGoneWild2018_function02() {
      assertEquals(-3 - -113, FunctionsGoneWild2018.f2(-558, -8));
      assertEquals(3 - -92, FunctionsGoneWild2018.f2(-450, 23));
      assertEquals(0, FunctionsGoneWild2018.f2(5, 6));
      assertEquals(908, FunctionsGoneWild2018.f2(7, 5*908+7));
      assertEquals(5140, FunctionsGoneWild2018.f2(-1, 5*5138+7));
   }

   public void testFunctionsGoneWild2018_function03() {
      assertEquals(-1, FunctionsGoneWild2018.f3(3));
      assertEquals(2631, FunctionsGoneWild2018.f3(50));
      assertEquals(316, FunctionsGoneWild2018.f3(51));
      assertEquals(343, FunctionsGoneWild2018.f3(53));
      assertEquals(584, FunctionsGoneWild2018.f3(72));
      assertEquals(398, FunctionsGoneWild2018.f3(100));
      assertEquals(112, FunctionsGoneWild2018.f3(1205));
      assertEquals(367, FunctionsGoneWild2018.f3(364));
   }

   public void testFunctionsGoneWild2018_function04() {
      assertEquals(2931, FunctionsGoneWild2018.f4(3, 1, 9));
/*
  a = 3 b = 1 c = 9
min1 = -6
max2 = 12
 */

      assertEquals(1140919, FunctionsGoneWild2018.f4(9, 11, 8));
 /*
  a = 9 b = 11 c = 8
min2 = 79
max2 = 107
*/

      assertEquals(2869, FunctionsGoneWild2018.f4(1, 4, 3));
 /*
a = 1 b = 4 c = 3
min1 = 1
max1 = 13
*/

      assertEquals(254, FunctionsGoneWild2018.f4(1, 2, 2));
/*
a = 1 b = 2 c = 2
min1 = 0
max1 = 5
*/

      assertEquals(313580, FunctionsGoneWild2018.f4(6, 10 ,5));
 /*
 a = 6 b = 10 c = 5
min2 = 44
max2 = 65
*/
   }

   public void testFunctionsGoneWild2018_function05() {
//       for(int r = 0; r < 19; r++)
//       {
//          double h = 200 * Math.random()-100;
//          double k = 200 * Math.random()-100;
//          double m = 200 * Math.random()-100;
//          System.out.println(h + " " + k +"  " +  m + " = " + FunctionsGoneWild2018.f5(h, k, m));
//       }
      assertEquals(0.103468, FunctionsGoneWild2018.f5(2, 0.5),  0.103468 * 0.05);
      assertEquals(3.777164, FunctionsGoneWild2018.f5(0.6, -1.9), 3.777164 * 0.05);
      assertEquals(0.165787, FunctionsGoneWild2018.f5(Math.E, Math.PI/5.), 0.165787 * 0.05);
      assertEquals(0.060841, FunctionsGoneWild2018.f5(-3, 4.7), 0.060841 * 0.05);
      assertEquals(3.607565, FunctionsGoneWild2018.f5(-0.75, -0.3), 3.607565 * 0.05);

   }

   public void testFunctionsGoneWild2018_function06() {
//       for(int r = 0; r < 19; r++)
//       {
//          int h = (int)(200 * Math.random());
//          int k = (int)(200 * Math.random());
//          int m = (int)(200 * Math.random());
//          System.out.println(h + " " + k + " " + m + " = " + FunctionsGoneWild2018.f6(h, k, m));
//       }
      assertEquals(4715.25,   FunctionsGoneWild2018.f6( Math.pow(Math.E, 3), 1, 1), 4.715);
      assertEquals(61337.8467,   FunctionsGoneWild2018.f6(26.178, 0.8, 2.0), 61.3378467);
      assertEquals(2414924.1681,   FunctionsGoneWild2018.f6( 34.9, 0.51, 1.0), 241.49241681);
      assertEquals(0.03399,   FunctionsGoneWild2018.f6( -199.507, -1.9, 0.2), 0.00339);
      assertEquals(0.046772,   FunctionsGoneWild2018.f6( -175.48772, 0.6, -2.4), 0.0046772);

      assertEquals(3.67506, FunctionsGoneWild2018.f6(-Math.pow(Math.E, 4), -1, 6), 0.0367506);
      assertEquals(1.37235, FunctionsGoneWild2018.f6(41.7, 2.3, 1.5), 0.137235/2.);
      assertEquals(0.145755, FunctionsGoneWild2018.f6(-Math.pow(Math.E, 6), 3, -6), 0.0145755);
   }

   public void testFunctionsGoneWild2018_function07() {
      String[] ans = FunctionsGoneWild2018.f7("ONE FISH TWO FISH RED FISH BLUE FISH", 4);
      assertEquals("OF  HDSLF", ans[0]);
      assertEquals("NITF  HUI", ans[1]);
      assertEquals("ESWIRF ES", ans[2]);
      assertEquals(" HOSEIB H", ans[3]);
      
      ans = FunctionsGoneWild2018.f7("KIND WORDS DO NOT COST MUCH.", 3);
      assertEquals("KDOSOOCTU.", ans[0]);
      assertEquals("I R  TO C", ans[1]);
      assertEquals("NWDDN SMH", ans[2]);
      
      ans = FunctionsGoneWild2018.f7("MAKING MISTAKES IS A LOT BETTER THAN NOT DOING ANYTHING", 6);
      assertEquals("M K  R ONG", ans[0]);
      assertEquals("AMEAB NIY", ans[1]);
      assertEquals("KIS ETONT", ans[2]);
      assertEquals("IS LTHTGH", ans[3]);
      assertEquals("NTIOTA  I", ans[4]);
      assertEquals("GASTENDAN", ans[5]);

      ans = FunctionsGoneWild2018.f7("NO EXCUSES", 12);
      assertEquals("N", ans[0]);
      assertEquals("O", ans[1]);
      assertEquals(" ", ans[2]);
      assertEquals("E", ans[3]);
      assertEquals("X", ans[4]);
      assertEquals("C", ans[5]);
      assertEquals("U", ans[6]);
      assertEquals("S", ans[7]);
      assertEquals("E", ans[8]);
      assertEquals("S", ans[9]);
      assertEquals("", ans[10]);
      assertEquals("", ans[11]);

      ans = FunctionsGoneWild2018.f7(" $2.88 & !^", 2);
      assertEquals(" 28  ^", ans[0]);
      assertEquals("$.8&!", ans[1]);
   }

   public void testFunctionsGoneWild2018_function08() {
      assertEquals("", FunctionsGoneWild2018.f8(""));
      assertEquals("GV", FunctionsGoneWild2018.f8("GV"));
      assertEquals("YTHFBCTYFHCB", FunctionsGoneWild2018.f8("TYFHCBYTHFBC"));
      assertEquals("UJNXDR", FunctionsGoneWild2018.f8("RDXNJU"));
      assertEquals(" ", FunctionsGoneWild2018.f8(" "));
      assertEquals("POIQWELKASMNZX", FunctionsGoneWild2018.f8("QWEPOIASLKZXMN"));
      assertEquals("QWERT YUIOPLKJHGFDSAZXCVBNM", FunctionsGoneWild2018.f8("POIUY TREWQASDFGHJKLMNBVCXZ"));
   }

   public void testFunctionsGoneWild2018_function09() {
      assertEquals(true, FunctionsGoneWild2018.f9(false, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f9(false, false, true) );
      assertEquals(false, FunctionsGoneWild2018.f9(false, true, false) );
      assertEquals(false, FunctionsGoneWild2018.f9(false, true, true) );
      assertEquals(false, FunctionsGoneWild2018.f9(true, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f9(true, false, true) );
      assertEquals(false, FunctionsGoneWild2018.f9(true, true, false) );
      assertEquals(true, FunctionsGoneWild2018.f9(true, true, true) );
   }

   public void testFunctionsGoneWild2018_function10() {
      assertEquals(true, FunctionsGoneWild2018.f10(false, false, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(false, false, false, true) );
      assertEquals(false, FunctionsGoneWild2018.f10(false, false, true, false) );
      assertEquals(false, FunctionsGoneWild2018.f10(false, false, true, true) );
      assertEquals(false, FunctionsGoneWild2018.f10(false, true, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(false, true, false, true) );
      assertEquals(true, FunctionsGoneWild2018.f10(false, true, true, false) );
      assertEquals(false, FunctionsGoneWild2018.f10(false, true, true, true) );
      assertEquals(false, FunctionsGoneWild2018.f10(true, false, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(true, false, false, true) );
      assertEquals(false, FunctionsGoneWild2018.f10(true, false, true, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(true, false, true, true) );
      assertEquals(true, FunctionsGoneWild2018.f10(true, true, false, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(true, true, false, true) );
      assertEquals(false, FunctionsGoneWild2018.f10(true, true, true, false) );
      assertEquals(true, FunctionsGoneWild2018.f10(true, true, true, true) );
   }

   public void testFunctionsGoneWild2018_Bonusfunction01_03() {
       testFunctionsGoneWild2018_function01();
       testFunctionsGoneWild2018_function02();
       testFunctionsGoneWild2018_function03();
   }

   public void testFunctionsGoneWild2018_Bonusfunction04_06() {
       testFunctionsGoneWild2018_function04();
       testFunctionsGoneWild2018_function05();
       testFunctionsGoneWild2018_function06();
   }

   public void testFunctionsGoneWild2018_Bonusfunction07_08() {
      testFunctionsGoneWild2018_function07();
      testFunctionsGoneWild2018_function08();
   }


   public void testFunctionsGoneWild2018_Bonusfunction09_10() {
       testFunctionsGoneWild2018_function09();
       testFunctionsGoneWild2018_function10();
   }

   public void testFunctionsGoneWild2018_Bonus_All() {
       testFunctionsGoneWild2018_Bonusfunction01_03();
      testFunctionsGoneWild2018_Bonusfunction04_06();
      testFunctionsGoneWild2018_Bonusfunction07_08();
       testFunctionsGoneWild2018_Bonusfunction09_10();
   }

   public void testDigitGuardian01() {
      List<Integer> digs = new ArrayList<Integer>();
      digs.add(new Integer(0));
      digs.add(new Integer(2));
      digs.add(new Integer(5));
      digs.add(new Integer(8));
      DigitGuardian dg = new DigitGuardian(digs);

      assertEquals(true, dg.isAllowable(5082));
      assertEquals(true, dg.isAllowable(50852));
      assertEquals(false, dg.isAllowable(582));
      assertEquals(false, dg.isAllowable(12508));

      List<Integer> ans = dg.getDigits(1575);
      assertEquals(3, ans.size());
      assertEquals(true, ans.contains(new Integer(1)));
      assertEquals(true, ans.contains(new Integer(5)));
      assertEquals(true, ans.contains(new Integer(7)));
      assertEquals(false, ans.contains(new Integer(0)));

      assertEquals(2058, dg.getMinLCM(2));
      assertEquals(5820, dg.getMinLCM(97));
      assertEquals(2025855, dg.getMinLCM(117));
   }

   public void testDigitGuardianIsAllowableNoRepeatedDigits02() {
      List<Integer> digs = new ArrayList<Integer>();
      digs.add(new Integer(1));
      digs.add(new Integer(3));
      DigitGuardian dg = new DigitGuardian(digs);

      assertEquals(true, dg.isAllowable(13));
      assertEquals(true, dg.isAllowable(31));
      assertEquals(false, dg.isAllowable(310));
      assertEquals(false, dg.isAllowable(321));
      assertEquals(false, dg.isAllowable(431));
      assertEquals(false, dg.isAllowable(351));
      assertEquals(false, dg.isAllowable(316));
      assertEquals(false, dg.isAllowable(371));
      assertEquals(false, dg.isAllowable(831));
      assertEquals(false, dg.isAllowable(931));
      assertEquals(false, dg.isAllowable(1));
      assertEquals(false, dg.isAllowable(3));

      digs.add(new Integer(9));
      digs.add(new Integer(6));
      dg = new DigitGuardian(digs);
      assertEquals(true, dg.isAllowable(9136));
      assertEquals(true, dg.isAllowable(3619));
      assertEquals(false, dg.isAllowable(316));
      assertEquals(false, dg.isAllowable(613));
      assertEquals(false, dg.isAllowable(10369));
      assertEquals(false, dg.isAllowable(612349));
      assertEquals(false, dg.isAllowable(513679));
      assertEquals(false, dg.isAllowable(13698));
      assertEquals(false, dg.isAllowable(0));
      assertEquals(false, dg.isAllowable(6));
      assertEquals(false, dg.isAllowable(169));
      assertEquals(false, dg.isAllowable(39));
    }

   public void testDigitGuardianIsAllowableWithRepeatedDigits03() {
      List<Integer> digs = new ArrayList<Integer>();
      digs.add(new Integer(7));
      digs.add(new Integer(5));
      digs.add(new Integer(4));
      DigitGuardian dg = new DigitGuardian(digs);

      assertEquals(true, dg.isAllowable(475455));
      assertEquals(true, dg.isAllowable(47457));
      assertEquals(false, dg.isAllowable(445));
      assertEquals(false, dg.isAllowable(747));
      assertEquals(false, dg.isAllowable(555));
      assertEquals(false, dg.isAllowable(474550));
      assertEquals(false, dg.isAllowable(73752));
      assertEquals(false, dg.isAllowable(55548));
      assertEquals(false, dg.isAllowable(777));
      assertEquals(false, dg.isAllowable(106));
      assertEquals(false, dg.isAllowable(99475));
      assertEquals(false, dg.isAllowable(0));

      digs.add(new Integer(0));
      digs.add(new Integer(3));
      digs.add(new Integer(8));
      dg = new DigitGuardian(digs);
      assertEquals(true, dg.isAllowable(3008754));
      assertEquals(true, dg.isAllowable(3038754));
      assertEquals(true, dg.isAllowable(30487584));
      assertEquals(true, dg.isAllowable(75430087));
      assertEquals(true, dg.isAllowable(75085384));
      assertEquals(false, dg.isAllowable(75438));
      assertEquals(false, dg.isAllowable(54730));
      assertEquals(false, dg.isAllowable(7543081));
      assertEquals(false, dg.isAllowable(8302754));
      assertEquals(false, dg.isAllowable(6830457));
      assertEquals(false, dg.isAllowable(937594));
      assertEquals(false, dg.isAllowable(754387));
   }

   public void testDigitGuardianGetDigitsNoRepeatedDigits04() {
      List<Integer> digs = new ArrayList<Integer>();
      digs.add(new Integer(0));
      DigitGuardian dg = new DigitGuardian(digs);

      List<Integer> ans = dg.getDigits(24680);
      assertEquals(5, ans.size());
      assertEquals(true, ans.contains(new Integer(2)));
      assertEquals(true, ans.contains(new Integer(4)));
      assertEquals(true, ans.contains(new Integer(6)));
      assertEquals(true, ans.contains(new Integer(8)));
      assertEquals(true, ans.contains(new Integer(0)));

      assertEquals(false, ans.contains(new Integer(1)));
      assertEquals(false, ans.contains(new Integer(3)));
      assertEquals(false, ans.contains(new Integer(5)));
      assertEquals(false, ans.contains(new Integer(7)));
      assertEquals(false, ans.contains(new Integer(9)));

      ans = dg.getDigits(59317);
      assertEquals(5, ans.size());
      assertEquals(true, ans.contains(new Integer(1)));
      assertEquals(true, ans.contains(new Integer(3)));
      assertEquals(true, ans.contains(new Integer(5)));
      assertEquals(true, ans.contains(new Integer(7)));
      assertEquals(true, ans.contains(new Integer(9)));

      assertEquals(false, ans.contains(new Integer(0)));
      assertEquals(false, ans.contains(new Integer(2)));
      assertEquals(false, ans.contains(new Integer(6)));
      assertEquals(false, ans.contains(new Integer(4)));
      assertEquals(false, ans.contains(new Integer(8)));
   }

   public void testDigitGuardianGetDigitsWithRepeatedDigits05() {
      List<Integer> digs = new ArrayList<Integer>();
      digs.add(new Integer(8));
      DigitGuardian dg = new DigitGuardian(digs);

      List<Integer> ans = dg.getDigits(242686);
      assertEquals(4, ans.size());
      assertEquals(true, ans.contains(new Integer(2)));
      assertEquals(true, ans.contains(new Integer(4)));
      assertEquals(true, ans.contains(new Integer(6)));
      assertEquals(true, ans.contains(new Integer(8)));

      assertEquals(false, ans.contains(new Integer(0)));
      assertEquals(false, ans.contains(new Integer(1)));
      assertEquals(false, ans.contains(new Integer(3)));
      assertEquals(false, ans.contains(new Integer(5)));
      assertEquals(false, ans.contains(new Integer(7)));
      assertEquals(false, ans.contains(new Integer(9)));

      ans = dg.getDigits(517771);
      assertEquals(3, ans.size());
      assertEquals(true, ans.contains(new Integer(1)));
      assertEquals(true, ans.contains(new Integer(5)));
      assertEquals(true, ans.contains(new Integer(7)));

      assertEquals(false, ans.contains(new Integer(9)));
      assertEquals(false, ans.contains(new Integer(3)));
      assertEquals(false, ans.contains(new Integer(0)));
      assertEquals(false, ans.contains(new Integer(2)));
      assertEquals(false, ans.contains(new Integer(6)));
      assertEquals(false, ans.contains(new Integer(4)));
      assertEquals(false, ans.contains(new Integer(8)));

      ans = dg.getDigits(90330);
      assertEquals(3, ans.size());
      assertEquals(true, ans.contains(new Integer(0)));
      assertEquals(true, ans.contains(new Integer(3)));
      assertEquals(true, ans.contains(new Integer(9)));

      assertEquals(false, ans.contains(new Integer(5)));
      assertEquals(false, ans.contains(new Integer(7)));
      assertEquals(false, ans.contains(new Integer(1)));
      assertEquals(false, ans.contains(new Integer(2)));
      assertEquals(false, ans.contains(new Integer(6)));
      assertEquals(false, ans.contains(new Integer(4)));
      assertEquals(false, ans.contains(new Integer(8)));
   }

   public void testDigitGuardianGetMinLCM06() {
      List<Integer> digs = new ArrayList<Integer>();
      digs.add(new Integer(3));
      digs.add(new Integer(4));
      digs.add(new Integer(1));
      DigitGuardian dg = new DigitGuardian(digs);
      assertEquals(341, dg.getMinLCM(31));

      digs = new ArrayList<Integer>();
      digs.add(new Integer(0));
      digs.add(new Integer(1));
      dg = new DigitGuardian(digs);
      assertEquals(101010, dg.getMinLCM(42));
      assertEquals(110, dg.getMinLCM(11));

      digs = new ArrayList<Integer>();
      digs.add(new Integer(0));
      digs.add(new Integer(1));
      digs.add(new Integer(9));
      digs.add(new Integer(8));
      dg = new DigitGuardian(digs);
      assertEquals(89018, dg.getMinLCM(947));

      digs = new ArrayList<Integer>();
      digs.add(new Integer(4));
      digs.add(new Integer(1));
      dg = new DigitGuardian(digs);
      assertEquals(114114, dg.getMinLCM(39));

      digs = new ArrayList<Integer>();
      digs.add(new Integer(0));
      digs.add(new Integer(2));
      dg = new DigitGuardian(digs);
      assertEquals(20, dg.getMinLCM(2));

      digs = new ArrayList<Integer>();
      digs.add(new Integer(0));
      digs.add(new Integer(3));
      dg = new DigitGuardian(digs);
      assertEquals(330, dg.getMinLCM(11));
   }

   public void testDigitGuardianIsAllowableAndGetDigits07() {
      testDigitGuardianIsAllowableNoRepeatedDigits02();
      testDigitGuardianIsAllowableWithRepeatedDigits03();
      testDigitGuardianGetDigitsNoRepeatedDigits04();
      testDigitGuardianGetDigitsWithRepeatedDigits05();
   }

   public void testDigitGuardianIsAllowableAndGetMinLCM08() {
      testDigitGuardianIsAllowableNoRepeatedDigits02();
      testDigitGuardianIsAllowableWithRepeatedDigits03();
      testDigitGuardianGetMinLCM06();
   }

   public void testDigitGuardianGetDigitsAndGetMinLCM09() {
      testDigitGuardianGetDigitsNoRepeatedDigits04();
      testDigitGuardianGetDigitsWithRepeatedDigits05();
      testDigitGuardianGetMinLCM06();
   }

   public void testDigitGuardianTestAll_10() {
      testDigitGuardianIsAllowableAndGetDigits07();
      testDigitGuardianGetMinLCM06();
   }

   public void testCoolAndWorthy01() {
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("vacuum"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("flyby"));

        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("cattree"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("biometer"));

        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("computer"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("yokel"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("tortrix"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("dekko"));

        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("alfaqui"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("factoid"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("pigmy"));

        assertEquals(9, CoolAndWorthy.getNumDistinctLetters("circumlocution"));
        assertEquals(6, CoolAndWorthy.getNumDistinctLetters("acumen"));

        assertEquals(true, CoolAndWorthy.isWordCool("alfaqui"));
        assertEquals(false, CoolAndWorthy.isWordCool("factoid"));

        assertEquals(false, CoolAndWorthy.isWordWorthy("alfaqui"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("buzzwigs"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("conjugately"));
        assertEquals(false, CoolAndWorthy.isWordWorthy("conjuahely"));

        List<String> listAns = CoolAndWorthy.makeWorthy("conjuahely", "x");
        assertEquals(2, listAns.size());
        assertEquals(true, listAns.contains("conjuahxely"));
        assertEquals(true, listAns.contains("conjuxahely"));

        listAns = CoolAndWorthy.makeWorthy("factoid", "sg");
        assertEquals(1, listAns.size());
        assertEquals(true, listAns.contains("factosgid"));
    }  

    public void testNoConsecutiveVowels02() {    //  vowels:  a, e, i, o, u
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("aa"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("vae"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("ai"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("aop"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("baup"));

        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("weep"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("vea"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("ei"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("eoc"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("beuk"));

        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("sii"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("dia"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("iej"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("gioc"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("nium"));

        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("doa"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("oej"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("soi"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("gooc"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("noum"));

        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("dua"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("uej"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("rui"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("wguocr"));
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("qnuum"));

        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("awa"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("vaye"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("api"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("alope"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("basup"));

        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("wedepa"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("vefa"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("egiy"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("eyoc"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("ibehuka"));

        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("siyi"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("diba"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("ilej"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("giyoca"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("inixuma"));

        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("udoza"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("odej"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("sosi"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("ogopoco"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("unobumo"));

        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("duqa"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("qurej"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("rudi"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("wguwocr"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("qnunum"));
    }

    public void testNoCommonlyUsedBigrams03() {   //  common bigraphs:   th,   he,  in,  er,  an
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("th"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("those"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("myth"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("myths"));

        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("he"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("help"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("sfhe"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("zhety"));

        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("in"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("sin"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("ink"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("sink"));

        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("er"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("her"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("erlp"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("quert"));

        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("an"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("ant"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("tan"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("sand"));

        //  common bigraphs:   th,   he,  in,  er,  an
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("twh"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("qtrht"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("txhc"));

        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("hte"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("ehye"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("khlel"));

        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("nion"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("iyn"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("iwn"));

        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("retr"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("ebr"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("betre"));

        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("na"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("rnayn"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("fatna"));
    }

    /*
     *    	One of the four fewest used letter (x, j, q, or z)
     *    or	Two of the following letters (y, b, v, or k)  - Same letter twice satisfies
     */
    public void testContainsSeldomUsedLetters04() {
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("xraw"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("jump"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("werq"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("z"));

        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("ymny"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("tbbt"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("vfgv"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("kick"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("ymnb"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("ymvn"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("ykol"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("bhy"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("bmvn"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("bkmn"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("vasy"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("vbc"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("vk"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("kuy"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("kibi"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("kvc"));

        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("acdefghilmnoprstuw"));
        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("yacdefghilmnoprstuw"));
        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("acdefghilmnoprstuwb"));
        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("acdefghilmnoprstuwv"));
        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("acdefghiklmnoprstuw"));
    }

    /*
     *     Contains tall letters, short letters and letters that dig:
     *        Tall letters are: b, d, f, h, k, l, and t
     *        Short letters are: a, c, e, i, m, n, o, r, s, u, v, w, x, z
     *        etter that dig are: g, j, p, q, y
     */
    public void testContainsTallShortAndDigLetters05() {
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("ba"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("dg"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("cj"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("ef"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("pi"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("hy"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("kq"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("my"));
        assertEquals(false, CoolAndWorthy.containsTallShortAndDigLetters("nl"));

        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bay"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("odg"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("cjt"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("eqf"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("pib"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("hyz"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("xkq"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("myl"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("nlj"));
    }

    public void testGetNumDistinctLetters06() {
        assertEquals(10, CoolAndWorthy.getNumDistinctLetters("qwertyuiop"));
        assertEquals(8, CoolAndWorthy.getNumDistinctLetters("azsxdcfv"));
        assertEquals(3, CoolAndWorthy.getNumDistinctLetters("mlkmlkmlk"));
        assertEquals(1, CoolAndWorthy.getNumDistinctLetters("uuuuuuuuuuuuuuuuuuuuuuuu"));
        assertEquals(4, CoolAndWorthy.getNumDistinctLetters("tgbhghtbhgbbbhgtghbgthbg"));
        assertEquals(5, CoolAndWorthy.getNumDistinctLetters("tgbhgqhtbhgqbbbhgtqghbgthbg"));
    }

    public void testIsCool07() {
        assertEquals(false, CoolAndWorthy.isWordCool("ami"));        //   y y n n
        assertEquals(false, CoolAndWorthy.isWordCool("yasiney"));    //   y n y n
        assertEquals(false, CoolAndWorthy.isWordCool("agmink"));     //   y n n y
        assertEquals(false, CoolAndWorthy.isWordCool("baik"));       //   n y y n
        assertEquals(false, CoolAndWorthy.isWordCool("baip"));       //   n y n y
        assertEquals(false, CoolAndWorthy.isWordCool("bainy"));      //   n n y y

        assertEquals(true, CoolAndWorthy.isWordCool("bazuv"));       //   y  y  y  n
        assertEquals(true, CoolAndWorthy.isWordCool("bagu"));        //   y  y  n  y
        assertEquals(true, CoolAndWorthy.isWordCool("agzuter"));     //   y  n  y  y
        assertEquals(true, CoolAndWorthy.isWordCool("baiy"));        //   n  y  y  y
        assertEquals(true, CoolAndWorthy.isWordCool("tagjur"));      //   y  y  y  y
    }

    public void testIsWordWorthy08() {
        assertEquals(false, CoolAndWorthy.isWordWorthy("abazuv"));       //   y  y  y  n
        assertEquals(false, CoolAndWorthy.isWordWorthy("sbazuv"));       //   y  y  y  n
        assertEquals(true, CoolAndWorthy.isWordWorthy("sbazuvt"));       //   y  y  y  n

        assertEquals(false, CoolAndWorthy.isWordWorthy("bagu"));        //   y  y  n  y
        assertEquals(false, CoolAndWorthy.isWordWorthy("astbagu"));        //   y  y  n  y
        assertEquals(true, CoolAndWorthy.isWordWorthy("estbagu"));        //   y  y  n  y

        assertEquals(false, CoolAndWorthy.isWordWorthy("baiy"));        //   n  y  y  y
        assertEquals(true, CoolAndWorthy.isWordWorthy("baiyddeh"));        //   n  y  y  y

        assertEquals(false, CoolAndWorthy.isWordWorthy("tttttagjur"));      //   y  y  y  y
        assertEquals(true, CoolAndWorthy.isWordWorthy("tagcjur"));      //   y  y  y  y

        assertEquals(false, CoolAndWorthy.isWordWorthy("bbbbagu"));        //   y  y  n  y
        assertEquals(true, CoolAndWorthy.isWordWorthy("istbagu"));        //   y  y  n  y

        assertEquals(false, CoolAndWorthy.isWordWorthy("dddbaiy"));        //   n  y  y  y
        assertEquals(true, CoolAndWorthy.isWordWorthy("dbaiysp"));        //   n  y  y  y

        assertEquals(false, CoolAndWorthy.isWordWorthy("rttagjur"));      //   y  y  y  y
        assertEquals(true, CoolAndWorthy.isWordWorthy("tagjurs"));      //   y  y  y  y

        assertEquals(true, CoolAndWorthy.isWordWorthy("agzuter"));     //   y  n  y  y

    }

    public void testMakeWorthy09() {
        List<String> listAns = CoolAndWorthy.makeWorthy("yasiney", "m");    //   y n y n
        assertEquals(1, listAns.size());
        assertEquals(true, listAns.contains("yasimney"));

        listAns = CoolAndWorthy.makeWorthy("agmink", "m");    //   y n n y
        assertEquals(0, listAns.size());

        listAns = CoolAndWorthy.makeWorthy("agmink", "t");    //   y n n y
        assertEquals(1, listAns.size());
        assertEquals(true, listAns.contains("agmitnk"));

        listAns = CoolAndWorthy.makeWorthy("bainy", "st");    //   n n y y
        assertEquals(2, listAns.size());
        assertEquals(true, listAns.contains("bastiny"));
        assertEquals(true, listAns.contains("baistny"));

        listAns = CoolAndWorthy.makeWorthy("wupgs", "zo");      //  y y n n 
        assertEquals(5, listAns.size(), listAns.toString());
        assertEquals(true, listAns.contains("zowupgs"));     
        assertEquals(true, listAns.contains("wuzopgs"));      
        assertEquals(true, listAns.contains("wupzogs"));     
        assertEquals(true, listAns.contains("wupgzos"));  
        assertEquals(true, listAns.contains("wupgszo"));    
    }

    public void testTestAllMethods10() {
        testNoConsecutiveVowels02();
        testNoCommonlyUsedBigrams03();
        testContainsSeldomUsedLetters04();
        testContainsTallShortAndDigLetters05();
        testGetNumDistinctLetters06();
        testIsCool07();
        testIsWordWorthy08();
        testMakeWorthy09();
    }
}