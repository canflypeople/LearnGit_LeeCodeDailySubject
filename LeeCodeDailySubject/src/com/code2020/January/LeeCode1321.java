package com.code2020.January;

/**
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 */
public class LeeCode1321 {
    /**
     * 两点确定一条直线 y = ax + b
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        double[] arr = getCoordinate(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (!matchLine(arr, coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断点是否在直线上
     * @param coordinate
     * @return
     */
    private boolean matchLine(double line[], int[] coordinate) {
        return line[0] * coordinate[1] == line[1] * coordinate[0] + line[2];
    }

    /**
     * 获取直线公式
     * @param coordinate1
     * @param coordinate2
     * @return arr[0] 是 a， arr[1]是b
     */
    private double[] getCoordinate(int[] coordinate1, int[] coordinate2) {
        double[] res = new double[3];
        int x1 = coordinate1[0], x2 = coordinate2[0];
        int y1 = coordinate1[1], y2 = coordinate2[1];
        if (x1 == x2) {
            res[0] = 0;
            res[1] = -1;
            res[2] = y1;
        } else {
            res[0] = 1;
            res[1] = ((y1 - y2) * 1.0) / (x1 - x2);
            res[2] = y1 - res[1] * x1;
        }
        return res;
    }

    public static void main(String[] args) {
        LeeCode1321 leeCode1321 = new LeeCode1321();
        leeCode1321.checkStraightLine(new int[][]{new int[]{2,1},new int[]{4,2},new int[]{6,3}});
    }
}
