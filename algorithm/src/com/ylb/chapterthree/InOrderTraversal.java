package com.ylb.chapterthree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InOrderTraversal {

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal01(TreeNode root){

        //记录目标序列
        List<Integer> res = new ArrayList<>();
        //显式模拟栈
        Deque<TreeNode> stk = new LinkedList<>();
        //判断二叉树是否处理完
        while(root != null || !stk.isEmpty()){
            //根据中序遍历，第一个节点是一棵树最左边的节点
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            //出栈
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal02(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    public void inorder(TreeNode root,List<Integer> res){

        //处理二叉树的边界条件,判断指针已经到达叶子节点的下一层了，立刻返回
        if(root != null){
           return;
        }
        //先遍历左子树节点
        inorder(root.left,res);
        //访问根节点
        res.add(root.val);
        //在遍历右子树树节点
        inorder(root.right,res);

    }


    /**
     * 莫里斯算法（难点）
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal03(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode expoint = null;
        while(root != null){
            if(root.left != null){
                expoint = root.left;
                while(expoint.right != null && expoint.right != root){
                    expoint = expoint.right;
                }
                if(expoint.right == null){
                    expoint.right = root;
                    root = expoint.left;
                }else{
                    res.add(root.val);
                    expoint.right = null;
                    root = root.right;
                }
            }else{
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
