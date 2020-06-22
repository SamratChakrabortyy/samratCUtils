package in.samratc.main.dynamicProgramming;

import in.samratc.util.TreeNode;
import sun.reflect.generics.tree.Tree;


public class MaxSumPathBinTree {
}



class MaxSumPathBinTreeSol {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxLinearSum(root);
        return ans;
    }

    private int maxLinearSum(TreeNode root){
        if(root == null)
            return  0;
        int leftLinerSum = maxLinearSum(root.left), rightLineamSum = maxLinearSum(root.right);
        ans = Math.max(ans, Math.max(0, leftLinerSum) + Math.max(rightLineamSum, 0) + root.val);
        return root.val + Math.max(0, Math.max(leftLinerSum, rightLineamSum));
    }
}
