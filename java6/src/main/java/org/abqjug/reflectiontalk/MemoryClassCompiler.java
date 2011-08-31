package org.abqjug.reflectiontalk;

import java.lang.reflect.Method;

/**
 * @author John Ericksen
 *         <p/>
 *         source from http://weblogs.java.net/blog/2008/12/17/how-compile-fly
 */
public class MemoryClassCompiler {

    private static final String CLASS = "Test";
    private static final String METHOD = "execute";
    private static final String EXPRESSION = "Math.cos(Math.PI/6)";
    private static final String CONTENT
            = "public class " + CLASS + " {"
            + "    public static Object " + METHOD + "() {"
            + "        return " + EXPRESSION + ";"
            + "    }"
            + "}";

    public static void main(String[] args) throws Exception {
        MemoryClassLoader mcl = new MemoryClassLoader(CLASS, CONTENT);

        Class clazz = mcl.loadClass(CLASS);

        Method method = clazz.getMethod(METHOD);

        System.out.println(method.invoke(null));
    }
}
