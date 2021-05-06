package org.example.graph;

import java.util.Arrays;

/**
 * Created by ankouichi on 3/7/21
 */

public class KruskalMST {
    int V, E;
    Edge[] edges;
    Graph graph;
    public KruskalMST(int v, int e) {
        graph = new Graph(v, e);
        this.V = graph.V;
        this.E = graph.E;
        this.edges = graph.edges;
    }

    static class subset {
        int parent, rank;
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (xRoot == yRoot) return;
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            if (subsets[xRoot].rank == subsets[yRoot].rank)
                subsets[xRoot].rank++;
        }
    }

    void kruskal() {
        // This will store the result MST
        Edge[] result = new Edge[V - 1];
        for (int i = 0; i < V - 1; i++) {
            result[i] = new Edge();
        }

        subset[] subsets = new subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new subset();
            subsets[i].parent = i;
        }

        int e = 0, i = 0;
        Arrays.sort(edges);
        while (e < V - 1) {
            Edge next = edges[i++];
            int x = find(subsets, next.src);
            int y = find(subsets, next.dest);

            if (x != y) {
                result[e++] = next;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest +
                    " == " + result[i].weight);
            minimumCost += result[i].weight;
        }

        System.out.println("Minimum cost spanning tree " + minimumCost);
    }

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        KruskalMST app = new KruskalMST(V, E);
        Graph graph = app.graph;

        // add edges 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edges 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edges 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // add edges 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edges 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        // Function call
        app.kruskal();
    }
}
