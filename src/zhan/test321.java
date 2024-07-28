package zhan;

import java.util.Stack;

public class test321 {
    static class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            // 获取两个数组中长度为i和k-1的子序列
            // 单调栈，融合两个数组，细节判断，当前数相同，看后面的
            // 贪心，优先选择大的数，细节判断，当前数相同，看后面的
            int m = nums1.length, n = nums2.length;
            int[] ans = new int[k];
            for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
                int[] s1 = pick_max(nums1, i);
                int[] s2 = pick_max(nums2, k - i);
                int[] center = merge(s1, s2);
                if (compare(center, ans) > 0) {
                    System.arraycopy(center, 0, ans, 0, k);
                }
            }
            return ans;
        }

        int[] pick_max(int[] nums, int k) {
            int n = nums.length;
            int[] stk = new int[k];
            int top = -1;
            int remain = n - k;
            for (int i = 0; i < n; i++) {
                while (top >= 0 && stk[top] < nums[i] && remain > 0) {
                    top--;
                    remain--;
                }
                // 当前数字大于栈顶元素，且还有剩余空间
                // 直接入栈
                if (top < k - 1) {
                    top++;
                    stk[top] = nums[i];
                } else {
                    // 取出后面的元素
                    remain--;
                }
            }
            return stk;
        }

        int[] merge(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int[] ans = new int[n1 + n2];
            int index1=0,index2=0;
            for (int i = 0; i < n1 + n2; i++) {
                if (compare(nums1, index1, nums2, index2) > 0) {
                    ans[i] = nums1[index1++];
                } else {
                    ans[i] = nums2[index2++];
                }
            }
            return ans;
        }

        int compare(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            for (int i = 0; i < n1 && i < n2; i++) {
                if (nums1[i] != nums2[i]) {
                    return nums1[i] - nums2[i];
                }
            }
            return n1 - n2;
        }

        int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
            int x = subsequence1.length, y = subsequence2.length;
            while (index1 < x && index2 < y) {
                int difference = subsequence1[index1] - subsequence2[index2];
                if (difference != 0) {
                    return difference;
                }
                index1++;
                index2++;
            }
            return (x - index1) - (y - index2);
        }

        public static void main(String[] args) {
            int[] nums1 = {5, 6, 8};
            int[] nums2 = {6, 4, 0};
            int[] ans = (new Solution()).maxNumber(nums1, nums2, 3);
        }
    }
}
