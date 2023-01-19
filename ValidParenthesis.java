import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValidParenStack(String str) {
        if (str.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }

    public static boolean isValidParenStack2(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static boolean isValidParenMap(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (map.containsKey(curr)) {
                stack.push(curr);
            } else if (map.containsValue(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s1 = "{}()[]";
        String s2 = "{[}(])";

        System.out.println(isValidParenStack(s1));
        System.out.println(isValidParenStack(s2));

        System.out.println(isValidParenStack2(s1));
        System.out.println(isValidParenStack2(s2));

        System.out.println(isValidParenMap(s1));
        System.out.println(isValidParenMap(s2));
    }
}
