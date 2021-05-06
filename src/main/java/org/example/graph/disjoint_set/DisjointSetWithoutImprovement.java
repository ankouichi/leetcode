package org.example.graph.disjoint_set;

/**
 * @author: Daniel
 * @date: 2021/5/6 2:34
 * @description:
 */
public class DisjointSetWithoutImprovement {
    int[] parent;
    int n;
    public DisjointSetWithoutImprovement(int n) {
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Finds the representative of the set that i is an element of
    int find(int i)
    {
        // If i is the parent of itself
        if (parent[i] == i)
        {
            // Then i is the representative of this set
            return i;
        }
        else
        {
            // Else if i is not the parent of itself, then i is not the representative of his set.
            // So we recursively call Find on its parent
            return find(parent[i]);
        }
    }

    // Unites the set that includes i and the set that includes j
    void union(int i, int j)
    {
        // Find the representatives (or the root nodes) for the set that includes i
        int i_rep = this.find(i);
        // And do the same for the set that includes j
        int j_rep = this.find(j);
        // Make the parent of i’s representative be j’s representative effectively
        // moving all of i’s set into j’s set)
        this.parent[i_rep] = j_rep;
    }

    public static void main(String[] args) {
        DisjointSetWithoutImprovement app = new DisjointSetWithoutImprovement(5);
        System.out.print(app.find(0) + " ");
        System.out.print(app.find(1) + " ");
        System.out.print(app.find(2));
        System.out.println();
        app.union(0,2);
        app.union(2,4);
        app.union(1,3);
        System.out.print(app.find(0) + " ");
        System.out.print(app.find(1) + " ");
        System.out.print(app.find(2));
        System.out.println();
        app.union(3,4);
        System.out.print(app.find(0) + " ");
        System.out.print(app.find(1) + " ");
        System.out.print(app.find(2));
    }
}
