package in.samratc.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {



    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) > b)
                        continue;
                    if (Math.abs(arr[k] - arr[i]) > c)
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    public int getWinner(int[] arr, int k) {
        int max = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (i - k + 1 > 0 && arr[i - k + 1] == max)
                return max;
            if (i - k >= 0 && arr[i - k] == max)
                return max;
            //System.out.println(i + " " +max + ( i- k + 1));
        }
        return max;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 0)
                    count++;
                else
                    break;
            }
            arr[i] = count;
        }
        int swaps = 0;
        for(int i = 0; i < n ; i++){
            while(arr[i] < n- i - 1){

            }
        }


        for (int i = 0; i < n; i++) {
            if (arr[i] < n-i-1)
                return -1;
        }
        return swaps;
    }

     static class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public int bstDistance(int num, List<Integer> values,
                               int node1, int node2)
        {
            TreeNode root = null;
            for(int val : values)
                inesertToBST(root, val);
            return dist(root, node1, node2);
        }
        // METHOD SIGNATURE ENDS

        private int dist(TreeNode root, int val1, int val2){
            if(root == null)
                return -1;
            if(val1 < root.val && val2 < root.val)
                return dist(root.left, val1, val2);
            else if(val1 > root.val && val2 > root.val)
                return dist(root.right, val1, val2);
            else{
                int val1Dist = dist(root, val1);
                if(val1Dist == -1)
                    return -1;
                int val2dist = dist(root, val2);
                if(val2dist == -1)
                    return -1;
                return val1Dist + val2dist + 2;
            }
        }

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

        private void inesertToBST(TreeNode root, int val){
            if(root == null){
                root = new TreeNode(val);
                return;
            }
            if(val < root.val){
                inesertToBST(root.left, val);
            } else {
                inesertToBST(root.right, val);
            }
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
        }
    }



    public static void main(String... args) {
        try(Scanner sc = new Scanner(System.in)){
            Solution s = new Solution();
        } catch (Exception ex){
            System.out.println("RunTime Error");
            ex.printStackTrace();
            throw ex;
        }
    }
}