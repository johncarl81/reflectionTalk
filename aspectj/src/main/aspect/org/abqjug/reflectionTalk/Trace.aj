package org.abqjug.reflectionTalk;

import java.util.HashMap;
import java.util.Map;

aspect Trace {

    pointcut methodCalls(): call(* org.abqjug.reflectionTalk..*(..))  && !within(org.abqjug.reflectionTalk.MannersAspect);

    Object around(): methodCalls() {

        String threadName = Thread.currentThread().getName();

        if (null == threadMap.get(threadName)) {
            threadMap.put(threadName, 0);
        }

        int stackDepth = threadMap.get(threadName) + 1;


        threadMap.put(threadName, stackDepth);


        String name = Thread.currentThread().getName();

        String indent = "";

        for (int index = 0; index < stackDepth; index++) {
            indent += "\t";
        }

        System.out.println(name + ":" + indent + ">>>> "
                + thisJoinPointStaticPart.getSignature().toString());

        long start = System.currentTimeMillis();
        try {
            return proceed();
        } finally {

            long end = System.currentTimeMillis();

            System.out.println(name + ":" + indent + "<<<< "
                    + thisJoinPointStaticPart.getSignature().toString() + "("
                    + (end - start) + " milliseconds)");

            threadMap.put(threadName, stackDepth - 1);
        }

    }

    private static Map<String, Integer> threadMap = new HashMap<String, Integer>();

}

