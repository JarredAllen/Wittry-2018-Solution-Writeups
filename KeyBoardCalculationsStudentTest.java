import junit.framework.TestCase;

import java.security.Key;
import java.util.*;

/**
 * The test class studentTest.
 *
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry programming contest
 */
public class KeyBoardCalculationsStudentTest extends junit.framework.TestCase {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
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

    public void testKeyboardLayout01() {
        for(String key:KeyBoardCalculations.layout.keySet()) {
            for(String adj:KeyBoardCalculations.layout.get(key)) {
                assertEquals(true, KeyBoardCalculations.layout.get(adj).contains(key), key+"<-->"+adj);
            }
        }
    }

    public void testWordDifficulty01() {
        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("WAS"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("KING"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("SAMPLE"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("COMPUTER"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("AVERAGE"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("ALABAMA"));

        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("SAW"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("RYTWE"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("ELPMAS"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("COMPUTED"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("EGAREVA"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("AMABALA"));

        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("QW"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("QE"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("QR"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("QT"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("QY"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("QP"));

        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("QQQ"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("QQQQQQ"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("QQQQQQQQ"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("QQQQQQQQQ"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("QQQQQQQQQQQQQ"));

        assertEquals("elementary", KeyBoardCalculations.wordDifficulty("QWQ"));
        assertEquals("basic", KeyBoardCalculations.wordDifficulty("QWQW"));
        assertEquals("so-so", KeyBoardCalculations.wordDifficulty("QWQWQ"));
        assertEquals("average", KeyBoardCalculations.wordDifficulty("QWQWQW"));
        assertEquals("demanding", KeyBoardCalculations.wordDifficulty("QWQWQWQ"));
        assertEquals("challenging", KeyBoardCalculations.wordDifficulty("QWQWQWQWQWQWQWQWQWQW"));
    }

    public void testAverageDistance01() {
        assertEquals(9, KeyBoardCalculations.averageDistance("QPQ"), .001);
        assertEquals(9, KeyBoardCalculations.averageDistance("QPQPQPQ"), .001);
        assertEquals(9, KeyBoardCalculations.averageDistance("QPQPQPQPQPQPQPQP"), .001);
        assertEquals(6, KeyBoardCalculations.averageDistance("QPPQ"), .001);
        assertEquals(2, KeyBoardCalculations.averageDistance("QZCE"), .001);
        assertEquals(2, KeyBoardCalculations.averageDistance("QZCEQZ"), .001);
        assertEquals(2, KeyBoardCalculations.averageDistance("QZCEQZCEQ"), .001);
        assertEquals(1, KeyBoardCalculations.averageDistance("QWERTY"), .001);
        assertEquals(1, KeyBoardCalculations.averageDistance("QWERTYHGFDSAQ"), .001);
        assertEquals(1, KeyBoardCalculations.averageDistance("QQZZCCE"), .001);
    }
}