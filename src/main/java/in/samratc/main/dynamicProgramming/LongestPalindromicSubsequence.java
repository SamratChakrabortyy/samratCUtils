package in.samratc.main.dynamicProgramming;

public class LongestPalindromicSubsequence {

    public static void main(String... args){
        String str = "bebeeed";
        System.out.println(new LongestCommonSubsequenceSol().solve(str, new StringBuilder(str).reverse().toString()));
    }

}
