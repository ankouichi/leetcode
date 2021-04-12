package org.problems.recursion;

/**
 * @author: Daniel
 * @date: 2021/4/12 1:21
 * @description:
 */
public class ReverseStringWithConstantMemory {
    public static void main(String[] args) {
        String s = "hello";
        char[] arr = s.toCharArray();
        System.out.println(arr);
        ReverseStringWithConstantMemory solution = new ReverseStringWithConstantMemory();
        solution.reverseString(arr);
        System.out.println(arr);
    }

    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }

    public void helper(int start, int end, char[] arr) {
        if (start >= end) return;
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        helper(start + 1, end - 1, arr);
    }
}
