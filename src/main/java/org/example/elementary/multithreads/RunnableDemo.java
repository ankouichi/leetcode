package org.example.elementary.multithreads;

/**
 * Created by ankouichi on 1/24/21
 */

public class RunnableDemo implements Runnable {
    private Thread t;
    private final String threadName;

    public RunnableDemo(String name) {
        threadName = name;
        System.out.println("creating: " + threadName);
    }

    @Override
    public void run() {
        System.out.println("running: " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException ex) {
            System.out.println("Thread " + threadName + " interrupted");
        }

        System.out.println("Thread " + threadName + " exiting");
    }

    public void start() {
        System.out.println("starting: " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
