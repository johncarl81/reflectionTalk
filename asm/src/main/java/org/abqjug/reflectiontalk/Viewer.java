package org.abqjug.reflectiontalk;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

/**
 * @author John Ericksen
 */
public class Viewer {

    public static void main(String[] args) {

        try {

            ClassPrinter classVisitor = new ClassPrinter();

            ClassReader cr = new ClassReader(Ghost.class.getCanonicalName());
            cr.accept(classVisitor, 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
