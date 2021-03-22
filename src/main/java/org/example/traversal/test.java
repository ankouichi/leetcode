package org.example.traversal;

/**
 * Created by ankouichi on 2/6/21
 */

import java.util.ArrayList;
// import java.util.Connections;
import java.util.Comparator;
import java.util.List;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// Connection CLASS IS ALREADY DEFINED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class test
{
    class Server {
        private String title;
        private Server parent;
        public Server(String t) {
            this.title = t;
            this.parent = this;
        }
    }

    public Server getParent(Server s, List<Server> path) {
        if (s.parent.equals(s)) {
            for (Server server : path) {
                server.parent = s;
            }

            return s;
        }

        path.add(s);
        return getParent(s.parent, path);
    }

    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<Connection> minimumCostConnection(int num,
                                                       ArrayList<Connection> connection)
    {
        ArrayList<Connection> ans = new ArrayList<Connection>();
        Comparator<Connection> comparator = Comparator.comparingInt(o -> o.cost);
        connection.sort(comparator);

        // List<Server> servers = new ArrayList<>();

        // for (Connection con : connection) {
        //     Server parentF = getParent();
        //     Server parentT = getParent();

        //     if (!parentT.title.equals(parentF.title)) {
        //         parentT.parent = parentF;
        //         ans.add(new Connection(con.firstTown, con.secondTown, con.cost));
        //     }
        // }

        return ans;
    }
}

