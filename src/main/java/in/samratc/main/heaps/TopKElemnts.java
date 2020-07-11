package in.samratc.main.heaps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKElemnts {
    public static void main(String... args){
        System.out.println(new TopKElemntsSol().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}

class TopKElemntsSol {
    Map<String, Long> freqMap;

    public List<String> topKFrequent(String[] words, int k) {
        // IP Validation
        if (words == null || words.length == 0)
            return new ArrayList<String>();
        freqMap = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        PriorityQueue<String> pq = new PriorityQueue<>(k);
        for (String str : freqMap.keySet()) {
            if (pq.size() < k)
                pq.add(str);
            else {
                if (compareElem(str, pq.peek()) > 0) {
                    pq.remove();
                    pq.add(str);
                }
            }
        }
        List<String> res = new ArrayList<>(pq);
        return res;

    }

    private int compareElem(String str1, String str2) {
        return freqMap.get(str1) == freqMap.get(str2) ? str2.compareTo(str1) : Long.compare(freqMap.get(str1), freqMap.get(str2));
    }
}

