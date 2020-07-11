package in.samratc.main.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class Dijksta {
}

class DijkstaSol {
    private static final int INFINITY = (int)1e6;
    /**
     *
     * @param v no. of vertices
     * @param edges edges
     * @param src source vertex
     * @return min dist array for all other vertices from src
     */
    public int[] solve(int v, int[][] edges, int src) {
        //null check
        if(edges == null || v == 0 || src < 0 || src >= v)
            return new int[]{};

        //Creating Adjacency List
        Map<Integer, List<int[]>> graph = new HashMap<>();
        IntStream.range(0, v).forEach(i -> graph.put(i, new ArrayList<>()));
        for(int[] edge: edges){
            graph.get(edge[0]).add(getPair(edge[2], edge[1]));
            graph.get(edge[1]).add(getPair(edge[2], edge[0]));
        }

        //Creating distance Array
        int[] dist = new int[v];
        Arrays.fill(dist, INFINITY);
        dist[src] = 0;

        //Priority Queue on weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        pq.add(getPair(0, src));

        //Creating visited
        boolean[] visited = new boolean[v];

        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i = 0; i < size; i++){
                int[] curr = pq.remove();
                visited[curr[1]] = true;
                for(int[] neighbor : graph.get(curr[1])){
                    if(!visited[neighbor[1]] && dist[neighbor[1]] > dist[curr[1]] + neighbor[0]){
                        dist[neighbor[1]] = dist[curr[1]] + neighbor[0];
                        pq.add(getPair(dist[neighbor[1]], neighbor[1]));
                    }
                }
            }
        }


        return dist;
    }

    private int[] getPair(int x, int y){
        return new int[] {x, y};
    }
}
