package com.jikeshijian.chris.list1;

import java.util.HashMap;
import java.util.Stack;

/**
 * This is description.
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author Chris0710
 */
public class ValidParentheses {
    private HashMap<Character, Character> map = new HashMap<>();

    private ValidParentheses() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        // Output: true
        String input1 = "()";
        boolean output1 = vp.isValid(input1);
        System.out.println("output1: " + output1);

        // Output: true
        String input2 = "()[]{}";
        boolean output2 = vp.isValid(input2);
        System.out.println("output2: " + output2);

        // Output: false
        String input3 = "(]";
        boolean output3 = vp.isValid(input3);
        System.out.println("output3: " + output3);

        // Output: false
        String input4 = "([)]";
        boolean output4 = vp.isValid(input4);
        System.out.println("output4: " + output4);

        // Output: true
        String input5 = "{[]}";
        boolean output5 = vp.isValid(input5);
        System.out.println("output5: " + output5);
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                char pop = stack.empty() ? '#' : stack.pop();
                if (pop != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
