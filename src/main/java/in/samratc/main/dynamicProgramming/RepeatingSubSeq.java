package in.samratc.main.dynamicProgramming;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RepeatingSubSeq {
    public static void main(String... argss){
        System.out.println(new RepeatingSubSeqSol().anytwo("abab"));
    }
}

class RepeatingSubSeqSol {
    public int anytwo(String str) {
        int n = str.length();
        if (n == 0)
            return 0;
        int[][] subSeqLen = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                subSeqLen[i][j] = str.charAt(i - 1) == str.charAt(j - 1) && i != j ? 1 + subSeqLen[i - 1][j - 1] : Math.max(subSeqLen[i - 1][j], subSeqLen[i][j - 1]);
            }
        }
        Arrays.stream(subSeqLen).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return subSeqLen[n][n] >= 2 ? 1 : 0;
    }
}
