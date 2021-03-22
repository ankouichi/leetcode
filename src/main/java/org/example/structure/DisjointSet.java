package org.example.structure;

/**
 * Created by ankouichi on 3/7/21
 *
 * A Java program to implement Disjoint Set Data
 * Structure.
 *
 */

public class DisjointSet {
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
    }

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

    int find(int x)
    {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int x, int y)
    {
        if((x = find(x)) == (y = find(y))) return ;
        if (rank[x] < rank[y])
            parent[x] = y;
        else {
            parent[y] = x;
            if (rank[y] == rank[x])
                rank[x] = rank[x] + 1;
        }
    }
}



