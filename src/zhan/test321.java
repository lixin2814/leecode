package zhan;

import java.util.Stack;

public class test321 {
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            int[] ans = new int[k];
            for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {



            }
            return ans;
        }

        int[] pick_max(int[] nums, int k) {
            int n = nums.length;
            Stack<Integer> stk = new Stack<>();
            for (int i = 0, j = 0; i < n; i++) {
                while (j < i && n - i + stk.size() < k) {
                    if (!stk.isEmpty() && stk.peek() < nums[i]) {
                        stk.pop();
                    }
                    j++;
                }
                if (stk.size() < k) {
                    stk.push(nums[i]);
                }
            }
            int[] res = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                res[i] = stk.pop();
            }
            return res;
        }
    }
}
