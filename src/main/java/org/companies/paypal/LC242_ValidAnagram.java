package org.companies.paypal;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

public class LC242_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int x : arr) {
            if (x != 0)
                return false;
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a']++ == 0) count++;
            if (arr[t.charAt(i) - 'a']-- == 1) count--;
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String s = "helloa";
        String t = "lloehb";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s, t));
    }
}
