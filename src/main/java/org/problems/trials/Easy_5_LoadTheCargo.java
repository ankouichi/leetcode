package org.problems.trials;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by ankouichi on 2/5/21
 */

public class Easy_5_LoadTheCargo {
    public static void main(String[] args) {
//        int num = 3;
//        int[] containers = {1,2,3};
//        int itemSize = 3;
//        int[] itemsPerContainer = {3,2,1};
//        long cargoSize = 3;

        int num = 5;
        int[] containers = {2,2,3,1,1};
        int itemSize = 5;
        int[] itemsPerContainer = {2,3,5,1,5};
        long cargoSize = 20;
        int res = loadTheCargo(num, containers, itemSize, itemsPerContainer, cargoSize);
        System.out.println(res);
    }

    public static int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {
        Point[] points = new Point[num];
        for (int i = 0; i < num; ++i) {
            points[i] = new Point(containers[i], itemsPerContainer[i]);
        }
        Arrays.sort(points, (p1, p2) -> p2.y - p1.y);
        for (Point p : points) {
            System.out.println(p);
        }
        int ans = 0;
        int j = 0;
        while (cargoSize > 0 && j < num) {
            if (cargoSize > points[j].x) {
                ans += points[j].x * points[j].y;
                cargoSize -= points[j].x;
            } else {
                ans += cargoSize * points[j].y;
                return ans;
            }

            j++;
        }

        return ans;
    }
}
