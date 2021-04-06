package org.problems.trie;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built
 * one character at a time by other words in words. If there is more than one possible answer, return the longest word
 * with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 *
 * Example 1:
 *
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 *
 * Example 2:
 *
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically
 * smaller than "apply".
 *
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 *
 */

public class LC_8_Easy_720_LongestWordInDictionary {
    /**
     * approach 1: Time - O(), Space - O()
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        String ans = "";
        for (String s : words) {
            boolean good = true;
            for (int i = 1; i < s.length(); i++) {
                if (!wordSet.contains(s.substring(0, i))) {
                    good = false;
                    break;
                }
            }
            if (good) return s;
        }

        return ans;
    }

    /**
     * approach 2: Time - O(), Space - O()
     * @param words
     * @return
     */
    public static String longestWord2(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (String w : words) {
            if (w.length() > ans.length() || (w.length() == ans.length() && w.compareTo(ans) < 0)) {
                boolean good = true;
                for (int i = 1; i < w.length(); i++) {
                    if (!wordSet.contains(w.substring(0, i))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = w;
            }
        }

        return ans;
    }

    /**
     * approach 3: Trie + DFS
     * @param words
     * @return
     */
    public String longestWord3(String[] words) {
        MyTrie trie = new MyTrie();
        int index = 0;
        for (String word : words) {
            trie.insert(word, ++index);
        }
        trie.words = words;
        return trie.dfs();
    }

    class Node {
        char c;
        Map<Character, Node> children = new HashMap<>();
        int end;
        public Node(char c) {
            this.c = c;
        }
    }

    class MyTrie {
        Node root;
        String[] words;
        public MyTrie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei: node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
        System.out.println("approach 1: " + longestWord(words));
        System.out.println("approach 2: " + longestWord2(words));

        LC_8_Easy_720_LongestWordInDictionary solution = new LC_8_Easy_720_LongestWordInDictionary();
        System.out.println("approach 3: " + solution.longestWord3(words));
    }
}
