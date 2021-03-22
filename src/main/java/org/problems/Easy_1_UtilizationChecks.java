package org.problems;

/**
 * Created by ankouichi on 2/4/21
 */

public class Easy_1_UtilizationChecks {

    /**
     * solution 1: brute force
     * Result in TLE
     * @param instances
     * @param averageUtil
     * @return
     */
    public int finalInstances(int instances, int[] averageUtil) {
        int N = averageUtil.length;
        int ans = instances;
        int i = 0;
        while (i < N) {
            if (averageUtil[i] >= 25 && averageUtil[i] <= 60) {
                i++;
                continue;
            }

            if (averageUtil[i] < 25) {
                ans = ans / 2 + ans % 2;
                continue;
            }

            if (ans <= Math.pow(10,8)) {
                ans *= 2;
            }

            i += 11;
        }

        return ans;
    }

    /**
     * solution 2: optimized solution
     * 1. Do NOT use index
     * 2. skip next 10 elements only when adding or removing is conducted
     * @param instances
     * @param averageUtil
     * @return
     */
    public int finalInstancesOptimized(int instances, int[] averageUtil) {
        int skip = 0;

        for (int ele : averageUtil) {
            if (skip > 0)
                skip--;
            else {
                int newIns = instances;
                if (ele >= 25 && ele <= 60) {
                    continue;
                }

                if (ele < 25) {
                    if (instances == 1) continue;
                    newIns = instances / 2 + instances % 2;
                } else if (instances <= Math.pow(10,8)) {
                    newIns = 2 * instances;
                }

                if (newIns != instances) {
                    instances = newIns;
                    skip = 10;
                }
            }
        }

        return instances;
    }
}
