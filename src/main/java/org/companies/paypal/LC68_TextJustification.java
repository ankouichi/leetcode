package org.companies.paypal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","
 * computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */

public class LC68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }

        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();
        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (left == right) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numOfSpaces = right - left;
        int totalSpaces = maxWidth - wordsLength(left, right, words);
        String space = isLastLine ? " " : blank(totalSpaces / numOfSpaces);
        int remainder = isLastLine ? 0 : totalSpaces % numOfSpaces;

        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++)
            sb.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");

        return padResult(sb.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

    public static void main(String[] args) {
//        LC68_TextJustification solution = new LC68_TextJustification();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        int mw = 16;
//        List<String> ans = solution.fullJustify(words, mw);
//        for (String s : ans) {
//            System.out.println(s);
//        }
//
//        System.out.println();
//        words = new String[] {"What","must","be","acknowledgment","shall","be"};
//        ans = solution.fullJustify(words, mw);
//        for (String s : ans) {
//            System.out.println(s);
//        }

        System.out.println(new String(new char[4]).replace('\0', '0'));
    }
}
