package in.samratc.main.dynamicProgramming.leetCode.pratice;

public class Interleaved {
    public boolean isInterLeaved(String s1, String s2, String s3){
        if(s1 == null) s1 = "";
        if(s2 == null) s2 = "";
        if(s3 == null) s3 = "";
        int n = s1.length(), m = s2.length();
        if(n + m != s3.length())
            return false;
        boolean[][] isInterleaved = new boolean[n+1][m+1];
        isInterleaved[0][0] = true;
        for(int i = 1; isInterleaved[i-1][0] && i <=n ; i++ )
            isInterleaved[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
        for(int i = 1; isInterleaved[0][i-1] && i <=m ; i++ )
            isInterleaved[0][i] = s2.charAt(i-1) == s3.charAt(i-1);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m ;j++){
                isInterleaved[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && isInterleaved[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && isInterleaved[i][j-1]);
            }
        }
        return isInterleaved[n][m];
    }

    //Driver
    public static void main(String... args){
        Interleaved interleaved = new Interleaved();
        System.out.println(interleaved.isInterLeaved("cats", "cast", "ccaatsst"));
        System.out.println(interleaved.isInterLeaved("cats", "cast", "cacatsts"));
        System.out.println(interleaved.isInterLeaved("cats", "cast", "ccaattss"));
    }
}
