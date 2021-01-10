package in.samratc.main.twoPointer;

public class LongestSubstringWithoutRepeatingCharacters {

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int low = 0, high = 0, count[] = new int[256], max = 0;
        for(high = 0; high < s.length(); high++){
            while(low<high && count[s.charAt(high)] != 0){
                count[s.charAt(low)]--;
                low++;
            }
            count[s.charAt(high)]++;
            max = Math.max(high - low + 1, max);
        }
        return max;
    }
    /*
            s = abcbcaccb
     */

}
