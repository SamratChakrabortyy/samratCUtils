package in.samratc.main.intuit;
import java.util.*;
import java.util.stream.*;

public class SubStringCalculator {

    //new hashset
    public static Set<String> seen = new HashSet();

    public long subStringCount(String s) {
        if(s == null || s.length() == 0)
            return 0L;
        int n = s.length();
        Set<String>[] sets = new Set[n];
        IntStream.range(0, n).forEach(i -> sets[i] = new HashSet<>());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                sets[i].add(s.substring(j, n - (i - j) ));
            }
        }
        return Arrays.stream(sets).map(Set::size).reduce(Integer::sum).get();
    }

    public static int backtrack(String s, int cnt){
        if(seen.contains(s) || s.length() == 0)
            return 0;

        if(!seen.contains(s))
            seen.add(s.toString());

        if(s.length() == 1)
            return 1;

        return (1 + backtrack(s.substring(0, s.length()-1), cnt)    +
                backtrack(s.substring(1, s.length()), cnt))     +
                backtrack(s.substring(1, s.length()-1), cnt);

    }

    public static void main(String... args) {
        System.out.println(new SubStringCalculator().subStringCount("bcraaafg"));
        System.out.println(SubStringCalculator.backtrack("bcraaafg", 0));
    }

}


/*
        bcraaafg -> 28 - 1 . 27
 */