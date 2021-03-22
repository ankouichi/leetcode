package org.example.elementary.stringformat;

import java.util.Date;

/**
 * Created by ankouichi on 1/24/21
 */

public class DateFormat {
    public static void main(String[] args) {
        String today = String.format("%tA, %<tB %<td", new Date());
        String time = String.format("%tr", new Date());
        System.out.println(today);
        System.out.println(time);
    }
}
