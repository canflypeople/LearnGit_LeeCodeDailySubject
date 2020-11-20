package com.november.week.second;

import java.util.*;

public class LeeCode1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : arr2) {
            set.add(num);
        }
        int length1 = arr1.length, length2 = arr2.length;
        int[] ans = new int[length1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            if (set.contains(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int index = 0;
        for (int num : arr2) {
            for (int i = 0; i < map.getOrDefault(num, 0); i++) {
                ans[index++] = num;
            }
        }
        int[] arr = new int[length1 - index];
        int temp = 0;
        for (int num : arr1) {
            if (!set.contains(num)) {
                arr[temp++] = num;
            }
        }
        // 快速排序
        quickSort(arr, 0, arr.length - 1);
        return ans;

    }

    /**
     * 快速排序
     * @param arr
     * @param p
     * @param q
     */
    private void quickSort(int[] arr, int p, int q) {
        if (p >= q) return;
        int pivot = arr[q];
        int i = p;
        for (int j = p; j < q; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i , q);
        quickSort(arr, p, i - 1);
        quickSort(arr, i + 1, q);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
