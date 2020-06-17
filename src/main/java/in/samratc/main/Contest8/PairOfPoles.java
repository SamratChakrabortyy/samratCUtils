package in.samratc.main.Contest8;

import java.util.ArrayList;
import java.util.List;

public class PairOfPoles {
}

class PairOfPolesSol {
    public int solve(ArrayList<Integer> poles) {
        int n = poles.size();
        List<Long> prefixSum = new ArrayList<>();
        prefixSum.add(0L);
        for(int i = 1; i <= n; i++)
            prefixSum.add(prefixSum.get(i-1) + poles.get(i-1));
        int count = n-1;
        return count;
    }
}

