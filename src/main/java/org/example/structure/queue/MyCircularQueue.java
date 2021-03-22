package org.example.structure.queue;

/**
 * Created by ankouichi on 1/30/21
 */

public class MyCircularQueue {
    private int capacity;
    private int count;
    private int headIdx;
    private int[] queue;
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.count = 0;
        this.headIdx = 0;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        this.headIdx = (this.headIdx + 1) % this.capacity;
        this.count--;
        return true;
    }

    public boolean enQueue(int x) {
        if (isFull())
            return false;
        this.queue[(this.headIdx + this.count) % this.capacity] = x;
        this.count++;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return this.queue[this.headIdx];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return this.queue[(this.headIdx + this.count - 1) % this.capacity];
    }
}
