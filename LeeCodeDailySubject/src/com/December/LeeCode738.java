package com.December;

/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */
public class LeeCode738 {

    /**
     * 贪心算法：分析若当前元素后面有比该元素小的元素，则当前元素则需降一位，后面都是99即可
     * 算法：
     * 1。 使用散列表存储元素出现的次数，
     * 2。 遍历当前元素，将元素统计到散列表中
     * 3。 若当前元素后面存在比当前元素大的元素，则停止，将当前元素-1，后面的元素都置为9
     * 4。 若当前元素的右边元素大，而后面还存在比当前元素小的，则将后面元素置为-1， 后面的元素都为9
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = str.charAt(i) - '0';
            // 若当前数和前一个数一样，直接放入
            if (i > 0 && num == str.charAt(i - 1) - '0') {
                sb.append(num);
                continue;
            }
            // 连续的字符串是否存在比当前字符串小的元素，若存在则跳出
            if (isExistBigggerNum(str, i)) {
                sb.append(num);
                continue;
            } else {
                sb.append(num - 1);
                break;
            }

        }
        while (sb.length() < length) {
            sb.append(9);
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 判断当前值后面连续是否有比当前元素大的元素
     * @param str
     * @param index
     * @return
     */
    private boolean isExistBigggerNum(String str, int index) {
        char pre = str.charAt(index);
        int n = str.length();
        while (index < n - 1 && str.charAt(index + 1) == pre) {
            index++;
        }
        return index == n - 1 ? true : str.charAt(index + 1) > pre;
    }


    public static void main(String[] args) {
        LeeCode738 leeCode738 = new LeeCode738();
        System.out.println(leeCode738.monotoneIncreasingDigits(668841));
    }
}
