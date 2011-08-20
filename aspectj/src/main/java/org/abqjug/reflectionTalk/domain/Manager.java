package org.abqjug.reflectionTalk.domain;

import java.util.List;

/**
 * @author John Ericksen
 */
public class Manager {

    private List<Worker> workers;

    public Manager(List<Worker> workers) {
        this.workers = workers;
    }

    public void golf() {
        // no workers allowed to golf
    }

    public void doWork() {
        for (Worker worker : workers) {
            worker.doWork();
        }
    }

    public void goToMeeting() {
        for (Worker worker : workers) {
            worker.goToMeeting();
        }
    }

}
