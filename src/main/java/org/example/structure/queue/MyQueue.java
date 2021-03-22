package org.example.structure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankouichi on 1/30/21
 */

public class MyQueue {
    private int start_pointer;
    private List<Integer> data;
    public MyQueue() {
        data = new ArrayList<>();
        start_pointer = 0;
    }

    public boolean isEmpty() {
        return start_pointer >= data.size();
    }

    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        start_pointer++;
        return true;
    }

    public int Front() {
        return data.get(start_pointer);
    }
}
