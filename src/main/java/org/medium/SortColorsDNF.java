package org.medium;

import java.util.stream.IntStream;

public class SortColorsDNF {

    private static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid<=high) {
            if(nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,0,1};
        sortColors(nums);
        IntStream.of(nums).forEach(System.out::println);
    }

}
