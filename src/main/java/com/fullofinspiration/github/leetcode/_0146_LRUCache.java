package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;


public class _0146_LRUCache {
    class LRUCache {
        private final int capacity;
        private Map<Integer, Node> key2Val = new HashMap<>();

        Node head = new Node();
        Node tail = new Node();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!key2Val.containsKey(key)) {
                return -1;
            }
            Node node = key2Val.get(key);
            moveToFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (!key2Val.containsKey(key)) {
                Node node = new Node(key, value);
                key2Val.put(key, node);
                addToFirst(node);
                if (key2Val.size() > capacity) {
                    remoLast();
                }
                return;
            }
            Node node = key2Val.get(key);
            node.value = value;
            moveToFirst(node);

        }

        private void moveToFirst(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToFirst(node);
        }

        private void addToFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void remoLast() {
            if (key2Val.size() == 0) {
                throw new IllegalStateException();
            }
            Node prev = tail.prev;
            key2Val.remove(prev.key);
            Node node = tail.prev.prev;
            node.next = tail;
            tail.prev = node;
        }

        public String debugPrint() {
            Node tmp = head.next;
            StringBuilder builder = new StringBuilder();
            while (tmp != tail) {
                builder.append(tmp.key).append(":").append(tmp.value).append(",");
                tmp = tmp.next;
            }
            return builder.toString();
        }
    }


    /**
     * 使用一个list存储访问频率，最近访问的在头，尾部为访问最少节点
     * 最新插入的元素，如果列表中有需要删除，这样保证最新插入也被认为是最近访问的
     * <p>
     * 1 为了保证查询时间是O(1), 需要key是查询，value放在hashmap中
     * 2 为了保证最近最少未使用放在队列尾部，需要每次查询时，如果查询到，则将该节点移动到队列首部，
     * 3 在插入元素时，如果有该值，需要更新，然后将该值放在队列首部，如果无该值，直接放置set，然后塞到队列首部，假如超过了最大数量，则要删除队列尾部的元素
     */
    class LRUCache00 {
        private final int capacity;
        private final Map<Integer, Node> key2Val;
        Node head = new Node();
        Node tail = new Node();

        public LRUCache00(int capacity) {
            key2Val = new HashMap<>(capacity);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!key2Val.containsKey(key)) {
                return -1;
            }
            moveToHead(key);
            return key2Val.get(key).value;
        }

        public void put(int key, int value) {
            if (key2Val.containsKey(key)) {
                key2Val.get(key).value = value;
                moveToHead(key);
                return;
            }

            Node node = new Node(key, value);
            addToHead(node);
            key2Val.put(key, node);

            if (key2Val.size() > capacity) {
                Node prev = tail.prev;
                prev.prev.next = tail;
                tail.prev = prev.prev;
                if (!key2Val.containsKey(prev.key)) {
                    throw new IllegalArgumentException();
                }
                key2Val.remove(prev.key);
            }
            printPutMsg(key, value);
        }

        private void printPutMsg(int key, int value) {
            String msg = String.format("succ put :%s: %s, capacity: %s, cur size: %s", key, value, capacity, key2Val.size());
            System.out.println(msg);
        }

        private void moveToHead(int key) {
            Node node = key2Val.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToHead(node);
        }

        private void addToHead(Node node) {
            Node tmp = head.next;
            tmp.prev = node;
            head.next = node;
            node.next = tmp;
            node.prev = head;
        }

        public String debugPrint() {
            Node tmp = head.next;
            StringBuilder builder = new StringBuilder();
            while (tmp != tail) {
                builder.append(tmp.key).append(":").append(tmp.value).append(",");
                tmp = tmp.next;
            }
            return builder.toString();
        }
    }

    class LRUCache01 {
        private final Map<Integer, Node> values;
        int capacity;
        int curSize = 0;
        Node head = new Node();
        Node tail = new Node();

        public LRUCache01(int capacity) {
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
