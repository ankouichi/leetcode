package org.example.elementary.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ankouichi on 1/24/21
 */

public class DailyAdviceClient {
    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 4242);

            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String msg = reader.readLine();
            System.out.println("message from server: " + msg);
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] agrs) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
