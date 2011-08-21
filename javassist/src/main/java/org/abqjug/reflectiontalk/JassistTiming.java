package org.abqjug.reflectiontalk;

import javassist.*;

import java.io.IOException;


//reference: http://www.ibm.com/developerworks/java/library/j-dyn0916/index.html
public class JassistTiming {
    public static void main(String[] argv) {

        String className = "org.abqjug.reflectiontalk.TestClass";
        String methodName = "callMe";

        try {

            // start by getting the class file and method
            ClassPool pool = ClassPool.getDefault();
            CtClass clas = pool.get(className);
            if (clas == null) {
                System.err.println("Class " + className + " not found");
            } else {

                // add timing interceptor to the class
                addTiming(clas, methodName);

                clas.writeFile();
                System.out.println("Added timing to method " +
                        className + "." + methodName);

                TestClass testClass = (TestClass) clas.toClass().newInstance();

                for (int i = 0; i < 3; i++) {
                    testClass.callMe();
                }

            }

        } catch (CannotCompileException ex) {
            ex.printStackTrace();
        } catch (NotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    private static void addTiming(CtClass clas, String mname)
            throws NotFoundException, CannotCompileException, IOException {

        //  get the metTestClasshod information (throws exception if method with
        //  given name is not declared directly by this class, returns
        //  arbitrary choice if more than one with the given name)
        CtMethod mold = clas.getDeclaredMethod(mname);

        //  rename old method to synthetic name, then duplicate the
        //  method with original name for use as interceptor
        String nname = mname + "$impl";
        mold.setName(nname);
        CtMethod mnew = CtNewMethod.copy(mold, mname, clas, null);

        //  start the body text generation by saving the start time
        //  to a local variable, then call the timed method; the
        //  actual code generated needs to depend on whether the
        //  timed method returns a value
        String type = mold.getReturnType().getName();
        StringBuffer body = new StringBuffer();
        body.append("{\nlong start = System.currentTimeMillis();\n");
        if (!"void".equals(type)) {
            body.append(type + " result = ");
        }
        body.append(nname + "();\n");

        //  finish body text generation with call to print the timing
        //  information, and return saved value (if not void)
        body.append("System.out.println(\"Call to method " + mname +
                " took \" +\n (System.currentTimeMillis()-start) + " +
                "\" ms.\");\n");
        if (!"void".equals(type)) {
            body.append("return result;\n");
        }
        body.append("}");

        //  replace the body of the interceptor method with generated
        //  code block and add it to class
        mnew.setBody(body.toString());
        clas.addMethod(mnew);

        //  print the generated code block just to show what was done
        System.out.println("Interceptor method body:");
        System.out.println(body.toString());
    }
}