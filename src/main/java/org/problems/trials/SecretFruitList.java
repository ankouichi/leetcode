package org.problems.trials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ankouichi on 2/3/21
 */

public class SecretFruitList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("anything");
        list1.add("apple");
        List<String> list2 = new ArrayList<>();
        list2.add("banana");
        list2.add("anything");
        list2.add("banana");
        List<List<String>> sList = new ArrayList<>();
        sList.add(list1);
        sList.add(list2);

        List<String> cList = new ArrayList<>();
        cList.add("orange");
        cList.add("grapes");
        cList.add("apple");
        cList.add("orange");
        cList.add("orange");
        cList.add("banana");
        cList.add("apple");
        cList.add("banana");
        cList.add("banana");
        System.out.println(matchSecretLists(sList, cList));
    }

    public static boolean matchSecretLists(List<List<String>> secretFruitList, List<String> customerPurchasedList) {
        if (secretFruitList == null || secretFruitList.size() == 0 || customerPurchasedList == null ||
                customerPurchasedList.size() == 0)
            return false;

        int i = 0;
        HashMap<String, List<Integer>> fruitIndicesTable = new HashMap<>();
        for (String fruit : customerPurchasedList) {
            if (fruitIndicesTable.containsKey(fruit)) {
                fruitIndicesTable.get(fruit).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                fruitIndicesTable.put(fruit, indices);
            }
            i++;
        }

        int curMatchIdx = -1;
        for (List<String> fruits : secretFruitList) {
            int j = 0;
            boolean anythingAtFirst = false;
            for (String f : fruits) {
                if (!fruitIndicesTable.containsKey(f)) {
                    if (f.equals("anything")) {
                        curMatchIdx++;
                        j++;

                        if (j == 0)
                            anythingAtFirst = true;

                        continue;
                    }

                    return false;
                }

                boolean isMatched = false;
                for (Integer index : fruitIndicesTable.get(f)) {
                    if (j == 0) {
                        if (curMatchIdx < index) {
                            isMatched = true;
                            curMatchIdx = index;
                            break;
                        }
                    } else {

                        if (curMatchIdx == index - 1) {
                            isMatched = true;
                            curMatchIdx = index;
                            break;
                        }
                    }
                }

                if (!isMatched)
                    return false;
            }
        }

        return true;
    }
}
