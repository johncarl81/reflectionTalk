package org.abqjug.reflectiontalk;

import org.abqjug.reflectiontalk.domain.Joker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * @author John Ericksen
 */
public class CommandLineInput {

    public static void main(String[] args) {

        Joker joker = new Joker();

        //examine attributes
        Method[] methods = Joker.class.getMethods();

        System.out.println("The Methods defined in Joker:");

        for (Method method : methods) {
            System.out.println("\t" + method.getName());
        }

        String input = null;

        while (!"exit".equals(input)) {
            try {
                System.out.println("What Talker method would you like to execute?: ");
                input = readInput();

                Method method = Joker.class.getMethod(input);

                method.invoke(joker);
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
