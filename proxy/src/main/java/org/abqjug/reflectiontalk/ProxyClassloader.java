package org.abqjug.reflectiontalk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author John Ericksen
 */
public class ProxyClassloader extends ClassLoader {

    private Map<String, Class> classMap = new HashMap<String, Class>();

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (classMap.containsKey(name)) {
            return classMap.get(name);
        }

        return super.loadClass(name);
    }

    public void put(String className, Class c) {
        classMap.put(className, c);
    }
}
