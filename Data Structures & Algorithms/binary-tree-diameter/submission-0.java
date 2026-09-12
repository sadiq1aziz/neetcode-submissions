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
    
    private int maxDiameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs( TreeNode root){
        if (root == null){
            return 0;
        }

        //post order traversel to check height of each subtree/nodes
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        //calculate the diameter as the sum of node heights
        int diameter = leftHeight+rightHeight;
        //update diameter of parent
        maxDiameter = Math.max(diameter, maxDiameter);

        //return height of individual node
        return Math.max(leftHeight, rightHeight) + 1;
    }    
}
