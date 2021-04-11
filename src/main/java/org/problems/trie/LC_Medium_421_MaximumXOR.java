package org.problems.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Daniel
 * @date: 2021/4/9 17:12
 * @description:
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
 *
 * Follow up: Could you do this in O(n) runtime?
 *
 * Example 1:
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 *
 * Example 2:
 * Input: nums = [0]
 * Output: 0
 *
 * Example 3:
 * Input: nums = [2,4]
 * Output: 6
 *
 * Example 4:
 * Input: nums = [8,10,2]
 * Output: 10
 *
 * Example 5:
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 *
 * Constraints:
 *
 *     1 <= nums.length <= 2 * 10^4
 *     0 <= nums[i] <= 2^31 - 1
 *
 */
public class LC_Medium_421_MaximumXOR {
    /**
     * Approach 1: Bitwise Trie
     * Time - O(), Space - O()
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        // compute the length of max number in a binary representation
        int maxVal = nums[0];
        for (int num : nums) maxVal = Math.max(maxVal, num);
        int L = Integer.toBinaryString(maxVal).length(), N = nums.length;

        // zero left-padding to ensure L bits for each number
        String[] numStrArray = new String[N];
        int margin = 1 << L;
        for (int i = 0; i < N; i++) {
            numStrArray[i] = Integer.toBinaryString(nums[i] | margin).substring(1);
        }

        TrieNode trie = new TrieNode();
        int maxXor = 0;
        for (String s : numStrArray) {
            TrieNode cur = trie, xorNode = trie;
            // populate the trie
            for (char c : s.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    TrieNode newNode = new TrieNode();
                    cur.children.put(c,newNode);
                    cur = newNode;
                } else {
                    cur = cur.children.get(c);
                }
            }

            // compute max xor of the new number with all previously inserted ones
            int curXor = 0;
            for (char c : s.toCharArray()) {
                char toggledBit = c == '1' ? '0' : '1';
                if (xorNode.children.containsKey(toggledBit)) {
                    xorNode = xorNode.children.get(toggledBit);
                    curXor = curXor << 1 | 1;
                } else {
                    xorNode = xorNode.children.get(c);
                    curXor <<= 1;
                }
            }
            System.out.println(curXor);
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        public TrieNode() {
            children = new HashMap<>();
        }
    }

    /**
     * Approach 2: HashMap
     * Time - O(), Space - O()
     * @param nums
     * @return
     */
    public int findMaximumXOR2(int[] nums) {
        // compute the length of max number in a binary representation
        int maxVal = nums[0];
        for (int num : nums) maxVal = Math.max(maxVal, num);
        int L = Integer.toBinaryString(maxVal).length(), N = nums.length;

        int maxXor = 0, curXor;
        Set<Integer> prefixes = new HashSet<>();
        for (int i = L - 1; i > -1; i--) {
            maxXor <<= 1;
            curXor = maxXor | 1;
            prefixes.clear();
            for (int num : nums) prefixes.add(num >> i);
            // update maxXor if two of these prefixes could result in curXor.
            // check if p1^p2 == curXor, i.e. p1 == curXor ^ p2
            for (int p : prefixes) {
                if (prefixes.contains(p ^ curXor)) {
                    maxXor = curXor;
                    break;
                }
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        LC_Medium_421_MaximumXOR solution = new LC_Medium_421_MaximumXOR();
        System.out.println("approach 1 - Bitwise Trie");
        System.out.println(solution.findMaximumXOR(nums));

        System.out.println();
        System.out.println("approach 2 - HashSet");
        System.out.println(solution.findMaximumXOR2(nums));
    }
}
