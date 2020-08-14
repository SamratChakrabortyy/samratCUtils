package in.samratc.main.notepadPractice;


//https://leetcode.com/problems/permutation-in-string/

import java.util.Arrays;

public class PermutationInString {
    private static final int mod = (int) 1e9 + 7;

    public boolean checkInclusion(String s1, String s2) {
        if (Utils.isEmpty(s1))
            return true;
        if (Utils.isEmpty(s2))
            return Utils.isEmpty(s1);
        if (s2.length() < s1.length())
            return false;
        int n = s1.length(), m = s2.length();
        int hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++) {
            hash1 = (hash1 + s1.charAt(i)) % mod;
            hash2 = (hash2 + s2.charAt(i)) % mod;
        }
        if (hash1 == hash2 && Utils.isAnnagram(s1, s2.substring(0, n)))
            return true;
        for (int l = 0, r = n; r < m; r++, l++) {
            hash2 = (hash2 - s2.charAt(l) + s2.charAt(r)) % mod;
            if (hash1 == hash2 && Utils.isAnnagram(s1, s2.substring(l + 1, r + 1)))
                return true;
        }

        return false;
    }

}

class Utils {

    public static boolean isAnnagram(String s1, String s2) {
        int[] count1 = new int[26], count2 = new int[26];
        s1.chars().map(i -> i - 'a').forEach(i -> count1[i]++);
        s2.chars().map(i -> i - 'a').forEach(i -> count2[i]++);

        return Arrays.equals(count1, count2);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
