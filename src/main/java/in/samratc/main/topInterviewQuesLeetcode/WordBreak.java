package in.samratc.main.topInterviewQuesLeetcode;

import java.util.*;

public class WordBreak {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *  The same word in the dictionary may be reused multiple times in the segmentation.
     *  You may assume the dictionary does not contain duplicate words.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        List<Integer> breakPoints = new ArrayList<>();
        breakPoints.add(0);
        for(int i = 0; i < s.length(); i++){
            for(int j = breakPoints.size() - 1; j >= 0; j--){
                if(dict.contains(s.substring(breakPoints.get(j), i+1))) {
                    breakPoints.add(i+1);
                    break;
                }
            }
        }
        return breakPoints.get(breakPoints.size() - 1) == s.length();
    }


    //Driver
    public static void main(String... args){
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}
