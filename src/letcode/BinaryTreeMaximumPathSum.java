package letcode;

import static java.lang.Math.*;

public class BinaryTreeMaximumPathSum {
    int ans;

    //max path going down
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int x = max(0, dfs(root.left));

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int y = max(0, dfs(root.right));

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        ans = max(ans, x + y + root.val);

        // return the max sum for a path starting at the root of subtree
        return root.val + max(x, y);

    }

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        /**
         * Definition for a binary tree node.
         */
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}