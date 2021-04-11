package org.problems.trie;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 */

public class LC_7_Hard_336_PalindromePairs {
    static class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        public int id = -1;
        public List<Integer> palindromePrefixRemaining = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        // build the Trie
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            String reversed = new StringBuilder(words[i]).reverse().toString();
            for (int j = 0; j < reversed.length(); j++) {
                char c = reversed.charAt(j);
                if (hasPalindromeRemaining(j, reversed))
                    cur.palindromePrefixRemaining.add(i);

                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    cur.children.put(c, newNode);
                    cur = newNode;
                }
            }
            cur.id = i;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                // case 2: part of word1 is the reverse of word2
                if (cur.id != -1 && hasPalindromeRemaining(j, word))
                    result.add(Arrays.asList(i, cur.id));
                cur = cur.children.get(word.charAt(j));
                if (cur == null) break;
            }

            if (cur == null) continue;
            // case 1: word1 is the reverse of word2
            if (cur.id != -1 && cur.id != i)
                result.add(Arrays.asList(i, cur.id));
            // case 3: word1 is the reverse of part of word2
            for (int idx : cur.palindromePrefixRemaining)
                result.add(Arrays.asList(i, idx));
        }

        return result;
    }

    private boolean hasPalindromeRemaining(int k, String word) {
        int low = k, hi = word.length() - 1;
        while (low <= hi) {
            if (word.charAt(low) != word.charAt(hi))
                return false;
            low++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
//        String[] words = {"bat","tab","cat"};
//        String[] words = {"","b"};
        LC_7_Hard_336_PalindromePairs solution = new LC_7_Hard_336_PalindromePairs();
        for (List<Integer> list : solution.palindromePairs(words)) {
            for (int i : list) System.out.print(i + " ");
            for (int i : list) System.out.print(words[i] + " ");
            System.out.println();
        }
    }
}
