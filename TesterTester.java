import junit.framework.TestCase;

/**
 * A quick test that my tester works as expected.
 *
 * @author Jarred Allen
 * @version 3/3/2018
 */
public class TesterTester extends junit.framework.TestCase {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
    }

    public void test01() {helperMethod();}
    public void test02() {helperMethod2();}
    public void test03() {throw new AssertionError();}
    public void test04() {helperMethod4();}
    public void test05() {throw new RuntimeException();}

    public void helperMethod() {try{Thread.sleep((int)(Math.random()*100));}catch(Exception e){}}
    public void helperMethod2() {try{Thread.sleep((int)(Math.random()*500));}catch(Exception e){}}
    public void helperMethod4() {try{Thread.sleep((int)(Math.random()*1500));}catch(Exception e){}}
}
