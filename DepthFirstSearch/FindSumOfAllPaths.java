/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Problem Statement: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root,0);
    }
    private int sumRootToLeaf(TreeNode currNode, int pathSum) {
        if(currNode==null)
            return 0;
        pathSum=pathSum*2+currNode.val;
        if(currNode.left==null && currNode.right==null)
            return pathSum;
        return sumRootToLeaf(currNode.left,pathSum)+sumRootToLeaf(currNode.right,pathSum);
    }
}
