package lin.xc.coding.skill.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ⼆叉树的最⼩⾼度
 * @author lin.xc
 * @date 2021/5/14
 **/
public class Case1 {

    int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 初始化
        Queue<TreeNode> q = new LinkedList<>();
        // 根节点入队
        q.offer(root);
        // root 本⾝就是⼀层，depth 初始化为 1
        int depth = 1;

        // 逐层从左到右扫描，最先得到null值即已经找到最小层级
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                // 推出首节点
                TreeNode cur = q.poll();
                System.out.println("——>"+cur.value);
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null){
                    /* 将 cur 的相邻节点加⼊队列 */
                    return depth;
                }
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            /* 这⾥增加深度 */
            depth++;
        }
        return depth;
    }

    /** 树形机构 */
    static class TreeNode{
        Integer value;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,17};
        TreeNode rootTreeNode = arrToBTreeNode(arr, 0);
        Case1 case1 = new Case1();
        System.out.println("最小深度："+case1.minDepth(rootTreeNode));
    }

    /**
     * 数组转树节点
     * */
    private static TreeNode arrToBTreeNode(Integer[] arr, int idx){
        TreeNode node = new TreeNode();
        // 设置节点值
        node.value = arr[idx];

        // 该下标为最底层了，直接返回该节点
        if((2*idx+2)>arr.length){
            return node;
        }

        // 设置左节点
        node.left = arrToBTreeNode(arr,2*idx+1);
        // 设置右节点
        node.right = arrToBTreeNode(arr,2*idx+2);
        // 返回
        return node;
    }

}
