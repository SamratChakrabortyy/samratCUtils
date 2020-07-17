package in.samratc.main.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class SpecialPath {
    /**
     *
     * Given a graph with N nodes numbered 1 to N and M weighted edges. Given a binary array A of size N. A[i] = 1 if the ith node is special else 0.
     * Find the minimum distance of the special path between the 1st and the Nth node.
     * Distance between two nodes is defined as the sum of the weight of edges in the path.
     * A special path is a path which visits at least C non-special nodes and at least D special nodes.
     *
     * NOTE: A node or edge can occur multiple times in a special path. If no such path exists return -1.
     */
    public int solve(int[] isSpecial, int[][] edges, int c, int d) {
        if(isSpecial == null || isSpecial.length == 0 || edges == null || edges.length == 0)
            return -1;
        //No of vertices
        int v = isSpecial.length;
        //Adjacency List
        List<List<int[]>> graph = new ArrayList<>();
        IntStream.range(0, v).forEach(i -> graph.add(new ArrayList<>()));
        for(int[] edge : edges){
            graph.get(edge[0] - 1).add(new int[]{edge[1] - 1, edge[2]});
            graph.get(edge[1] - 1).add(new int[]{edge[0] - 1, edge[2]});
        }

        //Distance of v'th node using c non-special node and d special node
        int[][][] dist = new int[v][11][11];
        for(int[][] arr1 : dist){
            for(int[] arr2 : arr1)
                Arrays.fill(arr2, Integer.MAX_VALUE);
        }

        //if 0 is nonSpecial the 0 ^ 1 = 1 and 0 special and if 0 is special then 1 ^ 1 = 0 nonSpecial and 1 special
        dist[0][isSpecial[0] ^ 1][isSpecial[0]] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[3]));
        pq.add(getQuad(0, isSpecial[0] ^ 1, isSpecial[0], 0));
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            for(int[] next : graph.get(curr[0])){
                int ns = Math.min(10, curr[1] + (isSpecial[next[0]] ^ 1)), s = Math.min(10, curr[2] + isSpecial[next[0]]);
                if(dist[next[0]][ns][s] > curr[3] + next[1]){
                    dist[next[0]][ns][s] = curr[3] + next[1];
                    pq.add(getQuad(next[0], ns, s, dist[next[0]][ns][s]));
                    if(next[0] == v - 1 && ns >= c && s >= d)
                        return dist[next[0]][ns][s];
                }
            }
        }
        return -1;
    }

    private int[] getQuad(int a, int b, int c, int d){
        return new int[]{a, b, c, d};
    }
}
