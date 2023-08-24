package com.ylb.chapterthree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最大深度
 */
public class TreeMaxDepth {

    /**
     * 通过BFS求二叉树的最大深度
     * @param treeNode
     * @return
     */
    public int maxDepthBFS(TreeNode treeNode){
        //如果树为空时，BFS无法处理
        if(treeNode == null){
           return 0;
        }
        //使用队列来记录各层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队  todo 这里为什么要使用offer而不是add?
        queue.offer(treeNode);
        //初始化目标值  目标值就是树的深度
        int res = 0;
        //判断是否还有没遍历完的节点
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                //todo 队列里的节点不断地取出来，有不断地把子节点放进去，这样不接一直遍历到最底层的叶子节点了吗，就不会按层增加目标值了
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
        }
        res++;
        return res;
    }


    /**
     * DFS求二叉树的最大深度
     * @param treeNode
     * @return
     */
    public int maxDepthDFS(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int leftMaxDepth = maxDepthDFS(treeNode);
        int rightMaxDepth = maxDepthDFS(treeNode);
        return Math.max(leftMaxDepth,rightMaxDepth);
    }
}
