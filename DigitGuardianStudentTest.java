import junit.framework.TestCase;

import java.util.*;

/**
 * The test class studentTest.
 *
 * @author Don Allen
 * @author Jarred Allen
 * @author Alexander Tsao
 * @version 2018 Wittry programming contest
 */
public class DigitGuardianStudentTest extends junit.framework.TestCase {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
    }

    public void testDigitGuardian01() {
        List<Integer> digs = new ArrayList<Integer>();
        digs.add(0);
        digs.add(2);
        digs.add(5);
        digs.add(8);
        DigitGuardian dg = new DigitGuardian(digs);

        assertEquals(true, dg.isAllowable(5082));
        assertEquals(true, dg.isAllowable(50852));
        assertEquals(false, dg.isAllowable(582));
        assertEquals(false, dg.isAllowable(12508));

        List<Integer> ans = dg.getDigits(1575);
        assertEquals(3, ans.size());
        assertEquals(true, ans.contains(1));
        assertEquals(true, ans.contains(5));
        assertEquals(true, ans.contains(7));
        assertEquals(false, ans.contains(0));

        assertEquals(2058, dg.getMinLCM(2));
        assertEquals(5820, dg.getMinLCM(97));
        assertEquals(2025855, dg.getMinLCM(117));
    }
}