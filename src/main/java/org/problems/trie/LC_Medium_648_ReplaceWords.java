package org.problems.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Daniel
 * @date: 2021/4/7 2:41
 * @description:
 */
public class LC_Medium_648_ReplaceWords {
    /**
     * approach 1
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.naturalOrder());
        String[] splits = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s : splits) {
            String tmp = s;
            for (String str : dictionary) {
                if (s.startsWith(str)) {
                    tmp = str;
                    break;
                }
            }
            sb.append(tmp).append(" ");
        }

        return sb.toString().trim();
    }

    /**
     * approach 2: Time - O(), Space - O()
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords2(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for (String s : dictionary) {
            TrieNode cur = trie;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }

        StringBuilder ans = new StringBuilder();
        for (String s : sentence.split("\\s+")) {
            TrieNode cur = trie;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[c - 'a'];
            }
            ans.append(cur.word == null ? s : cur.word).append(" ");
        }

        return ans.toString().trim();
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        LC_Medium_648_ReplaceWords solution = new LC_Medium_648_ReplaceWords();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String res = solution.replaceWords2(dict, sentence);
        System.out.println(res);
        System.out.println(res.equals("the cat was rat by the bat"));
    }
}
