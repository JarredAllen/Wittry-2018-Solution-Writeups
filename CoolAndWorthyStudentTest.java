import junit.framework.TestCase;

import java.util.*;

/**
 * The test class studentTest.
 *
 * @author Don Allen
 * @author Jarred Allen
 * @version 2018 Wittry programming contest
 */
public class CoolAndWorthyStudentTest extends junit.framework.TestCase {

    /*
    * For this to work, this method must be copied into the TestCase class
    */
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
    }

    public void testCoolAndWorthy01() {
        assertEquals(false, CoolAndWorthy.noConsecutiveVowels("vacuum"));
        assertEquals(true, CoolAndWorthy.noConsecutiveVowels("flyby"));

        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("cattree"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("biometer"));

        assertEquals(false, CoolAndWorthy.containsSeldomUsedLetters("computer"));
        assertEquals(true, CoolAndWorthy.containsSeldomUsedLetters("obvious"));
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

    public void testNoCommonBigrams01() {
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("hath"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("thine"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("heathen"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("hero"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("heroine"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("within"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("inside"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("within"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("there"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("era"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("terran"));
        assertEquals(false, CoolAndWorthy.noCommonlyUsedBigrams("anode"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("teh"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("pwnd"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("q"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams("empty"));
        assertEquals(true, CoolAndWorthy.noCommonlyUsedBigrams(""));
    }

    public void testIsWordCool01() {
        assertEquals(true, CoolAndWorthy.isWordCool("quaoart"));
        assertEquals(true, CoolAndWorthy.isWordCool("thuxly"));
        assertEquals(true, CoolAndWorthy.isWordCool("rigged"));
        assertEquals(true, CoolAndWorthy.isWordCool("zappew"));
        assertEquals(true, CoolAndWorthy.isWordCool("tuxly"));
        assertEquals(true, CoolAndWorthy.isWordCool("quaoartly"));
        assertEquals(true, CoolAndWorthy.isWordCool("thuxily"));
        assertEquals(true, CoolAndWorthy.isWordCool("riggedxjg"));
        assertEquals(true, CoolAndWorthy.isWordCool("zappewxvw"));
        assertEquals(true, CoolAndWorthy.isWordCool("stuxily"));
    }

    public void testIsWordWorthy01() {
        assertEquals(false, CoolAndWorthy.isWordWorthy("quaoart"));
        assertEquals(false, CoolAndWorthy.isWordWorthy("thuxly"));
        assertEquals(false, CoolAndWorthy.isWordWorthy("rigged"));
        assertEquals(false, CoolAndWorthy.isWordWorthy("zappew"));
        assertEquals(false, CoolAndWorthy.isWordWorthy("tuxly"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("quaoartly"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("thuxily"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("riggedxjg"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("zappewxvw"));
        assertEquals(true, CoolAndWorthy.isWordWorthy("stuxily"));
    }

    public void testContainsTallShortAndDigLetters() {
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bag"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("dcj"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("fep"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("hiq"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("kmy"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("lng"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("tog"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("brg"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bsg"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bug"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bvg"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bwg"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bxg"));
        assertEquals(true, CoolAndWorthy.containsTallShortAndDigLetters("bzg"));
    }
}