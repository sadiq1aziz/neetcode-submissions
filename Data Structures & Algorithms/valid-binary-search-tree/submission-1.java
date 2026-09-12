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

    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        
        //perform in order traversal
        //check for prev value and accordingly see the progression
        //of values as we traverse if it breaks
        //return false if so

        if(root == null) {
            return true;
        }   

        //check left subtree if valid
        if(!isValidBST(root.left)){
            return false;
        }

        //check main case
        if (prev != null && root.val <= prev.val){
            return false;
        }

        //assign prev to current node
        prev = root;


        //check right subtree if valid
        return isValidBST(root.right);

        
    }

    
}


