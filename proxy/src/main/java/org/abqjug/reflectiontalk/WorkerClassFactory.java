package org.abqjug.reflectiontalk;

/**
 * @author John Ericksen
 */
public class WorkerClassFactory {

    private static final WorkerClassFactory INSTANCE = new WorkerClassFactory();

    private WorkerClassFactory() {
    }

    public static WorkerClassFactory getInstance() {
        return INSTANCE;
    }

    public Worker buildWorker() {

        return new ClutterWorkerImpl();

        //return new DeclutterProxy(new Declutter());
    }
}
