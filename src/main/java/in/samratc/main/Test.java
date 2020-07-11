package in.samratc.main;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String... args){
        int[] arr = {5,7,8};
        System.out.println(Arrays.binarySearch(arr,0, arr.length, 6));
    }
}
