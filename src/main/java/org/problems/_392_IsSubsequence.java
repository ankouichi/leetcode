package org.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ankouichi on 2/3/21
 */

public class _392_IsSubsequence {

    /**
     * check if s is a subsequence of t
     * Solution 1: my initial solution
     * @param s substring or not
     * @param t string
     * @return is substring or not
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        if (t == null || t.length() == 0)
            return false;
        if (s.length() > t.length())
            return false;

        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int boundry = 0;
        int count = 0;
        for (int i = 0; i < s_arr.length; i++) {
            int j = boundry;
            for (; j < t_arr.length; j++) {
                if (s_arr[i] == t_arr[j]) {
                    boundry = j + 1;
                    count++;
                    break;
                }
            }

            if (j == boundry)
                return false;
        }

        if (count < s_arr.length)
            return false;

        return true;
    }

    // Solution 2
    // S - the length of the source string, T - the length of the target string
    // Time Complexity: O(T)
    // Space Complexity: O(T)
    String source, target;
    Integer leftBound, rightBound;
    private boolean rec_isSubsequence(int leftIndex, int rightIndex) {
        if (leftIndex == leftBound)
            return true;
        if (rightIndex == rightBound)
            return false;

        if (source.charAt(leftIndex) == target.charAt(rightIndex))
            leftIndex++;
        rightIndex++;

        return rec_isSubsequence(leftIndex, rightIndex);
    }

    public boolean isSubsequence_1(String s, String t) {
        this.source = s;
        this.target = t;
        this.leftBound = s.length();
        this.rightBound = t.length();
        return rec_isSubsequence(0, 0);
    }

    // Solution 3: two pointers
    public boolean isSubsequence_2(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft++;
            }
            pRight++;
        }

        return pLeft == leftBound;
    }

    // Solution 4: Hashmap
    public boolean isSubsequence_3(String s, String t) {
        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (letterIndicesTable.containsKey(t.charAt(i))) {
                letterIndicesTable.get(t.charAt(i)).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i), indices);
            }
        }

        Integer curMatchIndex = -1;
        for (char c : s.toCharArray()) {
            if (!letterIndicesTable.containsKey(c))
                return false;

            boolean matched = false;
            for (Integer index : letterIndicesTable.get(c)) {
                if (index > curMatchIndex) {
                    matched = true;
                    curMatchIndex = index;
                    break;
                }
            }

            if (!matched)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        _392_IsSubsequence app = new _392_IsSubsequence();
        String s = "abf";
        String t = "aebdc";
        System.out.println("s is subsequence of t: " + app.isSubsequence_1(s, t));
        System.out.println("s is subsequence of t: " + app.isSubsequence_2(s, t));
        System.out.println("s is subsequence of t: " + app.isSubsequence_3(s, t));
    }
}
