package com.test.mario;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/20 上午11:40
 **/
public enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
