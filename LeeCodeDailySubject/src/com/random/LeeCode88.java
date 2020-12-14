package com.random;

public class LeeCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] ans = new int[m + n];
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[i]) {
                ans[index++] = nums1[i++];
            } else {
                ans[index++] = nums2[j++];
            }
        }
        while (i < m) {
            ans[index++] = nums1[i++];
        }
        while (j < n) {
            ans[index++] = nums2[j++];
        }
        System.arraycopy(ans, 0, nums1, 0, m + n);

    }

    public static void main(String[] args) {
        LeeCode88 leeCode88 = new LeeCode88();
        leeCode88.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
