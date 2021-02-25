package com.test.mario.event;

import com.test.mario.State;

/**
 * @program:
 * @description: 所有状态类的接口
 * @author: zhongmou.ji
 * @create: 2021/2/20 上午11:59
 **/
public interface IMario {
    State getName();
    // 定义的事件
    void obtainMushRoom();
    void obtainCape();
    void obtainFireFlower();
    void meetMonster();
}
