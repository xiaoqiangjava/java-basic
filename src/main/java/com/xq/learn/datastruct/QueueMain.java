package com.xq.learn.datastruct;

import java.util.Stack;

/**
 * 队列：先进先出
 * 访问和查询的时间复杂度都是O(n)
 * 队列尾部插入的时间复杂度是O(1)
 * 队列头部取出的时间复杂度是O(1)
 * @author xiaoqiang
 * @date 2020/3/25 11:47
 */
public class QueueMain
{

    /**
     * 使用栈实现队列:
     * 使用两个栈，存入元素都存入input，弹出元素都从output取
     * 如果取元素之前发现output是空栈，那么将input所有的元素出栈压入output
     * 需要注意的是每次output里面的元素为空时才需要将input的元素压入output中，否则会
     * 发生顺序混乱
     * LIFO  --> FIFO
     */
    class MyQueue
    {
        private Stack<Integer> input = new Stack<>();

        private Stack<Integer> output = new Stack<>();

        public void push(int e)
        {
            input.push(e);
        }

        public void pop()
        {
            if (output.isEmpty())
            {
                output.push(input.pop());
            }

            output.pop();
        }
    }
}

