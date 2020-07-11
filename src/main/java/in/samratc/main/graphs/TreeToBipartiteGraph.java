package in.samratc.main.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class TreeToBipartiteGraph {
}


class TreeToBipartiteGraphSol {
    private static final long mod = (long) 1e9 + 7;

    /**
     * @param v     node count of the Tree
     * @param edges edges in the tree
     * @return the maximum number of edges that can be added to the the Tree keeping it bipartite
     */
    public int solve(int v, int[][] edges) {
        /*
         * Tree is a bipartite Graph with onr color for all odd levels and one for all the even ones
         *
         * Now we need to introduce maximum number of edges keeping the graph bipartite in nature
         * the Max number of edges will be oddLevelCount * evenLevelCount
         */
        long[] count = {0L, 0L}; // 0th index contains the even level count and 1 contains the odd
        //Creating the adjacency list
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        IntStream.range(1, v + 1).forEach(i -> graph.put(i, new HashSet<>()));
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        q.add(1);
        visited[0] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count[level % 2] += size;
            level++;
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                for (int neighbor : graph.get(curr)) {
                    if (!visited[neighbor - 1]) {
                        q.add(neighbor);
                        visited[neighbor - 1] = true;
                    }
                }
            }
        }
        return (int) ((((count[0] * count[1]) % mod) - (edges.length) + mod) % mod);
    }
}