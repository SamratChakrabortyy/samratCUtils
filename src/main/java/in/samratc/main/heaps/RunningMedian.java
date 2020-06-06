package in.samratc.main.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String... args){
        System.out.println(new RunningMedianSol().solve(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 4, 3))));
    }

}

/*
    In case of Running median we are creating two different Heaps one Max another Min. Max for the elements <= median and Min for elements > median
    Whenever we encounter a new number from the Stream then we add them to one of the heap.

    After addition we check if the Max and Min are balanced i.e. Max heap is greater than the Min at most by one
    If not then we remove from the head from one of the heap and insert it the other.

    The median is the top of the MaxHeap (as per the requirement of the question) but that can vary if we need to return the mean of the two middle elements
    of the array in that case the median will be mean of the top of Max and Min
*/

class RunningMedianSol{

    public ArrayList<Integer> solve(ArrayList<Integer> a) {
        int n = a.size();

        //Creating Max Heap for the elements <= Median and MinHeap for elements > median( note that the max size for this heap can be n/2 + 1)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n/2 +1, (p,q) -> Integer.compare(q,p));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n/2 +1);

        //Answer List
        ArrayList<Integer> c = new ArrayList<>(n);

        //Val is the number coming from the Stream
        for(int val : a){

            //For the very first elements
            if(maxHeap.size() == 0)
                maxHeap.add(val);
            else{
                int median = maxHeap.peek();
                if(val <= median)
                    maxHeap.add(val);
                else
                    minHeap.add(val);

                //As per our logic the size of maxHeap >= minHeap so if minHeap.size > maxHeap.size of the maxHeap.size - minHeap > 1 then we need to balance
                //the heaps
                if(minHeap.size() > maxHeap.size() || maxHeap.size() - minHeap.size() > 1){
                    if(minHeap.size() > maxHeap.size())
                        maxHeap.add(minHeap.remove());
                    else
                        minHeap.add(maxHeap.remove());
                }
            }
            c.add(maxHeap.peek());
        }
        return c;
    }

}
