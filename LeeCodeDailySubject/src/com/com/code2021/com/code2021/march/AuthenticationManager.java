package com.com.code2021.com.code2021.march;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program:
 * @description:
 * 你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。如果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。
 *
 * 请你实现 AuthenticationManager 类：
 *
 * AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
 * generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
 * renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
 * countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
 * 如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），过期事件 优先于 其他操作。
 * @author: zhongmou.ji
 * @create: 2021/3/20 下午10:43
 **/
public class AuthenticationManager {
    private final int TIME_TO_LIVE;
    private final PriorityQueue<Pair<String, Integer>> priorityQueue;
    private final Map<String, Pair<String, Integer>> map;

    /*
    构造 AuthenticationManager 并设置 timeToLive 参数。
     */
    public AuthenticationManager(int timeToLive) {
        this.TIME_TO_LIVE = timeToLive;
        priorityQueue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.value > o2.value ? 1 : -1;
            }
        });
        map = new HashMap<>();
    }

    /*
    给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
     */
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, new Pair<>(tokenId, currentTime + TIME_TO_LIVE));
        priorityQueue.offer(new Pair(tokenId, currentTime + TIME_TO_LIVE));
    }

    /*
    将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。
    如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
     */
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId).value > currentTime
                && map.get(tokenId).value - TIME_TO_LIVE < currentTime) {
            Pair pair = map.get(tokenId);
            priorityQueue.remove(pair);
            map.put(tokenId, new Pair<>(tokenId, currentTime + TIME_TO_LIVE));
            priorityQueue.offer(map.get(tokenId));
        }
    }

    /*
    countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
     */
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Pair<String, Integer> pair : priorityQueue) {
            if (pair.value - TIME_TO_LIVE > currentTime) {
                break;
            } else if (pair.value > currentTime) {
                count++;
            }
        }
        return count;

    }


    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return this.key.equals(((Pair) obj).key) && this.value.equals(((Pair) obj).value);
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /*
","renew","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","generate","countUnexpiredTokens","renew"]
,["ybiqb",21],[23],[25],[26],["aqdm",28],[29],["puv",30]]
     */
    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(13);
        authenticationManager.renew("ajvy", 1);
        authenticationManager.generate("fuzxq", 5);
        authenticationManager.generate("izmry", 7);
        authenticationManager.renew("puv", 12);
        authenticationManager.generate("ybiqb", 13);
        authenticationManager.generate("gm", 14);
        authenticationManager.renew("ybiqb", 21);
        authenticationManager.countUnexpiredTokens(23);
        authenticationManager.countUnexpiredTokens(25);



    }

}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
