package org.problems.trials;

import java.util.PriorityQueue;

/**
 * Created by ankouichi on 2/3/21
 * https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
 *
 */

public class _973_KNearest {

    public static void main(String[] args) {
        int[][] points = {{0, 1}, {2, -2}, {3, 4}};
        int k = 2;
        int[][] res = kClosest(points, k);
        for(int[] p : res) {
            System.out.println("x: " + p[0] + ", y: " + p[1]);
        }

    }

    /**
     * Max Heap
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1]
                - p1[0] * p1[0] - p1[1] * p1[1]);

        for (int[] p : points) {
            priorityQueue.offer(p);
            if (priorityQueue.size() > K)
                priorityQueue.poll();
        }

        int[][] ans = new int[K][2];
        while(K > 0) {
            ans[K - 1] = priorityQueue.poll();
            K--;
        }

        return ans;
    }
}
