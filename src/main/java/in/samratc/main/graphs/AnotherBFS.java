package in.samratc.main.graphs;

import com.sun.istack.internal.NotNull;

import java.util.*;

public class AnotherBFS {
}

class AnotherBFSSol {
    public int solve(int v, @NotNull int[][] edges, int source, int destination) {
        //creating Adjacency list
        Map<Integer, List<int[]>> adjacentList = new HashMap<>();
        for(int[] edge : edges){
            if(!adjacentList.containsKey(edge[0]))
                adjacentList.put(edge[0], new ArrayList<>());
            adjacentList.get(edge[0]).add(getPair(edge[1], edge[2]));

            if(!adjacentList.containsKey(edge[1]))
                adjacentList.put(edge[1], new ArrayList<>());
            adjacentList.get(edge[1]).add(getPair(edge[0], edge[2]));
        }

        // Approach BFS with two Queues
        Queue<Integer>[] qs = new Queue[2];
        qs[0] = new LinkedList<>();
        qs[1] = new LinkedList<>();
        //Visited Array
        boolean[] visited = new boolean[v];
        int dist = 0;
        qs[0].add(source);
        while(!qs[0].isEmpty() || !qs[1].isEmpty()){
            int size = qs[dist % 2].size();
            for(int i = 0; i < size; i++){
                int curr = qs[dist % 2].remove();
                visited[curr] = true;
                if(destination == curr)
                    return dist;
                if(!adjacentList.containsKey(curr))
                    continue;
                for(int[] vertex : adjacentList.get(curr)){
                    if(!visited[vertex[0]]){
                        qs[(dist + vertex[1]) % 2].add(vertex[0]);
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    private int[] getPair(int x, int y){
        return new int[] {x, y};
    }
}
