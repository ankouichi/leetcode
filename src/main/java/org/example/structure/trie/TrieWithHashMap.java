package org.example.structure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ankouichi on 3/7/21
 */

public class TrieWithHashMap {
    boolean isWord;
    Map<Character, TrieWithHashMap> children;

    /** Initialize your data structure here. */
    public TrieWithHashMap() {
        isWord = false;
        children = new HashMap<>();
    }

    public TrieWithHashMap(boolean isWord) {
        this.isWord = isWord;
        children = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TrieWithHashMap> map = children;
        for (int i = 0; i < word.length() - 1; i++) {
            Character c = word.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new TrieWithHashMap());
            }

            map = map.get(c).children;
        }

        map.put(word.charAt(word.length() - 1), new TrieWithHashMap(true));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Map<Character, TrieWithHashMap> map = children;
        TrieWithHashMap tmpTrie = new TrieWithHashMap();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!map.containsKey(c))
                return false;
            tmpTrie = map.get(c);
            map = tmpTrie.children;
        }

        return tmpTrie.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieWithHashMap tmpTrie;
        Map<Character, TrieWithHashMap> map = children;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!map.containsKey(c))
                return false;
            tmpTrie = map.get(c);
            map = tmpTrie.children;
        }

        return true;
    }

    public static void main(String[] args) {
        TrieWithHashMap trie = new TrieWithHashMap();
        System.out.println("contains apple: " + trie.search("apple"));
        System.out.println("insert apple");
        trie.insert("apple");
        System.out.println("contains apple: " + trie.search("apple"));
        System.out.println("starts with apple: " + trie.startsWith("apple"));
        System.out.println("search app: " + trie.search("app"));
        System.out.println("starts with app: " +  trie.startsWith("app"));
    }
}