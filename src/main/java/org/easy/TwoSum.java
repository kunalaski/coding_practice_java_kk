package org.easy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] ans = new int[2];

        for (int i=0; i<nums.length; i++) {
            int val = target - nums[i];
            if(numMap.get(val) != null) {
                ans[0] = numMap.get(val);
                ans[1] = i;
                break;
            }
            numMap.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {

        // Basic case: [2,7,11,15], target=9 → [0,1]
        assert Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}) : "Test 1 failed";

        // Middle elements: [3,2,4], target=6 → [1,2]
        assert Arrays.equals(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}) : "Test 2 failed";

        // Duplicates: [3,3], target=6 → [0,1]
        assert Arrays.equals(twoSum(new int[]{3, 3}, 6), new int[]{0, 1}) : "Test 3 failed";

        System.out.println("All tests passed!");
    }
}