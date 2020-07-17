package in.samratc.main.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BallMaze {
    private static final int[][] offset = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solve(int[][] maze, int[] start, int[] dest) {
        if (maze == null || maze.length == 0 || start == null || start.length == 0 || dest == null || dest.length == 0)
            return -1;
        int n = maze.length, m = maze[0].length;
        int[][] dist = new int[n][m];
        dijkstra(maze, dist, start);
        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
    }

    private void dijkstra(int[][] maze, int[][] dist, int[] start) {
        int n = maze.length, m = maze[0].length;
        Arrays.stream(dist).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
        dist[start[0]][start[1]] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        minHeap.add(getTrio(0, start));
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            for (int[] diff : offset) {
                int x = curr[1] + diff[0];
                int y = curr[2] + diff[1];
                int count = 0;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += diff[0];
                    y += diff[1];
                    count++;
                }
                if (dist[curr[1]][curr[2]] + count < dist[x - diff[0]][y - diff[1]]) {
                    dist[x - diff[0]][y - diff[1]] = dist[curr[1]][curr[2]] + count;
                    minHeap.add(getTrio(dist[x - diff[0]][y - diff[1]], x - diff[0], y - diff[1]));
                }
            }

        }
    }

    private int[] getTrio(int y, int... x) {
        return new int[]{y, x[0], x[1]};
    }

    //Driver
    public static void main(String... args){
        int[][] maze = {
                {1, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 0, 1, 0}
        };

        System.out.println(new BallMaze().solve(maze, new int[]{1, 1}, new int[]{2, 1}));
    }
}
