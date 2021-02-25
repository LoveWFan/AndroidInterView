package com.poney.androidinterview.suanfa.sort;

/**
 * @author feibiao.ma
 * @project AndroidInterView
 * @package_name com.poney.androidinterview.suanfa.sort
 * @date 2021/1/20
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 8, 4, 5, 7, 9};
        mergeSort(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }

    static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        for (; i <= mid && j <= end; k++) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int l = 0; l < k; l++) {
            nums[start + l] = temp[l];
        }
    }

}
