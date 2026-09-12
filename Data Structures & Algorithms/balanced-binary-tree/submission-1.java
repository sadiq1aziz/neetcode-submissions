/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) > 0;
    }


    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        //post order traversal
        
        //check heights returned by children
        int leftHeight = dfs(root.left);
        //if unbalanced we stop and return to parent terminating flow with -1
        if ( leftHeight < 0){
            return -1;
        }
        int rightHeight = dfs(root.right);
        if ( rightHeight < 0){
            return -1;
        }

        //check main case for balance
        int balance = Math.abs(leftHeight - rightHeight);
        if (balance > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
