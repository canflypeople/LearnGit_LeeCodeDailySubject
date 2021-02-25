package com.com.code2021.january;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/8 上午9:23
 **/
public class LeeCode978 {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        int res = 1;
        // 定义左右指针
        int left = 0, index = 0;
        // 遍历数组，查找符合条件的，如果符合泽右指针往右移一位，如果不符合泽将左指针移到右指针的位置，计算大小
        for (; index < n - 1; index++) {
            if ((index % 2 == 0 && arr[index] >= arr[index + 1]) || (index % 2 == 1 && arr[index] <= arr[index + 1])) {
                res = Math.max(res, index - left + 1);
                left = index + 1;
            }
        }
        res = Math.max(res, index - left + 1);
        // 返回
        return res;
    }

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i);
        LeeCode978 leeCode978 = new LeeCode978();
        leeCode978.maxTurbulenceSize(new int[]{0,1,1,0,1,0,1,1,0,0});
    }
}
