package org.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankouichi on 2/10/21
 */

public class _118_PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> generate(int rowNum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowNum; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));

            ans.add(new ArrayList<>(row));
        }

        return ans;
    }
}
