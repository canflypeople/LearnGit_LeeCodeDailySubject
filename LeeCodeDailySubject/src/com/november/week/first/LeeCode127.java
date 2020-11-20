package com.november.week.first;

import java.util.*;

/*给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

        每次转换只能改变一个字母。
        转换过程中的中间单词必须是字典中的单词。
        说明:

        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。*/
public class LeeCode127 {
    // 存储字符串和下标之间的映射
    public Map<String, Integer> wordId = new HashMap<>();
    // 存储字符串之间的边
    public List<List<Integer>> edge = new ArrayList<>();
    // 记录下标
    int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 构建图
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        // 特殊条件判断，字典中没有结束字符串
        if (wordId.containsKey(endWord)) {
            return 0;
        }
        // 初始化数组，用于记录到达每个点的长度
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        // 获取开始和结束字符串的下标，用于后续的判断
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;
        // 初始化队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(beginId);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endId) {
                return dis[x] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    queue.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
