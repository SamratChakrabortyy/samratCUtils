package in.samratc.main.tree;


import java.util.*;

public class RemoveExtraEdge {
    /**
     * Remove Extra Edge
     * Problem Description
     * <p>
     * Given a binary tree A where all values of nodes are distinct, there is a pair of leaf nodes which have the same value.
     * <p>
     * Considering that the pair that has the same value is indeed the same node and not two different nodes, return the tree after removing one of the edges from it.
     * <p>
     * You need to remove the edge from the parent whose value is greater.
     */

    Map<Integer, TreeNode> leafNodeParent;
    public TreeNode solve(TreeNode root) {
        leafNodeParent = new HashMap<>();
        removeDuplicateEdge(root, null);
        return root;
    }
    private void removeDuplicateEdge(TreeNode node, TreeNode parent){
        if(node.left == null && node.right == null){
            if(!leafNodeParent.containsKey(node.val)){
                leafNodeParent.put(node.val, parent);
            } else{
                TreeNode largerParent = parent.val > leafNodeParent.get(node.val).val ? parent : leafNodeParent.get(node.val);
                if(largerParent.left != null && largerParent.left.val == node.val)
                    largerParent.left = null;
                else
                    largerParent.right = null;
            }
        }
        if(node.left != null)
            removeDuplicateEdge(node.left, node);
        if(node.right != null)
            removeDuplicateEdge(node.right, node);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

}
