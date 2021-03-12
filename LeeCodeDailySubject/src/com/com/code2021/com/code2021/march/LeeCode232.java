package com.com.code2021.com.code2021.march;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/3/5 下午9:14
 **/
public class LeeCode232 {
    class MyQueue {

        Deque<Integer> inStack = new LinkedList<>();
        Deque<Integer> outStack = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyQueue() {
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();

        }

        /** Get the front element. */
        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
