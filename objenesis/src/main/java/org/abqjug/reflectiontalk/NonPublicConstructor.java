package org.abqjug.reflectiontalk;

/**
 * @author John Ericksen
 */
public class NonPublicConstructor {

    private NonPublicConstructor() {
        //private!
    }

    public void sayHello() {
        System.out.println("How did you construct me?");
    }
}
