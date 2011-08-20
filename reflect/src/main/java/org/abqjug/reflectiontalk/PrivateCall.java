package org.abqjug.reflectiontalk;

import org.abqjug.reflectiontalk.domain.Hidden;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author John Ericksen
 */
public class PrivateCall {

    public static void main(String[] args) {
        try {

            Hidden talkerInstance = new Hidden("PRIVATE", "PROTECTED", "PACKAGEPRIVATE", "PUBLIC");

            //examine attributes
            Method[] methods = Hidden.class.getDeclaredMethods();
            Field[] fields = Hidden.class.getDeclaredFields();

            System.out.println("The Methods defined in Talker:");

            //print methods
            for (Method method : methods) {
                System.out.println("\t" + method.getName());
            }

            System.out.println("The Fields defined in Talker:");

            //print fields
            for (Field field : fields) {

                //private accessable
                field.setAccessible(true);

                System.out.println("\t" + field.getName() +
                        ", Type: " + field.getType().getName() +
                        ", Value: " + field.get(talkerInstance));
            }

            for (Method method : methods) {
                method.setAccessible(true);

                method.invoke(talkerInstance);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
