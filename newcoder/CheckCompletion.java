package com.shark.newcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinghualiu on 2017/6/17.
 *
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。

 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。


 */
public class CheckCompletion {

    /**
     * 可采用宽度遍历的方式，对每一层及其下一层的节点做处理。
     * @param root
     * @return
     */
    public boolean chk(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean leaf = false; // 叶子结点
        TreeNode left;
        TreeNode right;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            left = root.left;
            right = root.right;
            if ((leaf&&(left!=null||right!=null)) || (left==null&&right!=null)) {
                // 如果之前层遍历的结点没有右孩子，且当前的结点有左或右孩子，直接返回false
                // 如果当前结点有右孩子却没有左孩子，直接返回false
                return false;
            }
            if (left != null) {
                queue.offer(root.left);
            }
            if (right != null) {
                queue.offer(root.right);
            }else {
                leaf = false; // 如果当前结点没有右孩子，那么之后层遍历到的结点必须为叶子结点
            }
        }
        return true;
    }
}
