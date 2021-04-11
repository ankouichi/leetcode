package org.problems.trie;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */

public class LC_4_Medium_211_DesignAddAndSearchWordsDS {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    static class WordDictionary {
        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        private boolean search(char[] arr, int index, TrieNode node) {
            if (index == arr.length) return node.isWord;
            if (arr[index] != '.') return node.children[arr[index] - 'a'] != null &&
                    search(arr, index + 1, node.children[arr[index] - 'a']);
            else {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null && search(arr, index + 1, node.children[i]))
                        return true;
                }
                return false;
            }
        }

        public boolean search(String word) {
            return search(word.toCharArray(), 0, root);
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        System.out.println("add bad");
        dict.addWord("bad");
        System.out.println("add dad");
        dict.addWord("dad");
        System.out.println("add mad");
        dict.addWord("mad");
        System.out.println("search for pad");
        System.out.println(dict.search("pad"));
        System.out.println("search for bad");
        System.out.println(dict.search("bad"));
        System.out.println("search for .ad");
        System.out.println(dict.search(".ad"));
        System.out.println("search for b..");
        System.out.println(dict.search("b.."));
        System.out.println("search for c..");
        System.out.println(dict.search("c.."));
    }
}
