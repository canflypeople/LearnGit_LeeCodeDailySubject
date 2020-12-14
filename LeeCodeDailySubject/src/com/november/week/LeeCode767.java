package com.november.week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class LeeCode767 {

    /**
     * 分析：字符串中的任意一个字符长度不大于S的一半-1
     * 还是使用双指针吧
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = 1;
        int length = s.length();
        while (right < length) {
            while (right < length && arr[right] == arr[left]) {
                right++;
            }
            swap(arr, left + 1, right);
            left++;
            right++;
        }
        // 若左指针指向倒数第二个下标特殊控制
        if (left == length - 2) {
            if (arr[left] != arr[length - 1]) {
                left++;
            }
        }
        return left == length - 1 ? String.valueOf(arr) : "";
    }

    /**
     * 统计出现次数
     * @param s
     * @return
     */
    public String reorganizeString1(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int left = 0, right = n - 1;
        sb.append(arr[0]);
        while (left < right) {
            if (left < n - 1 && arr[left] != arr[left + 1]) {
                left++;
            }
            if (arr[left] == arr[right]) {
                return "";
            }
            sb.append(arr[right]);
            left++;
            right++;
        }
        return sb.toString();
        /*int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int length = s.length();
        for (int count : counts) {
            if (count > (length + 1) / 2) {
                return "";
            }
        }
        return reBuild(counts, length);*/
    }

    /**
     * 计数：统计出现次数
     * @param s
     * @return
     */
    public String reorganizeString2(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int length = s.length();
        for (int count : counts) {
            if (count > (length + 1) / 2) {
                return "";
            }
        }
        return reBuild(counts, length);
    }

    /**
     * 重构字符串，贪心算法
     * 若字符出现的次数小于数组的一半，则可以放在奇数下标，也可以放在偶数下标
     * 若字符出现的次数等于数组的一般，则只能放在偶数下标，
     * @param counts
     * @param length
     * @return
     */
    private String reBuild(int[] counts, int length) {
        char[] reorganizeArray = new char[length];
        int halfLength = length / 2;
        int evenIndex = 0, oddIndex = 1;
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            int count = counts[i];
            while (oddIndex < length && count <= halfLength && counts[i] > 0) {
                reorganizeArray[oddIndex] = c;
                oddIndex += 2;
                counts[i]--;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                evenIndex += 2;
                counts[i]--;
            }
        }
        return String.valueOf(reorganizeArray);
    }


    /**
     * 交换字符数组中的两个下标的值
     * @param arr
     * @param i
     * @param j
     */
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LeeCode767 leeCode767 = new LeeCode767();
        leeCode767.reorganizeString1("vvvlo");
    }

}
