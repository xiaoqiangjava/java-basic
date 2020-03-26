package com.xq.learn.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqiang
 * @date 2019/6/22 23:26
 */
public class NoVisibility
{
    private static volatile boolean ready;

    private static volatile int number;

    private static class ReadThread extends Thread
    {
        @Override
        public void run()
        {
            while (!ready)
            {
                System.out.println("ready");
                // yield让当前线程让出CPU时间
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
        list.add("name");
    }
}
