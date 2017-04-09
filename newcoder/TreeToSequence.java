package com.shark.newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinghualiu on 2017/4/9.
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。

 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {

        // 前序遍历
        List<Integer> preList = new ArrayList<Integer>();
        preSeq(root ,preList);
        int[][] result = new int[3][preList.size()];
        for(int i=0;i<preList.size();i++){
            result[0][i] = preList.get(i);
        }

        //中序遍历
        List<Integer> orderList = new ArrayList<Integer>();
        orderSeq(root, orderList);
        for(int i=0;i<orderList.size();i++){
            result[1][i] = orderList.get(i);
        }

        //后续遍历
        List<Integer> postList = new ArrayList<Integer>();
        postSeq(root, postList);
        for(int i=0;i<postList.size();i++){
            result[2][i] = postList.get(i);
        }

        return result;
    }

    private void postSeq(TreeNode root, List<Integer> list) {
        if(root == null) return ;
        postSeq(root.left, list);
        postSeq(root.right, list);
        list.add(root.val);
    }

    private void orderSeq(TreeNode root, List<Integer> list) {
        if(root == null) return ;
        orderSeq(root.left, list);
        list.add(root.val);
        orderSeq(root.right, list);
    }

    private void preSeq(TreeNode root, List list) {
        if(root == null) return ;
        list.add(root.val);
        preSeq(root.left, list);
        preSeq(root.right, list);
    }
}
