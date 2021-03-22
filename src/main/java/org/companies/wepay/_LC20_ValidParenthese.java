package org.companies.wepay;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ankouichi on 3/21/21
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */

public class _LC20_ValidParenthese {
    static Map<Character, Character> mappings = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    /**
     * Time: O(n), Space: O(n)
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(mappings.get(c));
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
    }
}
