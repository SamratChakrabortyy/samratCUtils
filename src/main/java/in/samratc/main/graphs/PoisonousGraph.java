package in.samratc.main.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class PoisonousGraph {
    private static final int mod = 998244353;
    private boolean isBipartite = true;
    public int solve(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        IntStream.range(0, v).forEach(i -> graph.add(new ArrayList<>()));
        for(int[] edge : edges){
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] set = new int[v];
        Arrays.fill(set , -1);
        int ans = 1;
        for(int i = 0 ; isBipartite && i < v; i++){
            if (set[i] == -1) {
                set[i] = 0;
                int[] count = dfs(i, set, graph, new int[]{1, 0});
                ans =  (ans * (powMod(2, count[0], mod) + powMod(2, count[1], mod)) % mod) % mod;
            }
        }
        return isBipartite ? ans : 0;
    }

    private int powMod(long base, long exp, int mod) {
        long ans = 1;
        while(exp > 0){
            if(exp % 2 == 1)
                ans = (ans * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return (int)ans;
    }


    private int[] dfs(int curr, int[] set, List<List<Integer>> graph, int[] count) {
        for(int next : graph.get(curr)){
            if(set[next] == -1){
                set[next] = 1 ^ set[curr];
                count[set[next]]++;
                dfs(next, set, graph, count);
            } else if(set[next] == set[curr]){
                isBipartite = false;
            }
            if(!isBipartite)
                break;
        }
        return count;
    }

    //Driver
    public static void main(String...rargs){
        System.out.println(new PoisonousGraph().solve(2, new int[][]{{1,2}}));
    }
}