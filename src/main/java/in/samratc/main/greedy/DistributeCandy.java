package in.samratc.main.greedy;

import java.util.ArrayList;

public class DistributeCandy {



}

class DistrbuteCandySol{

    public int solve(ArrayList<Integer> ratings){
        int n = ratings.size();
        ArrayList<Integer> candies = new ArrayList<>(n);
        if(n == 0)
            return 0;
        candies.add(1);
        for(int i = 1; i < n; i++){
            if(ratings.get(i-1) < ratings.get(i))
                candies.add(candies.get(i-1)+1);
            else
                candies.add(1);
        }
        for(int i = n-2; i >= 0; i--){
            if(ratings.get(i+1) < ratings.get(i))
                candies.set(i, candies.get(i+1) + 1);
        }
        return candies.stream().reduce(Integer::sum).get();
    }

}
