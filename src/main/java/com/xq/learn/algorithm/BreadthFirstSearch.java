package com.xq.learn.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先搜索：Breadth-Firth-Search, 简称BFS，该算法为了解决在树（图，状态集）中搜索特定的节点。
 * 以根节点为起始位置，一层一层的向下搜索，知道找到固定的值
 * @author xiaoqiang
 * @date 2020/3/28 16:56
 */
public class BreadthFirstSearch
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        bfs(root, new ArrayList<>());
        bfsLevelOrder(root, new ArrayList<>());

        // 求一个树的最大深度
        System.out.println("max depth: " + maxDepth(root));
        // 求一个树的最小深度
        System.out.println("min depth: " + minDepth(root));
    }

    /**
     * 广度优先遍历树，使用队列
     * @param root root
     * @param path path
     */
    public static void bfs(TreeNode root, List<Integer> path)
    {
        if (null == root)
        {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            path.add(curr.val);
            if (null != curr.left)
            {
                queue.offer(curr.left);
            }
            if (null != curr.right)
            {
                queue.offer(curr.right);
            }
        }

        System.out.println(path);
    }

    /**
     * 分层遍历二叉树:
     * 使用bfs实现
     * LeetCode: 102
     */
    public static void bfsLevelOrder(TreeNode root, List<List<Integer>> path)
    {
        if (null == root)
        {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (null != curr.left)
                {
                    queue.offer(curr.left);
                }
                if (null != curr.right)
                {
                    queue.offer(curr.right);
                }
            }
            path.add(level);
        }
        System.out.println(path);
    }

    /**
     * 求一个树的最大深度
     * LeetCode：104
     * @param root root
     * @return depth
     */
    public static int maxDepth(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i ++)
            {
                TreeNode curr = queue.poll();
                if (null != curr.left)
                {
                    queue.offer(curr.left);
                }
                if (null != curr.right)
                {
                    queue.offer(curr.right);
                }
            }
        }
        return depth;
    }

    /**
     * 求一个树的最小深度，使用BFS
     * LeetCode: 111
     * @param root root
     * @return depth
     */
    public static int minDepth(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode curr = queue.poll();
                if (null == curr.left && null == curr.right)
                {
                    return depth;
                }
                if (null != curr.left)
                {
                    queue.offer(curr.left);
                }
                if (null != curr.right)
                {
                    queue.offer(curr.right);
                }
            }
        }
        return depth;
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}
