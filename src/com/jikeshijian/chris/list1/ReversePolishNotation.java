package com.jikeshijian.chris.list1;

import java.util.Stack;

/**
 * This is description.
 * 150. Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author Chris0710
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        // ["2", "1", "+", "3", "*"]
        // String[] tokens = {"2", "1", "+", "3", "*"};
        // String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        ReversePolishNotation rpn = new ReversePolishNotation();
        int result = rpn.evalRPN(tokens);
        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Integer one;
            Integer two;

            switch (token) {
                case "+":
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two + one);
                    break;
                case "-":
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two - one);
                    break;
                case "*":
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two * one);
                    break;
                case "/":
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two / one);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
