package in.samratc.main.dynamicProgramming.leetCode.pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return Collections.emptyList();
        TrieNode root = new TrieNode();
        wordDict.forEach(root::addWord);
        int n = s.length();

        @SuppressWarnings("unchecked")
        List<Integer>[] breaks = new List[n + 1];
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
        dfs(0, n, breaks, new ArrayList<>(), s, res);
        return res;
    }
    
    private void dfs(int curr, int end, List<Integer>[] breaks, List<Integer> currList, String s, List<String> res) {
        currList.add(curr);
        if (curr == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currList.size() - 1; i++) {
                sb.append(s, currList.get(i), currList.get(i + 1)).append(" ");
            }
            res.add(sb.substring(0, sb.length() - 1));
        } else {
            for (int next : breaks[curr]) {
                dfs(next, end, breaks, currList, s, res);
            }
        }
        currList.remove(currList.size() - 1);
    }

    static class TrieNode {
        TrieNode[] next;
        boolean isEnd;

        TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }

        void addWord(String word) {
            TrieNode curr = this;
            for (int i = 0; i < word.length(); i++) {
                if (curr.next[word.charAt(i) - 'a'] == null)
                    curr.next[word.charAt(i) - 'a'] = new TrieNode();
                curr = curr.next[word.charAt(i) - 'a'];
            }
            curr.isEnd = true;
        }
    }

    //Driver
    public static void main(String... args){
        System.out.println(new WordBreak2().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new WordBreak2().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new WordBreak2().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
