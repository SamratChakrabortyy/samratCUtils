package in.samratc.main.dynamicProgramming.leetCode.pratice;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBST {
    public int numTrees(int n) {
        if (n == 0)
            return 1;
        /*
                uniqueBSTCount[i] denotes the unique BSTs that can be formed using 0-i
         */
        int[] uniqueBSTCount = new int[n + 1];
        //Base Case uniqueBSTCount[0] = [null]
        uniqueBSTCount[0] = 1;

        //Finding the uniqueBSTCount's for i > 0
        for (int i = 1; i <= n; i++) {
            uniqueBSTCount[i] = 0;
            // L denotes the number left to i
            for (int l = 0; l < i; l++) {
                int leftCount = uniqueBSTCount[l]; // Nodes which has the values smaller than i
                int rightCount = uniqueBSTCount[i - l - 1]; // if there are l nodes in the left , 1 root, and i - l - 1noes in the right Subtree
                uniqueBSTCount[i] += leftCount * rightCount;
            }
        }
        return uniqueBSTCount[n];
    }

    //Driver
    public static void main(String... args) {
        UniqueBST uBST = new UniqueBST();
        System.out.println(uBST.numTrees(3));
    }
}



