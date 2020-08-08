package in.samratc.main.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionSystem {
}

class SearchSuggestionSystemSol {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        for (String str : products)
            insert(root, str);
        return search(root, searchWord);
    }

    private void insert(TrieNode root, String str) {
        if (root == null)
            return;
        TrieNode t = root;
        for (char c : str.toCharArray()) {
            if (t.next[c - 'a'] == null)
                t.next[c - 'a'] = new TrieNode();
            t = t.next[c - 'a'];
            if (t.sug.size() < 3)
                t.sug.add(str);
        }
    }

    private List<List<String>> search(TrieNode root, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (root != null)
                root = root.next[c - 'a'];
            res.add(root == null ? Collections.emptyList() : root.sug);
        }
        return res;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    List<String> sug = new ArrayList<>();
}
