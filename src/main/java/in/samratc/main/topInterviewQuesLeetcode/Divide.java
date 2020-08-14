package in.samratc.main.topInterviewQuesLeetcode;

// https://leetcode.com/problems/divide-two-integers/
public class Divide {
    public int divide(int dividend, int divisor) {
        int sign = 0;
        if(dividend == 0)
            return 0;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;
        long num = Math.abs((long)dividend), dino = Math.abs((long)divisor);
        long l = 0, r = 1L + Integer.MAX_VALUE, ans = 0;
        while(l <= r){
            long mid = l + (r - l)/ 2;
            if(isSmaller(num, dino, mid)){
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        if(sign < 0)
            ans = -ans;
        return ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) ans;
    }

    private boolean isSmaller(long dividend, long divisor, long count){
        long res = 0;
        while(res <= dividend && count > 0){
            if((count & 1) == 1)
                res += divisor;
            count = count >> 1;
            divisor = divisor << 1;
        }
        return res <= dividend;
    }
}
