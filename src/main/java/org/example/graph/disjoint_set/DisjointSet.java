package org.example.graph.disjoint_set;

/**
 * Created by Daniel An on 3/7/21
 *
 * A Java program to implement Disjoint Set Data Structure.
 *
 */
public class DisjointSet {
    int[] rank, parent;
    int n;
    // Constructor
    public DisjointSet(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet()
    {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Path Compression
    int find(int i)
    {
        if (parent[i] == i)
            return i;
        else {
            int result = find(parent[i]);
            parent[i] = result;
            return result;
        }
    }

    void union(int x, int y)
    {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep) return;
        int x_rank = rank[x];
        int y_rank = rank[y];
        if (x_rank > y_rank)
            parent[y] = x_rep;
        else {
            parent[x] = y_rep;
            if (x_rank == y_rank)
                rank[y]++;
        }
    }

    public static void main(String[] args)
    {
        // Let there be 5 persons with ids as 0, 1, 2, 3 and 4
        int n = 5;
        DisjointSet dus = new DisjointSet(n);
        dus.union(0, 2);
        dus.union(4, 2);
        dus.union(3, 1);

        // Check if 4 is a friend of 0
        if (dus.find(3) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}



