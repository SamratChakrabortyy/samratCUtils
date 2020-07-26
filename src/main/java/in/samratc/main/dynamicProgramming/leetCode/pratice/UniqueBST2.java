package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return Collections.emptyList();
        /*
                uniqueBST[i] denotes the unique BSTs that can be formed using 0-i
         */
        List<TreeNode>[] uniqueBST = new List[n + 1];
        //Base Case uniqueBST[0] = [null]
        uniqueBST[0] = new ArrayList<>();
        uniqueBST[0].add(null);

        //Finding the uniqueBST's for i > 0
        for (int i = 1; i <= n; i++) {
            uniqueBST[i] = new ArrayList<>();
            // L denotes the number left to i
            for (int l = 0; l < i; l++) {
                for (TreeNode nodeL : uniqueBST[l]) { // Nodes which has the values smaller than i
                    for (TreeNode nodeR : uniqueBST[i - l - 1]) { // if there are l nodes in the left , 1 root, and i - l - 1noes in the right Subtree
                        TreeNode node = new TreeNode(l + 1);
                        node.left = nodeL;
                        node.right = shiftByOffset(nodeR, l + 1); // nodeR is the node of uniqueBST[i- l - 1] which needs to added j+1 so that it can be at right of node
                        uniqueBST[i].add(node);
                    }
                }
            }
        }
        return uniqueBST[n];
    }

    private TreeNode shiftByOffset(TreeNode node, int offset) {
        if (node == null)
            return node;
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = shiftByOffset(node.left, offset);
        newNode.right = shiftByOffset(node.right, offset);
        return newNode;
    }

    //Driver
    public static void main(String... args) {
        UniqueBST2 uBST2 = new UniqueBST2();
        /*uBST2.generateTrees(3).forEach(System.out::println);
        System.out.println("\n");*/
        uBST2.generateTrees(3).forEach(node -> {
            TreeNode.print(node);
            System.out.println();
        });
    }
}


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

    public static void print(TreeNode node) {
        System.out.print((node == null ? null : node.val) + "\t");
        if (node == null)
            return;
        print(node.left);
        print(node.right);

    }
}
