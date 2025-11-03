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
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private static int dfs(TreeNode root, int counter){
        if(root == null){
            return counter - 1;
        }

        return Math.max(dfs(root.left, counter + 1), dfs(root.right, counter + 1));
    }

    
}