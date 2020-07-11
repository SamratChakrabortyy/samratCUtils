package in.samratc.main.graphs;


import java.util.*;

/**
 * Problem: https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder {
    public static void main(String... args) {
        System.out.println(new WordLadderSol().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}

class WordLadderSol {
    /**
     * Given two words (start and end), and a dictionary's word list, find all shortest transformation sequence(s) from start to end, such that:
     * <p>
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that start is not a transformed word.
     * Note:
     * <p>
     * Return an empty list if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume start and end are non-empty and are not the same.
     */
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        // I/P validation
        if (start == null || end == null || wordList == null || wordList.isEmpty())
            return new ArrayList<List<String>>();
        //Creating Adjacency List
        Map<String, List<String>> neighbors = new HashMap<>();
        List<String> words = new ArrayList<>(wordList);
        words.add(start);
        Map<String, Integer> distance = new HashMap<>();//distance of each string from start
        List<List<String>> res = new ArrayList<>();
        bfs(start, end, words, neighbors, distance);
        /*System.out.println(neighbors);
        System.out.println(distance);*/
        dfs(start, end, new ArrayList<String>(), neighbors, distance, res, distance.get(end));
        return res;
    }

    private void dfs(String curr, String end, ArrayList<String> currList, Map<String, List<String>> neighbors, Map<String, Integer> distance, List<List<String>> res, Integer maxSize) {
        if(currList.size() > maxSize)
            return;
        currList.add(curr);
        if (curr.equals(end)) {
            res.add(new ArrayList<String>(currList));
            currList.remove(currList.size() - 1);
            return;
        }
        for (String neighbor : neighbors.get(curr)) {
            if (distance.get(neighbor) == distance.get(curr) + 1) {
                dfs(neighbor, end, currList, neighbors, distance, res, maxSize);
            }
        }
        currList.remove(currList.size() - 1);
    }

    private void bfs(String start, String end, List<String> words, Map<String, List<String>> neighbors, Map<String, Integer> distance) {
        for (String word : words) {
            neighbors.put(word, new ArrayList<String>());
        }
        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.size(); j++){
                if(isAnagarmDist1(words.get(i), words.get(j))){
                    neighbors.get(words.get(i)).add(words.get(j));
                    //neighbors.get(words.get(j)).add(words.get(i));
                }
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);
        distance.put(start, 0);
        boolean foundEnd = false;
        while (!foundEnd && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size && !foundEnd; i++) {
                String curr = q.remove();
                for (String str : neighbors.get(curr)) {
                    if (!distance.containsKey(str) ) {
                        distance.put(str, distance.get(curr) + 1);
                        q.add(str);
                        if (str.equals(end))
                            foundEnd = true;
                    }
                }
            }
        }
    }


    private boolean isAnagarmDist1(String str1, String str2) {
        int[] count1 = new int[26], count2 = new int[26];
        str1.chars().forEach(i -> count1[i - 'a']++);
        str2.chars().forEach(i -> count2[i - 'a']++);
        int mismatchCount = 0;
        for (int i = 0; i < 26; i++) {
            mismatchCount += Math.abs(count1[i] - count2[i]);
            if (mismatchCount > 2)
                return false;
        }
        return mismatchCount == 2;
    }
}
