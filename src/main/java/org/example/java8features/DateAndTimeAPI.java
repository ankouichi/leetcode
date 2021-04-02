package org.example.java8features;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Java 8 introduced new APIs for Date and Time to address the shortcomings of the older java.util.Date and java.util.Calendar.
 *
 * Issues with the existing Date/Time APIs
 * 1. Thread Safety - The Date and Calendar classes are not thread safe, leaving developers to deal with the headache
 * of hard to debug concurrency issues and to write additional code to handle thread safety.
 * On the contrary, the new Date and Time APIs introduced in Java 8 are immutable and thread safe,
 * thus taking that concurrency headache away from developers.
 *
 * 2. APIs design and ease of understanding - The Date and Calendar APIs are poorly designed with inadequate methods to
 * perform day-to-day operations. The new Date/Time APIs is ISO centric and follows consistent domain models for date,
 * time, duration and periods. There are a wide variety of utility methods that support the commonest operations.
 *
 * 3. ZonedDate & Time - Developers had to write additional logic to handle timezone logic with the old APIs,
 * whereas with the new APIs, handling of timezone can be done with Local and ZonedDate/Time APIs.
 *
 * LocalDate, LocalTime and LocalDateTime
 */

public class DateAndTimeAPI {
    public static void main(String[] args) {
//        printDate();
//        printTime();
        printDateTime();
    }

    public static void printDate() {
        // yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate date1 = LocalDate.of(1991, 1, 1);
        LocalDate date2 = LocalDate.parse("1991-02-02");

        System.out.println(date1);
        System.out.println(date2);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(previousMonthSameDay);

        System.out.println(LocalDate.now().plusYears(-1).isLeapYear());
    }

    public static void printTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime sixThirty = LocalTime.parse("06:30");
        System.out.println(sixThirty);
        sixThirty = LocalTime.of(6,30);
        System.out.println(sixThirty);
    }

    public static void printDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getMonth());
        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println(tomorrow);
        System.out.println(tomorrow.isAfter(now));

        LocalDateTime yesterday = now.minusDays(1);
        List<LocalDateTime> dateTimes = new ArrayList<>();
        dateTimes.add(now);
        dateTimes.add(tomorrow);
        dateTimes.add(yesterday);

        System.out.println();
        Collections.sort(dateTimes, Collections.reverseOrder());
        for (LocalDateTime time : dateTimes) {
            System.out.println(time);
        }
    }
}
