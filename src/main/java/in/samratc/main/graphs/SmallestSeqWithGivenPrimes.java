package in.samratc.main.graphs;

import java.util.*;

public class SmallestSeqWithGivenPrimes {
    public ArrayList<Integer> solve(int a, int b, int c, int d) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        q.add(a); q.add(b); q.add(c);
        set.add(a); set.add(b); set.add(c);
        while(ans.size() < d){
            int curr = q.remove();
            ans.add(curr);
            if(!set.contains(curr * a)){
                set.add(curr * a);
                q.add(curr * a);
            }
            if(!set.contains(curr * b)){
                set.add(curr * b);
                q.add(curr * b);
            }
            if(!set.contains(curr * c)){
                set.add(curr * c);
                q.add(curr * c);
            }
        }
        return new ArrayList<>(ans.subList(0, d));
    }
}
