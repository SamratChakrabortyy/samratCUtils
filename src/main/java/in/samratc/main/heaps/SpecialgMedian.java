package in.samratc.main.heaps;

import java.util.*;

public class SpecialgMedian {

    public static void main(String... args){
        System.out.println(new SpecialMedianSol().solve(new ArrayList<Integer>(Arrays.asList(2147483647, -2147483648, 0))));
    }

}


class SpecialMedianSol {

    public int solve(ArrayList<Integer> list){
        int n = list.size();
        ArrayList<Double> runningMedianLeft = getRunningMedian(list);
        ArrayList<Integer> revList = new ArrayList<>(list);
        Collections.reverse(revList);
        ArrayList<Double> runningMedianRight = getRunningMedian(revList);
        Collections.reverse(runningMedianRight);
        //System.out.println(list);
        //System.out.println(runningMedianLeft);
        //System.out.println(runningMedianRight);
        for(int i = 0; i < n; i++){
            if(i != 0 && runningMedianLeft.get(i-1) - list.get(i) == 0)
                return 1;
            if(i != n-1 && runningMedianRight.get(i+1) - list.get(i) == 0)
                return 1;
        }
        return 0;
    }

    public ArrayList<Double> getRunningMedian(ArrayList<Integer> a) {
        int n = a.size();

        //Creating Max Heap for the elements <= Median and MinHeap for elements > median( note that the max size for this heap can be n/2 + 1)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n/2 +1, (p, q) -> Integer.compare(q,p));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n/2 +1);

        //Median list starting from left
        ArrayList<Double> runningMedian = new ArrayList<>(n);

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
            if(maxHeap.size() > minHeap.size())
                runningMedian.add(maxHeap.peek().doubleValue());
            else
                runningMedian.add(((double)maxHeap.peek() + minHeap.peek())/2.0);
        }


        return runningMedian;
    }

}