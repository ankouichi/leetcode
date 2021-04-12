package org.problems.trials;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ankouichi on 3/1/21
 */

public class _3_LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s = "abba";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        int N = s.length(), ans = 0;
        Map<Character, Integer> dict = new HashMap<>();
        char[] arr = s.toCharArray();

        for (int i = 0, j = 0; i < N; i++) {
            if (dict.containsKey(arr[i])) {
                // j = Math.max(j,dict.get(arr[i])+1);
                j = dict.get(arr[i]) + 1;
            }

            dict.put(arr[i], i);
            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}
