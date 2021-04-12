package org.problems.recursion;

/**
 * @author: Daniel
 * @date: 2021/4/12 1:01
 * @description:
 */
public class PrintStringReversely {
    public void printReversely(String s) {
        helper(0, s.toCharArray());
    }

    private void helper(int idx, char[] arr) {
        if (idx == arr.length) return;
        helper(idx + 1, arr);
        System.out.print(arr[idx]);
    }

    public static void main(String[] args) {
        PrintStringReversely solution = new PrintStringReversely();
        String s = "abcdefg";
        solution.printReversely(s);
    }
}
