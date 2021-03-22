package org.example.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ankouichi on 2/6/21
 */

public class Connection {
    public String first;
    public String second;
    public int cost;
    public Connection() {

    }

    public Connection(String t1, String t2, int c) {
        this.first = t1;
        this.second = t2;
        this.cost = c;
    }

    public static void main(String[] args) {
        ArrayList<Connection> list = new ArrayList<>();
        Connection c1 = new Connection("A", "B", 8);
        Connection c2 = new Connection("B", "C", 5);
        list.add(c1);
        list.add(c2);

        Comparator<Connection> comparator = Comparator.comparingInt(o -> o.cost);

        list.sort(comparator);

        System.out.println(list.get(0).cost);
    }
}
