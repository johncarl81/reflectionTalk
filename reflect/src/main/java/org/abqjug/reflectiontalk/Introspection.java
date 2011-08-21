package org.abqjug.reflectiontalk;

import org.abqjug.reflectiontalk.domain.Talker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author John Ericksen
 */
public class Introspection {

    public static void main(String[] args) {
        try {

            Talker talkerInstance = new Talker("ONE", "TWO");

            //examine attributes
            Method[] methods = Talker.class.getDeclaredMethods();
            Field[] fields = Talker.class.getFields();

            System.out.println("The Methods defined in Talker:");

            //print methods
            for (Method method : methods) {
                System.out.println("\t" + method.getName());
            }

            System.out.println("The Fields defined in Talker:");

            //print fields
            for (Field field : fields) {

                System.out.println("\t" + field.getName() +
                        ", Type: " + field.getType().getName() +
                        ", Value: " + field.get(talkerInstance));
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
