package org.companies.wepay;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by ankouichi on 3/21/21
 */

public class MaxQueue {
    private Queue<Integer> entries = new ArrayDeque<>();
    private Deque<Integer> maxElements = new ArrayDeque<>();

    public void enqueue(Integer x) {
        entries.add(x);
        while (!maxElements.isEmpty() && maxElements.peekLast() < x)
            maxElements.removeLast();
        maxElements.addLast(x);
    }

    public Integer dequeue() {
        if (!entries.isEmpty()) {
            Integer val = entries.remove();
            if (val.equals(maxElements.peekFirst()))
                maxElements.removeFirst();

            return val;
        }

        throw new NoSuchElementException();
    }

    public Integer getMax() {
        if (!maxElements.isEmpty())
            return maxElements.peekFirst();
        throw new NoSuchElementException();
    }
}
