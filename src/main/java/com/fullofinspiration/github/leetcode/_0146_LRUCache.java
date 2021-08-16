package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用一个list存储访问频率，最近访问的在头，尾部为访问最少节点
 * 最新插入的元素，如果列表中有需要删除，这样保证最新插入也被认为是最近访问的
 */
public class _0146_LRUCache {
    class LRUCache {
        private final Map<Integer, Node> values;
        int capacity;
        int curSize = 0;
        Node head = new Node();
        Node tail = new Node();

        public LRUCache(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException();
            }
            values = new HashMap<>(capacity);
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (values.containsKey(key)) {
                setToHead(key);
                return values.get(key).value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (values.containsKey(key)) {
                Node node = values.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (curSize == capacity) {
                Node removedNode = tail.prev;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                values.remove(removedNode.key);
            } else {
                curSize++;
            }
            Node node = new Node(key, value);
            Node temp = head.next;
            head.next = node;
            temp.prev = node;
            node.prev = head;
            node.next = temp;
            values.put(key, node);
        }


        private void setToHead(int key) {
            Node node = values.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            Node temp = head.next;
            head.next = node;
            temp.prev = node;
            node.next = temp;
            node.prev = head;
        }
    }

    private static final class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

}
