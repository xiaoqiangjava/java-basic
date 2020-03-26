package com.xq.learn.datastruct;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈数据结构：
 * 先进后出，FILO
 * 访问和查询时间复杂度：O(n)
 * 插入和删除栈顶元素：O(1)
 * @author xiaoqiang
 * @date 2020/3/24 22:32
 */
public class StackMain
{
    public static void main(String[] args)
    {
        isValid("{}[]");

        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());


    }
    /**
     * 判断括号是否匹配
     * LeetCode: 20
     * @param str str
     * @return 是否匹配
     */
    public static boolean isValid(String str)
    {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray())
        {
            if (!map.containsKey(ch))
            {
                stack.push(ch);
            }
            else if (stack.isEmpty() || map.get(ch) != stack.pop())
            {
                return false;
            }
        }
        return stack.isEmpty();
    }

}

/**
 * 使用队列实现栈
 * LeetCode: 225
 */
class MyStack
{
    private Queue<Integer> queue;
    private Queue<Integer> temp;
    private int top;

    public MyStack()
    {
        this.queue = new ArrayDeque<>();
        this.temp = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack
     * @param x element
     */
    public void push(int x)
    {
        this.top = x;
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * @return top element
     */
    public int pop()
    {
        int res = top;
        // 循环找出top元素，将出队的元素放入另一个队列中
        while (queue.size() > 1)
        {
            top = queue.peek();
            temp.add(queue.remove());
        }
        // 删除当前top对应的元素
        queue.remove();
        // 交换位置
        Queue<Integer> tmp = temp;
        temp = queue;
        queue = tmp;
        return res;
    }

    /**
     * Get the top element.
     * @return the top element.
     */
    public int top()
    {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     * @return true if the stack is empty.
     */
    public boolean empty()
    {
        return queue.isEmpty();
    }
}