package in.samratc.main.topInterviewQuesLeetcode;

import java.util.Arrays;
import java.util.Comparator;


// https://leetcode.com/problems/merge-intervals/
public class MergeItervals {
    public int[][] merge(int[][] intervals) {
        int [][] ans = new int[intervals.length][2];
        //sort by start
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int j = 0;
        for(int i = 0; i < intervals.length; i++){
            int[] arr = intervals[i];
            while(i < intervals.length - 1 && intervals[i+1][0] <= arr[1]){
                arr[0] = Math.min(arr[0], intervals[i+1][0]);
                arr[1] = Math.max(arr[1], intervals[i+1][1]);
                i++;
            }
            ans[j++] = arr;
        }
        return Arrays.copyOfRange(ans, 0, j);
    }
}
