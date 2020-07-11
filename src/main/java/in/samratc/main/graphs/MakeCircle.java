package in.samratc.main.graphs;

import java.util.*;

public class MakeCircle {
    public static void main(String... args){
        System.out.println(new MakeCircleSol().solve(Arrays.asList("zaz", "zbz", "zaz", "zdz")));
    }
}

class MakeCircleSol {
    /**
     *
    * @param words List of Strings for for which we need to check if there is a circle or not
    * @return 1 if circle is possible otherwise 0
    */
    public int solve(List<String> words) {
        /*
        *   Approach:
        *   =========
        * 
        *   A directed graph has a circle i.e a loop using all the vertices has inDegree == outDegree and 
        *   the graph is fully connected
        * */
        if(words == null || words.size() == 0)
            return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[26], outDegree = new int[26];
        
        for(String word : words){
            if(word.length() == 0)
                continue;
            int first = word.charAt(0) - 'a';
            int last = word.charAt(word.length() - 1) - 'a';

            if(!graph.containsKey(first))
                graph.put(first, new HashSet<>());
            graph.get(first).add(last);

            inDegree[last]++;
            outDegree[first]++;
        }

        for(int node : graph.keySet()){
            if(inDegree[node] != outDegree[node])
                return 0;
        }
        return isFullyConnected(graph, words.get(0).charAt(0) - 'a') ? 1 : 0;
    }


    /**
     *
     * @param graph AdjacentList of graph
     * @param start starting point of DFS
     * @return true iff fully connected
     */
    private boolean isFullyConnected(Map<Integer, Set<Integer>> graph, int start){
        boolean[] visited = new boolean[26];
        dfs(start, graph, visited);
        for(int node: graph.keySet()){
            if(!visited[node])
                return false;
        }
        return true;
    }

    /**
     *
     * @param start starting node of DFS
     * @param graph adjacency List of graph
     * @param visited visited array
     */
    private void dfs(int start, Map<Integer, Set<Integer>> graph, boolean[] visited){
        visited[start] = true;
        for(int next : graph.get(start)){
            if(!visited[next])
                dfs(next, graph, visited);
        }
    }
}
