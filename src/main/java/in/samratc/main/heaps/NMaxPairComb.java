package in.samratc.main.heaps;

import java.util.*;
import java.util.stream.Collectors;

public class NMaxPairComb {

    public static void main(String... args){
        System.out.println(new NMaxPairCombSol().solve2(new ArrayList<Integer>(Arrays.asList(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28 )),
                new ArrayList<Integer>(Arrays.asList(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43 ))));
    }

}

class NMaxPairCombSol {

    public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = a.size();
        PriorityQueue<Long> minHeap = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minHeap.size() < n) {
                    minHeap.add((long) a.get(i) + b.get(j));
                } else {
                    long curr = (long) a.get(i) + b.get(j);
                    if (curr > minHeap.peek()) {
                        minHeap.remove();
                        minHeap.add(curr);
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(n);
        minHeap.stream().forEach(i -> ans.add(i.intValue()));
        Collections.reverse(ans);
        return ans;
    }

    public ArrayList<Integer> solve2(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = a.size();
        Collections.sort(a, (p, q) -> Integer.compare(q, p));
        Collections.sort(b, (p, q) -> Integer.compare(q, p));
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((p, q) -> Integer.compare(q.get(0), p.get(0)));
        Set<List<Integer>> visited = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>(n);
        if(n == 0)
            return ans;
        System.out.println(a);
        System.out.println(b);
        maxHeap.add(Arrays.asList(a.get(0) + b.get(0), 0, 0));
        visited.add(Arrays.asList(0,0));
        for(int i = 0; i < n; i++){
            List<Integer> currMax = maxHeap.remove();
            ans.add(currMax.get(0));
            int x = currMax.get(1), y = currMax.get(2);
            if(x < n-1 && !visited.contains(Arrays.asList(x+1, y))){
                maxHeap.add(Arrays.asList(a.get(x+1) + b.get(y), x+1, y));
                visited.add(Arrays.asList(x+1,y));
            }
            if(y < n-1 && !visited.contains(Arrays.asList(x, y+1))) {
                maxHeap.add(Arrays.asList(a.get(x) + b.get(y + 1), x, y + 1));
                visited.add(Arrays.asList(x,y+1));
            }
        }
        return ans;
    }
}
