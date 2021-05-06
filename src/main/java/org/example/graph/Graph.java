package org.example.graph;

import java.util.Arrays;

/**
 * Created by ankouichi on 3/7/21
 */

public class Graph {
    int V, E; // V-> # of vertices, E -> # of edges
    Edge[] edges;

    // Create a graph with v vertices and e edges
    Graph(int v, int e) {
        this.V = v;
        this.E = e;
        this.edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            this.edges[i] = new Edge();
        }
    }
}
