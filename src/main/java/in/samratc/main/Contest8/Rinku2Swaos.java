package in.samratc.main.Contest8;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;

public class Rinku2Swaos {
    public static void main(String... args){
        System.out.println(new Rinku2SwaosSol().solve(Arrays.asList(2, 1, 6, 5, 7 , 9, 12)));
    }
}

class Rinku2SwaosSol{
    public String solve(List<Integer> nums) {
        int n = nums.size();
        List<Integer> sortedNums = nums.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        Map<Integer, Integer> posMap = IntStream.range(0, n).boxed().collect(Collectors.toMap(i-> sortedNums.get(i), i-> i));
        long misplaced = IntStream.range(0, n).filter(i -> !sortedNums.get(i).equals(nums.get(i))).count();
        if(misplaced > 4 || misplaced < 3)
            return "No";
        if(misplaced == 3){
            for(int i = 0; i < n; i++){
                if(!sortedNums.get(i).equals(nums.get(i))){
                    if(sortedNums.get(i) == nums.get(posMap.get(nums.get(posMap.get(nums.get(i))))))
                        return "Yes";
                    else
                        return "No";
                }
            }
        } else {
            for(int i = 0; i < n; i++){
                if(!sortedNums.get(i).equals(nums.get(i))){
                    if(sortedNums.get(i) == nums.get(posMap.get(nums.get(i))))
                        return "Yes";
                    else
                        return "No";
                }
            }
        }
        return "No";
    }
}
