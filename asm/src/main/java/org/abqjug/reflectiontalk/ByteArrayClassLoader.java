package org.abqjug.reflectiontalk;

import java.util.Map;

public class ByteArrayClassLoader extends ClassLoader {

    private Map<String, byte[]> classes;

    public ByteArrayClassLoader(Map<String, byte[]> classes) {
        this.classes = classes;
    }

    public Class findClass(String name) throws ClassNotFoundException {
        if (classes.containsKey(name)) {
            return defineClass(name, classes.get(name), 0, classes.get(name).length);
        }

        return super.findClass(name);
    }

}
