package in.samratc.main.amazonOp;

import java.util.*;
import java.util.stream.IntStream;

//https://leetcode.com/problems/possible-bipartition/

public class PossibleBipartition {
}

class PossibleBipartitionSol {
    /**
     * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
     * Each person may dislike some other people, and they should not go into the same group.
     * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
     * Return true if and only if it is possible to split everyone into two groups in this way.
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0)
            return true;
        Map<Integer, Integer> personGroup = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        IntStream.range(0, n + 1).forEach(i-> graph.add(new ArrayList<>()));
        for (int[] arr : dislikes) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        boolean isBipartite = true;
        for (int i = 1; i <= n; i++) {
            if (!personGroup.containsKey(i)) {
                personGroup.put(i, 0);
                isBipartite = checkBipartite(i, personGroup, graph, isBipartite);
                if (!isBipartite)
                    return isBipartite;
            }
        }
        return isBipartite;
    }

    private boolean checkBipartite(int node, Map<Integer, Integer> personGroup, List<List<Integer>> graph, boolean isBipartite) {
        for (int neighbor : graph.get(node)) {
            if (!personGroup.containsKey(neighbor)) {
                personGroup.put(neighbor, (personGroup.get(node) + 1) % 2);
                isBipartite = checkBipartite(neighbor, personGroup, graph, isBipartite);
            } else if (personGroup.get(neighbor) == personGroup.get(node)) {
                isBipartite = false;
                return isBipartite;
            }
            if (!isBipartite)
                return isBipartite;
        }
        return isBipartite;
    }
}
