package com.xq.learn.collection.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoqiang
 * @date 2019/6/22 13:36
 */
public class Main
{
    public static void main(String[] args)
    {
        int a = 0;
        if (a++ == 0)
        {
            System.out.println("a++: " + a);
        }

        if (++a == 2)
        {
            System.out.println("++a: " + a);
        }
    }
}
