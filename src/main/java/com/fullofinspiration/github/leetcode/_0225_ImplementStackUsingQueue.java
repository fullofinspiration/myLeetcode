package com.fullofinspiration.github.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/solutions/62516/concise-1-queue-java-c-python/?orderBy=most_votes
 * 这个方法太绝了,每次先插入，然后将其他元素插入到该元素尾部，在已有队列已经是占的情况下，保证了后进先出
 * copy答案时样板从链接中copy的，导致有一些方法返回值和题目变了（新题目返回为int，copy过来的返回值为void，导致报错：本来以为是leetcode bug， 原来是返回值写错了，想了好久才发现原因）
 * :Line 20: error: 'void' type not allowed here [in __Driver__.java]
 *                   return __Serializer__.serialize(obj.pop());
*    关键报错行数他也展示错了，就以为是力扣的bug
 */
public class _0225_ImplementStackUsingQueue {

    class MyStack {
        Queue<Integer> queue = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
