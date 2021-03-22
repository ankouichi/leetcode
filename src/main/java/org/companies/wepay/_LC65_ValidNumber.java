package org.companies.wepay;

/**
 * Created by ankouichi on 3/21/21
 *
 * A valid number can be split up into these components (in order):
 *
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * At least one digit, followed by a dot '.'.
 * At least one digit, followed by a dot '.', followed by at least one digit.
 * A dot '.', followed by at least one digit.
 * An integer can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * At least one digit.
 * Valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
 *
 * Not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 *
 */

public class _LC65_ValidNumber {
    public static boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*([eE][-+]?\\d+)?");
    }

    public static boolean isNumberSimple(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*");
    }

    public static void main(String[] args) {
//        System.out.println(isNumber("99e2.5"));
//        System.out.println(isNumber("-123.456e789"));

        System.out.println(isNumberSimple("123.4"));
        System.out.println(isNumberSimple("123.456.7"));
        System.out.println(isNumberSimple("abc"));
    }
}
