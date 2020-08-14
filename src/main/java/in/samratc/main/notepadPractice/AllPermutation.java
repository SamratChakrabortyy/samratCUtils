package in.samratc.main.notepadPractice;

import java.util.*;

public class AllPermutation {
    private List<String> allPermutations;
    public List<String> allPermutations(String s){
        if(s == null || s.length() == 0)
            return Collections.emptyList();
        allPermutations = new ArrayList<>();
        generatePermutaions(s.toCharArray(), 0);
        return allPermutations;
    }

    private void generatePermutaions(char[] arr, int idx){
        int n = arr.length;

        if(idx == n){
            allPermutations.add(new String(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = idx; i < n; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                swap(arr, idx, i);
                generatePermutaions(arr, idx + 1);
                swap(arr, idx, i);
            }
        }
    }

    private void swap(char[] arr, int a, int b){
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String... args){
        AllPermutation per = new AllPermutation();
        System.out.println(per.allPermutations("abc"));

        System.out.println(per.allPermutations("abcb"));
    }


}
