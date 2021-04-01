package org.companies.paypal;

import java.util.*;

/**
 * Created by ankouichi on 3/30/21
 */

public class LC261_GraphValidTree {
    /**
     * Solution 1: iterative DFS
     * @param n
     * @param edges
     * @return
     */
    public static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (Integer adjacentNode : adjList.get(node)) {
                if (parent.get(node).equals(adjacentNode))
                    continue;
                if (parent.containsKey(adjacentNode))
                    return false;
                stack.push(adjacentNode);
                parent.put(adjacentNode, node);
            }
        }

        return parent.size() == n;
    }

    private static List<List<Integer>> adjacencyList = new ArrayList<>();
    private static Set<Integer> seen = new HashSet<>();
    /**
     * Solution 2: recursive DFS
     * @param n
     * @param edges
     * @return
     */
    public static boolean validTree2(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && seen.size() == n;
    }

    private static boolean dfs(Integer node, Integer parent) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (Integer neighbor : adjacencyList.get(node)) {
            if (!neighbor.equals(parent)) {
                boolean result = dfs(neighbor, node);
                if (!result) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][] { {0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println("Solution 1: " + validTree(n, edges));
        System.out.println("Solution 2: " + validTree2(n, edges));
    }
}
