package com.xq.learn.datastruct;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表数据结构：
 * 链表的访问时间复杂度：O(n)
 * 链表的插入时间复杂度：O(1)
 * 链表的删除时间复杂度：O(n)
 * @author xiaoqiang
 * @date 2020/3/24 18:06
 */
public class LinkedListMain
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = reverseList1(head);
        System.out.println(node);
    }
    /**
     * 链表的反转: 时间复杂度O(n), 空间复杂度O(1)
     * LeetCode: 206
     * @param head 链表头结点
     * @return 反转后的链表
     */
    public static ListNode reverseList(ListNode head)
    {
        // 参数校验
        if (null == head || null == head.next)
        {
            return head;
        }
        // 链表反转
        ListNode pre = null, curr = head;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

    public static ListNode reverseList1(ListNode head)
    {
        if (null == head || null == head.next)
        {
            return head;
        }
        ListNode temp = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }

    /**
     * 两两反转链表中的元素
     * LeetCode: 24
     * @param head 链表头元素
     * @return 操作后的链表
     */
    public static ListNode swapPairs(ListNode head)
    {
        if (null == head || null == head.next) return head;
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }

    /**
     * 判断链表是否有环
     * LeetCode: 141
     * @param head 链表头结点
     * @return true if has cycle.
     */
    public static boolean hasCycle(ListNode head)
    {
        ListNode fast = head, slow = head;
        while (null != fast && null != fast.next)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle1(ListNode head)
    {
        // 定义一个set，遍历链表，如果set中存在则说明有环
        Set<ListNode> set = new HashSet<>();
        while (null != head) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}
