package in.samratc.main.graphs;

public class FloydWarshall {
}

class FloydWarshallSol {

    private static final int INFINITY = 10000000;
    /**
     * Find all pair shortest path
     * If there is no possible path from vertex i to vertex j , B[i][j] = -1
     * @param graph the adjacency matrix of the graph
     * @return the shortest path from different pair of vertices
     */
    public int[][] solve(int[][] graph) {
        //Null check
        if(graph == null || graph.length == 0)
            return graph;
        int v = graph.length;
        //Replacing -1 with INFINITY to mark it unreachable
        for(int i = 0; i < v ; i++){
            for(int j = 0 ; j < v; j++){
                if(graph[i][j] == -1)
                    graph[i][j] = INFINITY;
            }
        }
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                for(int k = 0; k < v; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        //Replacing INFINITY back to -1
        for(int i = 0; i < v ; i++){
            for(int j = 0 ; j < v; j++){
                if(graph[i][j] == INFINITY)
                    graph[i][j] = -1;
            }
        }
        return graph;
    }
}
