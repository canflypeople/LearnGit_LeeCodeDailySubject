package com.november.week.three;

public class LeeCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] rest = new int[length];
        for (int i = 0; i < length; i++) {
            rest[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < length; i++) {
            if (rest[i] < 0) {
                continue;
            }
            int restGas = rest[i];
            int index = i;
            index = (index == length - 1) ? 0 : index + 1;
            while (index != i) {
                restGas += rest[index];
                if (restGas < 0) {
                    break;
                }
                index = (index == length - 1) ? 0 : index + 1;
            }
            if (index == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeeCode134 leeCode134 = new LeeCode134();
        leeCode134.canCompleteCircuit(new int[]{3,3,4},
            new int[]{3,4,4});
    }
}
