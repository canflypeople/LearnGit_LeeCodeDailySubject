//package com.test.mario.event;
//
//import com.test.mario.State;
//
///**
// * @program:
// * @description:
// * @author: zhongmou.ji
// * @create: 2021/2/20 下午12:01
// **/
//public class SmallMario implements IMario {
//    private MarioStateMachine stateMachine;
//
//    public SmallMario(MarioStateMachine stateMachine) {
//        this.stateMachine = stateMachine;
//    }
//
//    @Override
//    public State getName() {
//        return State.SMALL;
//    }
//
//    @Override
//    public void obtainMushRoom() {
//        stateMachine.setCurrentState(new SuperMario(stateMachine));
//        stateMachine.setScore(stateMachine.getScore() + 100);
//
//    }
//
//    @Override
//    public void obtainCape() {
//        stateMachine.setCurrentState(new FireMario(stateMachine));
//        stateMachine.setScore(stateMachine.getScore() + 300);
//    }
//
//    @Override
//    public void obtainFireFlower() {
//        // do nothing...
//    }
//
//    @Override
//    public void meetMonster() {
//
//    }
//}
