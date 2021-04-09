package org.example.structure.trie;

/**
 * Created by ankouichi on 3/7/21
 */

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    // Time - O(m), where m is the key's length. Since in each iteration, we either examine or create a node in the
    // trie till we reach the end of the word

    // Space - O(m), in the worst case, newly inserted key doesn't share a prefix with the keys already inserted in
    // the trie. We have to add m new nodes, which takes O(m) spaces.
    //
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

    /**
     * search a prefix or whole key in trie and return the node where search ends
     * Time - O(m)
     * Space - O(1)
     *
     * @param word
     * @return
     */
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

    // Return if the word is in the trie
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Return if there is any word in the tree that starts with the given prefix
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
