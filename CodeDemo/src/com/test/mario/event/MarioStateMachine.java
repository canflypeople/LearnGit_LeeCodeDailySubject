package com.test.mario.event;

import com.test.mario.State;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/20 下午1:43
 **/
public class MarioStateMachine {
    private int score;
    private IMario currentState; // 不使用枚举来表示状体啊

    public MarioStateMachine() {
        this.score = 0;
        //this.currentState = new SmallMario(this);
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }

    public void obtainCape() {
        this.currentState.obtainCape();
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower();
    }

    public void meetMonster() {
        this.currentState.meetMonster();
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState.getName();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
