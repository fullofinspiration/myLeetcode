package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.HashSet;
import java.util.Set;


public class _0142_LinkedListCycle2 {
    /**
     * https://leetcode.cn/problems/linked-list-cycle-ii/solutions/2832831/jian-ji-qing-xi-yan-jin-de-tu-shi-tui-da-nak2/?envType=study-plan-v2&envId=top-100-liked
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, quick = head;
            while (true) {
                slow = slow.next;
                if (quick == null || quick.next == null) {
                    return null;
                }
                quick = quick.next.next;
                if (slow == quick) {
                    break;
                }
            }
            slow = head;
            while (slow != quick) {
                slow = slow.next;
                quick = quick.next;
            }
            return slow;
        }
    }

    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
     * 没完全看懂上面的方法，按照自己的推导重新写了一遍
     * 快慢指针，快指针走两步，慢指针走一步，步数为k，环长为c，开始到环的起点为s 则相遇时快指针比慢指针多走n圈：2k-k=nc
     * 环起点到相遇节点距离为d， d+s=k
     * 由此推导出d+s=nc-> s=nc-d-> s=(n-1)c + (c-d)  两个节点相遇节点只有一个，且肯定会相遇，所以必是该节点
     * 调试问题：1 应该加上quick!=null 导致了空指针 2 应该加上quick==null || quick.next== null 条件应该和循环条件相反
     */
    public class Solution01 {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, quick = head;
            while (quick != null && quick.next != null) {
                slow = slow.next;
                quick = quick.next.next;
                if (slow == quick) {
                    break;
                }
            }
            if (quick == null || quick.next == null) {
                return null;
            }
            slow = head;
            while (slow != quick) {
                slow = slow.next;
                quick = quick.next;
            }
            return slow;

        }
    }

    /**
     * 节省空间的算法没有看懂, 后面有空再看
     * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
     */
    public class Solution00 {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<ListNode> all = new HashSet<>();
            while (head != null) {
                if (all.contains(head)) {
                    return head;
                }
                all.add(head);
                head = head.next;
            }
            return null;
        }
    }
}
