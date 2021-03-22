package org.example.structure.trie;

/**
 * Created by ankouichi on 3/7/21
 */

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curCh = word.charAt(i);
            if (!node.containsKey(curCh))
                node.put(curCh, new TrieNode());
            node = node.get(curCh);
        }

        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter))
                node = node.get(curLetter);
            else
                return null;
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        boolean hasApple = trie.search("apple");
        System.out.println(hasApple);

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("apple"));
        System.out.println();
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
