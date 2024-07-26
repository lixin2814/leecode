package zhan;

public class test402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            // 单调栈
            int n = num.length();
            if (n == k) {
                return "0";
            }
            char[] stk = new char[n];
            int top = -1;
            for (int i = 0; i < n; i++) {
                char c = num.charAt(i);
                // 栈不为空，且当前数字小于栈顶元素，则栈顶元素出栈
                // 贪心思想，两个比较留小的
                while (top != -1 && k > 0 && stk[top] > c) {
                    top--;
                    k--;
                }
                stk[++top] = c;
            }
            // 处理剩余的移除
            while (k > 0) {
                top--;
                k--;
            }
            // 构造结果
            int start = 0;
            while (start <= top && stk[start] == '0') {
                start++;
            }
            return start > top ? "0" : new String(stk, start, top - start + 1);
        }
    }
}
