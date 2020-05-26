package in.samratc.main.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ProductOf3 {

    public static void main(String args[]){
        System.out.println(new ProductOf3Sol().solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))));
    }

}

class ProductOf3Sol{

    public ArrayList<Integer> solve(ArrayList<Integer> nums){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> products = new ArrayList<>();
        for(int val : nums){
            if(minHeap.size() >= 3){
                if(minHeap.peek() < val){
                    minHeap.remove();
                    minHeap.add(val);
                }
            } else
                minHeap.add(val);

            if(minHeap.size() < 3)
                products.add(-1);
            else
                products.add(minHeap.stream().reduce((p,q) -> {return  p*q;}).get());
        }
        return  products;
    }

}
