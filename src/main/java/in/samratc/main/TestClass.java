package in.samratc.main;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());

            String out_ = Solve(N);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static String Solve(int n){ // n = 8 output = 445
        int dig = (int)Math.ceil(Math.log(n+2)/Math.log(2)) - 1;  // dig = 3
        //System.out.println(dig);
        int noLeft = (1 << dig) - 2;
        String bin = Integer.toBinaryString(n - noLeft - 1);
        StringBuilder sb = new StringBuilder();

        for(int i = bin.length() - 1; i >= 0; i--){
            sb.append((bin.charAt(i) == '1' ? '5' : '4'));
        }
        for(int i = 1; i <= dig - bin.length(); i++)
            sb.append('4');
        String lst = sb.toString();
        sb.reverse();
        sb.append(lst);
        return sb.toString();
    }
}