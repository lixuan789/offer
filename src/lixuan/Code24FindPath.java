package lixuan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Code24FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        dfs(result,new LinkedList<Integer>(),root,target);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> path, TreeNode root, int target) {
        if (root==null){
            return;
        }
        target-=root.val;
        path.addLast(root.val);
        if(isLeaf(root)&&target==0){
            result.add(new ArrayList<>(path));
        }
        dfs(result,path,root.left,target);
        dfs(result,path,root.right,target);
        path.removeLast();
        target+=root.val;

    }
    private boolean isLeaf(TreeNode node){
        if(node.left==null&&node.right==null){
            return true;
        }
        return false;
    }
}
