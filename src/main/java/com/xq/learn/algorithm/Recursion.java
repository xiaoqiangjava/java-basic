package com.xq.learn.algorithm;

/**
 * 递归算法：方法体内循环调用方法本身
 * 个人总结：
 * 是否可以使用递归需要验证下面4个步骤：
 * 1. 判断当前任务是否可以拆分成多个重复的任务来执行
 * 2. 判断循环结束的条件是否存在
 * 3. 推断条件参数渐进终止条件的方式
 * 4. 可否返回一个中间结果，该结果是最终结果的一个子集
 * 编写代码从下面4个步骤实现：
 * 1. 循环终止的条件
 * 2. 递归调用，参数需要传递为渐进终止条件的方式计算的结果
 * 3. 重复任务具体需要做什么事情
 * 4. 返回中间结果
 * 其中2和3可以调换位置，具体根据业务来定。
 * @author xiaoqiang
 * @date 2020/3/26 23:22
 */
public class Recursion
{
    public static void main(String[] args)
    {
        System.out.println(sum(100));
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = swapPairs(head);
        System.out.println(node);
    }
    /**
     * 案例一：给定一个数n，求1到n的和
     * @param n n
     * @return sum
     */
    private static int sum(int n)
    {
        // 1. 终止条件
        if (n == 1)
        {
            return n;
        }
        // 2. 递归调用，参数为渐进方式计算的结果
        int temp = sum(n - 1);
        // 3. 求和
        int sum = n + temp;
        // 4. 返回中间结果, 2， 3， 4步骤可以合并，因此直接返回结果：return n + sum(n - 1)
        return sum;
    }

    /**
     * 案例二：链表的反转
     * @param head head
     * @return 反转之后的head
     */
    private static ListNode reverseList(ListNode head)
    {
        // 1. 终止条件
        if (null == head || null == head.next)
        {
            return head;
        }
        // 2. 递归调用，条件为head.next
        ListNode temp = reverseList(head.next);
        // 3. 将当前指针方向反转
        head.next.next = head;
        head.next = null;
        // 4. 返回中间结果
        return temp;
    }

    /**
     * 案例三：两两反转链表
     * 1->2->3->4->null 反转为 2->1->4->3->null
     * @param head head
     * @return 反转之后的链表
     */
    private static ListNode swapPairs(ListNode head)
    {
        // 1. 终止条件
        if (null == head || null == head.next)
        {
            return head;
        }
        // 2. 反转元素
        ListNode temp = head.next;
        // 3. 递归调用，条件为head.next.next
        head.next = swapPairs(head.next.next);
        temp.next = head;

        // 4. 返回中间结果
        return temp;
    }
}

class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
        this.val = val;
        next = null;
    }
}