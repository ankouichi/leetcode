package org.problems.trials;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Created by ankouichi on 2/4/21
 */



//If no other cities share an x or y coordinate, return null
public class Medium_10_NearestCities {
    public static void main(String[] args) {
//        int numOfPoints = 3;
//        String[] points = { "c1", "c2", "c3"};
//        int[] x = {3, 2, 1};
//        int[] y = {3, 2, 3};
//        int numOfQueriedPoints = 3;
//        String[] queriedPoints = { "c1", "c2", "c3"};

        int numOfPoints = 6;
        String[] points = { "green", "yellow", "red", "blue", "grey", "pink"};
        int[] x = {10, 20, 15, 30, 10, 15};
        int[] y = {30, 25, 30, 40, 25, 25};
        int numOfQueriedPoints = 4;
        String[] queriedPoints = { "grey", "blue", "red", "pink"};

        String[] res = findNearestCities(numOfPoints, points, x, y, numOfQueriedPoints, queriedPoints);
        for (String s : res) {
            System.out.println(s);
        }
    }


    public static String[] findNearestCities(int numOfPoints,
                                      String[] points,
                                      int[] xCoordinates,
                                      int[] yCoordinates,
                                      int numOfQueriedPoints,
                                      String[] queriedPoints) {
        HashMap<String, Set<Integer>> shareTable = new HashMap<>();
        for (int i = 0; i < numOfPoints; i++) {
            if (shareTable.containsKey(points[i])) {
                continue;
            }
            Set<Integer> xIds = new HashSet<>();
            xIds.add(i);
            Set<Integer> yIds = new HashSet<>();
            yIds.add(i);
            for (int j = i + 1; j < numOfPoints; j++) {
                if (xCoordinates[i] == xCoordinates[j]) {
                    xIds.add(j);
                }
                if (yCoordinates[i] == yCoordinates[j]) {
                    yIds.add(j);
                }
            }

            for (Integer id : xIds) {
                if (shareTable.containsKey(points[id])) {
                    shareTable.get(points[id]).addAll(xIds);
                } else {
                    shareTable.put(points[id], xIds);
                }
            }

            for (Integer id : yIds) {
                if (shareTable.containsKey(points[id])) {
                    Set<Integer> tmpSet = shareTable.get(points[id]);
                    tmpSet.addAll(yIds);
                    shareTable.put(points[id], tmpSet);
                } else {
                    shareTable.put(points[id], yIds);
                }
            }
        }

        shareTable.forEach((k,v) -> System.out.println(k + ": " + v));

        String[] ans = new String[numOfQueriedPoints];
        for (int i = 0; i < numOfQueriedPoints; i++) {
            if (shareTable.containsKey(queriedPoints[i])) {
                Set<Integer> ids = shareTable.get(queriedPoints[i]);

                if (ids.size() == 1) {
                    ans[i] = null;
                    continue;
                }

                Integer idx = Integer.MAX_VALUE;
                int dist = Integer.MAX_VALUE;
                for (Integer id : ids) {
                    if (id == i)
                        continue;
                    if (dist(i, id, xCoordinates, yCoordinates) < dist)
                        idx = id;
                }

                ans[i] = points[idx];
            } else {
                ans[i] = null;
            }
        }

        return ans;
    }

    private static int dist(int originIdx, int targetIdx, int[] xCoordinates, int[] yCoordinates) {
        return xCoordinates[originIdx] * xCoordinates[originIdx] + yCoordinates[originIdx] * yCoordinates[originIdx]
                - xCoordinates[targetIdx] * xCoordinates[targetIdx] - yCoordinates[targetIdx] * yCoordinates[targetIdx];
    }
}
