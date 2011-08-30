package org.abqjug.reflectiontalk;

/**
 * @author John Ericksen
 */
public class ParameterConstructor {

    private String input;

    public ParameterConstructor(String input) {
        this.input = input;
    }

    public void sayHello() {
        System.out.println("Here's my value: " + input);
    }
}
