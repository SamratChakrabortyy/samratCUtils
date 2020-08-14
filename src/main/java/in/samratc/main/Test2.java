package in.samratc.main;

import java.util.Arrays;
import java.util.List;

public class Test2 {


        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public int bstDistance(int num, List<Integer>values,
                               int node1, int node2)
        {
            if(num == 0)
                return 0;
            TreeNode root = new TreeNode(values.get(0));
            for(int i = 1; i < num; i++)
                insertToBST(root, values.get(i));
            //System.out.println(root.val);
            return dist(root, node1, node2);
        }
        // METHOD SIGNATURE ENDS

    /**
     *
     * @param root Root of BST
     * @param val1 Value of node 1
     * @param val2 Value of node 2
     * @return distance between node1 and node2 ( -1 if any of the node is absent)
     */
        private int dist(TreeNode root, int val1, int val2){
            if(root == null)
                return -1;
            if(val1 < root.val && val2 < root.val)
                return dist(root.left, val1, val2);
            else if(val1 > root.val && val2 > root.val)
                return dist(root.right, val1, val2);
            else{
                int val1Dist = dist(root, val1);
                //System.out.println(root.val + " "  + val1Dist);
                if(val1Dist == -1)
                    return -1;
                int val2dist = dist(root, val2);
                //System.out.println(root.val + " "  + val2dist);
                if(val2dist == -1)
                    return -1;
                return val1Dist + val2dist;
            }
        }

    /**
     *
     * @param root Root of BST
     * @param val Value of the node whose Distance is to be calculated
     * @return Distance between the root and the node with Value val (-1 if the node is absent)
     */
        private int dist(TreeNode root, int val){
            if(root == null)
                return -1; // val not present at subTree of root;
            if(root.val == val)
                return 0;
            int subTreeDist;
            if(val < root.val)
                subTreeDist = dist(root.left, val);
            else
                subTreeDist = dist(root.right, val);
            return subTreeDist == -1 ? -1 : subTreeDist + 1;
        }

    /**
     *  Method to Insert Value at BST
     * @param root Root of BST
     * @param val Value to be inserted at BST
     */
        private void insertToBST(TreeNode root, int val){
            TreeNode prev = null, curr = root;
            while(curr != null){
                prev = curr;
                if(val < curr.val)
                    curr = curr.left;
                else
                    curr = curr.right;
            }
            if(val < prev.val)
                prev.left = new TreeNode(val);
            else
                prev.right = new TreeNode(val);
        }


        class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val){
                this.val = val;
                this.left = null;
                this.right = null;
            }

            TreeNode(){}
        }

    public static void main(String... args){
            Test2 t = new Test2();
        System.out.println(t.bstDistance(5, Arrays.asList(5, 4, 3, 2, 1),2, 4));
    }
}
