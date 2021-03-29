package org.companies.paypal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by ankouichi on 3/25/21
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 *
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start_i <= end_i <= 10^4
 *
 */

public class _LC56_MergeIntervals {
    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for (int[] interval : intervals) {
            if (merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][] {{1,3}, {2,6}, {8,10}, {15,18}};
        for (int[] arr : arr1) {
            System.out.print("(" + arr[0] + ", " + arr[1] + ") ");
        }
        System.out.println();
        System.out.println("After merged: ");
        int[][] merged = merge(arr1);
        for (int[] arr : merged) {
            System.out.print("(" + arr[0] + ", " + arr[1] + ") ");
        }
    }
}
