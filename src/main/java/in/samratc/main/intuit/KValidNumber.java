package in.samratc.main.intuit;

import java.util.*;
import java.util.stream.*;

// https://leetcode.com/discuss/interview-question/880798/Intuit-or-OA
public class KValidNumber {

    public static void main(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] temp = sc.nextLine().split("\\s");
            int n = Integer.parseInt(temp[0]), x = Integer.parseInt(temp[1]), k = Integer.parseInt(temp[2]);
            char[] str = sc.nextLine().toCharArray();
            for (int i = 0; i < n ; i += x)
                Arrays.sort(str, i, Math.min(n, i + x));
            StringBuilder sb = new StringBuilder();
            int i = 1;
            while (k > 0) {
                int r = k % x;
                k /= x;
                sb.append(str[n - (i*x) + r]);
                i++;
            }
            System.out.println(sb.reverse().toString());
        } catch (Exception ex) {
            System.out.println("Runtime Error");
            ex.printStackTrace();
            throw ex;
        }
    }

}

/*
1 -> 0 0 0
2 -> 0 0 1
3 -> 0 0 2
17 -> 2 2 1
n = 8   x = 3
k =     17      5       1
r =     2       2       1
sb =    851

 */
