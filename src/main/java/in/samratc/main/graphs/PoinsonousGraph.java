package in.samratc.main.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class PoinsonousGraph {
}

class PoinsonousGraphSol {
    private Map<Integer, Integer> nodeSetMap= new HashMap<>();
    private Map<Integer, Set<Integer>> graph = new HashMap<>();
    private boolean isBipartite = true;
    private long[] count;
    private final long mod = 998244353;
    public int solve(int v, int[][] edges) {
        //Null check
        if (edges == null || v == 0 || edges.length == 0)
            return 1; //A blank graph is BiPartite
        //Create Adjacency List
        IntStream.range(0, v).forEach(i -> graph.put(i, new HashSet<>()));
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[v];
        long totCount = 1;
        for(int node : graph.keySet()){
            if(!visited[node]){
                count = new long[2];
                nodeSetMap.put(node, 0);
                count[0]++;
                dfs(node, visited);
            }
            count[0] = (((count[0] % mod) * 2) % mod);
            count[1] = (((count[1] % mod) * 2) % mod);
            totCount = (totCount * ((count[0] + count[1]) % mod)) % mod;
        }
        return isBipartite && nodeSetMap.size() == v ? (int)totCount : 0;
    }

    private void dfs(int node, boolean[] visited){
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(!isBipartite)
                return;
            if(nodeSetMap.containsKey(neighbor) && nodeSetMap.get(neighbor) == nodeSetMap.get(node)){
                isBipartite = false;
                break;
            } else if (!nodeSetMap.containsKey(neighbor)){
                nodeSetMap.put(neighbor, (nodeSetMap.get(node) + 1) % 2);
                count[(nodeSetMap.get(node) + 1) % 2]++;
            }
            if(!visited[neighbor])
                dfs(neighbor, visited);
        }
    }
}
