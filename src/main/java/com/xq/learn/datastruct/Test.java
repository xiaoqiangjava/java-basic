package com.xq.learn.datastruct;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xiaoqiang
 * @date 2020/3/25 10:54
 */
public class Test
{
    public boolean isVaild(String str)
    {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Deque<Character> stack = new LinkedList<>();
        for (char ch : str.toCharArray())
        {
            if (!map.containsKey(ch))
            {
                stack.push(ch);
            }
            else
            {
                if (stack.isEmpty() || map.get(ch) != stack.pop())
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
