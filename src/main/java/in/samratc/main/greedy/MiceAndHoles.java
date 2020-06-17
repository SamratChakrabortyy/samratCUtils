package in.samratc.main.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class MiceAndHoles {
}

class MiceAndHolesSol {
    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        int n = mice.size();
        if (n == 0)
            return 0;
        Collections.sort(mice);
        Collections.sort(holes);
        //int max = Integer.MIN_VALUE;
        return IntStream.range(0, n).map(i -> Math.abs(mice.get(i) - holes.get(i))).max().getAsInt();
    }
}
