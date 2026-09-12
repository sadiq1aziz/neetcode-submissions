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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        //perform in order traversal

        //also check the sum returned by children if not negative
        int leftSum = Math.max(dfs(root.left), 0);
        int rightSum = Math.max(dfs(root.right), 0);
    
        //calculate path sum
        int pathSum = root.val + leftSum + rightSum;

        //account for maxSum
        maxSum = Math.max(pathSum, maxSum);

        //now return to parent with the sum of the current node and max
        //of the child nodes
        return Math.max(leftSum, rightSum) + root.val;
    }
}
