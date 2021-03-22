package org.example.elementary.stackexample;

import java.util.Stack;

/**
 * Created by ankouichi on 1/28/21
 */

public class MinStackExample {
    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        System.out.println("get min: " + minStack.getMin());
//        minStack.push(1);
//        System.out.println("get min: " + minStack.getMin());
//        minStack.push(3);
//        minStack.push(5);
//        minStack.push(1);
////        minStack.push(0);
//        System.out.println("get min: " + minStack.getMin());
//        minStack.pop();
//        System.out.println("get min: " + minStack.getMin());
//        minStack.pop();
//        System.out.println("get min: " + minStack.getMin());

//        MinStackWithTwoStacks minStack = new MinStackWithTwoStacks();
//        minStack.push(1);
//        System.out.println("get min: " + minStack.getMin());
//        minStack.push(-3);
//        minStack.push(5);
//        minStack.push(1);
//        minStack.push(-3);
//        System.out.println("get min: " + minStack.getMin());
//        minStack.pop();
//        System.out.println("get min: " + minStack.getMin());
//        minStack.pop();
//        System.out.println("get min: " + minStack.getMin());

//        MinStackWithIntArray minStack = new MinStackWithIntArray();
//        minStack.push(1);
//        System.out.println("get min: " + minStack.getMin());
//        minStack.push(-3);
//        minStack.push(5);
//        minStack.push(1);
//        minStack.push(-3);
//        System.out.println("get min: " + minStack.getMin());
//        minStack.pop();
//        System.out.println("get min: " + minStack.getMin());
//        minStack.pop();
//        System.out.println("get min: " + minStack.getMin());


        MinStackWithImprovedTwoStacks minStack = new MinStackWithImprovedTwoStacks();
        minStack.push(1);
        System.out.println("get min: " + minStack.getMin());
        minStack.push(0);
        minStack.push(5);
        minStack.push(1);
        minStack.push(-3);
        System.out.println("get min: " + minStack.getMin());
        minStack.pop();
        System.out.println("get min: " + minStack.getMin());
        minStack.pop();
        System.out.println("get min: " + minStack.getMin());
    }
}

/**
 * Implementation just uses one stack
 */
class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack();
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    public void pop() {
        if (stack.pop() == min)
            min = stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
}

/**
 * Implemented with two stacks
 * one stores each element
 * one stores the present min value
 */
class MinStackWithTwoStacks {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        if (minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
        stack.push(x);
    }
    public void pop() {
        if (minStack.peek() == stack.peek())
            minStack.pop();
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Implemented with one stack which stores an int array whose size is two
 */
class MinStackWithIntArray {
    private Stack<int[]> stack = new Stack();
    public void push(int x) {
        if(stack.empty()) {
            stack.push(new int[]{x,x});
        }

        int minVal = Math.min(x, stack.peek()[1]);
        stack.push(new int[]{x, minVal});
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek()[0];
    }
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Implemented with two stacks
 * All the save with previous example except it improves the minStack which will no longer contains duplicate elements
 */
class MinStackWithImprovedTwoStacks {
    private Stack<Integer> stack = new Stack();
    private Stack<int[]> minStack = new Stack<>();
    public void push(int x) {
        if (minStack.empty() || minStack.peek()[0] > x)
            minStack.push(new int[] {x, 1});
        else if (minStack.peek()[0] == x) {
            minStack.peek()[1]++;
        }

        stack.push(x);
    }
    public void pop() {
        if (minStack.peek()[0] == stack.peek())
            minStack.peek()[1]--;

        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek()[0];
    }
}
