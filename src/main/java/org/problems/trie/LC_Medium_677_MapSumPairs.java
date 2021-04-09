package org.problems.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Daniel
 * @date: 2021/4/6 23:23
 * @description:
 *
 * https://leetcode.com/problems/map-sum-pairs/
 *
 * Implement the MapSum class:
 *
 *     MapSum() Initializes the MapSum object.
 *     void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed,
 *     the original key-value pair will be overridden to the new one.
 *
 *     int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 *
 *     Constraints:
 *
 *     1 <= key.length, prefix.length <= 50
 *     key and prefix consist of only lowercase English letters.
 *     1 <= val <= 1000
 *     At most 50 calls will be made to insert and sum.
 *
 */
public class LC_Medium_677_MapSumPairs {
    static class TrieNode {
        int score;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class MapSum {
        Map<String, Integer> map;
        TrieNode root;

        /** Initialize your data structure here. */
        public MapSum() {
            this.root = new TrieNode();
            this.map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode cur = root;
            cur.score += delta;
            for (char c : key.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode()); // putIfAbsent method
                cur = cur.children.get(c);
                cur.score += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                cur = cur.children.get(c);
                if (cur == null) return 0;
            }
            return cur.score;
        }
    }

    static class MapSum2 {
        Map<String, Integer> map;
        /** Initialize your data structure here. */
        public MapSum2() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int ans = 0;
            for (String k : map.keySet()) {
                if (k.startsWith(prefix))
                    ans += map.get(k);
            }
            return ans;
        }
    }

    static class MapSum3 {

    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */

    public static void main(String[] args) {
//        MapSum mapSum = new MapSum();
//        System.out.println("insert { 'apple': 10 }");
//        mapSum.insert("apple", 10);
//        System.out.println("get sum at ap: " + mapSum.sum("ap") );
//        System.out.println("insert { 'app' :  }");
//        mapSum.insert("app", 2);
//        System.out.println("get sum at ap: " + mapSum.sum("ap") );
//
//        System.out.println();
//        System.out.println(mapSum.sum(""));

        MapSum2 mapSum2 = new MapSum2();
        System.out.println("insert { 'apple': 10 }");
        mapSum2.insert("apple", 10);
        System.out.println("get sum at ap: " + mapSum2.sum("ap") );
        System.out.println("insert { 'app' : 2 }");
        mapSum2.insert("app", 2);
        System.out.println("get sum at ap: " + mapSum2.sum("ap") );

        System.out.println();
        System.out.println(mapSum2.sum(""));
    }
}
