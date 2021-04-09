package org.example.structure.trie;

/**
 * Created by ankouichi on 3/7/21
 *
 * using array to represent Trie Node
 *
 * Pro: fast since access by index takes O(1) time.
 * Con: a waste of space since we assume there are 26 children for each node.
 *
 */

public class TrieNode {
    private final TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}
