package org.abqjug.reflectiontalk;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;

/**
 * @author John Ericksen
 */
public class ClassImplementerAdaptor extends ClassAdapter {

    private String overrideName;

    public ClassImplementerAdaptor(ClassVisitor classVisitor, String overrideName) {
        super(classVisitor);

        this.overrideName = overrideName;
    }

    @Override
    public void visit(int i, int i1, String name, String s1, String s2, String[] strings) {
        super.visit(i, i1, overrideName.replace('.', '/'), s1, s2, strings);
    }
}
