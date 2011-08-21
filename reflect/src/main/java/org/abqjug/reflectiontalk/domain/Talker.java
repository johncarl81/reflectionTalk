package org.abqjug.reflectiontalk.domain;

/**
 * @author John Ericksen
 */
public class Talker {

    public String field1;
    public String field2;

    public Talker(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public void one() {
        System.out.println("One was called");
    }

    public void two() {
        System.out.println("Two was called");
    }
}
