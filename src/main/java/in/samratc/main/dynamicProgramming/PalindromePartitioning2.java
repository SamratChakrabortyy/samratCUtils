package in.samratc.main.dynamicProgramming;

import java.util.stream.IntStream;

public class PalindromePartitioning2 {
    public static void main(String... args){
        System.out.println(new PalindromePartitioning2Sol().minCut("abc"));
    }
}

class PalindromePartitioning2Sol {

    public int minCut(String str) {
        int n = str.length();
        boolean[][] isPal;
        isPal = new boolean[n][n];
        calculateIsPal(str, isPal);
        int[] cuts = new int[n];
        cuts[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            if(isPal[i][n-1]){
                cuts[i] = 0;
                continue;
            }
            cuts[i] = (int)1e7;
            for(int j = i; j < n; j++){
                if(isPal[i][j])
                    cuts[i] = Math.min(cuts[i], 1 + cuts[j+1]);
            }
        }
        return cuts[0];
    }

    private void calculateIsPal(String str, boolean[][] isPal) {
        int n = str.length();
        String rev = new StringBuilder(str).reverse().toString();
        IntStream.range(0, n).forEach(i -> isPal[i][i] = true);
        IntStream.range(0, n-1).forEach(i -> isPal[i][i+1] = str.charAt(i) == str.charAt(i+1));

        for(int l = 3; l <= n; l++){
            for(int i = 0; i <= n - l; i++){
                int j = i + l -1;
                if(str.charAt(i) == str.charAt(j))
                    isPal[i][j] = isPal[i+1][j-1];
                else
                    isPal[i][j] = false;
            }
        }
    }

}

