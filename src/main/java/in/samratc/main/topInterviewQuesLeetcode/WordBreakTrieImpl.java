package in.samratc.main.topInterviewQuesLeetcode;

import java.util.List;

public class WordBreakTrieImpl {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict)
            addToTrie(root, word);
        int n = s.length();
        boolean[] isBreak = new boolean[n];
        isBreak[0] = true;
        for (int i = n - 1; i >= 0; i--) {
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                curr = curr.next[s.charAt(j) - 'a'];
                if (curr == null)
                    break;
                if (curr.isEnd && isBreak[j + 1]) {
                    isBreak[i] = true;
                    break;
                }
            }
        }
        return isBreak[0];
    }

    private void addToTrie(TrieNode root, String str) {
        if (str == null || str.length() == 0)
            return;
        TrieNode curr = root;
        for (char c : str.toCharArray()) {
            if (curr.next[c - 'a'] == null)
                curr.next[c - 'a'] = new TrieNode();
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }
}

class TrieNode {
    TrieNode[] next;
    boolean isEnd;

    TrieNode(){
        next = new TrieNode[26];
        isEnd = false;
    }
}
