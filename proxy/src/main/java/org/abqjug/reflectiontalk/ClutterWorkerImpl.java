package org.abqjug.reflectiontalk;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author John Ericksen
 */
public class ClutterWorkerImpl implements Worker {

    public void runme() {

        GregorianCalendar today = new GregorianCalendar();
        Date date = today.getTime();
        if (date.getDay() != Calendar.WEDNESDAY &&
                (date.getHours() < 15 || date.getHours() > 17) &&
                date.getDay() != 31) {

            System.out.println("It's time to work!");

        } else {
            System.out.println("No working During the JUG!");
        }

    }

}
