package coding;

import java.util.*;

class Solution {
    public void solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
            } else {
                // pop until '('
                Stack<Character> temp = new Stack<>();
                while (stack.peek() != '(') {
                    temp.push(stack.pop());
                }
                stack.pop();
                // check if stack is not empty and top is '-'
                if (!stack.isEmpty() && stack.peek() == '-') {
                    while (!temp.isEmpty()) {
                        if (temp.peek() == '+') {
                            stack.push('-');
                        } else if (temp.peek() == '-') {
                            stack.push('+');
                        } else {
                            stack.push(temp.peek());
                        }
                        temp.pop();
                    }
                } else {
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String result = sb.reverse().toString();

        // Handle case like "a-b-a"
        if (result.charAt(0) != '-') {
            result = "+" + result;
        }

        StringBuilder sb2 = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < result.length(); i+=2) {
            char c = result.charAt(i);
            char c2 = result.charAt(i+1);
            if (c == '+') {
                map.put(c2, map.getOrDefault(c2, 0) + 1);
            } else {
                map.put(c2, map.getOrDefault(c2, 0) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            if (entry.getValue() < 0) {
                sb2.append('-');
            } else if (sb2.length() > 0) {
                sb2.append('+');
            }
            if (Math.abs(entry.getValue()) > 1) {
                sb2.append(Math.abs(entry.getValue()));
            }
            sb2.append(entry.getKey());
        }
        System.out.println(sb2.toString());
    }
}

public class SimplifyExpression {
    
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve("-a"); // -a
        s.solve("-a-a-a-b"); // -3a-b
        s.solve("(a)"); // a
        s.solve("a-b-a"); // -b
        s.solve("(a+b)+(b+c)"); // a+2b+c
        s.solve("(a+b)-(b+c)"); // a-c
        s.solve("(a+b)-(b-c)"); // a+c
        s.solve("(a-b)-b-b"); // a - 3b
        s.solve("a+b-(c+(d-b))"); // a + 2b - c - d
        s.solve("(a+b)-(b+c)-(c+d)"); // a-2c-d
        s.solve("(a+b)-(b+c)-(c+d)-(d+e)"); // a-2c-2d-e
    }
}
