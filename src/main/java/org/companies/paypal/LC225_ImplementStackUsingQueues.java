package org.companies.paypal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last in first out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means only push to back,
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue),
 * as long as you use only a queue's standard operations.
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 *
 */

public class LC225_ImplementStackUsingQueues {
    /**
     * Solution 1: 2 queues, push - O(1), pop - O(n)
     */
    static class MyStack1 {
        private int top;
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack1() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.offer(x);
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                top = q1.remove();
                q2.add(top);
            }
            q1.remove();
            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;
            return top;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * Solution 2: 2 queues, push - O(n), pop - O(1)
     */
    static class MyStack2 {
        private int top;
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack2() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            top = x;
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int result = q1.remove();
            top = q1.isEmpty() ? 0 : q1.peek();
            return result;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * Solution 3: 1 queue, push - O(n), pop - O(1)
     */
    static class MyStack3 {
        private Queue<Integer> queue = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack3() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            int size = queue.size();
            while (size > 1) {
                queue.add(queue.remove());
                size--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (!queue.isEmpty()) return queue.poll();
            else return 0;
        }

        /** Get the top element. */
        public int top() {
            return queue.isEmpty() ? 0 : queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
//        MyStack1 myStack1 = new MyStack1();
//        myStack1.push(1);
//        myStack1.push(2);
//        myStack1.push(3);
//        System.out.println(myStack1.top());
//        myStack1.pop();
//        System.out.println(myStack1.top());
//        System.out.println("is empty : " + myStack1.empty());

//        MyStack2 myStack2 = new MyStack2();
//        myStack2.push(1);
//        myStack2.push(2);
//        myStack2.push(3);
//        System.out.println(myStack2.top());
//        myStack2.pop();
//        System.out.println(myStack2.top());
//        System.out.println("is empty : " + myStack2.empty());
//        myStack2.pop();
//        System.out.println(myStack2.top());
//        System.out.println("is empty : " + myStack2.empty());
//        myStack2.pop();
//        System.out.println(myStack2.top());
//        System.out.println("is empty : " + myStack2.empty());

        MyStack3 myStack3 = new MyStack3();
        myStack3.push(1);
        myStack3.push(2);
        myStack3.push(3);
        System.out.println(myStack3.top());
        myStack3.pop();
        System.out.println(myStack3.top());
        System.out.println("is empty : " + myStack3.empty());
        myStack3.pop();
        System.out.println(myStack3.top());
        System.out.println("is empty : " + myStack3.empty());
        myStack3.pop();
        System.out.println(myStack3.top());
        System.out.println("is empty : " + myStack3.empty());
    }
}
