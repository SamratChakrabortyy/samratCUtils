package in.samratc.main.dynamicProgramming.leetCode.pratice;


import java.util.Stack;
import java.util.stream.IntStream;

//https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix[0].length, max = 0;
        int[] heights = new int[n];
        for (char[] arr : matrix) {
            IntStream.range(0, n).forEach(i -> heights[i] = arr[i] == '0' ? 0 : heights[i] + 1);
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    private int largestHistogramArea(int[] heights) {
        int n = heights.length;
        int[] leftMin = new int[n], rightMin = new int[n];
        leftMin[0] = -1;
        rightMin[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = leftMin[p];
            leftMin[i] = p;
        }
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i])
                p = rightMin[p];
            rightMin[i] = p;
        }
        /*System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMin));*/
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (rightMin[i] - leftMin[i] - 1));
        }
        return max;
    }

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

    //Driver
    public static void main(String... args) {

        System.out.println(new MaximalRectangle().largestHistogramArea(new int[]{0, 0, 2, 2, 2, 3, 2, 1, 4, 0}));
        char[][] arr = {{'0', '1', '1', '0', '0', '1', '0', '1', '0', '1'},
                {'0', '0', '1', '0', '1', '0', '1', '0', '1', '0'},
                {'1', '0', '0', '0', '0', '1', '0', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0', '1', '1', '1', '1', '0'},
                {'0', '0', '0', '1', '1', '0', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '1', '0', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '1', '0', '1', '0', '1', '1'}};
        System.out.println(new MaximalRectangle().maximalRectangle(arr));
    }
}

class Pair<E,F>{
    public E val1;
    public F val2;

    public Pair(E e, F f){
        this.val1 = e;
        this.val2 = f;
    }

    public String toString(){
        return String.format("(%s, %s)", this.val1, this.val2);
    }
}
