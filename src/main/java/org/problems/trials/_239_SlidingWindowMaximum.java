package org.problems.trials;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ankouichi on 2/5/21
 */

public class _239_SlidingWindowMaximum {
    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 4;
        int[] maximals = printMax(arr, arr.length, k);
        for (int ele : maximals) {
            System.out.println(ele);
        }
    }

    static int[] printMax(int arr[], int n, int k) {
        Deque<Integer> qi = new LinkedList<>();

        int i;
        for (i = 0; i < k; i++) {
            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) {
                qi.removeLast();
            }

            qi.addLast(i);
        }

        int[] ans = new int[n - k + 1];

        for (; i < n; i++) {
            ans[i - k] = arr[qi.peek()];

            while (!qi.isEmpty() && qi.peek() <= i - k) {
                qi.removeFirst();
            }

            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) {
                qi.removeLast();
            }

            qi.addLast(i);
        }

        ans[n-k] = arr[qi.peek()];

        return ans;
    }
}
