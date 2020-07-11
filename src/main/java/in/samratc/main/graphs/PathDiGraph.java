package in.samratc.main.graphs;

import java.util.*;

public class PathDiGraph {
}

class PathDiGraphSol {

    //NodeCount is the count of the node in the Graph, edge[i] represent there is an Directed edge from edge[i][0] edge[i][1]
    public int solve(int nodeCount, int[][] edges) {
        //Null Check
        if (nodeCount == 0 || edges == null || edges.length == 0)
            return 0;
        //Adjacency List of the Graph
        Map<Integer, List<Integer>> adjacentList = new HashMap<>(nodeCount);
        for (int[] edge : edges) {
            if (!adjacentList.containsKey(edge[0]))
                adjacentList.put(edge[0], new ArrayList<>());
            adjacentList.get(edge[0]).add(edge[1]);
        }

        // Implementing BFS starting from 1
        Queue<Integer> q = new LinkedList<>();
        //Visited Array
        boolean[] visited = new boolean[nodeCount];
        q.add(1);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                visited[curr] = true;
                if (adjacentList.containsKey(curr)) {
                    for (int next : adjacentList.get(curr)) {
                        if (!visited[next])
                            q.add(next);
                    }
                }
            }
        }
        return visited[nodeCount - 1] ? 1 : 0;
    }
}
