package in.samratc.main.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MinSumPathTriangle {
    public static void main(String... args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(6, 6));

        list.add(Arrays.asList(7, 4, 8));
        System.out.println(new MinSumPathTriangleSol().minimumTotal(list));
    }
}

class MinSumPathTriangleSol {
    public int minimumTotal(List<List<Integer>> triagle) {
        int n = triagle.size(), sum = 0;
        List<List<Integer>> pathSum = new ArrayList<>();
        pathSum.add(Arrays.asList(0));
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.MAX_VALUE);
            pathSum.add(temp);
        }
        for (int i = 1; i <= n; i++) {
            int m = triagle.get(i - 1).size();
            for (int j = 1; j <= i; j++) {
                if (j < pathSum.get(i - 1).size())
                    pathSum.get(i).add(triagle.get(i - 1).get(j - 1) + Math.min(pathSum.get(i - 1).get(j - 1), pathSum.get(i - 1).get(j)));
                else
                    pathSum.get(i).add(triagle.get(i - 1).get(j - 1) + pathSum.get(i - 1).get(j - 1));
            }
        }
        return IntStream.range(1, n + 1).mapToObj(i -> pathSum.get(n).get(i)).min(Integer::compareTo).get();
    }
}
