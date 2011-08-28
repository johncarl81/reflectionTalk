package org.abqjug.reflectiontalk;

import org.abqjug.reflectiontalk.dump.GhostImplDump;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John Ericksen
 */
public class Implementer {

    private static final String GHOST_IMPL_NAME = "org.abqjug.reflectiontalk.GhostImpl_stub";

    public static void main(String[] args) {
        try {
            ClassReader reader = new ClassReader(GhostImpl.class.getCanonicalName());

            ClassWriter writer = new ClassWriter(0);

            ClassImplementerAdaptor adapter = new ClassImplementerAdaptor(writer, GHOST_IMPL_NAME);

            reader.accept(adapter, 0);

            byte[] output = writer.toByteArray();

            byte[] value = GhostImplDump.dump(GHOST_IMPL_NAME);

            Map<String, byte[]> classes = new HashMap<String, byte[]>();
            classes.put(GHOST_IMPL_NAME, output);

            ClassLoader classLoader = new ByteArrayClassLoader(classes);

            Class ghostImplClass = classLoader.loadClass(GHOST_IMPL_NAME);

            Ghost ghost = (Ghost) ghostImplClass.newInstance();

            ghost.one();
            ghost.two("test two");
            String retValue = ghost.three("test three");

            System.out.println("Returned: " + retValue);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
