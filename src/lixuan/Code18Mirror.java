package lixuan;

import util.ListNode;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Code18Mirror {
    /**
     * 方法一
     * @param root
     */
    public void Mirror(TreeNode root) {
        swap(root);
    }

    private TreeNode swap(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode temp=swap(root.left);
        root.left=swap(root.right);
        root.right=temp;
        return root;
    }

    public void Mirror1(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 非递归：层序便利
     * @param root
     */
    public void Mirror2(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int len = nodes.size();
            for(int i = 0; i < len; i++){
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if(curr.left != null) nodes.offer(curr.left);
                if(curr.right != null) nodes.offer(curr.right);
            }
        }
    }
}
