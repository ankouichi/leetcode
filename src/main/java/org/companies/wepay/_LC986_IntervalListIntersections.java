package org.companies.wepay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankouichi on 3/21/21
 *
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and
 * secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a
 * closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *
 */

public class _LC986_IntervalListIntersections {
    /**
     * Time: O(M+N), Space: O(M+N), when M,N are the length of A and B, respectively.
     * @param firstList
     * @param secondList
     * @return
     */
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi)
                ans.add(new int[] {lo, hi});
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] first = new int[][] { {0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = new int[][] { {1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ans = intervalIntersection(first, second);
        for (int[] item : ans) {
            System.out.println("[" + item[0] + ", " + item[1] + "]");
        }
    }
}
