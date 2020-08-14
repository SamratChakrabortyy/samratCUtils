package in.samratc.main.notepadPractice;

public class InterLeavingString {

    public boolean isInterleaved(String s1, String s2, String s3){
        // Replacing null String with empty String
        if(s1 == null) s1 = "";
        if(s2 == null) s2 = "";
        if(s3 == null) s3 = "";

        if(s3.equals(s1 + s2) || s3.equals(s2 + s1))
            return true;

        int n = s1.length(), m = s2.length();

        // Sum of the length of 1st 2 should be equall to the third
        if(n + m != s3.length())
            return false;


		/*
			isInterleaved[i][j] represents if we can form s3[0, (i+j)] using s1[0, i] and s2[0, j]
		*/
        boolean[][] isInterleaved = new boolean[n+1][m+1];

        // Base conditions
        isInterleaved[0][0] = true;
        for(int i = 1; isInterleaved[i-1][0] && i <= n; i++)
            isInterleaved[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
        for(int i = 1; isInterleaved[0][i-1] && i <= m; i++)
            isInterleaved[0][i] = s2.charAt(i-1) == s3.charAt(i-1);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                isInterleaved[i][j] = (s2.charAt(j-1) == s3.charAt(i + j -1) && isInterleaved[i][j-1]) || (s1.charAt(i-1) == s3.charAt(i + j -1) && isInterleaved[i-1][j]);
            }
        }

        return isInterleaved[n][m];
    }

    public static void main(String... args){
        InterLeavingString interLeavingString = new InterLeavingString();
        System.out.println(interLeavingString.isInterleaved("ab", "aa", "aaab"));
        System.out.println(interLeavingString.isInterleaved("ab", "aa", "baaa"));
    }
}
