package com.shark.newcoder;

/**
 * Created by qinghualiu on 2017/3/19.
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。

 给定树的根结点root，请返回树的大小

 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;
 public TreeNode(int val) {
 this.val = val;
 }

 总结： 二叉树问题的一个总体思路： 可以递归地处理 左子树和右子树
 }*/
public class CountNodes {

    /**
     * 思路
     *    遍历一颗二叉树的基本时间复杂度是 O(N),这里说要小于O(N),确定使用 二叉遍历
     *    首先注意到这是一颗完全二叉树：若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     *
     *    1.首先需要遍历以节点node为root的完全二叉树最左节点的层次，此为这颗二叉树的深度，记为hroot
     *    2.然后需要遍历以节点node为root.right的完全二叉树的层次，记为hright
     *    3.如果hroot==hright+1,则表明以root为根的完全二叉树的左子树为满二叉树，以公式可算，而右二叉树则递归处理
     *    4.如果hroot>=hright+1,则表明root为根的完全二叉树的右子树为满二叉树，以公式计算，而左子树则递归处理
     *
     * @param root
     * @return
     */
    public int count(TreeNode root) {
        // write code here

        if(root == null) return 0;

        return countTreeNode(root, 1, calcLeftLevel(root, 1));
    }

    /**
     * 计算节点数目
     * @param root 当前树的根节点
     * @param levelIndex 当前树的根节点在整颗计算的树的层次
     * @param level      以root为根节点的子树的高度（层次数）
     * @return
     */
    private int countTreeNode(TreeNode root, int levelIndex, int level) {

        if(levelIndex == level) //只有一层，
            return 1;

        if(calcLeftLevel(root.right, levelIndex+1) == level){//对应思路描述第三点
            return (1 << (level - levelIndex)) + countTreeNode(root.right, levelIndex + 1, level);
        }else{
            return (1 << (level - levelIndex - 1)) + countTreeNode(root.left, levelIndex + 1, level);
        }

    }

    /**
     * 计算以当前层次的某一个节点为根节点的子树的高度
     * @param root
     * @param curLevel
     * @return
     */
    private int calcLeftLevel(TreeNode root, int curLevel) {
        while(root != null){
            curLevel++;
            root = root.left;
        }
        return curLevel-1;
    }
}
