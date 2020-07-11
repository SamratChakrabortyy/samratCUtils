package in.samratc.main.amazonOp;

import java.util.*;
import java.util.stream.Collectors;

public class OptimalUtilization {
    public static void main(String... args) {

        OptimalUtilizationSol sol = new OptimalUtilizationSol();

        int[][][] As = {
                {{1, 2}, {2, 4}, {3, 6}},
                {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
                {{1, 8}, {2, 7}, {3, 14}},
                {{1, 8}, {2, 15}, {3, 9}}
        };
        int[][][] Bs = {
                {{1, 2}},
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                {{1, 5}, {2, 10}, {3, 14}},
                {{1, 8}, {2, 11}, {3, 12}}
        };
        int[] targets = {7, 10, 20, 20};

        for (int i = 0; i < 4; i++) {
            List<int[]> l1 = Arrays.stream(As[i]).collect(Collectors.toList()), l2 = Arrays.stream(Bs[i]).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            sol.findOptimalPair(l1, l2, targets[i]).stream().forEach(arr -> sb.append(Arrays.toString(arr)));
            System.out.println(sb);
        }

    }

    private static int[] getPair(int x, int y) {
        return new int[]{x, y};
    }
}

class OptimalUtilizationSol {
    public List<int[]> findOptimalPair(List<int[]> a, List<int[]> b, int target) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty())
            return Collections.emptyList();
        Collections.sort(a, Comparator.comparingInt(x -> x[1]));
        List<int[]> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int[] arr : b) {
            int aPos = equalOrLowerPos(a, target - arr[1]);
            int diff = target - (arr[1] + a.get(aPos)[1]);
            if(diff < 0)
                continue;
            if (minDiff >= diff) {
                if (minDiff > diff)
                    res.clear();
                minDiff = diff;
                res.add(getPair(a.get(aPos)[0], arr[0]));
            }
        }

        return res;
    }

    public int equalOrLowerPos(List<int[]> list, int target) {
        int n = list.size();
        int l = 0, r = n - 1, pos = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid)[1] <= target) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    public int equalOrHigherPos(List<int[]> list, int target) {
        int n = list.size();
        int l = 0, r = n - 1, pos = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid)[1] >= target) {
                pos = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }

    private static int[] getPair(int x, int y) {
        return new int[]{x, y};
    }


}
