package org.example.elementary.stringformat;

import java.util.Calendar;

/**
 * Created by ankouichi on 1/24/21
 */

public class CalendarFormat {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2021,0,24,0,22);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        c.add(Calendar.DATE, 2);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        c.roll(Calendar.DATE, -2);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.getTime());
        long day = c.getTimeInMillis();
        day += 1000 * 60 * 60;
        c.setTimeInMillis(day);
        System.out.println(c.getTime());
    }
}
