package org.abqjug.reflectiontalk.domain;

/**
 * @author John Ericksen
 */
public class Hidden {

    private String privateValue;
    protected String protectedValue;
    String pacakgePrivateValue;
    public String publicValue;

    public Hidden(String privateValue, String protectedValue, String pacakgePrivateValue, String publicValue) {
        this.privateValue = privateValue;
        this.protectedValue = protectedValue;
        this.pacakgePrivateValue = pacakgePrivateValue;
        this.publicValue = publicValue;
    }

    public void yeahYouCanCallMe() {
        System.out.println("But you cant call my other method");
    }

    private void hahaICannotBeCalled() {
        System.out.println("Foiled!!");
    }
}
