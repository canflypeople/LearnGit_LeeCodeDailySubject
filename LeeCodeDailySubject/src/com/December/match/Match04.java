package com.December.match;

import java.util.LinkedList;
import java.util.Queue;

public class Match04 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stuQueue = new LinkedList<>();
        Queue<Integer> sandQueue = new LinkedList<>();
        int circularCount = 0, rectangleCount = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                circularCount++;
            } else {
                rectangleCount++;
            }
            stuQueue.offer(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            sandQueue.offer(sandwiches[i]);
        }
        while (!stuQueue.isEmpty()) {
            if (stuQueue.peek() == sandQueue.peek()) {
                if (stuQueue.peek() == 0) {
                    circularCount--;
                } else {
                    rectangleCount--;
                }
                stuQueue.poll();
                sandQueue.poll();
            } else {
                if ((sandQueue.peek() == 0 && circularCount == 0) || (sandQueue.peek() == 1 && rectangleCount == 0)) {
                    return stuQueue.size();
                }
                stuQueue.offer(stuQueue.poll());
            }
        }
        return 0;
    }

    public double averageWaitingTime(int[][] customers) {
        int waitTime = 0, currTime = 1;
        for (int[] customer : customers) {
            currTime = Math.max(currTime, customer[0]);
            currTime += customer[1];
            waitTime += currTime - customer[0];
        }
        return (double)waitTime / customers.length;
    }

    public String maximumBinaryString(String binary) {
        char[] arr = binary.toCharArray();
        int index = 0, n = arr.length;
        while (index < n - 1) {
            if (arr[index] == 0 && arr[index + 1] == 0) {
                arr[index] = 1;
            } else {
                if (index < n - 4 && "0110".equals(new String(arr, index, 4))) {
                    arr[index] = '1';
                    arr[index + 1] = '0';
                    arr[index + 2] = '1';
                    arr[index + 3] = '1';
                } else if (index < n - 3 && "010".equals(new String(arr, index , 3))) {
                    arr[index] = '1';
                    arr[index + 1] = '0';
                    arr[index + 2] = '0';
                }
            }
            index++;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Match04 match04 = new Match04();
        System.out.println(match04.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
}
