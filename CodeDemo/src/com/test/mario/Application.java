package com.test.mario;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/20 上午11:44
 **/
public class Application {

    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom(); int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);
    }
}
