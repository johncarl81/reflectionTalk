package org.abqjug.reflectiontalk;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author John Ericksen
 */
public class DeclutterProxy implements Worker {

    private Declutter delegate;

    public DeclutterProxy(Declutter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void runme() {
        GregorianCalendar today = new GregorianCalendar();
        Date date = today.getTime();
        if (date.getDay() != Calendar.WEDNESDAY &&
                (date.getHours() < 15 || date.getHours() > 17) &&
                date.getDay() != 31) {

            delegate.runme();

        } else {
            System.out.println("No working During the JUG!");
        }
    }
}
