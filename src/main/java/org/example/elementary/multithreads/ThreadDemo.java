package org.example.elementary.multithreads;

public class ThreadDemo extends Thread {
    private Thread t;
    private final String threadName;
    public ThreadDemo(String name) {
        this.threadName = name;
        System.out.println("creating " + this.threadName);
    }

    @Override
    public void run() {
        super.run();
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
