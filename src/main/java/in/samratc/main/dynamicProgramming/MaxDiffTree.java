package in.samratc.main.dynamicProgramming;

import in.samratc.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MaxDiffTree {
}

class MaxDiffTreeSol {
    private int[] vals;
    private Map<Integer, List<Integer>> childMap;
    private int ans = 0;

    public int solve(int[] values, int[][] edges) {
        vals = values;
        childMap = new ConcurrentHashMap<>();
        for (int[] edge : edges) {
            int min = Math.min(edge[0], edge[1]), max = Math.max(edge[0], edge[1]);
            if (!childMap.containsKey(min))
                childMap.put(min, new ArrayList<>());
            childMap.get(min).add(max);
        }
        getMaxMin(1);
        return ans;
    }

    private Pair<Integer, Integer> getMaxMin(int i) {
        if (!childMap.containsKey(i) || childMap.get(i).isEmpty())
            return new Pair<>(vals[i - 1], vals[i - 1]);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int c : childMap.get(i)) {
            Pair<Integer, Integer> maxMin = getMaxMin(c);
            max = Math.max(max, maxMin.val1);
            min = Math.min(min, maxMin.val2);
        }
        ans = Math.max(ans, Math.max(Math.abs(vals[i - 1] - max), Math.abs(vals[i - 1] - min)));
        return new Pair<>(Math.max(vals[i - 1], max), Math.min(vals[i - 1], min));
    }
}
