package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * f your device has JUnit installed, then you do not need to copy over this class. However,
 * if you are like me and can't get JUnit to work on your computer, then any subclass will act
 * like JUnit if run as a standard Java application.
 *
 * @author Jarred Allen
 * @version 3/3/2018
 */
public class TestCase {

    public static final boolean showPassed = true;
    public static final boolean showStackTrace = true;
    public static final boolean showAssertTrace = true;

    /**
     * For any subclass to work, this method must be copied into the TestCase subclass.
     */
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<? extends TestCase> cls = (Class<? extends TestCase>) new Object(){}.getClass().getEnclosingClass();
        runTests(cls);
    }

    /**
     * A reflection-hacking method to automatically run all tests included in the given class argument.
     */
    public static void runTests(Class<? extends TestCase> cls) throws ReflectiveOperationException {
        System.out.println("Testing "+cls.getSimpleName()+"...");
        TestCase tester = cls.newInstance();
        int count = 0, passed = 0;
        long time = System.currentTimeMillis();
        for(Method m:cls.getDeclaredMethods()) {
            if(m.getName().substring(0,4).equals("test")) {
                try {
                    m.invoke(tester);
                    count++;
                    passed++;
                    if(showPassed) {
                        System.out.println(rightpad(m.getName(), ' ', 40) + " PASSED!");
                    }
                }
                catch(InvocationTargetException ite) {
                    if(ite.getCause() instanceof AssertionError) {
                        count++;
                        System.out.println(rightpad(m.getName(), ' ', 40) + " FAILED :(");
                        if(showAssertTrace) {
                            ite.getCause().printStackTrace(System.out);
                        }
                    }
                    else {
                        count++;
                        System.out.println(rightpad(m.getName(), ' ', 40) + " ERRORED:(");
                        if(showStackTrace) {
                            ite.getCause().printStackTrace(System.out);
                        }
                    }
                }
                catch(ReflectiveOperationException roe) {
                    assert true;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("Passed %d out of %d, for a success rate of %.1f%%, in %.2fs\n",
                          passed, count, (100d*passed)/count, (System.currentTimeMillis()-time)/1000d);
    }


    public void assertEquals(Object a, Object b) {
        if(a==null) {
            if(b!=null) {
                throw new AssertionError("null!="+b);
            }
            return;
        }
        if(!a.equals(b)) {
            throw new AssertionError(a+"!="+b);
        }
    }

    public void assertEquals(Object a, Object b, String msg) {
        if(a==null) {
            if(b!=null) {
                throw new AssertionError(msg);
            }
            return;
        }
        if(!a.equals(b)) {
            throw new AssertionError(msg);
        }
    }

    public void assertEquals(double a, double b, double e) {
        if(Math.abs(a-b) > e && Math.abs((a-b)/a) > e) {
            throw new AssertionError(a+"!="+b);
        }
    }

    public void assertEquals(double a, double b, double e, String msg) {
        if(Math.abs(a-b) > e && Math.abs((a-b)/a) > e) {
            throw new AssertionError(msg);
        }
    }

    private static String rightpad(String text, char pad, int length) {
        if(text.length() < length) {
            return text + new String(new char[length-text.length()]).replace((char)0, pad);
        }
        return text;
    }
}
