package org.companies.paypal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */

public class LC658_FindKClosestElements {
    /**
     * Solution 1: Using Collections.sort()
     * Time - O(nlogn), Space - O(k)
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int e : arr)
            list.add(e);
        Collections.sort(list, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        list = list.subList(0, k);
        Collections.sort(list);
        return list;
    }

    /**
     * Solution 2: Binary Search with two pointers
     * Time - O(logn + k), Space - O(k)
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int e : arr)
            list.add(e);
        int n = list.size();
        if (x <= list.get(0)) return list.subList(0,k);
        else if (x >= list.get(n - 1)) return list.subList(n - k,n);
        else {
            int idx = Collections.binarySearch(list, x);
            if (idx < 0) idx = - idx - 1;
            int low = Math.max(0, idx - k - 1), high = Math.min(list.size() - 1, idx + k - 1);
            while (high - low > k - 1) {
                if (low < 0 || (x - list.get(low)) <= (list.get(high) - x)) high--;
                else if (high > list.size() - 1 || (x - list.get(low)) > (list.get(high) - x)) low++;
                else System.out.println("unhandled case: " + low + " " + high);
            }
            return list.subList(low, high + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;
        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println("solution 1: " + result);
        System.out.println();
        System.out.println("solution 2: " + findClosestElements2(arr, k, x));
    }
}
