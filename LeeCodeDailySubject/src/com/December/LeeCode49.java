package com.December;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class LeeCode49 {

    /**
     * 哈希表记录字符串中出现的字符的个数
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortStr = new String(arr);
            if (map.containsKey(sortStr)) {
                ans.get(map.get(sortStr)).add(str);
            } else {
                ans.add(new ArrayList<String>());
                ans.get(ans.size() - 1).add(str);
                map.put(sortStr, ans.size() - 1);
            }
        }
        return ans;

    }
}
