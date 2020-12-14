package com.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class LeeCode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    /**
     * 递归
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, 0, numRows);
        return ans;
    }

    private void generate(List<List<Integer>> ans, int begin, int end) {
        if (begin == end) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        if (begin == 0) {
            list.add(1);
        } else {
            for (int i = 0; i <= begin; ++i) {
                int num = ans.get(begin - 1).get(i) + (i < begin - 1 ? ans.get(begin - 1).get(i + 1) : 0);
                list.add(num);
            }
        }
        ans.add(list);
        generate(ans, begin + 1, end);
    }

    public static void main(String[] args) {
        LeeCode118 leeCode118 = new LeeCode118();
        leeCode118.generate(5);
    }


}
