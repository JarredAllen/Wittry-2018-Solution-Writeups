import java.util.*;
/**
 * @author Don Allen
 * @author Ahmed Abdalla
 * @version 2018 Wittry Contest
 */
public class CountingSquares {
    private int size;
    private List<Edge> myEdges;
    private final int GRID_SIZE = 10;

    public CountingSquares(List<Edge> edges) {
        size = 10;
        myEdges = edges;
    }
    /*

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
     */
    /*
     *    
     */
    public boolean hasSquare(Point lowLeftCorner, int length) {
        Point upperLeftCorner = new Point(lowLeftCorner.getX(), lowLeftCorner.getY() + length);
        Point lowRightCorner = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY());
        Point upperRightCorner = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY() + length);

        int i = 0;

        //left edge
        while(!( i == length)) {
            Point bot = new Point(lowLeftCorner.getX(), lowLeftCorner.getY() + i);
            Point top = new Point(lowLeftCorner.getX(), lowLeftCorner.getY() + i + 1);
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) return false;
            i++;
        }
        i = 0;

        //right edge
        while(!( i == length)) {
            Point bot = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY() + i);
            Point top = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY() + i + 1);
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) return false;
            i++;
        }
        i = 0;

        //bot edge
        while(!( i == length)) {
            Point bot = new Point(lowLeftCorner.getX() + i, lowLeftCorner.getY());
            Point top = new Point(lowLeftCorner.getX() + i + 1, lowLeftCorner.getY());
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) return false;
            i++;
        }
        i = 0;

        //top edge
        while(!( i == length)) {
            Point bot = new Point(lowLeftCorner.getX() + i, lowLeftCorner.getY() + length);
            Point top = new Point(lowLeftCorner.getX() + i + 1, lowLeftCorner.getY() + length);
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) return false;
            i++;
        }

        return true;
    }

    /*
     *        (0, size - 1)                   (size - 1, size -1)
     *        
     *        
     *           (0, 0)                         size - 1, 0)
     */    
    public int getNumSquares(int length) {
        int numSquares = 0;
        for(int x = 0; x < GRID_SIZE - length; x++){
            for(int y = 0; y < GRID_SIZE - length; y++){
                Point test = new Point(x, y);
                if(hasSquare(test, length)) numSquares++;
            }
        }
        return numSquares;
    }

    /*
     *    return the size of the largest square
     *    
     */    
    public int getSizeOfLargestSquare() {
        int i = GRID_SIZE;
        while(getNumSquares(i) == 0) i--;
        return i;
    }
}