package org.abqjug.reflectionTalk;

import org.abqjug.reflectionTalk.domain.Manager;
import org.abqjug.reflectionTalk.domain.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John Ericksen
 */
public class TraceRunner {

    public static void main(String[] args) {

        List<Worker> workers = new ArrayList<Worker>();

        for (int i = 0; i < 3; i++) {
            workers.add(new Worker());
        }
        Manager manager = new Manager(workers);

        manager.doWork();
        manager.goToMeeting();
        manager.golf();
    }
}
