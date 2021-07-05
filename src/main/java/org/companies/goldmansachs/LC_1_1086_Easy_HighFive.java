package org.companies.goldmansachs;

import java.util.*;

/**
 * @author: Daniel
 * @date: 2021/6/28 22:11
 * @description:
 *
 * Given a list of the scores of different students, items, where items[i] = [IDi, score_i] represents one score
 * from a student with IDi, calculate each student's top five average.
 *
 * Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAverage_j] represents the student
 * with IDj and their top five average. Sort result by IDj in increasing order.
 *
 * A student's top five average is calculated by taking the sum of their top five scores and dividing it
 * by 5 using integer division.
 *
 * Example 1:
 *
 * Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is
 * (100 + 92 + 91 + 87 + 65) / 5 = 87.
 *
 * The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is
 * (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
 *
 * Constraints:
 *
 *     1 <= items.length <= 1000
 *     items[i].length == 2
 *     1 <= ID_i <= 1000
 *     0 <= score_i <= 100
 *     For each ID_i, there will be at least five scores.
 *
 */
public class LC_1_1086_Easy_HighFive {
    public static int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0], score = item[1];
            PriorityQueue<Integer> scores = map.getOrDefault(id, new PriorityQueue<>((a, b) -> b - a));
            scores.add(score);
            map.put(id, scores);
        }

        List<int[]> list = new ArrayList<>();
        for (int k : map.keySet()) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += map.get(k).poll();
            }
            list.add(new int[] {k, sum / 5});
        }

        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] result = highFive(items);
        for (int[] item : result) {
            System.out.println("id: " + item[0] + ", average score: " + item[1]);
        }
    }
}





















