package org.problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Daniel
 * @date: 2021/6/13 1:01
 * @description:
 */
public class LC1512_Easy_NumberOfGoodPairs {
    // preferred solution
    // space - O(1), time - O(N)
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int res = 0;
        for (int num : nums) {
            res += count[num]++;
        }
        return res;
    }

    // my original solution
    // space - O(N), time - O(N)
     public int numIdenticalPairs2(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
         for (int num : nums) {
             Integer count = map.get(num);
             map.put(num, count == null ? 1 : count + 1);
         }
         int res = 0;
         for (int val : map.values()) {
             res += val * (val - 1) / 2;
         }
         return res;
     }
}
