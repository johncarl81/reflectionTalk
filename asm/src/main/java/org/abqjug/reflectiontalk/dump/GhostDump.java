package org.abqjug.reflectiontalk.dump;

import org.objectweb.asm.*;

public class GhostDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "org/abqjug/reflectiontalk/Ghost", null, "java/lang/Object", null);

        cw.visitSource("Ghost.java", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "one", "()V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "two", "(Ljava/lang/String;)V", null, null);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "three", "(Ljava/lang/String;)Ljava/lang/String;", null, null);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
