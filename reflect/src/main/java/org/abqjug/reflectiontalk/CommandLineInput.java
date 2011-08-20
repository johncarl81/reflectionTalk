package org.abqjug.reflectiontalk;

import org.abqjug.reflectiontalk.domain.Talker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author John Ericksen
 */
public class CommandLineInput {

    public static void main(String[] args) {

        Talker talkerInstance = new Talker();

        //examine attributes
        Method[] methods = Talker.class.getMethods();

        System.out.println("The Methods defined in Talker:");

        for (Method method : methods) {
            System.out.println("\t" + method.getName());
        }

        System.out.println("The Fields defined in Talker:");

        System.out.println("What Talker method would you like to execute: ");

        String input = null;

        while(!"exit".equals(input)){
            try{
            input = readInput();

            Method method = Talker.class.getMethod(input);

            method.invoke(talkerInstance);
            } catch (Exception e) {
               System.out.println("Exception was thrown during getMethod or method invoke: " + e.toString());
            }
        }

    }

    private static String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
