package in.samratc.main;

import sun.invoke.empty.Empty;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.net.Inet4Address;
import java.util.*;

public class Test {
    public static void main(String... args){
        int[] arr = {7,8};
        int pos = Arrays.binarySearch(arr,0, 0, 12);
        pos  = pos < 0 ? ~pos : pos;
        System.out.println(pos);

    }
}