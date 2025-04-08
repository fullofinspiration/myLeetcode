package com.fullofinspiration.github.leetcode;

public class _0287_DuplicateFinder {
    /**
     * 快慢指针，每个value值对应着下一个节点的索引，这有点反常识：
     * 一般链表的值就是值，和其他没有关系，然后有一个下一个节点的指针
     * 但是数组比较特殊，他没有值，只有下一个节点的指针，这个不太好想象
     * 现成结论：快慢指针，一快一慢，在相遇后，慢指针从第一个节点开始，两个一起走，走到一起就是这个环的起点
     * 为何环的起点是这个重复的值？因为有多个节点指向了他（这个好像并不直观，我理解了很久）
     * 如何查找一个链表环的入口：
     * 1 起点到链表环的入口长度为a, 相遇节点到环开始的地方长度为b, 环的长度为c，d=c-b目标是求a
     * 短：a+kc+b
     * 长: a + lc + b
     * 2(a+kc+b) = a+lc+b
     * a=lc+b-2kc-2b
     * a=(l-2k)c-b
     * a=(l-2k-1)c+c-b
     * a=(l-2k-1)c+d
     * 由此可以得出结论：快慢节点相遇节点开始只要走d步，然后绕圈，就会和从头开始走的节点相遇，
     * 且不会早相遇（还没进入环肯定不会遇到）
     * 也不会晚相遇（如果开始遇不到，就永远也遇不到了，因为每次步长是1）
     */
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0], quick = nums[slow];
            System.out.println(String.format("first slow idx: %s, slow val: %s, quick idx: %s, quick val: %s",
                    slow, nums[slow], quick, nums[quick]));
            while (slow != quick) {
                slow = nums[slow];
                quick = nums[quick];
                quick = nums[quick];
                System.out.println(String.format("first slow idx: %s, slow val: %s, quick idx: %s, quick val: %s",
                        slow, nums[slow], quick, nums[quick]));

            }
            slow = 0;
            while (slow != quick) {
                slow = nums[slow];
                quick = nums[quick];
                System.out.println(String.format("second slow idx: %s, slow val: %s, quick idx: %s, quick val: %s",
                        slow, nums[slow], quick, nums[quick]));
            }
            return slow;
        }
    }
}
