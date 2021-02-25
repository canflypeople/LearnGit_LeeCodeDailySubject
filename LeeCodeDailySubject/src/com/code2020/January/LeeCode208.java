package com.code2020.January;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class LeeCode208 {

    /**
     * 字典树，适合前缀匹配，使用节点加节点对应的子节点，有点类似n叉树
     */
    static class Trie {
        private TrieNode root = new TrieNode('/');
        class TrieNode {
            public char data;
            public TrieNode[] children = new TrieNode[26];
            public boolean isEndingChar = false;
            public TrieNode(char data) {
                this.data = data;
            }
        }
        /** Initialize your data structure here. */
        public Trie() {
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] == null) {
                    TrieNode newNode = new TrieNode(c);
                    p.children[c - 'a'] = newNode;
                }
                p = p.children[c - 'a'];
            }
            p.isEndingChar = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return p.isEndingChar;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return true;
        }
    }
}
