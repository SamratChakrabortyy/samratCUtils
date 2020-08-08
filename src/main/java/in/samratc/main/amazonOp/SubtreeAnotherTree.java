package in.samratc.main.amazonOp;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SubtreeAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String postFixS = postFix(s), postFixT = postFix(t);
        return postFixS.contains(postFixT);
    }

    private String postFix(TreeNode root) {
        if (root == null)
            return "#,";
        StringBuilder postFix = new StringBuilder();
        postFix.append(postFix(root.left));
        postFix.append(postFix(root.right));
        postFix.append(root.val + ",");
        return postFix.toString();
    }
}

//Approach 2
class SubtreeAnotherTree2 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isIdentical(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}