package in.samratc.main.topInterviewQuesLeetcode;


//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;
        int[] count = new int[256];
        int l = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
            while(l < i && count[s.charAt(i)] > 1){
                count[l]--;
                l++;
            }
            max = Math.max(max, i-l+1);
        }
        return max;
    }
}
