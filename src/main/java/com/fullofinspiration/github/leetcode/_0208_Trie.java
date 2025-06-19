package com.fullofinspiration.github.leetcode;

public class _0208_Trie {
    /**
     * 开始时间:8:35
     * 结束时间: 9:06
     * 30min
     */
    class Trie {
        private Trie[] subs = new Trie[26];
        private boolean leaf = false;

        public Trie() {
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.subs[idx] == null) {
                    Trie trie = new Trie();
                    cur.subs[idx] = trie;
                }
                cur = cur.subs[idx];
            }
            cur.leaf = true;
        }

        public boolean search(String word) {
            Trie node = findNode(word);
            return node != null && node.leaf;
        }

        public boolean startsWith(String prefix) {
            Trie node = findNode(prefix);
            return node != null;
        }

        private Trie findNode(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.subs[idx] == null) {
                    return null;
                }
                cur = cur.subs[idx];
            }
            return cur;
        }
    }


}