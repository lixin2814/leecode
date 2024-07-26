package zhan;

import java.util.Stack;

public class test20 {
    class Solution {
        public boolean isValid(String s) {
            // 创建一个栈用于存储字符
            Stack<Character> stack = new Stack<>();
            // 遍历字符串中的每个字符
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 如果字符是左括号，则将其压入栈中
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                // 如果字符是右括号，则尝试弹出栈顶元素
                else {
                    // 如果栈为空，或者弹出的元素与当前字符不匹配，则返回false
                    if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                        return false;
                    }
                }
            }
            if (!stack.isEmpty()){
                return false;
            }
            return true;
        }
        public  boolean isMatch(char left, char right) {
            return  (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
        }
    }
}
