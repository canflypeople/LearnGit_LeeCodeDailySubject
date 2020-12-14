package com.november.week.four;

import java.util.Arrays;

public class LeeCode976 {

    /**
     * 双指针
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int min = n - 3, mid = n - 2, max = n - 1;
        while (min > 0) {
            if (A[min] + A[mid] > A[max]) {
                return A[min] + A[mid] + A[max];
            }
            max--;
            mid--;
            min--;
        }
        return 0;

    }
}
