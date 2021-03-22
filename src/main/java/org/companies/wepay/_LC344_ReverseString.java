package org.companies.wepay;

/**
 * Created by ankouichi on 3/22/21
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 */

public class _LC344_ReverseString {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s1 = new char[] { 'h','e','l','l','o' };
        System.out.println("Example 1");
        for (char c : s1) {
            System.out.print(c);
        }
        System.out.println();
        reverseString(s1);
        for (char c : s1) {
            System.out.print(c);
        }
    }
}
