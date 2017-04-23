package com.shark.newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qinghualiu on 2017/4/23.
 *
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。

 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequenceNoRecur {

    public int[][] convert(TreeNode root) {
        // write code here
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> post = new ArrayList<Integer>();
        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);
        int[][] res = new int[3][pre.size()];
        for(int i = 0; i < pre.size(); i++){
            res[0][i] = pre.get(i);
            res[1][i] = in.get(i);
            res[2][i] = post.get(i);
        }
        return res;
    }

    /**
     * 非递归先序遍历，思路：
     * 1.创建一个栈
     * 2.当前节点入栈
     * 3.栈中如果不为空，从栈中弹出一个节点，访问该节点，然后右节点入栈，左节点入栈
     * @param root
     * @param list
     */
    private void preOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 非递归中序遍历，思路：
     * 1.先不断将当前节点及其左节点入栈，直到没有左节点为止。
     * 2.从栈中弹出一个节点，访问之，然后将当前节点的右节点赋值给当前节点，继续循环
     * @param root
     * @param list
     */
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 非递归后续遍历，思路：
     *
     *
     * @param root
     * @param list
     */
    private void postOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode h = root, c = null;
        stack.push(root);
        while(!stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && (c.left != h && c.right != h)){
                stack.push(c.left);
                c = c.left;
            }else if(c.right != null && c.right != h){
                stack.push(c.right);
                c = c.right;
            }else{
                h = c;
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
            }


        }
    }


}
