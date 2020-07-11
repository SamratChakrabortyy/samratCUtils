package in.samratc.main.graphs;

import java.util.*;
import java.util.stream.IntStream;


public class CheckBiPartite {
}

class CheckBiPartiteSol {
    /**
     * @param v     no. of vertices
     * @param edges edges of Undirected Graph
     * @return 1 if BiPartite 0 if Not
     */
    private Map<Integer, Integer> nodeSetMap= new WeakHashMap<>();
    private Map<Integer, Set<Integer>> graph = new HashMap<>();
    private boolean isBiPartite = true;
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
        for(int node : graph.keySet()){
            if(!visited[node]){
                nodeSetMap.put(node, 0);
                dfs(node, visited);
            }
        }
        return isBiPartite && nodeSetMap.size() == v ? 1 : 0;
    }

    private void dfs(int node, boolean[] visited){
        visited[node] = true;
        for(int neighbor : graph.get(node)){
            if(!isBiPartite)
                return;
            if(nodeSetMap.containsKey(neighbor) && nodeSetMap.get(neighbor) == nodeSetMap.get(node)){
                isBiPartite = false;
                break;
            } else if (!nodeSetMap.containsKey(neighbor)){
                nodeSetMap.put(neighbor, (nodeSetMap.get(node) + 1) % 2);
            }
            if(!visited[neighbor])
                dfs(neighbor, visited);
        }
    }

}
