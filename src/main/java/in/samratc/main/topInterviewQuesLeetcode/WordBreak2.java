package in.samratc.main.topInterviewQuesLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//https://leetcode.com/problems/word-break-ii/
public class WordBreak2 {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word
     * is a valid dictionary word. Return all such possible sentences.
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        wordDict.forEach(str -> addToTrie(root, str));
        int n = s.length();
        /*
            breaks[i] contains list of indices where the break can happen starting from i;
         */
        List<Integer>[] breaks = new List[n+1];
        IntStream.range(0, n+1).forEach(i -> breaks[i] = new ArrayList<>());
        breaks[n].add(n);
        for (int i = n - 1; i >= 0; i--) {
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                curr = curr.next[s.charAt(j) - 'a'];
                if (curr == null)
                    break;
                if (curr.isEnd && !breaks[j + 1].isEmpty())
                    breaks[i].add(j + 1);
            }
        }
        List<String> res = new ArrayList<>();
        dfs(0, n, new ArrayList<>(), breaks, s, res);
        return res;
    }

    private void dfs(int curr, int end, List<Integer> currList, List<Integer>[] breaks, String s, List<String> res) {
        currList.add(curr);
        if (curr == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currList.size() - 1; i++) {
                sb.append(s, currList.get(i), currList.get(i + 1)).append(" ");
            }
            res.add(sb.substring(0, sb.length() - 1));
        } else {
            for (int next : breaks[curr]) {
                dfs(next, end, currList, breaks, s, res);
            }
        }
        currList.remove(currList.size() - 1);
    }

    private void addToTrie(TrieNode root, String str) {
        TrieNode curr = root;
        for (char c : str.toCharArray()) {
            if (curr.next[c - 'a'] == null)
                curr.next[c - 'a'] = new TrieNode();
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }

    class TrieNode {
        TrieNode[] next;
        boolean isEnd;

        TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }
    }


    //Driver
    public static void main(String... args){
        System.out.println(new WordBreak2().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new WordBreak2().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new WordBreak2().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}

