package com.code2020.January;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * @author: zhongmou.ji
 * @create: 2021/1/26 上午9:08
 **/
public class LeeCode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            String str = domino[0] + "@" + domino[1];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int value : map.values()) {
            if (value > 1) {
                res += (value - 1) * value / 2;
            }
        }
        return res;
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() == Pair.class) {
                return this.x == ((Pair)obj).x && this.y == ((Pair)obj).y;
            }
            return false;
        }
    }
}
