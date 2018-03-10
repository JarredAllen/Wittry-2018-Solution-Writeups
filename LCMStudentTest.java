import junit.framework.TestCase;

/**
 * The test class studentTest.
 *
 * @author Don Allen
 * @author Ahmed Abdalla
 * @author Jarred Allen
 * @version 2018 Wittry programming contest
 */
public class LCMStudentTest extends junit.framework.TestCase {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
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
    }

    public void testLCMOfMultipleNumbers() {
        //Test for three prime numbers
        assertEquals(30, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{2,3,5}));
        assertEquals(42, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{2,3,7}));
        assertEquals(70, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{2,7,5}));
        //Test for three coprime numbers
        assertEquals(210, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{2,3,35}));
        assertEquals(210, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{2,15,7}));
        assertEquals(210, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{10,3,7}));
        assertEquals(210, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{5,6,7}));
        //Test for two non-coprime numbers
        assertEquals(30, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{6,10}));
        assertEquals(40, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{8,10}));
        assertEquals(60, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{10,12}));
        assertEquals(12, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{12,12}));
        assertEquals(48, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{6,48}));
        //Test for three non-coprime numbers
        assertEquals(60, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{6,10,12}));
        assertEquals(120, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{8,10,12}));
        assertEquals(420, LCM_PlusPlus.LCMofMultipleNumbers(new int[]{10,12,14}));
    }

    public void testMinLCMValue() {
        //Coprime values
        assertEquals(5, LCM_PlusPlus.minLCMValue(10,2));
        assertEquals(5, LCM_PlusPlus.minLCMValue(15,3));
        assertEquals(7, LCM_PlusPlus.minLCMValue(21,3));
        //Non-coprime values
        assertEquals(8, LCM_PlusPlus.minLCMValue(24,6));
        assertEquals(144, LCM_PlusPlus.minLCMValue(144,6));
        assertEquals(144, LCM_PlusPlus.minLCMValue(144,12));
        assertEquals(144, LCM_PlusPlus.minLCMValue(144,24));
        assertEquals(16, LCM_PlusPlus.minLCMValue(144,72));
        assertEquals(1, LCM_PlusPlus.minLCMValue(144,144));
    }
}