package com.poney.androidinterview.suanfa.sort;

/**
 * @author feibiao.ma
 * @project AndroidInterView
 * @package_name com.poney.androidinterview.suanfa.sort
 * @date 2021/1/20
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 8, 4, 5, 7, 9, -77};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }

    static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = patition(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private static int patition(int[] nums, int start, int end) {
        int privot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= privot)
                end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= privot)
                start++;
            nums[end] = nums[start];
        }

        nums[start] = privot;
        return start;
    }


}
