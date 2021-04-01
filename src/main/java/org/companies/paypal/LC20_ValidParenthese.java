package org.companies.paypal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ankouichi on 3/31/21
 */

public class LC20_ValidParenthese {
    static Map<Character, Character> mapping = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c== '[' || c == '{') {
                stack.push(mapping.get(c));
            } else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
    }
}
