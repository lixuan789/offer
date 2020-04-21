package lixuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Code59Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag=true;
        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(flag){
                    list.add(node.val);
                }else {
                    stack.push(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            if(flag){
                res.add(list);
            }else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!stack.isEmpty()){
                    temp.add(stack.pop());
                }
                res.add(temp);
            }
            flag=!flag;

        }
        return res;

    }
}
