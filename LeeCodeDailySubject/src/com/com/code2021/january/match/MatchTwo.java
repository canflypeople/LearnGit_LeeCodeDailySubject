package com.com.code2021.january.match;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/7 上午10:38
 **/
public class MatchTwo {

    public boolean check(int[] nums) {
        int midIndex = Integer.MIN_VALUE;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                midIndex = i;
                break;
            }
        }
        if (midIndex == Integer.MIN_VALUE) {
            return true;
        }
        if (nums[0] < nums[length - 1]) {
            return false;
        }
        for (int i = midIndex + 1; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int score = 0;
        while (arr[0] + arr[1] > arr[2]) {
            arr[0]--;
            arr[1]--;
            score += 1;
        }
        score += arr[2];
        return score;
    }

    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        int len1 = word1.length(), len2 = word2.length();
        while (p1 < len1 && p2 < len2) {
            int temp1 = p1, temp2 = p2;
            StringBuilder sb1 = new StringBuilder();
            sb1.append(word1.charAt(temp1));
            temp1++;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(word2.charAt(temp2));
            temp2++;
            while (temp1 < len1 && temp2 < len2 && sb1.toString().equals(sb2.toString())) {
                if (sb1.charAt(sb1.length() - 1) > word1.charAt(temp1) || sb2.charAt(sb2.length() - 1) > word2.charAt(temp2)) {
                    break;
                }
                sb1.append(word1.charAt(temp1));
                sb2.append(word2.charAt(temp2));
                temp1++;
                temp2++;
            }
            int i = sb1.toString().compareTo(sb2.toString());
            if (i == 0) {
                if (temp1 == len1) {
                    sb.append(sb2);
                    p2 = temp2;
                } else {
                    sb.append(sb1);
                    p1 = temp1;
                }
            } else if (i < 0) {
                sb.append(sb2);
                p2 = temp2;
            } else if (i > 0) {
                sb.append(sb1);
                p1 = temp1;
            }
        }
        if (p1 < len1) {
            sb.append(word1.substring(p1, len1));
        }
        if (p2 < len2) {
            sb.append(word2.substring(p2, len2));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        MatchTwo matchTwo = new MatchTwo();
        System.out.println();
        matchTwo.largestMerge("guguuuuuuuuuuuuuuguguuuuguug"
                ,"gguggggggguuggguugggggg");
        matchTwo.check(new int[]{3, 4, 5, 1, 2});
    }
}
