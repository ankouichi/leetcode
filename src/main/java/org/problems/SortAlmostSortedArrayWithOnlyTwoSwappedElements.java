package org.problems;

import java.util.Arrays;

/**
 * @author: Daniel
 * @date: 2021/5/10 7:01
 * @description:
 */
public class SortAlmostSortedArrayWithOnlyTwoSwappedElements {
    /**
     * Time - O(n), Space - O(1)
     * @param nums
     */
    static void sortByOneSwap(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                int j = i - 1;
                while (j >= 0 && nums[i] < nums[j]) {
                    j--;
                }
                System.out.println(j);
                int temp = nums[i];
                nums[i] = nums[j + 1];
                nums[j + 1] = temp;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,3,4,5,1};
        System.out.println(Arrays.toString(arr));
        sortByOneSwap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
