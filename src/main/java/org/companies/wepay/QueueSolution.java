package org.companies.wepay;

/**
 * Created by ankouichi on 3/21/21
 */

public class QueueSolution {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.enqueue(1);
        maxQueue.enqueue(5);
        System.out.println("Max is : " + maxQueue.getMax());
        maxQueue.enqueue(3);
        maxQueue.enqueue(10);
        System.out.println("Max is : " + maxQueue.getMax());
    }
}
