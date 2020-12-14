package com.December;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class LeeCode860 {

    /**
     * 贪心算法：若有10快的，每次先找10块的
     * 根据金额来进行找零
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[2]; // 只有5和10有用
        for (int bill : bills) {
            if (!change(bill, changes)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param bill
     * @param changes
     * @return
     */
    private boolean change(int bill, int[] changes) {
        if (bill == 20) {
            if (changes[1] > 0 && changes[0] > 0) {
                --changes[1];
                --changes[0];
            } else if (changes[1] == 0 && changes[0] >= 3) {
                changes[0] -= 3;
            } else {
                return false;
            }
        } else if (bill == 10) {
            if (changes[0] > 0) {
                --changes[0];
                ++changes[1];
            } else {
                return false;
            }
        } else if (bill == 5) {
            ++changes[0];
        }
        return true;
    }
}
