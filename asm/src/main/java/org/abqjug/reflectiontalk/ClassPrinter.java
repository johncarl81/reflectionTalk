package org.abqjug.reflectiontalk;

import org.objectweb.asm.*;

/**
 * @author John Ericksen
 */
public class ClassPrinter implements ClassVisitor {
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }


    @Override
    public void visitSource(String s, String s1) {

    }

    @Override
    public void visitOuterClass(String s, String s1, String s2) {

    }

    @Override
    public AnnotationVisitor visitAnnotation(String s, boolean b) {
        return null;
    }

    @Override
    public void visitAttribute(Attribute attribute) {

    }

    @Override
    public void visitInnerClass(String s, String s1, String s2, int i) {

    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.println("    " + desc + " " + name);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println("    " + name + " " + desc);
        return null;
    }

    public void visitEnd() {
        System.out.println("}");
    }

}
