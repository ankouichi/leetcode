package org.problems.trials;

/**
 * Created by ankouichi on 3/1/21
 */

public class _4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { };
        int[] nums2 = { 1 };
        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // ensure m <= n
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }

        int min = 0, max = m, halfLen = (m + n + 1) / 2;

        while (min <= max) {
            int i = (min + max) / 2;
            int j = halfLen - i;

            if (i > min && nums1[i-1] > nums2[j]) {
                max = i - 1;
            } else if (i < max && nums2[j-1] > nums1[i]) {
                min = i + 1;
            } else {
                int leftHalfEnd = i == 0 ? nums2[j-1] : j == 0 ? nums1[i-1] : Math.max(nums1[i-1], nums2[j-1]);

                if ((m + n) % 2 == 1) {
                    return leftHalfEnd;
                }

                int rightHalfStart = i == m ? nums2[j] : j == n ? nums1[i] : Math.min(nums1[i], nums2[j]);

                return (leftHalfEnd + rightHalfStart) / 2;
            }

        }

        return 0.0;
    }
}
