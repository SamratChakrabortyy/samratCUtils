package in.samratc.main.Stack;

import in.samratc.util.Pair;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int n = heights.length, max = 0;
        Stack<Pair<Integer, Integer>> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            int h = heights[i], start = i;
            while(!stk.empty() && stk.peek().val2 > h){
                Pair<Integer, Integer> top = stk.pop();
                max = Math.max(max, top.val2 * (i - top.val1));
                start = top.val1;
            }
            stk.push(new Pair<Integer, Integer>(start, h));
        }
        while(!stk.empty()){
            Pair<Integer, Integer> top = stk.pop();
            max = Math.max(max, top.val2 * (n - top.val1));
        }
        return max;
    }
}
