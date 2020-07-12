package in.samratc.main.topInterviewQuesLeetcode;

public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] ways = new int[2];
        ways[0] =  1;
        if(s.charAt(0) >= '1' && s.charAt(0) <= '9')
            ways[1] = 1;
        else
            return 0;
        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1), prev = s.charAt(i - 2);
            if (curr == '0') {
                if (prev != '1' && prev != '2')
                    return 0;
                else
                    ways[i % 2] = ways[(i - 2) % 2];
            } else if (curr >= '1' && curr <= '9') {
                int val = 10 * (prev - '0') + (curr - '0');
                if (val >= 10 && val <= 26)
                    ways[i % 2] = ways[(i - 2) % 2] + ways[(i - 1) % 2];
                else
                    ways[i % 2] = ways[(i - 1) % 2];
            } else{
                return 0;
            }
        }
        return ways[n % 2];
    }
}
