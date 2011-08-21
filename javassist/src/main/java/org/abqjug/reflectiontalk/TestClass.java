package org.abqjug.reflectiontalk;

/**
 * @author John Ericksen
 */
public class TestClass {

    public String callMe() {
        System.out.println("Working...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Done";
    }
}
