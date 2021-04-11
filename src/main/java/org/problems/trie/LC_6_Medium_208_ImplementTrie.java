package org.problems.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

public class LC_6_Medium_208_ImplementTrie {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    static class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    cur.children.put(c, newNode);
                    cur = newNode;
                }
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }

                cur = cur.children.get(c);
            }

            return cur != null && cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (!cur.children.containsKey(c))
                    return false;
                cur = cur.children.get(c);
            }
            return cur != null;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        public TrieNode() {}
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app"));      // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
