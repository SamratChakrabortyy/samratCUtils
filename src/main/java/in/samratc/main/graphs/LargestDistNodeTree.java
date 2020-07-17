package in.samratc.main.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
 * The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between
 * the nodes (there will be a unique path between any pair of nodes since it is a tree).
 */
public class LargestDistNodeTree {
    // Two max distances from root
    int max = 0;

    /**
     * The nodes will be numbered 0 through N - 1.
     * The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N).
     * Exactly one of the i's will have A[i] equal to -1, it will be root node.
     */
    public int solve(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int n = A.length;
        List<List<Integer>> tree = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> tree.add(new ArrayList<>()));
        boolean[] visited = new boolean[n];
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) {
                root = i;
            } else {
                tree.get(A[i]).add(i);
                tree.get(i).add(A[i]);
            }
        }
        height(root, tree, visited);

        return max;
    }

    private int height(int curr, List<List<Integer>> tree, boolean[] visited) {
        visited[curr] = true;
        int max1 = 0, max2 = 0;
        for(int child : tree.get(curr)){
            if(!visited[child]){
                int temp = height(child, tree, visited);
                if(max1 < temp){
                    max2 = max1;
                    max1 = temp;
                } else if(max2 < temp){
                    max2 = temp;
                }
            }
        }
        max = Math.max(max, max1 + max2);
        return max1 + 1;
    }
}
