import java.util.*;
/**
 * @author Don Allen
 * @author Ahmed Abdalla
 * @author Jarred Allen
 * @version 2018 Wittry Contest
 */
public class CountingSquares {
    private List<Edge> myEdges;
    private final int GRID_SIZE = 10;

    public CountingSquares(List<Edge> edges) {
        myEdges = edges;
    }

    /**
     * Returns true if and only if there is a square of side length length and
     * lower left corner at the specified point
     */
    public boolean hasSquare(Point lowLeftCorner, int length) {
        Point upperLeftCorner = new Point(lowLeftCorner.getX(), lowLeftCorner.getY() + length);
        Point lowRightCorner = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY());
        Point upperRightCorner = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY() + length);
        // these variables are never used in the actual method, but are left here because
        // they make it easier to read the code and figure out what is happening.

        // check the left edge
        for(int i=0; i<length; i++) {
            Point bot = new Point(lowLeftCorner.getX(), lowLeftCorner.getY() + i);
            Point top = new Point(lowLeftCorner.getX(), lowLeftCorner.getY() + i + 1);
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) {
                return false;
            }
        }

        // check the right edge
        for(int i=0; i<length; i++) {
            Point bot = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY() + i);
            Point top = new Point(lowLeftCorner.getX() + length, lowLeftCorner.getY() + i + 1);
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) {
                return false;
            }
        }

        // check the bottom edge
        for(int i=0; i<length; i++) {
            Point bot = new Point(lowLeftCorner.getX() + i, lowLeftCorner.getY());
            Point top = new Point(lowLeftCorner.getX() + i + 1, lowLeftCorner.getY());
            // bot is actually the left side and top is the right side
            // The names were unchanged from the previous two because it's faster to copy+paste and change
            // as little as necessary.
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) {
                return false;
            }
        }

        // check the top edge
        for(int i=0; i<length; i++) {
            Point bot = new Point(lowLeftCorner.getX() + i, lowLeftCorner.getY() + length);
            Point top = new Point(lowLeftCorner.getX() + i + 1, lowLeftCorner.getY() + length);
            // bot is actually the left side and top is the right side
            Edge testEdge = new Edge(bot, top);
            if (!myEdges.contains(testEdge)) {
                return false;
            }
        }
        // all four edges are complete, so this is a complete square
        return true;
    }

    /**
     * Returns the number of squares of a given length in the grid, at any origin point.
     */    
    public int getNumSquares(int length) {
        int numSquares = 0;
        for(int x = 0; x < GRID_SIZE - length; x++){
            for(int y = 0; y < GRID_SIZE - length; y++){
                Point test = new Point(x, y);
                if(hasSquare(test, length)) {
                    numSquares++;
                }
            }
        }
        return numSquares;
    }

    /**
     * Returns the size of the largest square which may be found in the grid
     */    
    public int getSizeOfLargestSquare() {
        int i = GRID_SIZE;
        for(; getNumSquares(i) == 0; i--);
        return i;
    }
}