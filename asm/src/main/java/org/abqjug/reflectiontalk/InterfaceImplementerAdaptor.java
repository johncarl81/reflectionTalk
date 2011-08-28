package org.abqjug.reflectiontalk;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @author John Ericksen
 */
public class InterfaceImplementerAdaptor extends ClassAdapter {

    private String overrideName;

    public InterfaceImplementerAdaptor(ClassVisitor classVisitor, String overrideName) {
        super(classVisitor);

        this.overrideName = overrideName;
    }

    @Override
    public void visit(int i, int i1, String name, String s1, String s2, String[] strings) {
        super.visit(i, i1, overrideName.replace('.', '/'), s1, s2, strings);
        //super.visit(i, i1 + Opcodes.ACC_SUPER - Opcodes.ACC_INTERFACE - Opcodes.ACC_ABSTRACT, overrideName.replace('.', '/'), s1, s2, strings);
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        return super.visitMethod(i, s, s1, s2, strings);
    }
}
