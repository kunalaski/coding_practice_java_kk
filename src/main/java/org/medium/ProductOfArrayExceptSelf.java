package org.medium;

import java.util.stream.IntStream;

public class ProductOfArrayExceptSelf {

    private static int[] productExceptSelf(int[] nums) {

        int[] preArr = new int[nums.length];
        int preProd = 1;
        preArr[0] = preProd;

        for(int i=1; i<nums.length; i++) {
            preProd = preProd*nums[i-1];
            preArr[i] = preProd;
        }

        preProd = 1;
        int prev = nums[nums.length-1];
        nums[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
            preProd = preProd*prev;
            prev = nums[i];
            nums[i] = preProd;
        }

        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i] * preArr[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1,2,4,6});
        IntStream.of(res).forEach(System.out::println);
    }

}
