package org.problems.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Constraints:
 *     m == board.length
 *     n == board[i].length
 *     1 <= m, n <= 12
 *     board[i][j] is a lowercase English letter.
 *     1 <= words.length <= 3 * 10^4
 *     1 <= words[i].length <= 10
 *     words[i] consists of lowercase English letters.
 *     All the strings of words are unique.
 */

public class LC_1_Hard_212_WordSearchII {
    private final List<String> resList = new ArrayList<>();
    private char[][] board;

    /**
     * Backtracking + Trie
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        this.board = board;
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    TrieNode newNode = new TrieNode();
                    cur.children.put(c, newNode);
                    cur = newNode;
                } else {
                    cur = cur.children.get(c);
                }
            }
            cur.word = w;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }

        return this.resList;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        char letter = this.board[row][col];
        TrieNode node = parent.children.get(letter);

        if (node.word != null) {
            this.resList.add(node.word);
            node.word = null;
        }
        // mark the current letter before exploration
        this.board[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int n_row = row + rowOffset[i];
            int n_col = col + colOffset[i];
            if (n_row < 0 || n_row >= this.board.length || n_col < 0 || n_col >= this.board[0].length)
                continue;
            if (node.children.containsKey(this.board[n_row][n_col])) {
                backtracking(n_row, n_col, node);
            }
        }
        // restore the original letter after the exploration
        this.board[row][col] = letter;
        // optimization: incrementally remove the leaf node
        if (node.children.isEmpty())
            parent.children.remove(letter);
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        char[][] board = { {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'t', 'h', 'd', 'o'}, {'i', 'f', 'l', 'g'} };
        String[] words = {"oath", "dig", "dog", "dogs"};
        LC_1_Hard_212_WordSearchII solution = new LC_1_Hard_212_WordSearchII();
        for (String s : solution.findWords(board, words)) {
            System.out.println(s);
        }
    }
}
