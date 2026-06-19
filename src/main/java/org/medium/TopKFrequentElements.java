package org.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freqList = new ArrayList[nums.length+1];
        
        freqMap.forEach((key, value) -> {
             if(freqList[value] == null) freqList[value] = new ArrayList<>();
             freqList[value].add(key);
        });
        int[] res = new int[k];
        int j = 0;
        for (int i = freqList.length-1; i>=0; i--) {
            if(freqList[i] != null) {
                for(int val : freqList[i]) {
                    if(j>=k) return res;
                    res[j] = val;
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ans = topKFrequentElements.topKFrequent(new int[]{5,1,-1,-8,-7,8,-5,0,1,10,8,0,-4,3,-1,-1,4,-5,4,-3,0,2,2,2,4,-2,-4,8,-7,-7,2,-8,0,-8,10,8,-8,-2,-9,4,-7,6,6,-1,4,2,8,-3,5,-9,-3,6,-8,-5,5,10,2,-5,-1,-5,1,-3,7,0,8,-2,-3,-1,-5,4,7,-9,0,2,10,4,4,-4,-1,-1,6,-8,-9,-1,9,-9,3,5,1,6,-1,-2,4,2,4,-6,4,4,5,-5}, 7);
        IntStream.of(ans).forEach(System.out::println);
    }
}
