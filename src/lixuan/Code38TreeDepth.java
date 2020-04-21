package lixuan;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class Code38TreeDepth {
    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=TreeDepth(root.left)+1;
        int rightDepth=TreeDepth(root.right)+1;
        return Math.max(leftDepth,rightDepth);
    }

    /**
     * 方法二：层序遍历
     * @param root
     * @return
     */
    public int TreeDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return res;

    }

    /**
     * 层序遍历另一种写法
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res=0;
        int count=0;
        int nextCount=1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(count==nextCount){
                nextCount=queue.size();
                count=0;
                res++;
            }

        }
        return res;

    }

}
