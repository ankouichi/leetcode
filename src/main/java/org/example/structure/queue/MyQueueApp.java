package org.example.structure.queue;

/**
 * Created by ankouichi on 1/30/21
 */

public class MyQueueApp {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
    }
}
