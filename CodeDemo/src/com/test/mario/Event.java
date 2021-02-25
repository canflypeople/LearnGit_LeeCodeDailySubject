package com.test.mario;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/2/20 上午11:48
 **/
public enum Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);

    private int value;

    private Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
