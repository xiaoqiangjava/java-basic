package com.xq.learn.datastruct;

/**
 * Trie数，常用作在搜索时匹配具有相同前缀的词
 * Trie数即字典树，又称单词查找树或者键树，是一种树形结构，是一种hash树的变种。典型应用是用于排序和统计大量的字符串
 * ，但是不仅限于字符串，所以经常被搜索引擎系统用于文本词频统计。
 * 它的优点是最大限度地减少无谓的字符串比较，查询效率比hash高。
 * Trie的核心思想是空间换时间。利用字符串的公共前缀来降级查询时间的开销，以达到提高效率的问题。
 * @author xiaoqiang
 * @date 2020/3/30 21:06
 */
public class TrieMain {
}

class TrieNode {
    private char val;
    private TreeNode[] children;

    public TrieNode(char val) {
        this.val = val;
        children = new TreeNode[26];
    }
}
