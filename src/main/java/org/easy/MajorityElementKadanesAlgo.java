package org.easy;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2

public class MajorityElementKadanesAlgo {

    public static int majorityElement(int[] nums) {
        int freq = 0;
        int maj = -1;
        for(int i=0; i<nums.length; i++) {
            if(freq == 0) {
                maj = nums[i];
            }
            if(nums[i] == maj) {
                freq += 1;
            } else {
                freq -= 1;
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        assert majorityElement(new int[]{3,2,3}) == 3;
        assert majorityElement(new int[]{2,2,1,1,1,2,2}) == 2;
        System.out.println("Test cases passed!!!");
    }
}
