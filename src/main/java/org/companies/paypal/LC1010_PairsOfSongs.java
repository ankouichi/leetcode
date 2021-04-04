package org.companies.paypal;

/**
 * Pairs of Songs With Total Durations Divisible by 60
 *
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 *
 *
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 * Constraints:
 *
 * 1 <= time.length <= 6 * 10^4
 * 1 <= time[i] <= 500
 *
 *
 */
public class LC1010_PairsOfSongs {
    /**
     * Time - O(n), Space - O(1) since arr is a fixed size array (60).
     * @param time
     * @return
     */
    public static int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int ans = 0;
        for (int j : time) {
            if (j % 60 == 0) {
                ans += arr[0];
            } else {
                ans += arr[60 - j % 60];
            }

            arr[j % 60]++;
        }

        return ans;
    }

    /**
     * Solution from LC Discussion, Time - O(n), Space - O(1), shorter code
     * @param time
     * @return
     */
    public static int numPairsDivisibleBy60_2(int[] time) {
        int arr[] = new int[60], ans = 0;
        for (int j : time) {
            ans += arr[(600 - j) % 60];
            arr[j % 60]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        System.out.println("solution1: " + numPairsDivisibleBy60(time));
        System.out.println("solution2: " + numPairsDivisibleBy60_2(time));

        time = new int[] {60,60,60};
        System.out.println("solution1: " + numPairsDivisibleBy60(time));
        System.out.println("solution2: " + numPairsDivisibleBy60_2(time));
    }
}
