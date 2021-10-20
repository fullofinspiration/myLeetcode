package com.fullofinspiration.github.interview;

import java.util.LinkedList;

/**
 * 题目：
 * 便利蜂面试题
 * <p>
 * 解析形如 A(B(C(,),),E(,)) 的字符串，在内存中构建一棵二叉树
 * 说明：
 * <p>
 * 1. 是形如上面的字符串，你的程序需要能解析所有类似的字符串，而不是只限于上面这一个
 * <p>
 * 2. 逗号分隔为左右两个节点，节点可能为空
 * <p>
 * 3. 字符是节点里的值，括号里的是左右节点，为了简化节点值只会是一个字符
 * <p>
 * }
 */
public class TreeBuilder {

    Node parse(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        LinkedList<Node> all = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (all.isEmpty()) {
                Node node = new Node(null, null, c);
                all.push(node);
                continue;
            }
            if (isLeft(c)) {
                continue;
            }
            if (isNum(c)) {
                Node top = all.peek();
                Node node = new Node(null, null, c);
                top.left = node;
                all.push(node);
                continue;
            }
            if (isDelimiter(c)) {
                i++;
                c = input.charAt(i);
                if (isRight(input.charAt(i))) {
                    all.pop();
                    continue;
                }
                if (isNum(c)) {
                    Node node = new Node(null, null, c);
                    all.peek().right = node;
                    all.push(node);
                }
            }
            if (isRight(c)) {
                if (all.size() == 1) {
                    return all.pop();
                }
                all.pop();
            }
        }
        return null;
    }

    private boolean isLeft(char c) {
        return '(' == c;
    }

    private boolean isRight(char c) {
        return ')' == c;
    }

    private boolean isNum(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isDelimiter(char c) {
        return c == ',';
    }


    class Node {
        Node left;
        Node right;
        char value;

        public Node(Node left, Node right, char value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

}
