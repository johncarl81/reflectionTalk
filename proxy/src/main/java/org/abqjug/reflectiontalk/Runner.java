package org.abqjug.reflectiontalk;

/**
 * @author John Ericksen
 */
public class Runner {

    public static void main(String args[]) {

        Worker worker = WorkerClassFactory.getInstance().buildWorker();

        worker.runme();
    }
}
