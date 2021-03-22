package org.companies.wepay;

/**
 * Created by ankouichi on 3/22/21
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
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
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 */

public class _LC242_ValidAnagram {
    /**
     * Approach 1
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] += 1;
            letters[t.charAt(i) - 'a'] -= 1;
        }

        for (int x : letters) {
            if (x != 0)
                return false;
        }

        return true;
    }

    /**
     * Follow-Up: Uppercase
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramUpperCase(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[127];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (++map[cs[i]] == 1) count++;
            if (--map[ct[i]] == 0) count--;
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram", s2 = "rat", t2 = "car";
        String s3 = "Anagram", t3 = "nAgaram";
        System.out.println(isAnagram(s1, t1));
        System.out.println(isAnagramUpperCase(s1, t1));
        System.out.println(isAnagramUpperCase(s2, t2));

        System.out.println(isAnagramUpperCase(s3, t3));
    }
}
