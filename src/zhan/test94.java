package zhan;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // 迭代
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty()||root!=null) {
                while (root != null){
                    stack.push(root);
                    root=root.left;
                }
                root=stack.pop();
                ans.add(root.val);
                root=root.right;
            }
            return ans;
        }
    }
}
