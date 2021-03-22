package org.problems;

import java.util.*;

/**
 * Created by ankouichi on 2/5/21
 */

public class _937_ReorderDataInLogFiles {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] ans = reorderLogFiles(logs);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    /**
     * First Intuitive Solution
     * Runtime beats 16.81%, Space beats 75.65%
     * @param logs
     * @return
     */
    public static String[] reorderLogFiles(String[] logs) {
        int N = logs.length;
        List<String> lLogs = new ArrayList<>();
        TreeMap<String,List<String>> table = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String[] split = logs[i].split(" ", 2);

            if (Character.isDigit(split[1].charAt(0))) {
                lLogs.add(logs[i]);
            } else {
                List<String> tmpList = table.getOrDefault(split[1], new ArrayList<String>());
                tmpList.add(split[0]);
                table.put(split[1], tmpList);
            }
        }

        String[] ans = new String[N];
        int i = 0;

        while (i < N - lLogs.size()) {
            Map.Entry<String, List<String>> entry = table.pollFirstEntry();
            String key = entry.getKey();
            List<String> valList = entry.getValue();
            Collections.sort(valList);
            for (String val : valList) {
                ans[i] = val + " " + key;
                i++;
            }
        }

        for (String s : lLogs) {
            ans[i] = s;
            i++;
        }

        return ans;
    }

    /**
     * Comparator Solution:
     * Runtime beats 73.40%, Space beats 75.65%
     * @param logs
     * @return
     */
    public static String[] reorderLogFiles_1(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
