package com.xq.learn.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaoqiang
 * @date 2020/3/28 20:31
 */
public class DepthFirstSearch
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // dfs遍历树
        dfs(root, new ArrayList<>());
        List<Integer> path = new ArrayList<>();
        // dfs通过递归遍历树
        dfs_recursion(root, path);
        // dfs层级遍历树
        List<List<Integer>> res = new ArrayList<>();
        dfsLevelOrder(root, res);
        System.out.println(res);
        // dfs方式求树的最大深度
        System.out.println("max depth: " + maxDepth(root));
        // dfs求树的最小深度
        System.out.println("min depth: " + minDepth(root));

    }
    /**
     * 深度优先遍历树，使用栈，由于Recursion本身维护了一个栈，所以也可以使用递归来实现
     * 该案例自己维护栈来实现
     * @param root root
     * @param path path
     */
    public static void dfs(TreeNode root, List<Integer> path)
    {
        if (null == root)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode curr = stack.pop();
            path.add(curr.val);
            if (null != curr.left)
            {
                stack.push(curr.left);
            }
            if (null != curr.right)
            {
                stack.push(curr.right);
            }
        }

        System.out.println(path);
    }

    /**
     * 使用递归实现深度优先的遍历
     * @param root root
     * @param path path
     */
    public static void dfs_recursion(TreeNode root, List<Integer> path)
    {
        if (null == root)
        {
            return;
        }

        path.add(root.val);
        dfs_recursion(root.left, path);
        dfs_recursion(root.right, path);
    }

    /**
     * 使用dfs实现二叉树分层打印
     */
    public static void dfsLevelOrder(TreeNode root, List<List<Integer>> path)
    {
        doDfsLevelOrder(root, 0, path);
    }

    private static void doDfsLevelOrder(TreeNode root, int level, List<List<Integer>> path)
    {
        if (null == root)
        {
            return;
        }
        // path中没有当前层的元素，加一个空集合，方便后面操作
        if (path.size() < level + 1)
        {
            path.add(new ArrayList<>());
        }
        path.get(level).add(root.val);
        doDfsLevelOrder(root.left, level + 1, path);
        doDfsLevelOrder(root.right, level + 1, path);
    }

    /**
     * 通过DFS求树的最大深度
     * LeetCode: 104
     */
    public static int maxDepth(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 通过DFS求树的最小深度
     * LeetCode: 111
     */
    public static int minDepth(TreeNode root)
    {
        if (null == root)
        {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 这里需要注意，如果有一边不存在，需要+1
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
