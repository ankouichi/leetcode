package org.companies.paypal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 *     LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *     int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *     void put(int key, int value) Update the value of the key if the key exists.
 *     Otherwise, add the key-value pair to the cache.
 *     If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 * Constraints:
 *
 *     1 <= capacity <= 3000
 *     0 <= key <= 3000
 *     0 <= value <= 104
 *     At most 3 * 104 calls will be made to get and put.
 */

public class LC146_LRUCache {
    /**
     * Time: O(1), since all operations with ordered dictionary are done in constant time.
     * Space: O(capacity)
     */
    public static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private final int capacity;
        public LRUCache(int capacity) {
            super(capacity, 0.75f, true); // attention here
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        /**
         * Returns true if this map should remove its eldest entry.
         * This method is invoked by put and putAll after inserting a new entry into the map.
         * It provides the implementor with the opportunity to remove the eldest entry each tim a new one is added.
         * This is useful if the map represents a cache: it allows the map to reduce memory consumption by deleting
         * stale entries.
         *
         * @param eldest
         * @return
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > this.capacity;
        }
    }

    public static class LRUCache2 {
        private final int capacity;
        private int size;
        private final DLinkedNode head;
        private final DLinkedNode tail;
        private final Map<Integer, DLinkedNode> cache;

        static class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            DLinkedNode tailPrev = tail.prev;
            removeNode(tailPrev);
            return tailPrev;
        }

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.cache = new HashMap<>();
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key, newNode);
                addNode(newNode);
                if (++size > capacity) {
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    size--;
                }
            }
        }
    }

    public static void main(String[] args) {
//        LC146_LRUCache solution = new LC146_LRUCache();
        System.out.println("Solution 1: ");
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1,1);
        cache1.put(2,2);
        System.out.println(cache1.get(1));
        cache1.put(3,3);
        System.out.println(cache1.get(2));
        cache1.put(4,4);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(3));
        System.out.println(cache1.get(4));

        System.out.println("Solution 2: ");
        LRUCache2 cache2 = new LRUCache2(2);
        cache2.put(1,1);
        cache2.put(2,2);
        System.out.println(cache2.get(1));
        cache2.put(3,3);
        System.out.println(cache2.get(2));
        cache2.put(4,4);
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(3));
        System.out.println(cache2.get(4));
    }
}
