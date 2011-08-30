package org.abqjug.reflectiontalk;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * @author John Ericksen
 */
public class ObjenesisParameterRunner {

    public static void main(String[] args) {

        try {
            ParameterConstructor.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Objenesis objenesis = new ObjenesisStd();

        ParameterConstructor instance = (ParameterConstructor) objenesis.newInstance(ParameterConstructor.class);

        instance.sayHello();
    }
}
