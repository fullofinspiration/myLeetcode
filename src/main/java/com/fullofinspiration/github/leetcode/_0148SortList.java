package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by Zhenpeng Zhang on 2021/2/19.
 */
public class _0148SortList {
    /**
     * https://leetcode.com/problems/sort-list/solutions/46714/java-merge-sort-solution/
     */
    public class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre, slow, quick;
            slow = quick = head;
            pre = null;
            while (quick!=null &&quick.next != null) {
                pre = slow;
                slow = slow.next;
                quick = quick.next.next;
            }
            if (pre != null) {
                pre.next = null;
            }

            ListNode ret1 = sortList(head);
            ListNode ret2 = sortList(slow);
            return merge(ret1, ret2);
        }

        private ListNode merge(ListNode ret1, ListNode ret2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (ret1 != null && ret2 != null) {
                if (ret1.val <= ret2.val) {
                    cur.next = ret1;
                    cur = ret1;
                    ret1 = ret1.next;
                } else {
                    cur.next = ret2;
                    cur = ret2;
                    ret2 = ret2.next;
                }
            }
            if (ret1 != null) {
                cur.next = ret1;
            } else {
                cur.next = ret2;
            }
            return dummy.next;
        }
    }

    /**
     * https://leetcode.com/problems/sort-list/solutions/46714/java-merge-sort-solution/comments/1779138/?parent=172439
     */
    public class Solution01 {
        public ListNode sortList(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode[] sublistHeads = new ListNode[2];
            ListNode[] sublistTails = new ListNode[2];
            ListNode remains;
            int step = 1;
            for (; ; step *= 2) {
                ListNode prev = dummy;
                remains = dummy.next;
                int count = 0;
                for (; remains != null; count++) {
                    for (int i = 0; i < 2; i++) {
                        sublistHeads[i] = remains;
                        sublistTails[i] = null;
                        int dataCount = 0;
                        while (++dataCount <= step && remains != null) {
                            sublistTails[i] = remains;
                            remains = remains.next;
                        }
                        if (sublistTails[i] != null) {
                            sublistTails[i].next = null;
                        }
                    }
                    // 合并数组
                    while (sublistHeads[0] != null && sublistHeads[1] != null) {
                        if (sublistHeads[0].val >= sublistHeads[1].val) {
                            prev.next = sublistHeads[1];
                            prev = sublistHeads[1];
                            sublistHeads[1] = sublistHeads[1].next;
                        } else {
                            prev.next = sublistHeads[0];
                            prev = sublistHeads[0];
                            sublistHeads[0] = sublistHeads[0].next;
                        }
                    }
                    if (sublistHeads[0] != null) {
                        prev.next = sublistHeads[0];
                        prev = sublistTails[0];
                    } else {
                        prev.next = sublistHeads[1];
                        prev = sublistTails[1];
                    }
                }
                if (count <= 1) {
                    return dummy.next;
                }
            }
        }

    }

    /**
     * https://leetcode.com/problems/sort-list/solutions/166324/c++-and-java-legit-solution.-O(nlogn)-time-and-O(1)-space!-No-recursion!-With-detailed-explaination
     * 迭代方式，时间复杂度O(nlog(n)) 空间复杂度O(1)
     */
    public class Solution00 {
        public ListNode sortList(ListNode head) {
            // 使用虚拟头节点简化操作
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // 用于暂存分割出的两个子链表及其尾节点
            ListNode[] subListHeads = new ListNode[2];
            ListNode[] subListsTails = new ListNode[2];

            // 使用自底向上的归并排序，步长从1开始，每次翻倍
            for (int step = 1; ; step *= 2) {
                // prev记录已排序部分的尾节点
                ListNode prev = dummy;

                // remaining记录待处理部分的头节点
                ListNode remaining = prev.next;

                int loopCount = 0;
                // 遍历整个链表进行分割和合并
                for (; null != remaining; ++loopCount) {
                    // 分割出两个长度为step的子链表
                    for (int i = 0; i < 2; ++i) {
                        subListHeads[i] = remaining;
                        subListsTails[i] = null;
                        // 移动指针到子链表的末尾
                        for (int j = 0; null != remaining && j < step; ++j) {
                            subListsTails[i] = remaining;
                            remaining = remaining.next;
                        }
                        // 断开子链表与后续节点的连接
                        if (null != subListsTails[i]) {
                            subListsTails[i].next = null;
                        }
                    }

                    // 合并两个有序子链表
                    while (null != subListHeads[0] && null != subListHeads[1]) {
                        if (subListHeads[0].val <= subListHeads[1].val) {
                            prev.next = subListHeads[0];
                            subListHeads[0] = subListHeads[0].next;
                        } else {
                            prev.next = subListHeads[1];
                            subListHeads[1] = subListHeads[1].next;
                        }
                        prev = prev.next;
                    }

                    // 将剩余部分连接到已排序部分的末尾
                    if (null != subListHeads[0]) {
                        prev.next = subListHeads[0];
                        prev = subListsTails[0];
                    } else {
                        prev.next = subListHeads[1];
                        prev = subListsTails[1];
                    }
                }

                // 如果整个链表在一次循环中就处理完毕，说明排序完成
                if (1 >= loopCount) {
                    return dummy.next;
                }
            }
        }
    }

    class Solution03 {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fakeHead = new ListNode();
            fakeHead.next = head;
            int interval = 1;
            while (true) {
                ListNode headOfEachLoop = fakeHead;
                boolean firstLoop = true;
                while (true) {
                    ListNode first = headOfEachLoop.next;
                    ListNode second = first;
                    int tempInterval = interval;
                    while (tempInterval > 0 && second != null) {
                        second = second.next;
                        tempInterval--;
                    }
                    if (second == null) {
                        if (firstLoop) {
                            return fakeHead.next;
                        } else {
                            //每次遍历时结尾的元素
                            while (first != null) {
                                headOfEachLoop.next = first;
                                headOfEachLoop = headOfEachLoop.next;
                                first = first.next;
                            }
                            break;
                        }
                    }
                    firstLoop = false;
                    int leftCount = interval;
                    int rightCont = interval;
                    while (leftCount > 0 && rightCont > 0 && second != null) {
                        if (first.val > second.val) {
                            headOfEachLoop.next = second;
                            headOfEachLoop = second;
                            second = second.next;
                            rightCont--;
                        } else {
                            headOfEachLoop.next = first;
                            headOfEachLoop = first;
                            first = first.next;
                            leftCount--;
                        }
                    }
                    if (leftCount > 0) {
                        while (leftCount > 0) {
                            headOfEachLoop.next = first;
                            headOfEachLoop = headOfEachLoop.next;
                            leftCount--;
                            first = first.next;
                        }
                        headOfEachLoop.next = second;
                    } else {
                        while (rightCont > 0 && second != null) {
                            headOfEachLoop.next = second;
                            headOfEachLoop = headOfEachLoop.next;
                            rightCont--;
                            second = second.next;
                        }
                    }
                }
                interval <<= 1;
            }
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