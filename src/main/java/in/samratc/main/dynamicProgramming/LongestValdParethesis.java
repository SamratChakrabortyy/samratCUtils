package in.samratc.main.dynamicProgramming;

public class LongestValdParethesis {
    public static void main(String... ars){
        System.out.println(new LongestValdParethesisSol().longestValidParentheses("(()))(()(()))()(()("));
    }
}
class LongestValdParethesisSol {
    public int longestValidParentheses(String str) {
        int n = str.length(), max = 0;
        int[] valParLen = new int[n];
        valParLen[0] = 0;
        for(int i = 1; i < n; i++){
            if(str.charAt(i) == '(')
                continue;
            int l = i - valParLen[i-1] - 1;
            if(l >= 0 && str.charAt(l) == '('){
                valParLen[i] = valParLen[i-1] + 2;
                if(l - 1 >= 0)
                    valParLen[i] += valParLen[l - 1];
            }
            max = Math.max(max, valParLen[i]);
        }
        //System.out.println(Arrays.toString(valParLen));
        return max;
    }
}
