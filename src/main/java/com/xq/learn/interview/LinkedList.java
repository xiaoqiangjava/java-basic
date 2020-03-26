package com.xq.learn.interview;

import java.util.List;

/**
 * @author xiaoqiang
 * @date 2020/3/21 16:51
 */
public class LinkedList<E>
{
    public LinkedList()
    {
    }

    Node<E> first;

    Node<E> last;

    public void add(E e)
    {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
        {
            first = newNode;
        }
        else
        {
            l.next = newNode;
        }
    }

    private static class Node<E>
    {
        E e;
        Node<E> pre;
        Node<E> next;

        public Node(Node<E> pre, E e, Node<E> next)
        {
            this.pre = pre;
            this.e = e;
            this.next = next;
        }
    }

    public static void main(String[] args)
    {
        List<String> list = new java.util.LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);
    }
}
