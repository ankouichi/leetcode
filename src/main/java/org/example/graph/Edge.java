package org.example.graph;

/**
 * Created by ankouichi on 3/7/21
 */

public class Edge implements Comparable<Edge> {
    int src, dest, weight;
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
