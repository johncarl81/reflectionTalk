package org.abqjug.reflectiontalk;

/**
 * @author John Ericksen
 */
public class GhostImpl implements Ghost {
    @Override
    public void one() {
        System.out.println("method: one");
    }

    @Override
    public void two(String input) {
        System.out.println("method: two");
    }

    @Override
    public String three(String input) {
        System.out.println("method: three");
        return "value";
    }
}
