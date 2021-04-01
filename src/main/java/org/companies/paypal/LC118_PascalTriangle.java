package org.companies.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ankouichi on 3/29/21
 *
 * Pascal Triangle
 *
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 *
 */

public class LC118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) return triangle;
        triangle.add(new ArrayList<>(Collections.singletonList(1)));
        if (numRows == 1) return triangle;
        triangle.add(new ArrayList<>(Arrays.asList(1,1)));
        if (numRows == 2) return triangle;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> newLine = new ArrayList<>();
            newLine.add(1);
            List<Integer> prevLine = triangle.get(i - 2);
            for (int j = 0; j < prevLine.size() - 1; j++) {
                newLine.add(prevLine.get(j) + prevLine.get(j + 1));
            }
            newLine.add(1);
            triangle.add(newLine);
        }

        return triangle;
    }

    /**
     * Solution 2
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            // be careful here, not : result.add(row);
            result.add(new ArrayList<>(row));
        }

        return result;
    }

    public static void main(String[] args) {
        int row = 4;
        LC118_PascalTriangle solution = new LC118_PascalTriangle();
        List<List<Integer>> result = solution.generate2(row);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
