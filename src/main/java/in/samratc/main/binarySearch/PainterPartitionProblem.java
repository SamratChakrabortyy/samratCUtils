package in.samratc.main.binarySearch;

import java.util.Arrays;

public class PainterPartitionProblem {
    /**
     * Given 2 integers A and B and an array of integars C of size N.
     * Element C[i] represents length of i'th board.
     * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.
     * Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
     */
    public int paint(int a, int b, int[] c) {
        int l = 0, r = Arrays.stream(c).sum(), ans = 0;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(isPossible(mid, a, c)){
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return (int)Math.ceil((double)ans / b);
    }

    private boolean isPossible(int size, int a, int[] c){
        int painterCount = 0, currLen = 0;
        for (int value : c) {
            currLen += value;
            if (currLen > size) {
                painterCount++;
                currLen = value;
                if (painterCount > a)
                    return false;
            }
        }
        return painterCount <= a;
    }
}

