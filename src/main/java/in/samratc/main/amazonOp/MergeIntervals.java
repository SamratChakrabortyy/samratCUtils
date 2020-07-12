package in.samratc.main.amazonOp;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > intervals[i][1])
                intervals[i] = new int[]{intervals[i][1], intervals[i][0]};
        }
        //sort by start
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int j = 0;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            while (i < n - 1 && end >= intervals[i + 1][0]) {
                i++;
                end = Math.max(end, intervals[i][1]);
            }
            ans[j++] = new int[]{start, end};
        }
        return Arrays.copyOfRange(ans, 0, j);
    }
}
