package org.abqjug.reflectionTalk;

import org.abqjug.reflectionTalk.domain.Manager;
import org.abqjug.reflectionTalk.domain.Worker;

import java.util.Arrays;
import java.util.List;

/**
 * @author John Ericksen
 */
public class Trace {

    public static void main(String[] args) {

        List<Worker> workers = Arrays.asList(new Worker(), new Worker(), new Worker());
        Manager manager = new Manager(workers);

        manager.doWork();
        manager.goToMeeting();
        manager.golf();
    }
}
