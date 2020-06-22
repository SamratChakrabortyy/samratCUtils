package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValuableNodes {
    public static void main(String... args) {
        System.out.println(new ValuableNodesSol().solve(Arrays.asList(0, 1, 1, 1, 3, 3, 6, 6), Arrays.asList(100, 2, 3, 4, 5, 6, 7, 8 )));
    }
}

class ValuableNodesSol {
    private static final long mod = 1000000007;
    Map<Integer, List<Integer>> childMap = new ConcurrentHashMap<>(), greatGrandChildMap = new ConcurrentHashMap<>();
    Map<Integer, Long> maxVal = new ConcurrentHashMap<>();
    List<Long> vals;

    public int solve(List<Integer> parent, List<Integer> values) {
        int n = parent.size();
        vals = values.stream().map(i -> (long) i).collect(Collectors.toList());
        IntStream.range(1, n + 1).forEach(i -> {
            childMap.put(i, new ArrayList<Integer>());
            greatGrandChildMap.put(i, new ArrayList<Integer>());
        });
        for (int i = 1; i <= n; i++) {
            if (parent.get(i - 1) >= 1 && parent.get(i - 1) <= n)
                childMap.get(parent.get(i - 1)).add(i);
            if (parent.get(i - 1) >= 1 && parent.get(i - 1) <= n // parent present
                    && parent.get(parent.get(i - 1) - 1) >= 1 && parent.get(parent.get(i - 1) - 1) <= n//grandParent present
                    && parent.get(parent.get(parent.get(i - 1) - 1) - 1)>= 1
                    && parent.get(parent.get(parent.get(i - 1) - 1) - 1)<= n //great grand parent present
            ) {
                greatGrandChildMap.get(parent.get(parent.get(parent.get(i - 1) - 1) - 1)).add(i);
            }
        }
        System.out.println(parent + "\n");
        System.out.println(childMap + "\n");
        System.out.println(greatGrandChildMap + "\n");
        /*
                let maxVal[i] denote the maximum value that can be achieved from the sub tree of that node
                There are two cases possible:
                    1. Include it:
                        Then maxValIncluding = value[i] + sum(maxVal[g] where g in greatGrandChildren[i])
                    2. Don't include it:
                        Then maxValExcluding = sum(maxVal[c] where c in children[i]
                Therefore maxVal[i] = max(maxValIncluding, maxValExcluding)

                Base case: LeafNode where there is no child present then maxVal[leaf] = value[leaf]
        */
        return (int) (maxValFromSubTree(1) % mod);
    }

    private long maxValFromSubTree(int node) {
        if (maxVal.containsKey(node))
            return maxVal.get(node);
        if (childMap.get(node).isEmpty()) {
            maxVal.put(node, vals.get(node - 1));
        } else {
            long incNode = vals.get(node - 1), excNode = 0L;
            for (int c : childMap.get(node)) {
                excNode += maxValFromSubTree(c);
            }
            for (int g : greatGrandChildMap.get(node)) {
                incNode += maxValFromSubTree(g);
            }
            maxVal.put(node, Math.max(incNode, excNode));
        }
        return maxVal.get(node);
    }
}
