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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return processed(root,target);
    }
    private TreeNode processed(TreeNode root, int target){
        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left=processed(root.left,target);
        }
        if(root.right!=null){
            root.right=processed(root.right,target);
        }
        
        if(root.val==target && root.left == null && root.right == null){
            root=null;
        }
        return root;

    }
}