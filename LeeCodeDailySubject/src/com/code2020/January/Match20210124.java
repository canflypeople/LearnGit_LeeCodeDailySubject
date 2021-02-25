package com.code2020.January;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/1/24 上午10:46
 **/
public class Match20210124 {


    public String maximumTime(String time) {
        Map<Integer, Map<Integer, Integer>> hourMaps = new HashMap<Integer, Map<Integer, Integer>>();
        Map<Integer, Integer> hour1 = new HashMap<>();
        hour1.put(0, 9);
        hour1.put(1, 9);
        hour1.put(2, 3);
        Map<Integer, Integer> hour2= new HashMap<>();
        for (int i = 0; i < 4; i++) {
            hour2.put(i, 2);
        }
        for (int i = 4; i <= 9; i++) {
            hour2.put(i, 1);
        }
        hourMaps.put(1, hour1);
        hourMaps.put(2, hour2);
        Map<Integer, Map<Integer, Integer>> timeMaps = new HashMap<>();
        Map<Integer, Integer> time1 = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            time1.put(i, 9);
        }
        Map<Integer, Integer> time2= new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            time2.put(i, 5);
        }
        timeMaps.put(1, time1);
        timeMaps.put(2, time2);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            sb.append(23);
        } else if (time.charAt(0) == '?' || time.charAt(1) == '?') {
            if (time.charAt(0) == '?') {
                sb.append(hourMaps.get(2).get(time.charAt(1) - '0'));
                sb.append(time.charAt(1));
            } else {
                sb.append(time.charAt(0));
                sb.append(hourMaps.get(1).get(time.charAt(0) - '0'));
            }
        } else {
            sb.append(time.charAt(0)).append(time.charAt(1));
        }
        sb.append(':');
        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            sb.append(59);
        } else if (time.charAt(3) == '?' || time.charAt(4) == '?') {
            if (time.charAt(3) == '?') {
                sb.append(timeMaps.get(2).get(time.charAt(4) - '0'));
                sb.append(time.charAt(4));
            } else {
                sb.append(time.charAt(3));
                sb.append(timeMaps.get(1).get(time.charAt(3) - '0'));
            }
        } else {
            sb.append(time.charAt(3)).append(time.charAt(4));
        }
        return sb.toString();
    }

    /**
     * 前缀和
     * @param a
     * @param b
     * @return
     */
    public int minCharacters(String a, String b) {
        int[] count1 = new int[26], count2 = new int[26];
        int sameLength = 0;
        for (char c : a.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            sameLength = Math.max(sameLength, Math.min(count1[i], count2[i]));
        }
        int res = a.length() + b.length() - 2 * sameLength;
        // 前缀和
        int[] preCount1 = new int[26];
        preCount1[0] = count1[0];
        for (int i = 1; i < 26; i++) {
            preCount1[i] = count1[i] + preCount1[i - 1];
        }
        int[] preCount2 = new int[26];
        preCount2[0] = count2[0];
        for (int i = 1; i < 26; i++) {
            preCount2[i] = count2[i] + preCount2[i - 1];
        }
        res = Math.min(res, getChangeCount(preCount1, preCount2));
        res = Math.min(res, getChangeCount(preCount2, preCount1));
        return res;
    }

    /**
     * count1 完全小于 count2
     * @param preCount1
     * @param preCount2
     * @return
     */
    private int getChangeCount(int[] preCount1, int[] preCount2) {
        int changeCount = Integer.MAX_VALUE;
        for (int i = 1; i <= 25; i++) {
            if (i == 24) {
                System.out.println(24);
            }
            //changeCount = Math.min(changeCount, preCount1[25] - preCount1[i - 1] + preCount2[i - 1]);
            if (changeCount > preCount1[25] - preCount1[i - 1] + preCount2[i - 1]) {
                /*System.out.println("修改坐标为" + i + "-- 值为" + (preCount1[25] - preCount1[i - 1] + preCount2[i - 1]));
                System.out.println(preCount1[25] - preCount1[i - 1] + "-----" + preCount2[i - 1]);*/
                changeCount = Math.min(changeCount, preCount1[25] - preCount1[i - 1] + preCount2[i - 1]);
            }
        }
        return changeCount;
    }

    public static void main(String[] args) {
        Match20210124 demo = new Match20210124();
        demo.minCharacters("otpaynexxlngyrdmand"
                ,"twtyifiiundfejxfktclktjnqrmycnqmxhxfitnlasyuwotjguerenjjnpkaajsnnraopdnambfccwthppimijghg");
    }
}
