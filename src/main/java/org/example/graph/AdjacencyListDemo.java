package org.example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankouichi on 3/30/21
 */

public class AdjacencyListDemo {
    static void addEdge(List<List<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        // Warning: do not ignore the following sentence
        adjacencyList.get(v).add(u);
    }

    static void printGraph(List<List<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + ": head");
            for (Integer x : adjacencyList.get(i)) {
                System.out.print("->" + x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ajaList = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            ajaList.add(new ArrayList<>());
        }

        addEdge(ajaList, 0, 1);
        addEdge(ajaList, 0, 4);
        addEdge(ajaList, 1, 2);
        addEdge(ajaList, 1, 3);
        addEdge(ajaList, 1, 4);
        addEdge(ajaList, 2, 3);
        addEdge(ajaList, 3, 4);

        printGraph(ajaList);
    }
}
