package org.medium;

public class QuickSort {

    private static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low<high) {
            int p = partition(nums, low, high);

            quickSort(nums, p+1, high);
            quickSort(nums, low, p-1);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low-1;

        for (int j=low; j<high; j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        sortArray(new int[]{10,9,1,1,1,2,3,1});
        sortArray(new int[]{5,10,2,1,3});
    }

}
