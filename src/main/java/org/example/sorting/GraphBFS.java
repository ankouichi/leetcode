package org.example.sorting;

import java.util.LinkedList;

public class GraphBFS {
    private int v; // NO. of nodes
    private LinkedList<Integer>[] adj; // Adjacency list of graph
    public GraphBFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * add an edge to the graph
     * @param u source vertex
     * @param v added vertex
     */
    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    /**
     * print BFS traversal from a given source
     * @param s source vertex
     */
    void BFS(int s) {
        // Make all the vertices as not visited
        // By default set as false
        boolean[] visited = new boolean[v];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Make the current node as visited and enqueue it.
        visited[s] = true;
        queue.add(s);  // add - end
//        queue.push(s); // push - front
        while(!queue.isEmpty()) {
            // Retrieves and removes the head (first element) of this list
            int n = queue.poll();
            System.out.print(n + " ");

            // Get all adjacent vertices of the dequeued vertex n
            // If an adjacent has not been visited, then
            // mark it visited and enqueue it
            for (int next : adj[n]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    /**
     * a function recursively used by DFS
     * @param v vertex
     * @param visited flag array
     */
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int n : adj[v]) {
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    /**
     * The function to do DFS traversal. It uses recursive DFSUtil()
     * @param s the start vertex
     */
    void DFS(int s) {
        boolean[] visited = new boolean[v];
        DFSUtil(s, visited);
    }

    public static void main(String[] args) {
        GraphBFS graphBFS = new GraphBFS(4);
        graphBFS.addEdge(0,1);
        graphBFS.addEdge(0,2);
        graphBFS.addEdge(1,2);
        graphBFS.addEdge(2,0);
        graphBFS.addEdge(2,3);
        graphBFS.addEdge(3,3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        graphBFS.BFS(2);

        System.out.println();

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 0)");

        graphBFS.BFS(0);

        System.out.println();

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 1)");

        graphBFS.BFS(1);

        System.out.println();

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        graphBFS.DFS(2);

        System.out.println();

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");

        graphBFS.DFS(0);
    }
}
