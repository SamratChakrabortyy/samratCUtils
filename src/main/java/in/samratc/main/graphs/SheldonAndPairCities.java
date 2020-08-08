package in.samratc.main.graphs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SheldonAndPairCities {
    /**
     * Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
     * Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the distance between the cities.
     * Now he has many lectures to give in the city and is running short of time, so he asked you C queries, for each query i,
     * find the shortest distance between city G[i] and H[i].
     * <p>
     * If the two cities are not connected then the distance between them is assumed to be -1.
     */
    public int[] solve(int a, int b, int c, int[] d, int[] e, int[] f, int[] g, int[] h) {
        int[][] dist = new int[a][a];
        Arrays.stream(dist).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
        IntStream.range(0, a).forEach(i -> dist[i][i] = 0);
        for (int i = 0; i < b; i++) {
            dist[d[i] - 1][e[i] - 1] = Math.min(dist[d[i] - 1][e[i] - 1], f[i]);
            dist[e[i] - 1][d[i] - 1] = Math.min(dist[e[i] - 1][d[i] - 1], f[i]);
        }
        for(int i = 0; i < a; i++){
            for(int j = 0; j < a; j++){
                for(int k = 0; k < a; k++){
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        return IntStream.range(0, c).map(i -> dist[g[i]][h[i]] == Integer.MAX_VALUE ? -1 : dist[g[i]][h[i]]).toArray();
    }
}
