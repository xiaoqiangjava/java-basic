package com.xq.learn.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * 树：本质跟LinkedList差不多，相当于LinkedList有两个next指针
 * 二叉树本身没有使用的目的，常用的是二叉搜索树，二叉搜索树的特点：
 * 1. 左子树上所有的节点的值均小于它的根节点的值
 * 2. 右子树上所有的节点的值均大于它的根节点的值
 * 3. Recursively, 左、右子树也分别为二叉查找树。
 * 链表是的时间复杂度：O(n)
 * 二叉搜索树的时间复杂度：O(logn)
 *                  A
 *          B               C
 *      D       E       F       G
 * 树的遍历有三种顺序：根据根的顺序来划分
 * pre-order(前序): 根，左，右，即先访问根，然后访问所有的左子树，再放问所有的右子树: A->B->D->E->C->F->G
 * in-order(中序)：左，根，右
 * post-order(后序)：左，右，根
 *
 * @author xiaoqiang
 * @date 2020/3/26 18:02
 */
public class TreeMain
{
    private static List<Integer> path = new ArrayList<>();
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // 前序遍历
        postOrder(root);
        System.out.println(path);
    }

    /**
     * 前序遍历：根--左--右
     * @param root root
     */
    public static void preOrder(TreeNode root)
    {
        if (null != root)
        {
            path.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历：左--根--右
     * @param root root
     */
    public static void inOrder(TreeNode root)
    {
        if (null != root)
        {
            inOrder(root.left);
            path.add(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 后续遍历：左--右--根
     * @param root root
     */
    public static void postOrder(TreeNode root)
    {
        if (null != root)
        {
            postOrder(root.left);
            postOrder(root.right);
            path.add(root.val);
        }
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

