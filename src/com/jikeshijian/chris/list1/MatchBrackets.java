package com.jikeshijian.chris.list1;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class MatchBrackets {
    public static void main(String[] args) {
        // "(a)(b)" true
        // "((a)b" false
        String str1 = "(a)(b)";
        String str2 = "((a)b";
        boolean match1 = isMatch(str1);
        boolean match2 = isMatch(str2);
        System.out.println("match1: " + match1);
        System.out.println("match2: " + match2);
    }

    private static boolean isMatch(String string) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            String value = String.valueOf(string.charAt(i));
            if ("(".equals(value)) {
                stack.push(value);
            } else if (")".equals(value)) {
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
