package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhenpeng Zhang on 2021/2/19.
 */
public class _0148SortList {
    class Solution {
        //冒泡
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummyFirst = new ListNode();
            ListNode dummySecond = new ListNode();
            dummyFirst.next = head;
            dummySecond.next = head;

            int curLength = 1;
            //todo
            return null;
        }
    }

    //冒泡运行超时
    class Solution2 {
        //冒泡
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode();
            ListNode preOfBegin = new ListNode();
            preOfBegin.next = head;
            while (preOfBegin.next != null) {
                ListNode curMax = preOfBegin.next;
                ListNode preOfMax = preOfBegin;
                ListNode curNode = curMax;
                ListNode preOfCurNode = preOfMax;
                while (curNode != null) {
                    if (curNode.val > curMax.val) {
                        curMax = curNode;
                        preOfMax = preOfCurNode;
                    }
                    preOfCurNode = curNode;
                    curNode = curNode.next;
                }
                preOfMax.next = curMax.next;
                curMax.next = dummy.next;
                dummy.next = curMax;
                if (preOfBegin.next == curMax) {
                    preOfBegin.next = curMax.next;
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = buildList(new Integer[]{3, 2, 4});
        Solution1 solution = new _0148SortList().new Solution1();
        ListNode result = solution.sortList(listNode);
        print(result);
    }

    /**
     * 参考答案后写出的归并排序
     */
    class Solution1 {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int length = 0;
            ListNode tmp = head;
            while (tmp != null) {
                length++;
                tmp = tmp.next;
            }
            for (int i = 0; Math.pow(2, i) < length; i++) {
                int countEach = (int) (Math.pow(2, i));
                head = mergeList(head, countEach);
            }
            return head;
        }

        public ListNode mergeList(ListNode node, int countEach) {
            ListNode cur = new ListNode(-1);
            ListNode result = cur;
            ListNode firstHead = node;
            ListNode secondHead = getNextNthOrNull(node, countEach);
            int abc = 0;
            int def = 0;
            while (firstHead != null && secondHead != null) {
                System.out.println("outer Round: " + abc++);
                int firstHeadCount = 0;
                int secondHeadCount = 0;
                while (firstHead != null && secondHead != null && firstHeadCount < countEach && secondHeadCount < countEach) {
                    System.out.println("inner round: " + def++);
                    if (firstHead.val > secondHead.val) {
                        cur.next = secondHead;
                        cur = secondHead;
                        secondHead = secondHead.next;
                        secondHeadCount++;
                    } else {
                        cur.next = firstHead;
                        cur = firstHead;
                        firstHead = firstHead.next;
                        firstHeadCount++;
                    }
                }
                if (firstHeadCount < countEach) {
                    ListNode curNextValue = cur.next;
                    cur.next = firstHead;
                    cur = getNextNthOrNull(cur, countEach - firstHeadCount);
                    cur.next = curNextValue;
                } else {
                    cur.next = secondHead;
                    cur = getNextNthOrNull(cur, countEach - secondHeadCount);
                }
                firstHead = getNextNthOrNull(cur, 1);
                secondHead = getNextNthOrNull(cur, countEach + 1);
            }
            print(result);
            return result.next;
        }

        private ListNode getNextNthOrNull(ListNode node, int nth) {

            while (node != null && nth-- > 0) {
                node = node.next;
            }
            return node;
        }
    }

    private static ListNode buildList(Integer[] vals) {
        List<ListNode> list = Arrays.stream(vals).map(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            }
        }
        print(list.get(0));
        return list.get(0);
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}

//leetcode上的解法，我是参考这里面的思想解出来的, 和我的解法区别不大，有时间可以看下
//https://leetcode.com/problems/sort-list/discuss/46767/Java-solution-with-strict-O(1)-auxiliary-space-complexity
class Solution1 {
    private class MergeHelper {
        public ListNode newHead;
        public ListNode newTail;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHeadOne = new ListNode(0);
        ListNode dummyHeadTwo = new ListNode(0);
        ListNode dummySortedHead = new ListNode(0);
        ListNode dummySortedLast = dummySortedHead;
        ListNode unvisitedNode = head;
        MergeHelper mergeRst = new MergeHelper();

        int listLength = 0;
        int level = 0;
        while (unvisitedNode != null && unvisitedNode.next != null) {
            unvisitedNode = addNode(dummyHeadOne, unvisitedNode, 1 << level);
            unvisitedNode = addNode(dummyHeadTwo, unvisitedNode, 1 << level);
            merge(dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
            dummySortedLast.next = mergeRst.newHead;
            dummySortedLast = mergeRst.newTail;
            listLength += 2;
        }
        if (unvisitedNode != null) {
            dummySortedLast.next = unvisitedNode;
            listLength++;
        }
        level++;

        while (listLength > 1 << level) {
            dummySortedLast = dummySortedHead;
            unvisitedNode = dummySortedHead.next;
            while (unvisitedNode != null) {
                unvisitedNode = addNode(dummyHeadOne, unvisitedNode, 1 << level);
                unvisitedNode = addNode(dummyHeadTwo, unvisitedNode, 1 << level);
                merge(dummyHeadOne.next, dummyHeadTwo.next, mergeRst);
                dummySortedLast.next = mergeRst.newHead;
                dummySortedLast = mergeRst.newTail;
            }
            level++;
        }

        return dummySortedHead.next;
    }

    /* merge listOne and listTwo.
    Save the sorted list head into rst.newHead
    Save the last node of the sorted list into rst.newTail
    */
    private void merge(ListNode listOne, ListNode listTwo, MergeHelper rst) {
        ListNode dummyHead = new ListNode(0);
        ListNode lastNode = dummyHead;
        while (listOne != null && listTwo != null) {
            if (listOne.val < listTwo.val) {
                lastNode.next = listOne;
                listOne = listOne.next;
            } else {
                lastNode.next = listTwo;
                listTwo = listTwo.next;
            }
            lastNode = lastNode.next;
        }

        while (listOne != null) {
            lastNode.next = listOne;
            listOne = listOne.next;
            lastNode = lastNode.next;
        }
        while (listTwo != null) {
            lastNode.next = listTwo;
            listTwo = listTwo.next;
            lastNode = lastNode.next;
        }
        rst.newHead = dummyHead.next;
        rst.newTail = lastNode;
    }

    /*
     add at max #"count" nodes into "head" from "source"
     return the new position of source after adding.
    */
    private ListNode addNode(ListNode head, ListNode source, int count) {
        while (count > 0 && source != null) {
            head.next = source;
            head = head.next;
            source = source.next;
            count--;
        }
        head.next = null;
        return source;
    }
}