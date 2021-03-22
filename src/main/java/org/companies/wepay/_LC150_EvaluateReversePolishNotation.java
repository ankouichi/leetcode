package org.companies.wepay;

import java.util.Stack;

/**
 * Created by ankouichi on 3/21/21
 *
 * 逆波兰表达式
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 *
 */

public class _LC150_EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(stack.pop() * -1 + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        // Case 1
        // Input: tokens = ["2","1","+","3","*"]
        // Output: 9
        // Explanation: ((2 + 1) * 3) = 9
        String[] tokens1 = new String[] { "2","1","+","3","*" };
        System.out.println("Case 1: " + evalRPN(tokens1));

        // Case 2
        // Input: tokens = ["4","13","5","/","+"]
        // Output: 6
        // Explanation: (4 + (13 / 5)) = 6
        String[] tokens2 = new String[] { "4","13","5","/","+" };
        System.out.println("Case 2: " + evalRPN(tokens2));
    }
}
