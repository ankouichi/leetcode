package org.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: Daniel
 * @date: 2021/5/4 11:12
 * @description:
 */
public class LC220_Medium_ContainsDuplicateIII {

    /**
     * Solution 1: Bucket Sort (Recommended)
     * Time - O(N)
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> buckets = new HashMap<>();
        long capacity = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], capacity);
            if (buckets.containsKey(id)) return true;
            if (buckets.containsKey(id - 1) && nums[i] - buckets.get(id - 1) < capacity) return true;
            if (buckets.containsKey(id + 1) && buckets.get(id + 1) - nums[i] < capacity) return true;
            buckets.put(id, (long)nums[i]);
            if (buckets.size() > k)
                buckets.remove(getBucketId(nums[i - k],capacity));
        }
        return false;
    }

    private long getBucketId(long val, long bucketCapacity) {
        return val < 0 ? (val + 1) / bucketCapacity - 1 : val / bucketCapacity;
    }

    /**
     * Solution 2: TreeSet/Heap
     * Time - O(N*Log(min(N,k)))
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer c = set.ceiling(nums[i]);
            if (c != null && (long)c - (long)nums[i] <= t) return true;
            Integer f = set.floor(nums[i]);
            if (f != null && (long)nums[i] - (long)f <= t) return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int k = 3, t = 0;
        LC220_Medium_ContainsDuplicateIII app = new LC220_Medium_ContainsDuplicateIII();
        System.out.println(app.containsNearbyAlmostDuplicate(arr, k, t));
        System.out.println(app.containsNearbyAlmostDuplicate2(arr, k, t));
        System.out.println();
        arr = new int[] {1,0,1,1};
        k = 1;
        t = 2;
        System.out.println(app.containsNearbyAlmostDuplicate(arr, k, t));
        System.out.println(app.containsNearbyAlmostDuplicate2(arr, k, t));
        System.out.println();
        arr = new int[] {1,5,9,1,5,9};
        k = 2;
        t = 3;
        System.out.println(app.containsNearbyAlmostDuplicate(arr, k, t));
        System.out.println(app.containsNearbyAlmostDuplicate2(arr, k, t));
    }
}
