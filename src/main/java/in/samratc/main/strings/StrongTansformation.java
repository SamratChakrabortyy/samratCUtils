package in.samratc.main.strings;

import java.util.Arrays;

public class StrongTansformation {
    /**
     * Rick and Morty are best friends. Rick and Morty will change their name to strings A and B respectively.
     *
     * They want to know if it is possible to transform A into B by doing zero or more conversions.
     *
     * In one conversion you can convert all occurrences of one character in A to any other lowercase English character.
     */

    public int solve(String a, String b) {
        if(isEmpty(a) && isEmpty(b))
            return 1;
        if((isEmpty(a) || isEmpty(b)) || a.length() != b.length())
            return 0;
        if(a.equals(b))
            return 1;
        int[] mapsTo = new int[26];
        Arrays.fill(mapsTo, -1);
        for(int i = 0; i < a.length(); i++){
            if(mapsTo[a.charAt(i) - 'a'] != -1 && mapsTo[a.charAt(i) - 'a'] != b.charAt(i) - 'a')
                return 0;
            mapsTo[a.charAt(i) - 'a'] = b.charAt(i) - 'a';
        }
        for(int mapped : mapsTo){
            if(mapped == -1)
                return 1;
        }
        return 0;
    }

    public static boolean isEmpty(String s){
        return s == null || s.length() == 0;
    }
}
