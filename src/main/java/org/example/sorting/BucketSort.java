package org.example.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * @author: Daniel
 * @date: 2021/5/4 10:29
 * @description:
 *
 * Bucket Sort - Time: O(N)
 */
public class BucketSort {
    private static void sort(float[] arr, int n) {
        if (n <= 0) return;
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<>();
        }
        for (int i = 0; i < n; i++) {
             buckets[(int)(arr[i] * n)].add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[idx++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = { 0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        System.out.println(Arrays.toString(arr));
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
