package org.example.elementary.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ankouichi on 1/24/21
 */

public class DailyAdviceServer {

    static final String MESSAGE = "msg from server";

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while(true) {
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(MESSAGE);
                writer.close();
                System.out.println("New client accessed.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
