package org.problems.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 */

public class LC_3_Hard_642_DesignSearchAutocompleteSystem {
    static class TrieNode {
        int times;
        TrieNode[] branches = new TrieNode[27];
    }

    static class Node {
        String sentence;
        int times;
        Node(String st, int t) {
            this.sentence = st;
            this.times = t;
        }
    }

    static class AutocompleteSystem {
        private final TrieNode root;
        private String cur_sent = "";
        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            for (int i = 0; i < times.length; i++) {
                populate(root, sentences[i], times[i]);
            }
        }

        private static int toInt(char c) {
            return c == ' ' ? 26 : c - 'a';
        }

        private static void populate(TrieNode t, String s, int times) {
            for (int i = 0; i < s.length(); i++) {
                if (t.branches[toInt(s.charAt(i))] == null)
                    t.branches[toInt(s.charAt(i))] = new TrieNode();
                t = t.branches[toInt(s.charAt(i))];
            }
            t.times += times;
        }

        private List<Node> lookup(TrieNode t, String s) {
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (t.branches[toInt(s.charAt(i))] == null)
                    return new ArrayList<>();
                t = t.branches[toInt(s.charAt(i))];
            }

            traverse(s, t, list);
            return list;
        }

        private static void traverse(String s, TrieNode t, List<Node> list) {
            if (t.times > 0) list.add(new Node(s, t.times));
            for (char i = 'a'; i <= 'z'; i++) {
                if (t.branches[i - 'a'] != null)
                    traverse(s + i, t.branches[i - 'a'], list);
            }
            if (t.branches[26] != null)
                traverse(s + ' ', t.branches[26], list);
        }

        public List<String> input(char c) {
            List<String> res = new ArrayList<>();
            if (c == '#') {
                populate(root, cur_sent, 1);
                cur_sent = "";
            } else {
                cur_sent += c;
                List<Node> list = lookup(root, cur_sent);
                list.sort((a, b) -> a.times == b.times ?
                        a.sentence.compareTo(b.sentence) : b.times - a.times);
                for (int i = 0; i < Math.min(3, list.size()); i++) res.add(list.get(i).sentence);
            }
            return res;
        }
    }

    /**
     * Your AutocompleteSystem object will be instantiated and called as such:
     * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
     * List<String> param_1 = obj.input(c);
     */

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};
        AutocompleteSystem solution = new AutocompleteSystem(sentences, times);
        System.out.println("input i");
        System.out.println(solution.input('i'));
        System.out.println("input space");
        System.out.println(solution.input(' '));
        System.out.println("input a");
        System.out.println(solution.input('a'));
        System.out.println("input #");
        System.out.println(solution.input('#'));

        System.out.println(solution.input('i'));
        System.out.println(solution.input(' '));
        System.out.println(solution.input('a'));

    }
}
