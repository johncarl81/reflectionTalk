package org.abqjug.reflectiontalk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John Ericksen
 */
public class Viewer {

    public static void main(String[] args) {

        try {

            Map<String, byte[]> classes = new HashMap<String, byte[]>();
            //classes.put("Hello", HelloDump.dump());

            ByteArrayClassLoader classLoader = new ByteArrayClassLoader(classes);

            Class genereatedClass = classLoader.loadClass("Hello");

            Object instance = genereatedClass.newInstance();

            instance.getClass().getMethod("main", String.class).invoke(instance, "test");

            //examine attributes
            Method[] methods = genereatedClass.getDeclaredMethods();
            Field[] fields = genereatedClass.getFields();

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
                        ", Value: " + field.get(instance));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
