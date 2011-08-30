package org.abqjug.reflectiontalk;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * @author John Ericksen
 */
public class ObjenesisPrivateRunner {

    public static void main(String[] args) {

        try {
            NonPublicConstructor.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Objenesis objenesis = new ObjenesisStd();

        NonPublicConstructor instance = (NonPublicConstructor) objenesis.newInstance(NonPublicConstructor.class);

        instance.sayHello();
    }
}
