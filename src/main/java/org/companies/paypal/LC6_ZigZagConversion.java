package org.companies.paypal;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 * Constraints:
 *     1 <= s.length <= 1000
 *     s consists of English letters (lower-case and upper-case), ',' and '.'.
 *     1 <= numRows <= 1000
 */

public class LC6_ZigZagConversion {
    /**
     * T - O(n), S - O(n)
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            while (j + i < s.length()) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + 2 * numRows - 2 - i < s.length())
                    sb.append(s.charAt(j + 2 * numRows - 2 - i));
                j += 2 * numRows - 2;
            }
        }
        return sb.toString();
    }

    /**
     * Solution 2: Time - O(n), Space - O(n)
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        boolean goingDown = false;
        int row = 0;
        for (Character c : s.toCharArray()) {
            if (row == 0 || row == numRows - 1) goingDown = !goingDown;
            list.get(row).append(c);
            row += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list)
            res.append(sb);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println("solution 1 : " + convert(s, 4));
        System.out.println("solution 2 : " + convert2(s, 4));
        System.out.println("1 equals 2 : " + convert(s, 4).equals(convert2(s, 4)));
    }
}
